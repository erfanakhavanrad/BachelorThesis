const form = {
  namespaced: true,
  state: () => ({
    id: null, // buttonID
    title: null, // buttonDesc
    name: null, // webAddress
    filterParam: null, // منظور baseFilter است
    filterParams: null, // منظور سایر فیلتر پارامتر هاست به جز baseFilter
    validation: {},
    dataEntry: {},
    pkFieldName: null,
    pageNumber: 1,
    resourceData: null,
    resourceMeta: null
  }),
  mutations: {
    SET_ID (state, id) {
      state.id = id
    },
    SET_TITLE (state, title) {
      state.title = title
    },
    SET_NAME (state, name) {
      state.name = name
    },
    SET_FILTER_PARAM (state, filterParam) {
      state.filterParam = filterParam
    },
    SET_FILTER_PARAMS (state, filterParams) {
      state.filterParams = filterParams
    },
    SET_VALIDATION (state, validation) {
      state.validation = Object.assign({}, validation)
    },
    SET_DATA_ENTRY (state, dataEntry) {
      state.dataEntry = Object.assign({}, dataEntry)
    },
    SET_PK_FIELD_NAME (state, pkFieldName) {
      state.pkFieldName = pkFieldName
    },
    SET_PAGE_NUMBER (state, pageNumber) {
      state.pageNumber = pageNumber
    },
    SET_RESOURCE_DATA (state, resourceData) {
      state.resourceData = resourceData
    },
    SET_RESOURCE_META (state, resourceMeta) {
      state.resourceMeta = resourceMeta
    }
  },
  getters: {
    GET_ID: (state) => {
      return state.id
    },
    GET_TITLE: (state) => {
      return state.title
    },
    GET_NAME: (state) => {
      return state.name
    },
    GET_FILTER_PARAM: (state) => {
      return state.filterParam
    },
    GET_FILTER_PARAMS: (state) => {
      return state.filterParams
    },
    GET_VALIDATION: (state) => {
      return state.validation
    },
    GET_DATA_ENTRY: (state) => {
      return state.dataEntry
    },
    GET_PK_FIELD_NAME: (state) => {
      return state.pkFieldName
    },
    GET_PAGE_NUMBER: (state) => {
      return state.pageNumber
    },
    GET_RESOURCE_DATA (state) {
      return state.resourceData
    },
    GET_RESOURCE_META (state) {
      return state.resourceMeta
    },
    IS_READY: (state, getters, rootState, rootGetters) => {
      if (rootGetters['subSystem/GET_ID'] == null) {
        return false
      }
      return true
    },
    IS_VALID: (state) => {
      for (const key in state.validation) {
        if (!state.validation[key]) {
          return false
        }
      }
      return true
    }
  },
  actions: {
    clear ({ commit }) {
      commit('SET_ID', null)
      commit('SET_TITLE', null)
      commit('SET_NAME', null)
      commit('SET_FILTER_PARAM', null)
      commit('SET_FILTER_PARAMS', null)
      commit('SET_VALIDATION', {})
      commit('SET_DATA_ENTRY', {})
      commit('SET_PK_FIELD_NAME', null)
      commit('SET_PAGE_NUMBER', 1)
      commit('SET_RESOURCE_DATA', null)
      commit('SET_RESOURCE_META', null)
    },
    fill ({ commit }, { id, title, name }) {
      commit('SET_ID', id)
      commit('SET_TITLE', title)
      commit('SET_NAME', name)
    }
  }
}
export default form
