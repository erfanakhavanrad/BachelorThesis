<template>
  <span>
    <b-input-group id="t-input-group-range" size="sm">
      <template #append>
        <span id="t-input-group-text" class="input-group-text">
          {{ label }}
        </span>
      </template>
      <b-form-input
        id="t-form-input"
        type="range"
        :disabled="disabled"
        :value="value"
        :step="step"
        :min="min"
        :max="max"
        @input="onInput"
      />
      <template #prepend>
        <span id="t-input-group-text" class="input-group-text">
          {{ value }}
        </span>
      </template>
    </b-input-group>

    <p id="error-feedback" />
  </span>
</template>

<script>
export default {
  name: 'TTextBoxRange',
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
      default: 0
    },
    step: {
      type: Number,
      default: 1
    },
    min: {
      type: Number,
      default: 0
    },
    max: {
      type: Number,
      default: 100
    },
    disabled: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {}
  },
  computed: {},
  methods: {
    onInput (value) {
      this.$emit('input', parseInt(value))
    }
  }
}
</script>

<style lang="scss" scoped>
span {
  direction: ltr;
  padding: 5px;
  #t-input-group-range {
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
    font-size: 0.8rem;
  }
}
</style>
