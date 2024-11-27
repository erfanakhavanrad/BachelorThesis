export class TScroll {
  onScrollToBottom () {
    window.scrollTo({
      top: document.body.scrollHeight,
      left: 0,
      behavior: 'smooth'
    })
  }

  onScrollToTop () {
    window.scrollTo({
      top: 0,
      left: 0,
      behavior: 'smooth'
    })
  }
}
export default (context, inject) => {
  inject('tscroll', new TScroll())
}
