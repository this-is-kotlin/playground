package _01_intro

import kotlin.test.Test

class Examples {
    val a = 5
    val b = 10

    @Test
    fun `if is an expression`() {
        val max = if (a > b) a else b

        println(max)
    }

    @Test
    fun `if with block branches`() {
        val max = if (a > b) {
            println("a is greater than b")
            a
        } else {
            println("b is greater or equal to a")
            b
        }

        println(max)
    }

    @Test
    fun `when is an expression`() {
        val grade = 7
        val ects = when (grade) {
            in (5..6) -> "E"
            7 -> "D"
            8 -> "C"
            9 -> "B"
            10 -> "A"
            else -> "F"
        }

        println(ects)
    }

    @Test
    fun `when can have block branches`() {
        val grade = 9
        val result = when {
            grade >= 5 -> "passed"
            else -> {
                println("reschedule exam")
                "failed"
            }
        }

        println(result)
    }

    @Test
    fun `for in`() {
        val ns = listOf(299, 792, 458)

        print("the speed of light is ")
        for (n in ns) {
            print(n)
        }
        println("m/s")
    }

    @Test
    fun `for with index`() {
        val ns = listOf(299, 792, 458)

        for ((i, n) in ns.withIndex()) {
            println("the element at $i is $n")
        }
    }

    @Test
    fun `for over map`() {
        val designers = mapOf(
            "Scala" to "Martin Odersky",
            "Java" to "James Gosling",
            "Kotlin" to "JetBrains",
            "Groovy" to "James Strachan",
            "Closure" to "Rich Hickey"
        )

        for ((language, designer) in designers) {
            println("$language is designed by $designer")
        }
    }

    @Test
    fun `classes and default constructors`() {
        class Account(
            val iban: String,
            val product: String,
            val currency: String,
            val balance: Double
        ) {
            init {
                require(currency.length == 3) { "Currency should be a 3 chars code" }
            }
        }

        val account = Account("NL69INGB0123456789", "Current Account", "EUR", 100.0)

        println(account.iban)
    }

    @Test
    fun `try is an expression`() {
        val n = try {
            "42".toInt()
        } catch (e: NumberFormatException) {
            0
        }

        println(n)
    }
}
