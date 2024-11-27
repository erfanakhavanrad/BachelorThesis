<template>
  <span>
    <b-input-group id="t-input-group-combo" size="sm">
      <template #append>
        <span id="t-input-group-text" class="input-group-text">
          {{ label }}
          <sup v-if="required">*</sup>
        </span>
      </template>
      <b-overlay :show="initializing || retrieving" spinner-variant="secondary">
        <template #overlay>
          <b-spinner small type="grow" />
        </template>
        <b-dropdown
          :id="`t-dropdown_${id}`"
          ref="dropdown"
          variant="outline-secondary"
          class="t-dropdown"
          right
          toggle-class="t-toggle"
          menu-class="t-menu shadow"
        >
          <template #button-content>
            <span v-if="selected == null" class="t-content">---</span>
            <span v-else class="t-content">{{ selected.text }}</span>
          </template>
          <template #default>
            <div class="t-container-options" :style="containerOptionsStyle">
              <b-dropdown-form
                form-class="t-dropdown-form"
              ><b-form-input
                id="t-form-input"
                placeholder="جستجو"
                @input="onInputSearch"
              /></b-dropdown-form>
              <b-dropdown-item
                :active="selected == null"
                class="t-dropdown-text"
                @click="onSelectItem(null)"
              >---</b-dropdown-item>

              <template v-for="option in _options">
                <b-dropdown-text
                  :key="option.value"
                  :class="
                    selected != null && option.value === selected.value
                      ? 't-dropdown-text active'
                      : 't-dropdown-text'
                  "
                  @click="onSelectItem(option)"
                >{{ option.text }}</b-dropdown-text>

                <!-- <b-dropdown-item
                  :key="option.value"
                  :active="selected != null && option.value === selected.value"
                  class="t-dropdown-item"
                  @click="onSelectItem(option)"
                >{{ option.text }}</b-dropdown-item> -->
              </template>
            </div>
          </template>
        </b-dropdown>
      </b-overlay>
    </b-input-group>
    <p />
  </span>
</template>

<script>
export default {
  name: 'TComboBox',
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
    resourceData: {
      type: String,
      default: null
    },
    resourceMeta: {
      type: String,
      default: null
    },
    filterParams: {
      type: Object,
      default () {
        return {}
      }
    },
    mainFieldName: {
      /**
       * فیلدی که به عنوان متن داخل کمبو نمایش میابد
       */
      type: String,
      default: null
    },
    options: {
      /**
       * زمانی که آیتم های کمبو از بصورت هارد کدی پاس داده میشود
       */
      type: Array,
      default () {
        return []
      }
    },
    async: {
      type: Boolean,
      default: false
    },
    pkSubstitute: {
      /**
       * ممکن است نام کلید اصلی در جدول دیتابیس مثلا
       * userID
       * باشد ولی ما نیاز داریم این فیلد با نام
       * toUserID
       * در دیتاانتری مدل بنشیند . بخاطر همین در این گونه موارد برای کلید اصلی نام جایگزین
       * در نظر میگیریم
       */
      type: String,
      default: null
    }
  },
  data () {
    return {
      search: null, // مقدار تکست باکس سرچ
      selected: null, // آیتم سلکت شده
      initializing: true,
      retrieving: false,
      meta: null,
      data: [],
      optionsLength: 0
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
    mode () {
      if (this.options.length === 0) {
        // یعنی دیتا باید از وب سرویس خوانده شود
        return 'SERVER'
      }
      // یعنی دیتا از بیرون پاس داده میشود
      return 'LOCAL'
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
    // #region combo
    containerOptionsStyle () {
      let height = 50
      // height += (this._options.length + 1) * 32
      height += (this.optionsLength + 1) * 32
      // console.log('set the height')
      // console.log(height)
      if (height > 600) {
        return 'height: 20rem;'
      }
      return `height: ${height}px;`
    },
    _options () {
      let options = []
      // let hello = []
      // console.log('before set the options in computed')
      if (this.mode === 'SERVER') {
        options = this.testToorkhodaBesho()
        // console.log(options)
      } else {
        this.options.forEach((option) => {
          if (this.search == null || option.text.includes(this.search)) {
            options.push({ value: option.value, text: option.text })
          }
        })
      }
      // console.log(
      // 'after set options in computed and before returning data to template'
      // )
      // console.log(options)
      return options
    }
    // #endregion
  },
  watch: {
    initializing: {
      async handler (_initializing) {
        if (this.mode === 'SERVER') {
          if (!this.async) {
            // همزمان
            // وقتی که کمبو به هیچ آیتم دیگری وابسته نیست باید به محض ایجاد شدن دیتا بگیرد
            if (!_initializing) {
              // وقتی متا از سرور واکشی شد نوبت به واکشی دیتا است
              await this.retrieveData()
            }
          } else {
            // غیر همزمان
            // وقتی که کمبو به آیتم دیگری وابسته است برای پر شدن باید منتظر دستور بماند
          }
        }
      }
    },
    retrieving: {
      handler (_retrieving) {
        if (!_retrieving) {
          // وقتی که دیتا از سرور فراخوانی شد اگر ولیو از خارج کامپوننت پر شده است
          // باید کمبو پر شود
          if (this.value != null) {
            this.data.forEach((row) => {
              if (row[this.pk] === this.value) {
                this.onSelectItem({
                  value: this.value,
                  text: row[this.mainFieldName]
                })
              }
            })
          }
        }
      }
    },
    value: {
      handler (_value) {
        if (_value == null) {
          this.selected = null
        }
        this.onChangedValidation(_value)
      }
    },

    resourceData: {
      async handler (_resourceData, _resourceDataOld) {
        this.onSelectItem(null)
        if (_resourceData !== null) {
          await this.retrieveData()
        }

        // if (_resourceDataOld != null) {
        //   console.log(_resourceDataOld)
        // }

        // // اگر ریسورس تغییر کند باید دوباره دیتا از سرور لود شود
        // this.onSelectItem(null)
        // if (_resourceData == null) {
        //   //
        // } else if (_resourceDataOld != null) {
        //   console.log(this.id, _resourceData, _resourceDataOld)
        //   // خیلی مسخره است
        //   // وقتی در یک صفحه چند تا کمبو داریم ریسورس دیتای کمبوی قبلی
        //   // در ریسورس دیتای اولد کمبوی بعدی قرار میگیرد
        //   // برای همین مشکل بوجود میاد
        //   // و شرط زیر را نوشتم تا از بروز مشکل جلوگیری بشه
        //   const entityName = _resourceData.split('/')[1]
        //   const entityNameOld = _resourceDataOld.split('/')[1]
        //   if (entityName === entityNameOld) {
        //     await this.retrieveData()
        //   }
        // }
      }
    },
    filterParams: {
      async handler (_filterParams) {
        // اگر فیلتر پارامز تغییر کند باید دوباره دیتا از سرور لود شود
        this.onSelectItem(null)
        if (JSON.stringify(_filterParams) === '{}') {
          //
        } else {
          await this.retrieveData()
        }
      }
    }
  },
  async created () {
    if (this.mode === 'SERVER') {
      // واکشی متا از سرور
      await this.retrieveMeta()
    } else {
      this.initializing = false
      this.retrieving = false
    }
    this.onChangedValidation(this.value)
  },
  methods: {
    // #region call api
    async retrieveMeta () {
      // واکشی متا( اطلاعات مربوط به ستون ها) از سرور
      this.initializing = true
      const response = await this.$taxios.get(this.resourceMeta)
      this.meta = response.data
      this.initializing = false
      // console.log(this.meta)
    },
    async retrieveData () {
      // واکشی دیتا( سطرها) از سرور
      this.retrieving = true
      this.search = null
      this.selected = null
      this.data = []
      const filterParams = JSON.parse(JSON.stringify(this.filterParams))
      Object.keys(filterParams).forEach((key, val) => {
        if (filterParams[key] === null || filterParams[key] === '') {
          delete filterParams[key]
        }
      })
      filterParams.pageNumber = 1
      filterParams.recordCount = 10000000
      const response = await this.$taxios.get(this.resourceData, filterParams)
      if (response.data !== '') {
        this.data = response.data
      }
      this.retrieving = false
    },
    testToorkhodaBesho () {
      const options = []
      if (this.search == null) {
        this.data.forEach((row) => {
          options.push({ value: row[this.pk], text: row[this.mainFieldName] })
          // console.log('searching for all data')
          // console.log(options)
        })
        // console.log('when search is null | All Data')
        // console.log(options)
      } else {
        // setTimeout(async () => {
        this.data.forEach((row) => {
          if (row[this.mainFieldName].includes(this.search)) {
            options.push({
              value: row[this.pk],
              text: row[this.mainFieldName]
            })
          }
          // console.log('searching for Filtered Data')
          // console.log(options)
        })
        // }, 500)
        // console.log('when user search sth')
        // console.log(options)
      }
      this.optionsLength = options.length
      // console.log('options length')
      // console.log(this.optionsLength)
      // console.log('return data from method')
      return options
    },
    // #endregion
    // #region search & select
    onInputSearch (value) {
      this.search = value
      // console.log(this.search)
      // console.log(value)
    },
    onSelectItem (option) {
      this.$refs.dropdown.hide(true)
      this.selected = option
      if (option == null) {
        this.$emit('input', null)
        this.$emit('onSelect', null)
        this.$emit('change', null)
      } else {
        this.$emit('input', option.value)
        this.$emit('change', option.value)
        this.$emit('onSelect', option.text)
      }
    },
    // #endregion
    onChangedValidation (value) {
      const _validation = {}
      if (this.required) {
        if (value == null) {
          _validation[this.id] = false
        } else {
          _validation[this.id] = true
        }
      } else {
        _validation[this.id] = true
      }

      this.$emit('onChangedValidation', _validation)
    }
  }
}
</script>

<style lang="scss" scoped>
span {
  direction: ltr;
  padding: 5px;
  #t-input-group-combo {
    flex-wrap: nowrap;
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    #t-input-group-text {
      direction: rtl;
      font-size: 0.8rem;
    }
    :deep(#t-input-group-text) {
      text-align: right;
      border-left: none;
      border-top-left-radius: 0;
      border-bottom-left-radius: 0;
    }
    .t-dropdown {
      height: 100%;
      // z-index: 3;
      .t-content {
        font-size: 0.8rem;
        white-space: normal;
      }
      .t-container-options {
        overflow: auto;
        width: 14rem;
      }
      :deep(.t-toggle) {
        text-align: right;
        border-right: none;
        border-top-right-radius: 0;
        border-bottom-right-radius: 0;
        border: 1px solid #ced4da;
        padding: 0;
        padding-right: 0.5rem;
      }

      :deep(.t-menu) {
        padding: 0;
        li {
          &:first-child {
            position: sticky;
            top: 0;
            background-color: var(--t-color-0-5-90);
          }
        }

        .t-dropdown-form {
          #t-form-input {
            text-align: right;
          }
        }
        .t-dropdown-text {
          display: flex;
          flex-direction: row;
          justify-content: flex-start;
          align-items: flex-start;
          text-align: right;
          :hover {
            background-color: var(--t-color-70-40);
            cursor: pointer;
            color: white;
          }
        }

        .active {
          background-color: var(--t-color-90-70);
          color: white;
        }
      }
    }
  }
}
.position-relative {
  margin-left: auto;
}
</style>
