<template>
  <span id="t-validation-provider">
    <b-input-group id="t-input-group-color" size="sm">
      <template #append>
        <span id="t-input-group-text" class="input-group-text">
          {{ label }}
        </span>
      </template>
      <b-form-input
        id="t-form-input"
        type="color"
        :disabled="disabled"
        :value="value"
        @input="onInput"
      />
    </b-input-group>
    <p id="error-feedback" />
  </span>
</template>

<script>
export default {
  name: 'TColor',
  components: {},
  props: {
    id: {
      type: String,
      default: null,
      required: true
    },
    label: {
      type: String,
      default: null,
      required: true
    },
    value: {
      type: String,
      default: '#FFFFFF'
    },
    disabled: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {}
  },
  mounted () {
    if (this.value == null) {
      this.$emit('input', '#FFFFFF')
    } else {
      this.$emit('input', this.value)
    }
  },
  methods: {
    onInput (value) {
      this.$emit('input', value)
    }
  }
}
</script>

<style lang="scss" scoped>
#t-validation-provider {
  direction: ltr;
  padding: 5px;

  #t-input-group-color {
    flex-wrap: nowrap;
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    align-items: center;

    #t-input-group-text {
      direction: rtl;
      font-size: 0.8rem;
    }
    #t-form-input {
      text-align: right;
      direction: rtl;
      max-width: 100px;
      font-size: 0.8rem;
    }
  }

  #error-feedback {
    text-align: right;
    color: #dc3545;
    font-size: 0.7rem;
  }
}
</style>
