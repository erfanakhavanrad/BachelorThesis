<template>
  <b-overlay :show="isLoading">
    <b-card
      ref="card"
      header-tag="header"
      footer-tag="footer"
      header-class="t-card-header"
      body-class="t-card-body"
      footer-class="t-card-footer"
      class="t-card"
    >
      <template #header>
        <div id="t-title">
          {{ title }}
        </div>
      </template>
      <slot name="dataEntryElements" />
      <template #footer>
        <b-button-group size="sm">
          <b-button variant="secondary" title="بازگشت" @click="onReturn">
            <span>بازگشت</span>
            <font-awesome-icon icon="undo" size="lg" />
          </b-button>
          <b-button
            variant="info"
            title="اعمال تغییرات"
            :disabled="!isValid"
            @click="onUpdate"
          >
            <span>اعمال تغییرات</span>
            <font-awesome-icon icon="check" size="lg" />
          </b-button>
        </b-button-group>
      </template>
    </b-card>
  </b-overlay>
</template>

<script>
export default {
  components: {},
  props: {
    // #region public
    title: {
      type: String,
      default: null,
      required: true
    },
    resourceData: {
      type: String,
      default: null,
      required: true
    },
    dataEntryModel: {
      type: Object,
      default () {
        return {}
      },
      required: true
    },
    validation: {
      /**
       * کدام فبلد ها اجباری است
       */
      type: Object,
      default () {
        return {}
      },
      required: true
    }
    // #endregion
  },
  data () {
    return {
      isLoading: false
    }
  },
  computed: {
    parentRoute () {
      // نام فرم پرنت این دیتا انتری
      return this.$route.name.split('-')[0]
    },
    recordID () {
      return this.$route.query.id
    },
    isValid () {
      // برای تک تک فیلد ها ولیدیشن چک میشود و به محض این که یک فیلد ولید نبود کل فرم غیر ولید میشود
      for (const key in this.validation) {
        if (!this.validation[key]) {
          return false
        }
      }
      return true
    }
  },
  async created () {
    this.isLoading = true
    await this.retrieveRecord()
    this.isLoading = false
  },
  methods: {
    async retrieveRecord () {
      // واکشی این رکورد خاص از سرور
      const response = await this.$taxios.get(
        this.resourceData + '/' + this.recordID
      )
      this.$emit('onRetrieveRecord', response.data)
      // this.$emit('input', response.data)
    },
    onUpdate () {
      this.isLoading = true
      const dataEntryModel = JSON.parse(JSON.stringify(this.dataEntryModel))
      this.$taxios
        .put(this.resourceData, this.recordID, dataEntryModel)
        .then((response) => {
          this.isLoading = false
          if (response.status === 200) {
            this.$ttoast.createToast(
              'info',
              200,
              'OK',
              'Record updated successfully',
              'رکورد با موفقیت آپدیت شد',
              3000
            )
          }
        })
        .catch(() => {
          this.isLoading = false
        })
    },
    onReturn () {
      this.$router.push({
        name: this.parentRoute
      })
    }
  }
}
</script>
<style lang="scss" scoped>
$menuHeight: 80px; // ارتفاع منوی بالای صفحه
// #region card
$cardMargin: 1rem; // مارجین کارد
$cardHeaderHeight: 4rem; // ارتفاع هدر کارد
$cardBodyMargin: 1rem; // مارجین بادی کارد
// #endregion

// #region footer
$actionButtonWidth: 9rem; // عرض دکمه های فوتر
// #endregion

.t-card {
  margin: $cardMargin;
  .t-card-header {
    z-index: 2;
    height: $cardHeaderHeight;
    position: sticky;
    top: $menuHeight;
    // background-color: var(--t-color-0-96);
    background: #e1e3e4; /* fallback for old browsers */
    background: -webkit-linear-gradient(
      to bottom,
      #f4f7f8,
      #e1e3e4
    ); /* Chrome 10-25, Safari 5.1-6 */
    background: linear-gradient(
      to bottom,
      #f4f7f8,
      #e1e3e4
    ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    // border: 1px solid var(--t-color-0-80);

    #t-title {
      align-self: center;
      font-weight: bold;
    }
  }
  .t-card-body {
    padding: $cardBodyMargin;
  }
  .t-card-footer {
    display: flex;
    flex-direction: row;
    direction: ltr;
    justify-content: right;
    button {
      width: $actionButtonWidth;
    }
  }
}
</style>
