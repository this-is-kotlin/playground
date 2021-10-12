package _04_oop

import _04_oop.Enums.Currency.*

class Enums {

    enum class Currency(val info: String) {
        EUR("Euro"),
        RON("Romanian leu"),
        USD("United States Dollar"),
        GBP("British Pound Sterling")
    }

    fun convertToEur(currency: String, amount: Double): Double = when (currency) {
        "RON" -> amount * 0.2
        "USD" -> amount * 0.8
        "GBP" -> amount * 1.2
        "EUR" -> amount
        else -> throw IllegalArgumentException("Unrecognized currency!")
    }

    fun convertToEurWithEnum(currency: Currency, amount: Double): Double = when (currency) {
        RON -> amount * 0.2
        USD -> amount * 0.8
        GBP -> amount * 1.2
        EUR -> amount
    }
}
