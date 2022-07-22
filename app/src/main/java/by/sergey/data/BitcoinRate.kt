package by.sergey.data

import java.util.*


class Bpi {
    var uSD: USD? = null
    var gBP: GBP? = null
    var EUR: EUR? = null
}

class EUR {
    var code: String? = null
    var symbol: String? = null
    var rate: String? = null
    var description: String? = null
    var rate_float = 0.0
}

class GBP {
    var code: String? = null
    var symbol: String? = null
    var rate: String? = null
    var description: String? = null
    var rate_float = 0.0
}

class Root {
    var time: Time? = null
    var disclaimer: String? = null
    var chartName: String? = null
    var bpi: Bpi? = null
}

class Time {
    var updated: String? = null
    var updatedISO: Date? = null
    var updateduk: String? = null
}

class USD {
    var code: String? = null
    var symbol: String? = null
    var rate: String? = null
    var description: String? = null
    var rate_float = 0.0
}
