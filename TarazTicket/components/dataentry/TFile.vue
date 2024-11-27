<template>
  <span id="t-validation-provider">
    <b-input-group id="t-input-group-file" size="sm">
      <template #append>
        <span id="t-input-group-text" class="input-group-text">
          {{ label }}
        </span>
      </template>
      <b-form-file
        :id="id"
        v-model="file"
        class="t-form-file"
        browse-text="انتخاب"
        :disabled="disabled"
        :state="null"
        placeholder="فایل را انتخاب کنید یا اینجا رها کنید"
        drop-placeholder="فایل را اینجا رها کنید"
        aria-placeholder=""
        @input="onInput"
      />
      <template #prepend>
        <b-button
          style="z-index: 1"
          variant="outline-danger"
          title="حذف فایل"
          @click="onClearFile"
        >
          <font-awesome-icon icon="trash" size="lg" />
        </b-button>
      </template>
    </b-input-group>
    <p id="t-container-image">
      <img style="display: block; width: 100px; height: 100px" :src="src">
    </p>
  </span>
</template>

<script>
export default {
  name: 'TFile',
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
      type: String,
      default: null
    },
    disabled: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {
      file: null
    }
  },
  computed: {
    src () {
      // console.log(this.value)
      if (this.value == null) {
        return null
      }
      return `data:${this.type};base64, ${this.value}`
    }
  },
  // watch: {
  //   file: {
  //     async handler (_file) {
  //       const u8 = new Uint8Array(await _file.arrayBuffer())
  //       console.log(u8)
  //     }
  //   }
  // },
  mounted () {},
  methods: {
    async onInput () {
      if (this.file != null) {
        const u8 = new Uint8Array(await this.file.arrayBuffer())
        const b64 = Buffer.from(u8).toString('base64')
        // فایل انتخاب شده به بیس ۶۴ تبدیل شده و به بیرون بر میگردد
        this.$emit('input', b64)
        const attachment = { type: this.file.type, aName: this.file.name }

        this.$emit('on-input-file', attachment)
      } else {
        const attachment = { type: null, aName: null }
        this.$emit('input', null)
        this.$emit('on-input-file', attachment)
      }
    },
    onClearFile () {
      // this.file = null
      this.$emit('input', null)
    }
  }
}
</script>

<style lang="scss" scoped>
#t-validation-provider {
  direction: ltr;
  padding: 5px;

  #t-input-group-file {
    flex-wrap: nowrap;
    #t-input-group-text {
      direction: rtl;
      font-size: 0.8rem;
    }
    .t-form-file {
      height: 100%;
    }
  }

  #t-container-image {
    direction: rtl;
    padding: 1px;
    img {
      border: 1px solid var(--t-color-0-0-75);
    }
  }
}
</style>
