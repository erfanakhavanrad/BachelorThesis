<template>
  <span>
    <b-input-group id="t-input-group-date-picker" size="sm">
      <template #append>
        <span id="t-input-group-text" class="input-group-text">
          {{ label }}
          <sup v-if="required">*</sup>
        </span>
      </template>
      <date-picker
        id="t-form-input"
        calendar="jalali"
        input-class="t-date-picker-text-box"
        locale="fa"
        format="jYYYY/jMM/jDD"
        :value="value"
        @input="onInput"
      />
    </b-input-group>
    <p id="error-feedback">{{ error }}</p>
  </span>
</template>

<script>
export default {
  name: 'TJalaliCalendar',
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
      if (this.required && this.isEmpty) {
        return false
      }
      return true
    },
    error () {
      if (this.required && this.isEmpty) {
        return `${this.label} الزامی است`
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
  #t-input-group-date-picker {
    flex-wrap: nowrap;
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    #t-input-group-text {
      direction: rtl;
      font-size: 0.8rem;
    }
    #t-form-input {
      text-align: left;
      font-size: 0.8rem;
      padding: 0px;
      margin: 0px;
    }
    ::placeholder {
      color: var(--t-color-0-0-75);
    }
  }
  :deep(.t-date-picker-text-box) {
    font-size: 0.8rem;
  }
  #error-feedback {
    text-align: right;
    color: #dc3545;
    font-size: 0.7rem;
  }
}
</style>
