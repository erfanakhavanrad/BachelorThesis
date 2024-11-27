export class TNumber {
  convertPersianNumber (persianNumber) {
    let englishNumber = ''
    for (let i = 0; i < persianNumber.length; i++) {
      switch (persianNumber[i]) {
        case '۰':
          englishNumber += '0'
          break
        case '۱':
          englishNumber += '1'
          break
        case '۲':
          englishNumber += '2'
          break
        case '۳':
          englishNumber += '3'
          break
        case '۴':
          englishNumber += '4'
          break
        case '۵':
          englishNumber += '5'
          break
        case '۶':
          englishNumber += '6'
          break
        case '۷':
          englishNumber += '7'
          break
        case '۸':
          englishNumber += '8'
          break
        case '۹':
          englishNumber += '9'
          break
        default:
          englishNumber += persianNumber[i]
      }
    }
    return englishNumber
  }

  integerCommas (x) {
    return x === undefined || x === null || x === ''
      ? ''
      : x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')
  }

  decimalCommas (x) {
    return x === undefined || x === null || x === ''
      ? ''
      : x.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ',')
  }

  removeCommas (x) {
    return x === undefined || x === null || x === ''
      ? null
      : x.replaceAll(',', '')
  }

  acceptInteger (event) {
    let key = event.key
    key = new TNumber().convertPersianNumber(key)
    if (!/\d/.test(key)) {
      return event.preventDefault()
    }
  }

  acceptDecimal (event) {
    let key = event.key
    key = new TNumber().convertPersianNumber(key)
    if (!/\d/.test(key) && key !== '.') {
      return event.preventDefault()
    }
  }

  oddEvenNumber (x) {
    if (x % 2 === 0) {
      return 'odd'
    } else {
      return 'even'
    }
  }
}
export default (context, inject) => {
  inject('tnumber', new TNumber())
}
