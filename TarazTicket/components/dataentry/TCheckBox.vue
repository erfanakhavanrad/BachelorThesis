<template>
  <span id="t-validation-provider">
    <b-input-group id="t-input-group-boolean" size="sm">
      <template #append>
        <span id="t-input-group-text-append" class="input-group-text">
          {{ label }}
        </span>
      </template>

      <template #prepend>
        <b-input-group-text id="t-input-group-text-prepend">
          <b-form-checkbox
            class="t-test"
            :checked="value"
            :disabled="disabled"
            @change="onChange"
          />
        </b-input-group-text>
      </template>
    </b-input-group>
    <p id="error-feedback" />
  </span>
</template>

<script>
export default {
  name: 'TCheckBox',
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
      type: Boolean,
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
  computed: {},
  created () {},
  methods: {
    onChange (value) {
      this.$emit('input', value)
    }
  }
}
</script>

<style lang="scss" scoped>
#t-validation-provider {
  direction: ltr;
  padding: 5px;

  #t-input-group-boolean {
    flex-wrap: nowrap;
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    align-items: center;
    #t-input-group-text-append {
      direction: rtl;
      font-size: 0.8rem;
    }
    #t-input-group-text-prepend {
      direction: rtl;
      font-size: 0.8rem;
      background-color: white;
      padding: 1px;
      padding-left: 7px;
      padding-right: 2px;
    }
    #error-feedback {
      text-align: right;
      color: #dc3545;
      font-size: 0.7rem;
    }
  }
}
</style>
