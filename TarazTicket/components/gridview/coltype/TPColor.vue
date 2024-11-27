<template>
  <span :id="id" :class="colorPick()">{{ value }}</span>
</template>

<script>
export default {
  name: 'TPColor',
  props: {
    id: {
      type: String,
      default: null
    },
    value: {
      type: String,
      default: null
    }
  },
  computed: {},
  methods: {
    colorPick () {
      switch (this.value) {
        case 'پایین':
          return 't-p-color-low'
        case 'متوسط':
          return 't-p-color-mid'

        case 'بالا':
          return 't-p-color-high'

        default:
          return 't-p-color-def'
      }
    }
  }
}
</script>
<style lang="scss" scoped>
.t-p-color-low {
  display: flex;
  padding: 5px 5px;
  box-sizing: border-box;
  border-radius: 8px;
  text-shadow: none;
  font-weight: 500;
  width: 50%;
  flex-direction: row;
  justify-content: center !important;
  background-image: linear-gradient(to bottom, #51ff9f 10%, #28c76f 100%);
  color: #fff;
}

.t-p-color-mid {
  display: flex;
  padding: 5px 5px;
  box-sizing: border-box;
  border-radius: 8px;
  text-shadow: none;
  font-weight: 500;
  width: 50%;
  flex-direction: row;
  justify-content: center !important;
  background-image: linear-gradient(to bottom, #ffe46b 10%, #ff8747 100%);
  color: #fff;
}

.t-p-color-high {
  display: flex;
  padding: 5px 5px;
  box-sizing: border-box;
  border-radius: 8px;
  text-shadow: none;
  font-weight: 500;
  width: 50%;
  flex-direction: row;
  justify-content: center !important;
  background-image: linear-gradient(to bottom, #d6514a 20%, #810d1c 100%);
  color: #fff;
}

.t-p-color-def {
  display: flex;
  padding: 5px 5px;
  box-sizing: border-box;
  border-radius: 8px;
  text-shadow: none;
  font-weight: 500;
  width: 50%;
  flex-direction: row;
  justify-content: center !important;
  background-color: rgb(0, 0, 0);
  color: rgb(255, 255, 255);
}
</style>
