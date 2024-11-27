// const setting = {
//   namespaced: true,
//   state: () => ({
//     data: {}
//     // yearIDs: [],
//     // serverIDs: []
//   }),
//   mutations: {
//     SET_DATA (state, data) {
//       state.data = data
//     }
//     // SET_YEARIDS (state, yearIDs) {
//     //   state.yearIDs = yearIDs
//     // },
//     // SET_SERVERIDS (state, serverIDs) {
//     //   state.serverIDs = serverIDs
//     // }
//   },
//   getters: {
//     GET_DATA (state) {
//       return state.data
//     }
//     // GET_SYSTEMTITLE (state) {
//     //   return state.data.systemTitle
//     // }
//   },
//   actions: {
//     clear ({ commit }) {
//       commit('SET_DATA', {})
//       // commit('SET_YEARIDS', [])
//       // commit('SET_SERVERIDS', [])
//     },
//     async retrieve ({ commit }) {
//       try {
//         const responseSetting = await this.$taxios.get('tkt/settings')

//         // const data = Object.assign({}, responseSetting.data, {
//         //   systemTitle: responseSetting.data.systemTitle
//         // })

//         // commit('SET_DATA', data)
//         commit('SET_DATA', responseSetting)

//         // باید سال پیش فرض و سرور پیش فرض کاربر در متغیر مربوطه قرار گیرد
//         // const yearIDs = []
//         // yearIDs.push(responseSetting.data.activeYearID)
//         // commit('SET_YEARIDS', yearIDs)

//         // const serverIDs = []
//         // serverIDs.push(responseSetting.data.defaultServerID)
//         // commit('SET_SERVERIDS', serverIDs)

//         return true
//       } catch (error) {
//         return false
//       }
//     }
//     // changeYearIDs ({ commit }, { yearIDs }) {
//     //   commit('SET_YEARIDS', yearIDs)
//     // },
//     // changeServerIDs ({ commit }, { serverIDs }) {
//     //   commit('SET_SERVERIDS', serverIDs)
//     // }
//   }
// }
// export default setting
