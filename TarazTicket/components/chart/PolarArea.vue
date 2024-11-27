<template>
  <b-overlay v-if="retrieving" show class="t-loading" />
  <div v-else id="container-bar">
    <Apexchart
      height="100%"
      width="100%"
      :options="chartOptions"
      :series="series"
    />
  </div>
</template>

<script>
export default {
  name: 'PolarArea',
  props: {
    resourceData: {
      type: String,
      default: null
    },
    title: {
      type: String,
      default: 'فروش لحظه ای استان ها'
    }
  },
  data () {
    return {
      retrieving: true,
      data: [],
      chartOptions: {
        title: {
          text: 'گزارش فروش 1 سال اخیر',
          align: 'center'
        },
        chart: {
          background: 'white',
          dropShadow: {
            enabled: true
          },
          type: 'polarArea'
        },
        colors: [
          '#77B6EA',
          '#545454',
          '#f44336',
          '#009688',
          '#ffeb3b',
          '#795548',
          '#ff5722',
          '#673ab7',
          '#cddc39',
          '#e91e63',
          '#00bcd4',
          '#9e9e9e'
        ],
        dataLabels: {
          enabled: false
        },
        labels: [
          'فروردین',
          'اردیبهشت',
          'خرداد',
          'تیر',
          'مرداد',
          'شهریور',
          'مهر',
          'آبان',
          'آذر',
          'دی',
          'بهمن',
          'اسفند'
        ],
        legend: {
          position: 'bottom',
          horizontalAlign: 'center',
          floating: false,
          offsetY: 0,
          offsetX: 0
        }
      },
      series: [30, 40, 10, 34, 22, 75, 80, 9, 42, 11, 13, 11]
    }
  },
  computed: {},
  watch: {
    retrieving: {
      handler (_retrieving) {
        if (!_retrieving) {
          //
        }
      }
    }
  },
  async created () {
    this.data = await this.retrieveData()
  },
  mounted () {},
  methods: {
    async retrieveData () {
      this.retrieving = true
      const response = await this.$taxios.get(this.resourceData, null)
      this.retrieving = false
      return response.data
    }
  }
}
</script>

<style lang="scss" scoped>
#container-bar {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 10px;
}
</style>
