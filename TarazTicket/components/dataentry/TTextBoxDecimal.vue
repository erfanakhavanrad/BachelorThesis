<template>
  <validation-provider
    id="t-validation-provider"
    v-slot="validationContext"
    ref="validation_provider"
    :name="label"
    :rules="rules"
  >
    <b-input-group id="t-input-group-decimal" size="sm">
      <template #append>
        <span id="t-input-group-text" class="input-group-text">
          {{ label }}
          <sup v-if="required">*</sup>
        </span>
      </template>
      <b-form-input
        id="t-form-input"
        :disabled="disabled"
        :value="hasComma ? $tnumber.decimalCommas(value) : value"
        :state="validateState(validationContext)"
        autocomplete="off"
        @input="onInput"
        @keypress="$tnumber.acceptDecimal"
      />
    </b-input-group>
    <p id="error-feedback">
      {{ validationContext.errors[0] }}
    </p>
  </validation-provider>
</template>

<script>
import { ValidationProvider } from 'vee-validate'
export default {
  name: 'TTextBoxDecimal',
  components: {
    ValidationProvider
  },
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
      type: Number,
      default: null
    },
    rules: {
      type: Object,
      default: null
    },
    disabled: {
      type: Boolean,
      default: false
    },
    hasComma: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return { isValid: null }
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
    }
  },
  watch: {
    isValid: {
      handler (_isValid) {
        const _validation = {}
        _validation[this.id] = _isValid
        this.$emit('onChangedValidation', _validation)
      }
    }
  },
  methods: {
    validateState ({ dirty, validated, valid = null }) {
      // const isValid = dirty && validated ? valid : null
      this.isValid = valid
      return valid
    },
    onInput (value) {
      if (this.hasComma) {
        const _value = this.$tnumber.removeCommas(value)
        this.$emit(
          'input',
          value == null || value === '' ? null : parseFloat(_value)
        )
      } else {
        this.$emit(
          'input',
          value == null || value === '' ? null : parseFloat(value)
        )
      }
    }
  }
}
</script>

<style lang="scss" scoped>
#t-validation-provider {
  direction: ltr;
  padding: 5px;
  #t-input-group-decimal {
    flex-wrap: nowrap;
    #t-input-group-text {
      direction: rtl;
      font-size: 0.8rem;
    }
    #t-form-input {
      text-align: right;
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
