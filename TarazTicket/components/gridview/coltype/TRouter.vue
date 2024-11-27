<template>
  <div :id="id" class="t-container-router">
    <b-button size="sm" :variant="variant" @click="onClick()">
      <font-awesome-icon
        v-if="value.icon != null"
        :icon="value.icon"
        size="lg"
        class="t-icon"
      />
      <span :class="spanClassName">{{ value.value }}</span>
      <!-- this v-if for handle -->
      <span v-if="keyNameField.includes('Number')" class="hashtag"> #</span>
    </b-button>
  </div>
</template>

<!-- <template>
  <div :id="id" class="t-container-router">
    <NuxtLink :to="onClick()">
      <font-awesome-icon
        v-if="value.icon != null"
        :icon="value.icon"
        size="lg"
        class="t-icon"
      />
      <span :class="spanClassName">{{ value.value }}</span>
    </NuxtLink>
  </div>
</template> -->

<script>
export default {
  name: 'TRouter',
  props: {
    id: {
      type: String,
      default: null
    },
    // for handle hashtag in ticketNumber and all field Name that have 'Number'
    keyNameField: {
      type: String,
      default: ''
    },
    value: {
      type: Object,
      default () {
        return {}
      }
    }
  },
  computed: {
    variant () {
      // if (this.value.query == null) {
      //   return 'outline-light'
      // }
      return 'outline-light'
      // return 'primary'
    },
    spanClassName () {
      if (this.value.query == null) {
        return 'span1'
      }
      return 'span2'
    }
  },
  methods: {
    onClick () {
      // console.log(this.key)
      // فقط باید پست کنیم به لاگ با تیکت ای دی که همین آیدی این کامپوننت میشه اگه فیلدش TicketNumber یا TicketTitle بود
      const resourceData = 'tkt/ticketlogs/' + this.id
      // const dataEntryModel = {}
      console.log('this.keyNameField')
      console.log(this.keyNameField)
      if (
        this.keyNameField.includes('ticketNumber') ||
        this.keyNameField.includes('ticketTitle')
      ) {
        this.$taxios
          .post(resourceData, null)
          .then((response) => {
            this.isLoading = false
            if (response.status === 200) {
              // this.$ttoast.createToast(
              //   'success',
              //   200,
              //   'OK',
              //   'Record inserted successfully',
              //   'رکورد با موفقیت اضافه شد',
              //   3000
              // )
              // this.$emit('onInserted', response.data)
            }
          })
          .catch(() => {
            this.isLoading = false
          })
      }

      this.$router.push({
        name: this.value.name,
        params: this.value.params,
        query: this.value.query
      })
    }
  }
}
</script>
<style lang="scss" scoped>
.t-container-router {
  display: flex;
  flex-direction: row;
  justify-content: center;
  .t-icon {
    color: gray;
  }
  .span1 {
    color: gray;
  }
  .span2 {
    // color: gray;
    // text-decoration: underline
    // color: var(--t-color-20-15);
    color: var(--t-color-70-40);
    text-decoration: none;
  }
}
.hashtag {
  color: gray;
}
</style>
