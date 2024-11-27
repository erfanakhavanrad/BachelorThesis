<template>
  <span>
    <b-input-group id="t-input-group-date" size="sm">
      <template #append>
        <span id="t-input-group-text" class="input-group-text">
          {{ label }}
          <sup v-if="required">*</sup>
        </span>
      </template>
      <b-form-input
        id="t-form-input"
        v-mask="'####/##/##'"
        placeholder="1400/01/01"
        :disabled="disabled"
        :value="value"
        :state="validateState"
        autocomplete="off"
        @input="onInput"
      />
    </b-input-group>
    <p id="error-feedback">{{ error }}</p>
  </span>
</template>

<script>
export default {
  name: 'TTextBoxDate',
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
      default: null
    },
    rules: {
      type: Object,
      default: null
    },
    disabled: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {}
  },
  computed: {
    required () {
      let _required = false
      if (
        this.rules === null ||
        this.rules.required === null ||
        !this.rules.required
      ) {
        // وقتی هیچ رولی تعیین نشود
        // یا اجباری بودن رول نال باشد
        // یا اجباری بودن رول فالس باشد
        _required = false
      } else {
        _required = true
      }
      return _required
    },
    isEmpty () {
      if (this.value == null || this.value === '') {
        return true
      }
      return false
    },
    validateState () {
      // /^\d{4}[\\-\\/\s]?((((0[13578])|(1[02]))[\\-\\/\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\s]?[0-2][0-9]))$/
      if (this.required && this.isEmpty) {
        return false
      }
      if (
        /^\d{4}\/(0[1-9]|1[0-2])\/(0[1-9]|[1-2][0-9]|3[0,1])$/.test(
          this.value
        ) ||
        this.isEmpty
      ) {
        return true
      }
      return false
    },
    error () {
      if (this.required && this.isEmpty) {
        return `${this.label} الزامی است`
      }
      if (!this.validateState) {
        return 'مقدار نامعتبر است'
      }
      return null
    }
  },
  watch: {
    validateState: {
      handler (_validateState) {
        const _validation = {}
        _validation[this.id] = _validateState
        this.$emit('onChangedValidation', _validation)
      }
    }
  },
  created () {
    const _validation = {}
    _validation[this.id] = this.validateState
    this.$emit('onChangedValidation', _validation)
  },
  methods: {
    onInput (value) {
      this.$emit('input', value)
    }
  }
}
</script>

<style lang="scss" scoped>
span {
  direction: ltr;
  padding: 5px;
  #t-input-group-date {
    flex-wrap: nowrap;
    #t-input-group-text {
      direction: rtl;
      font-size: 0.8rem;
    }
    #t-form-input {
      text-align: left;
      font-size: 0.8rem;
    }
    ::placeholder {
      color: var(--t-color-0-0-75);
    }
  }
  #error-feedback {
    text-align: right;
    color: #dc3545;
    font-size: 0.7rem;
  }
}
</style>
