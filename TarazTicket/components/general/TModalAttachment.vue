<template>
  <b-modal id="t-modal-attachment" :title="title" />
</template>
<script>
export default {
  name: 'TModalAttachment',
  props: {
    // fileAttachment: {
    //   type: Image,
    //   default: null
    // }
  },
  data () {
    return { title: 'فایل' }
  }
}
</script>
