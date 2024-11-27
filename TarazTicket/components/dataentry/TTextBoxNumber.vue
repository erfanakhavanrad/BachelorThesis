<template>
  <validation-provider
    id="t-validation-provider"
    v-slot="validationContext"
    ref="validation_provider"
    :name="label"
    :rules="rules"
  >
    <b-input-group id="t-input-group-string" size="sm">
      <template #append>
        <span id="t-input-group-text" class="input-group-text">
          {{ label }}
          <sup v-if="required">*</sup>
        </span>
      </template>
      <b-form-input
        id="t-form-input"
        :disabled="disabled"
        :value="value"
        :state="validateState(validationContext)"
        autocomplete="off"
        @input="onInput"
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
  name: 'TTextBoxString',
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
      // const isValid = dirty && validated ? valid : true
      this.isValid = valid
      return valid
    },
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

  #t-input-group-string {
    flex-wrap: nowrap;
    #t-input-group-text {
      direction: ltr;
      font-size: 0.8rem;
    }
    #t-form-input {
      text-align: left;
      direction: ltr;
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
