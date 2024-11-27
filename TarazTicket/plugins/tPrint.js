export class TPrint {
  create (title, contents) {
    const iFramePrint = document.createElement('iframe')
    iFramePrint.name = 'iFramePrint'
    iFramePrint.style.position = 'absolute'
    iFramePrint.style.top = '-1000000px'
    document.body.appendChild(iFramePrint)
    const contentDocument = iFramePrint.contentWindow
      ? iFramePrint.contentWindow
      : iFramePrint.contentDocument.document
        ? iFramePrint.contentDocument.document
        : iFramePrint.contentDocument
    contentDocument.document.open()
    contentDocument.document.write('<html>')
    contentDocument.document.write('<head>')
    contentDocument.document.write('<style>')
    contentDocument.document.write('</style>')
    contentDocument.document.write('<title>' + title + '</title>')
    contentDocument.document.write('</head>')
    contentDocument.document.write('<body>')
    contentDocument.document.write('<div style="direction: rtl;font-family:tahoma;">')
    contentDocument.document.write(contents())
    contentDocument.document.write('</div>')
    contentDocument.document.write('</body>')
    contentDocument.document.write('</html>')
    contentDocument.document.close()
    setTimeout(function () {
      window.frames.iFramePrint.focus()
      window.frames.iFramePrint.print()
      document.body.removeChild(iFramePrint)
    }, 500)
  }

  createStyle (styleJson) {
    let style = 'style="'
    Object.keys(styleJson).forEach((key) => {
      style += `${key}:${styleJson[key]};`
    })
    style += '"'
    return style
  }

  openElement (name, style) {
    let tag = '<'
    tag += `${name}`
    tag += ` ${style}`
    tag += '>'
    return tag
  }

  closeElement (name) {
    let tag = '</'
    tag += `${name}`
    tag += '>'
    return tag
  }
}
export default (context, inject) => {
  inject('tprint', new TPrint())
}
