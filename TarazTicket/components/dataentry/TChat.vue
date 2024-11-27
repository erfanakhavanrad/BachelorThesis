<template>
  <div :class="containerClass">
    <div :class="popoverClass">
      <div v-if="!isFirstComment" :class="convArrowColor()" />
      <h3 :class="convBoxColor()">
        <div class="t-actionbar-owner">
          <div class="t-actionbar">
            <div
              v-if="!isFirstComment && ticket.statusID !== 10000007"
              class="t-actionbar-button"
              @click="onClickReplyChat(conversation)"
            >
              <font-awesome-icon icon="reply" size="sm" />
            </div>
            <!-- اگر این پیام پیام من باشد و پیام اول نباشد و روی آن رپلای نخورده باشد میتوان حذفش کرد -->
            <div
              v-if="
                isMyComment &&
                  !isFirstComment &&
                  !isRepliedComment &&
                  ticket.statusID !== 10000007
              "
              class="t-actionbar-button"
              @click="onClickDeleteChat(conversation.ticketConversationID)"
            >
              <font-awesome-icon icon="trash" size="sm" />
            </div>
            <!-- اگر این پیام پیام من باشد و پیام اول نباشد و روی آن رپلای نخورده باشد میتوان ویرایشش کرد -->
            <div
              v-if="
                isMyComment &&
                  !isFirstComment &&
                  !isRepliedComment &&
                  ticket.statusID !== 10000007
              "
              class="t-actionbar-button"
              @click="onClickEditChat(conversation)"
            >
              <font-awesome-icon icon="edit" size="sm" />
            </div>

            <div v-if="conversation.isConfidential" class="t-confirential-icon">
              <font-awesome-icon icon="user-secret" size="sm" />
              <span v-if="conversation.referName">({{ conversation.referName }})</span>
              <span>محرمانه</span>
            </div>
          </div>
          <span>{{ conversation.fromUserName }}</span>
        </div>
        <div
          v-if="conversation.ticketConversationReferID != null"
          class="t-ref-chat"
        >
          <span
            class="t-owner"
          ><i>{{ conversation.toUserName }}</i></span>
          <span class="t-chat-desc">{{ conversation.ticketDescRefer }}</span>
        </div>
      </h3>
      <div class="popover-body t-popover-body">
        <span class="t-chat-desc">{{ conversation.ticketDesc }}</span>

        <div v-if="conversation.staffSignature !== null" id="staff-signature">
          <!-- <br> -->
          <hr>
          <span>
            {{ conversation.staffSignature }}
          </span>
        </div>
        <div class="t-chat-footer">
          <div
            v-if="conversation.hasAttachment"
            class="t-link-button"
            @click="onClickShowAttachment()"
          >
            <font-awesome-icon icon="file-download" size="sm" />
          </div>
          <span
            class="t-time-diff"
          ><i>{{ conversation.modifyDateS }}</i></span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
// import JsZip from 'jszip'
export default {
  name: 'TChat',
  components: {},
  props: {
    conversation: {
      type: Object,
      default () {
        return {}
      },
      required: true
    },
    ticket: {
      type: Object,
      default () {
        return {}
      },
      required: true
    }
  },
  data () {
    return { innerTicketID: null }
  },
  computed: {
    ...mapGetters({
      perComID: '_user/GET_PERCOMID',
      token: 'authentication/GET_TOKEN'
    }),
    isMyComment () {
      return this.conversation.creatorID === this.perComID
    },
    isFirstComment () {
      return this.conversation.isFirst
    },
    isRepliedComment () {
      // آیا به این چت رپلای خورده
      return this.conversation.isReplied
    },
    containerClass () {
      if (this.isFirstComment) {
        return 't-container-chat-is-first'
      }
      return this.isMyComment
        ? 't-container-chat t-container-chat-right'
        : 't-container-chat t-container-chat-left'
    },
    popoverClass () {
      return this.isMyComment
        ? 'popover bs-popover-left t-popover shadow'
        : 'popover bs-popover-right t-popover shadow'
    }
  },
  created () {
    this.innerTicketID = this.ticket.ticketID
  },
  mounted () {},
  methods: {
    convBoxColor () {
      if (this.conversation.isConfidential) {
        return 'popover-header t-popover-header t-confidential'
      } else if (this.isMyComment) {
        return 'popover-header t-popover-header t-my-comment'
      } else {
        return 'popover-header t-popover-header'
      }
    },
    convArrowColor () {
      if (this.conversation.isConfidential) {
        return 'arrow t-arrow-confidentail'
      } else if (this.isMyComment) {
        return 'arrow t-arrow t-arrow-my-comment'
      } else {
        return 'arrow t-arrow'
      }
    },
    onClickReplyChat (conversation) {
      this.$emit('onClickReplyChat', conversation)
    },
    onClickDeleteChat (ticketConversationID) {
      this.$emit('onClickDeleteChat', ticketConversationID)
    },
    onClickEditChat (conversation) {
      this.$emit('onClickEditChat', conversation)
    },
    onClickShowAttachment () {
      this.$taxios
        .get(
          `tkt/tickets/${this.innerTicketID}/conversations/${this.conversation.ticketConversationID}/attachmentFile`,
          null
        )
        .then((response) => {
          if (response.status === 200) {
            console.log(response)
            console.log(this.innerTicketID)
            const attachFile = response.data.attachmentFile
            const fileName = response.data.fileName
            const fileType = response.data.fileType
            const a = document.createElement('a')
            const linkSource = `data:${fileType};base64,${attachFile}`
            a.href = linkSource
            a.download = fileName
            a.click()
            a.remove()
          }
        })
    }

    // returnFile () {
    //   this.$taxios
    //     .get(
    //       `tkt/tickets/${this.ticket.ticketID}/conversations/${this.conversation.ticketConversationID}/attachmentFile`,
    //       null
    //     )
    //     .then((response) => {
    //       if (response.status === 200) {
    //         console.log(response)
    //         console.log(this.ticket.ticketID)
    //         const attachFile = response.data.attachmentFile
    //         const fileName = response.data.fileName
    //         const fileType = response.data.fileType
    //         const a = document.createElement('a')
    //         const linkSource = `data:${fileType};base64,${attachFile}`
    //         a.href = linkSource
    //         a.download = fileName
    //         a.click()
    //         a.remove()
    //       }
    //     })
    // }
  }
}
</script>

<style lang="scss" scoped>
.t-container-chat-is-first {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  // margin: 15px;
  margin-top: 10px;
  margin-bottom: 10px;
  .t-popover {
    position: relative;
    font-family: Tahoma;
    font-size: 1rem;
    z-index: 0;
    width: 90%;
    max-width: 90%;

    .t-popover-header {
      font-size: 0.9rem;
      background-color: var(--t-success-header-background);

      color: var(--t-success-header-foreground);
      display: flex;
      flex-direction: column;
      text-align: right;
      .t-actionbar-owner {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        .t-actionbar {
          margin-right: 20px;
          display: flex;
          flex-direction: row;
          .t-actionbar-button {
            cursor: pointer;
            margin-left: 2px;
            margin-right: 2px;
            svg {
              margin-left: 5px;
              margin-right: 5px;
              :hover {
                color: var(--t-color-20-85);
              }
            }
          }
        }
      }
    }
    .t-popover-body {
      display: flex;
      flex-direction: column;
      font-size: 0.9rem;
      text-align: right;
      background-color: var(--t-success-body-background);
      color: var(--t-success-body-foreground);

      // #staff-signature {
      //   hr {
      //     width: 40%;
      //     display: inline-block;
      //     justify-content: right;
      //   }
      // }
      .t-chat-footer {
        .t-link-button {
          display: flex;
          justify-content: left;
          cursor: pointer;
          margin-left: 5px;
          // margin-bottom: 5px;
          svg {
            margin-left: 5px;
            margin-bottom: 5px;
            width: 20px;
            height: 20px;
            color: var(--t-color-70-25);
            :hover {
              color: var(--t-color-70-40);
            }
          }
        }
        .t-time-diff {
          padding-top: 15px;
          font-size: 0.75rem;
          direction: ltr;
        }
      }
    }
  }
}
.t-container-chat {
  display: flex;
  flex-direction: column;
  width: 100%;
  margin: 5px;
  margin-bottom: 20px;
  .t-popover {
    position: relative;
    font-family: Tahoma;
    font-size: 1rem;
    z-index: 0;
    width: 40%;
    max-width: 40%;
    .t-arrow {
      &:after {
        border-left-color: var(--t-color-20-70);
        border-right-color: var(--t-color-20-70);
      }
    }
    .t-arrow-confidentail {
      &:after {
        border-left-color: var(--t-color-9-24-51);
        border-right-color: var(--t-color-9-24-51);
      }
    }

    .t-arrow-my-comment {
      &:after {
        // border-left-color: var(--t-color-196-100-42);
        // border-right-color: var(--t-color-196-100-42);
        border-left-color: var(--t-color-70-80);
        border-right-color: var(--t-color-70-80);
      }
    }

    .t-popover-header {
      font-size: 0.9rem;
      background-color: var(--t-color-20-70);

      display: flex;
      flex-direction: column;
      text-align: right;
      .t-actionbar-owner {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        .t-actionbar {
          margin-right: 20px;
          display: flex;
          flex-direction: row;
          .t-actionbar-button {
            cursor: pointer;
            margin-left: 2px;
            margin-right: 2px;
            svg {
              margin-left: 5px;
              margin-right: 5px;
              :hover {
                color: var(--t-color-20-85);
              }
            }
          }
          .t-confirential-icon {
            margin-left: 20px;
            font-style: italic;
            svg {
              margin-left: 5px;
              margin-right: 5px;
            }
          }
        }
      }
      .t-ref-chat {
        display: flex;
        flex-direction: column;
        border-right: 3px solid var(--t-color-70-40);
        font-size: 0.85rem;
        margin-top: 5px;
        padding-right: 5px;
        .t-owner {
          font-size: 0.8rem;
          padding-top: 5px;
        }
        .t-chat-desc {
          padding-top: 5px;
          padding-bottom: 5px;
        }
      }
    }
    .t-confidential {
      background-color: var(--t-color-9-24-51);
    }
    .t-my-comment {
      // background-color: var(--t-color-196-100-42);
      background-color: var(--t-color-70-80);
    }
    .t-popover-body {
      display: flex;
      flex-direction: column;
      font-size: 0.9rem;
      text-align: right;

      .t-chat-footer {
        .t-link-button {
          display: flex;
          justify-content: left;
          cursor: pointer;
          margin-left: 5px;
          // margin-bottom: 5px;
          svg {
            margin-left: 5px;
            margin-bottom: 5px;
            width: 20px;
            height: 20px;
            color: var(--t-color-70-25);
            :hover {
              color: var(--t-color-70-40);
            }
          }
        }
        .t-time-diff {
          padding-top: 15px;
          font-size: 0.75rem;
          direction: ltr;
        }
      }
    }
  }
}
.t-container-chat-right {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}
.t-container-chat-left {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}
</style>
