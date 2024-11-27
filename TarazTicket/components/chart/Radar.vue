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
  name: 'Radar',
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
          text: 'گزارش فروش 12 ماه اخیر',
          align: 'center'
        },
        chart: {
          background: 'white',
          dropShadow: {
            enabled: true
          },
          type: 'radar'
        },
        dataLabels: {
          enabled: true
        },
        xaxis: {
          categories: [
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
          ]
        },
        legend: {
          show: true
        }
      },
      series: [
        {
          name: 'آقای رضایی',
          data: [12, 60, 150, 90, 45, 16, -20, 4, 39, 75, 79, 20]
        }
      ]
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
