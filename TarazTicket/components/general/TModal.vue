<template>
  <b-modal
    v-model="visibility"
    :size="size"
    body-class="t-modal-body"
    :header-bg-variant="headerBgVariant"
    :header-text-variant="headerTextVariant"
    button-size="sm"
    cancel-title="انصراف"
    centered
    footer-class="t-modal-footer"
    header-class="t-modal-header"
    ok-title="تایید"
    ok-variant="outline-info"
    cancel-variant="outline-secondary"
    @ok="onOk"
    @cancel="onCancel"
    @close="onClose"
    @hide="onHide"
  >
    <template #modal-header="{ close }">
      <div class="t-header">
        <font-awesome-icon icon="times" size="lg" @click="close()" />
        <span class="t-title">{{ title }}</span>
      </div>
    </template>
    <template #default>
      <slot />
    </template>
  </b-modal>
</template>

<script>
export default {
  name: 'TModal',
  props: {
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
      default: 'sm',
      required: false
    },
    value: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return { visibility: this.value, isOkClicked: false }
  },
  computed: {
    headerBgVariant () {
      // مشخص میشود که با توجه به ورینت کلی چه ورینتی باید برای بک گراند هدر اعمال شود
      switch (this.variant) {
        case 'danger':
          return 'danger'

        default:
          return this.variant
      }
    },
    headerTextVariant () {
      // مشخص میشود که با توجه به ورینت کلی چه ورینتی باید برای فور گراند هدر اعمال شود
      switch (this.variant) {
        case 'danger':
        case 'success':
        case 'secondary':
          return 'light'

        default:
          return 'dark'
      }
    }
  },
  watch: {
    value: {
      handler (_value) {
        this.visibility = _value
      }
    },
    visibility: {
      handler (_visibility) {
        this.isOkClicked = false
        this.$emit('input', _visibility)
      }
    }
  },
  methods: {
    onOk () {
      this.isOkClicked = true
      this.$emit('ok')
    },
    onCancel () {
      this.$emit('cancel')
    },
    onClose () {
      this.$emit('close')
    },
    onHide () {
      if (!this.isOkClicked) {
        this.$emit('hide')
      }
    }
  }
}
</script>

<style lang="scss" scoped>
:deep(.t-modal-header) {
  padding: 0;
  direction: ltr;

  .t-header {
    padding: 10px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    flex-grow: 1;

    a {
      color: white;
    }
  }
}

:deep(.t-modal-body) {
  padding: 5px;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}

:deep(.t-modal-footer) {
  padding: 0;
  direction: ltr;
}
</style>
