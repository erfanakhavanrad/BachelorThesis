<template>
  <b-card class="t-b-card" no-body>
    <b-card-header header-class="t-b-card-header">
      <div id="t-container-card-header">
        <span>{{ label }}</span>
        <div id="t-container-actionbar">
          <b-button
            size="sm"
            variant="light"
            title="حذف فابل های انتخابی"
            class="t-action"
            @click="onDeleteSelectedFiles"
          >
            <font-awesome-icon icon="trash" />
          </b-button>

          <b-form-checkbox
            id="checkbox-selectall"
            v-model="isSelectAllFiles"
            name="checkbox-selectall"
            class="t-action"
          />
        </div>
      </div>
    </b-card-header>
    <b-card-body body-class="t-b-card-body">
      <div
        v-for="(file, index) in files"
        :key="index"
        class="t-container-file-preview"
      >
        ss

        <!-- <b-form-checkbox
          id="checkbox-select-specific-file"
          v-model="isSelectSpecificFile"
          name="checkbox-select-specific-file"
          class="t-action"
        /> -->
      </div>
      <div class="t-container-file-add">
        <b-button
          size="lg"
          variant="outline-secondary"
          title="افزودن فایل"
          class="t-button-file-add"
          @click="onClickAddFile"
        >
          <font-awesome-icon icon="plus" size="lg" />
        </b-button>
        <b-form-file
          id="t-form-file"
          v-model="selectedFile"
          class="t-form-file"
          @input="onSelectFile"
        />
      </div>
    </b-card-body>
  </b-card>
</template>
<!--  -->
<script>
export default {
  name: 'TFileManager',
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
      isSelectAllFiles: null,
      selectedFile: null,
      files: [1, 2],
      trashFiles: []
    }
  },
  computed: {},
  watch: {
    isSelectAllFiles: {
      handler (_isSelectAllFiles) {
        if (_isSelectAllFiles) {
          for (const file in this.files) {
            this.trashFiles.push(this.files[file])
          }
        } else {
          for (const file in this.files) {
            this.trashFiles.pop(this.files[file])
          }
        }
      }
    }
  },
  mounted () {},
  methods: {
    // onChangedCheckboxSelectAll (bb) {
    //   console.log(bb)
    // },
    onDeleteSelectedFiles () {
      for (const file in this.trashFiles) {
        this.files.pop(this.trashFiles[file])
        this.trashFiles.pop(file)
      }
      console.log('delete all files')
    },
    onClickAddFile () {
      // console.log(this.$refs.file)
      document.getElementById('t-form-file').click()

      // this.$refs.file.click()
    },
    async onSelectFile () {
      const u8 = new Uint8Array(await this.selectedFile.arrayBuffer())
      const b64 = Buffer.from(u8).toString('base64')
      const arr = new Uint8Array(
        await this.selectedFile.arrayBuffer()
      ).subarray(0, 4)
      let header = ''
      for (let i = 0; i < arr.length; i++) {
        header += arr[i].toString(16)
      }
      console.log(header)
      this.files.push(b64)
    }
  }
}
</script>

<style lang="scss" scoped>
.t-b-card {
  .t-b-card-header {
    height: 2.5rem;
    display: flex;
    flex-direction: row;
    align-items: center;

    #t-container-card-header {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      flex-grow: 1;
      #t-container-actionbar {
        display: flex;
        flex-direction: row;
        align-items: center;
        .t-action {
          margin-right: 1rem;
        }
      }
    }
  }
  .t-b-card-body {
    display: flex;
    flex-direction: row;
    padding: 0;
    flex-wrap: wrap;
    .t-container-file-add {
      display: flex;
      width: 5rem;
      height: 5rem;
      margin: 1rem;
      .t-button-file-add {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        flex-grow: 1;
      }
      .t-form-file {
        display: none;
      }
    }
    .t-container-file-preview {
      display: flex;
      width: 5rem;
      height: 5rem;
      border: 1px solid gray;
      margin: 1rem;
    }
  }
}
// #t-container-file-manager {
//   display: flex;
//   flex-direction: row;
//   flex-wrap: wrap;
// }
</style>
