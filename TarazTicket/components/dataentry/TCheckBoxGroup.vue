<template>
  <span>
    <b-input-group id="t-input-group-checkboxgroup" size="sm">
      <template #append>
        <span id="t-input-group-text" class="input-group-text">
          {{ label }}
          <span v-if="required">*</span>
        </span>
      </template>
      <b-overlay :show="initializing || retrieving" spinner-variant="secondary">
        <template #overlay>
          <b-spinner small type="grow" />
        </template>
        <b-form-checkbox-group
          :id="id"
          v-model="selected"
          class="t-form-checkbox-group"
          :name="id"
          @change="onChanged"
        >
          <b-form-checkbox
            v-for="option in options"
            :key="option.value"
            :value="option.value"
          >
            <template #default>
              {{ option.text }}
            </template>
          </b-form-checkbox>
        </b-form-checkbox-group>
      </b-overlay>
    </b-input-group>
  </span>
</template>

<script>
export default {
  name: 'TCheckBoxGroup',
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
      type: Array,
      default () {
        return []
      }
    },
    rules: {
      type: Object,
      default: null
    },
    disabled: {
      type: Boolean,
      default: false
    },
    resourceData: {
      type: String,
      default: null,
      required: true
    },
    resourceMeta: {
      type: String,
      default: null,
      required: true
    },
    filterParams: {
      type: Object,
      default () {
        return {}
      }
    },
    mainFieldName: {
      /**
       * فیلدی که به عنوان متن داخل چک باکس ها نمایش میابد
       */
      type: String,
      default: null,
      required: true
    }
  },
  data () {
    return {
      selected: [], // آیتم سلکت شده
      initializing: true,
      retrieving: true,
      meta: null,
      data: []
    }
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
    isValid () {
      if (this.required) {
        if (this.selected.length === 0) {
          return false
        }
        return true
      } else {
        return true
      }
    },
    // #region cols
    cols () {
      // لیست ستون های از متا
      if (this.meta === null) {
        return []
      }
      return this.meta.cols
    },
    colPK () {
      // ستون کلید اصلی
      return this.cols.find(col => col.isPK)
    },
    pk () {
      // نام کلید اصلی
      return this.colPK.name
    },
    // #endregion
    // #region checkboxgroup
    options () {
      const options = []
      this.data.forEach((row) => {
        options.push({ value: row[this.pk], text: row[this.mainFieldName] })
      })
      return options
    }
    // #endregion
  },
  watch: {
    initializing: {
      async handler (_initializing) {
        if (!_initializing) {
          // وقتی متا از سرور واکشی شد نوبت به واکشی دیتا است
          await this.retrieveData()
        }
      }
    },
    retrieving: {
      handler (_retrieving) {
        if (!_retrieving) {
          //
        }
      }
    },
    value: {
      handler (_value) {
        // اگر ولیو از خارج کامپوننت پر شده است
        // باید چک باکس هاتیک بخورد
        this.selected = this.value
      }
    },
    isValid: {
      handler (_isValid) {
        this.onChangedValidation(_isValid)
      }
    }
  },
  async created () {
    // واکشی متا از سرور
    await this.retrieveMeta()
    this.onChangedValidation(this.isValid)
  },
  mounted () {
    this.$emit('input', this.value)
  },
  methods: {
    // #region call api
    async retrieveMeta () {
      // واکشی متا( اطلاعات مربوط به ستون ها) از سرور
      this.initializing = true
      const response = await this.$taxios.get(this.resourceMeta)
      this.meta = response.data
      this.initializing = false
    },
    async retrieveData () {
      // واکشی دیتا( سطرها) از سرور
      this.retrieving = true
      const filterParams = JSON.parse(JSON.stringify(this.filterParams))
      Object.keys(filterParams).forEach((key, val) => {
        if (filterParams[key] === null || filterParams[key] === '') {
          delete filterParams[key]
        }
      })
      filterParams.pageNumber = 1
      filterParams.recordCount = 10001
      const response = await this.$taxios.get(this.resourceData, filterParams)
      if (response.data !== '') {
        this.data = response.data
      }
      this.retrieving = false
    },
    // #endregion
    // #region select
    onChanged (selected) {
      this.$emit('input', selected)
    },
    // #endregion
    onChangedValidation (isValid) {
      const _validation = {}
      _validation[this.id] = isValid
      this.$emit('onChangedValidation', _validation)
    }
  }
}
</script>

<style lang="scss" scoped>
span {
  direction: ltr;
  padding: 5px;
  #t-input-group-checkboxgroup {
    flex-wrap: nowrap;
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    #t-input-group-text {
      direction: rtl;
      align-items: flex-start;
      font-size: 0.8rem;
    }
    .t-form-checkbox-group {
      display: flex;
      flex-direction: row;
      flex-wrap: wrap;
      direction: rtl;
      justify-content: flex-end;
      border: 1px solid #ced4da;
      padding: 10px;
      border-radius: 0.2rem;
    }
  }
}
</style>
