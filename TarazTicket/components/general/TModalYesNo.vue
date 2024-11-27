<template>
  <t-modal
    ref="TModalYesNo"
    v-model="visibility"
    :title="title"
    :variant="variant"
    :size="size"
    @ok="onOk"
    @cancel="onCancel"
  >
    <slot />
  </t-modal>
</template>

<script>
import TModal from '~/components/general/TModal.vue'
export default {
  name: 'TModalYesNo',
  components: {
    TModal
  },
  props: {
    id: {
      type: String,
      default: null
    },
    title: {
      type: String,
      default: null
    },
    variant: {
      type: String,
      default: 'light',
      required: true
    },
    size: {
      type: String,
      default: 'sm'
    }
  },
  data () {
    return {
      visibility: false,
      onOkCallback: undefined,
      onCancelCallback: undefined
    }
  },
  computed: {},
  methods: {
    show (onOkCallback, onCancelCallback) {
      this.visibility = true
      this.onOkCallback = onOkCallback
      this.onCancelCallback = onCancelCallback
    },
    onOk () {
      if (this.onOkCallback !== undefined) {
        this.onOkCallback()
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

<style lang="scss" scoped></style>
