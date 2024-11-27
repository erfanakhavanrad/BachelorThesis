<template>
  <div v-if="true" header-tag="header" class="t-card-container-bar">
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
        ref="bar"
        :height="height"
        class="w-100"
        :options="chartOptions"
        :series="series"
      />
      <!-- {{ data.yValues[0].data }} -->
    </b-overlay>
  </div>
</template>

<script>
export default {
  name: 'TBar',
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
    },
    horizontal: {
      type: Boolean,
      default: false
    },
    showDataLabels: {
      type: Boolean,
      default: false
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
          type: 'bar',
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
        colors: [
          'hsl(200, 70%, 40%)',
          '#66DA26',
          '#546E7A',
          '#E91E63',
          '#FF9800'
        ],
        dataLabels: {
          enabled: this.showDataLabels,
          style: {
            colors: ['#FFF']
          }
        },
        title: {
          text: this.title,
          align: 'center'
        },
        fill: {
          opacity: 1
        },
        xaxis: {
          title: {
            text: this.xAxis.title
          },
          type: 'category',
          categories: [''],
          tooltip: {
            enabled: true
          }
        },
        yaxis: {
          title: {
            text: this.yAxis.title
          }
        },
        legend: {
          position: 'bottom',
          horizontalAlign: 'right',
          floating: false
        },
        plotOptions: {
          bar: {
            borderRadius: 2,
            columnWidth: '30%',
            horizontal: this.horizontal,
            dataLabels: {
              position: 'center' // top, center, bottom
            }
          }
        },
        stroke: {
          width: 1,
          colors: ['dimgrey']
        }
      },
      series: [
        {
          name: '',
          data: [0]
        }
      ],
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
            this.chartOptions.xaxis.categories = ['']
            this.series = [
              {
                name: '',
                data: [0]
              }
            ]
          } else {
            this.chartOptions.xaxis.categories = this.data.xValues
            this.series = this.data.yValues
            this.routes = this.data.routes
          }
          this.$refs.bar.refresh()
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
.t-card-container-bar {
  display: flex;
  margin: 20px;
  :deep(.t-toast-alarm-container) {
    margin: 0;
    .t-toast-alarm {
      position: absolute;
    }
  }
  #container-bar {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 10px;
  }
}
</style>
