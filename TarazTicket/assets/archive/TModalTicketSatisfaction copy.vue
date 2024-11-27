<template>
  <t-modal
    v-model="visibility"
    title="رضایت مندی"
    variant="success"
    size="lg"
    @ok="onOk"
    @cancel="onCancel"
  >
    <!-- :options="options" -->
    <div class="t-container-satisfaction">
      <span>
        با اعلام میزان رضایتمندی خود ما را در ارائه خدمات بهتر یاری نمایید
      </span>
      <b-form-radio-group
        id="radio-group-satisfaction"
        v-model="selected"
        name="radio-satisfactions"
        class="t-radio-group"
      >
        <b-form-radio
          v-for="(option, index) in options"
          :key="index"
          value="first"
        >
          <!-- {{ option.text }} -->
          <h1>
            <font-awesome-icon :icon="option.icon" style="margin-right:20px;margin-left:20px;" />
          </h1>
        </b-form-radio>
      </b-form-radio-group>
    </div>
  </t-modal>
</template>

<script>
import TModal from '~/components/general/TModal.vue'
export default {
  name: 'TModalTicketSatisfaction',
  components: {
    TModal
  },
  props: {
    id: {
      type: String,
      default: null
    }
  },
  data () {
    return {
      visibility: false,
      selected: null,
      options: [],
      onOkCallback: undefined,
      onCancelCallback: undefined
    }
  },
  async created () {
    await this.retrieveData()
  },
  methods: {
    show (onOkCallback, onCancelCallback) {
      this.visibility = true
      this.onOkCallback = onOkCallback
      this.onCancelCallback = onCancelCallback
    },
    async retrieveData () {
      const response = await this.$taxios.get('tkt/satisfactions')
      response.data.forEach((obj) => {
        let icon
        switch (obj.satisfactionID) {
          case 10000001:
            icon = 'trash'
            break
          case 10000002:
            icon = 'reply'
            break
          case 10000003:
            icon = 'times'
            break
        }
        this.options.push({
          icon,
          value: obj.satisfactionID
        })
      })
      this.selected = response.data[0].satisfactionID
    },
    onOk () {
      if (this.onOkCallback !== undefined) {
        this.onOkCallback(this.selected)
      }
    },
    onCancel () {
      if (this.onCancelCallback !== undefined) {
        this.onCancelCallback()
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.t-container-satisfaction {
  display: flex;
  width: 100%;
  flex-direction: column;
  span {
    text-align: right;
  }
  .t-radio-group {
    text-align: right;
    padding: 10px;
  }
}
</style>
