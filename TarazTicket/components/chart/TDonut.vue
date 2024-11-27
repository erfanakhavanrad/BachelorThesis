<template>
  <div v-if="true" header-tag="header" class="t-card-container-donut">
    <b-toast
      :id="`t-toast-alarm-${id}`"
      variant="warning"
      class="t-toast-alarm-container"
      toast-class="t-toast-alarm"
      title="204"
      static
      no-auto-hide
    >
      در این بازه داده ای وجود ندارد
    </b-toast>
    <b-overlay
      variant="transparent"
      :show="retrieving"
      :style="retrieving ? 'opacity:0.5' : ''"
      class="t-loading"
    >
      <Apexchart
        ref="donut"
        :height="height"
        class="w-100"
        :options="chartOptions"
        :series="series"
      />
    </b-overlay>
  </div>
</template>

<script>
export default {
  name: 'TDonut',
  props: {
    id: {
      type: String,
      default: null
    },
    resourceData: {
      type: String,
      default: null
    },
    filterParam: {
      type: String, // منظور baseFilter است
      default: null
    },
    filterParams: {
      type: Object, // منظور سایر فیلتر پارامتر هاست به جز baseFilter
      default () {
        return {}
      }
    },
    async: {
      type: Boolean,
      default: false
    },
    title: {
      type: String,
      default: ''
    },
    height: {
      type: String,
      default: '400px'
    },
    yAxis: {
      type: Object,
      default () {
        return {}
      }
    },
    xAxis: {
      type: Object,
      default () {
        return {}
      }
    }
  },
  data () {
    return {
      retrieving: false,
      data: [],
      chartOptions: {
        chart: {
          dropShadow: {
            enabled: true
          },
          type: 'donut',
          fontFamily: 'IRANSansX',
          events: {
            dataPointSelection: (event, chartContext, config) => {
              const index = config.dataPointIndex
              this.$router.push({
                name: this.routes[index].name,
                params: this.routes[index].params
              })
            }
          }
        },
        dataLabels: {
          enabled: true
        },
        title: {
          text: this.title,
          align: 'center'
        },
        labels: [''],
        legend: {
          position: 'bottom',
          horizontalAlign: 'center',
          floating: false
        }
      },
      series: [1],
      routes: []
    }
  },
  computed: {
    _yFieldNames () {
      const yFieldNames = []
      this.yAxis.fields.forEach((field) => {
        yFieldNames.push(field.name)
      })
      return yFieldNames
    },
    _yFieldTitles () {
      const yFieldTitles = []
      this.yAxis.fields.forEach((field) => {
        yFieldTitles.push(field.title)
      })
      return yFieldTitles
    },
    _filterParams () {
      const _filterParams = this.filterParams
      _filterParams.xFieldName = this.xAxis.fieldName
      _filterParams.yFieldNames = this._yFieldNames.join(',')
      _filterParams.yFieldTitles = this._yFieldTitles.join(',')
      return _filterParams
    }
  },
  watch: {
    retrieving: {
      handler (_retrieving) {
        if (!_retrieving) {
          if (this.data.length === 0) {
            this.chartOptions.labels = ['']
            this.series = [1]
          } else {
            this.chartOptions.labels = this.data.xValues
            // چون پای چارت هیچ وقت ترکیبی نمیشود فقط دیتاهای اول را میگیریم
            this.series = this.data.yValues[0].data
            this.routes = this.data.routes
          }
          this.$refs.donut.refresh()
        }
      }
    }
  },
  async created () {
    if (!this.async) {
      await this.retrieveData()
    }
  },
  mounted () {},
  methods: {
    async retrieveData () {
      this.retrieving = true
      const response = await this.$taxios.get(
        this.resourceData,
        this._filterParams
      )
      this.retrieving = false
      if (response.data === '') {
        this.data = []
        this.$bvToast.show(`t-toast-alarm-${this.id}`)
      } else {
        this.data = response.data
        this.$bvToast.hide(`t-toast-alarm-${this.id}`)
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.t-card-container-donut {
  display: flex;
  margin: 20px;
  :deep(.t-toast-alarm-container) {
    margin: 0;
    .t-toast-alarm {
      position: absolute;
    }
  }
  :deep(.apexcharts-legend-text) {
    margin-right: 5px;
  }
}
</style>
