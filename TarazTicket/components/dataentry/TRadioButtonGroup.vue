<template>
  <span>
    <b-input-group id="t-input-group-radiogroup" size="sm">
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
        <div class="t-form-radio-group">
          <b-form-radio-group
            v-for="(options, key) in optionsGroupByFieldName"
            :id="key"
            :key="key"
            v-model="selected[key]"
            :name="key"
          >
            <b-form-radio
              v-for="option in options"
              :key="option.value"
              :value="option.value"
            >{{ option.text }}</b-form-radio>
          </b-form-radio-group>
        </div>
      </b-overlay>
      <template #prepend>
        <b-button
          style="z-index: 1"
          variant="outline-secondary"
          title="عدم انتخاب همه گزینه ها"
          @click="onClear"
        >
          <font-awesome-icon icon="brush" size="lg" />
        </b-button>
      </template>
    </b-input-group>
  </span>
</template>

<script>
export default {
  name: 'TRadioButtonGroup',
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
    },
    groupByFieldName: {
      /**
       * اگر این فیلد پر شود آیتم هایی که این فیلدشان مشترک است
       * به صورت دکمه رادیویی می آید
       */
      type: String,
      default: null,
      required: false
    }
  },
  data () {
    return {
      initializing: true,
      retrieving: true,
      meta: null,
      data: [],
      selected: {}
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
        if (JSON.stringify(this.selected) === '{}') {
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
    // #region radiogroup
    optionsNotGroupBy () {
      const options = []
      this.data.forEach((row) => {
        options.push({
          name: row[this.groupByFieldName],
          value: row[this.pk],
          text: row[this.mainFieldName]
        })
      })
      return options
    },
    optionsGroupByFieldName () {
      return this.groupBy(this.optionsNotGroupBy, 'name')
    },
    selectedToArray () {
      // selected
      // آبجکت است و برای این که به پرنت برگردد باید تبدیل به آرایه شود
      const arr = []
      Object.keys(this.selected).forEach((key, val) => {
        if (this.selected[key] != null) {
          arr.push(this.selected[key])
        }
      })
      return arr
    },
    isReady () {
      // زمانی که هم
      // لیست رادیو باتن ها
      // و هم
      // لیست رادیو هایی که باید تیک بخورد
      // لود شود
      // true
      // ریترن می شود
      if (this.value != null && this.optionsNotGroupBy.length > 0) {
        return true
      }
      return false
    }
    // #endregion
  },
  watch: {
    isReady: {
      handler (_isReady, _isReadyOld) {
        if (_isReady && _isReadyOld != null && !_isReadyOld) {
          if (this.value != null) {
            const _selected = {}
            this.value.forEach((item) => {
              const target = this.optionsNotGroupBy.find((option) => {
                return item === option.value
              })
              if (target !== undefined) {
                _selected[target.name] = item
              }
            })
            this.selected = _selected
          }
        }
      }
    },
    selectedToArray: {
      handler (_selectedToArray) {
        this.$emit('input', _selectedToArray)
      }
    },
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
    isValid: {
      handler (_isValid) {
        this.onChangedValidation(_isValid)
      }
    },
    value: {
      handler (_value) {
        if (_value === null) {
          this.selected = {}
        }
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
    onClear () {
      //
      this.selected = {}
    },
    groupBy (xs, key) {
      // این متد برای گروپ بندی است بر اساس فیلدی که معرفی شذه
      // آرایه را اسپلیت میکند
      return xs.reduce(function (rv, x) {
        ;(rv[x[key]] = rv[x[key]] || []).push(x)
        return rv
      }, {})
    },
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
      filterParams.recordCount = 10003
      const response = await this.$taxios.get(this.resourceData, filterParams)
      if (response.data !== '') {
        this.data = response.data
      }

      this.retrieving = false
    },
    // #endregion
    // #region select
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
  #t-input-group-radiogroup {
    flex-wrap: nowrap;
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    #t-input-group-text {
      direction: rtl;
      align-items: flex-start;
      font-size: 0.8rem;
    }
  }
  .t-form-radio-group {
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
</style>
