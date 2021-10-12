package _04_oop

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertTrue

class Classes {

    @Test
    fun `override getter and setter`() {
        class Account {
            var currency: String = "EUR"
                get() {
                    println("accessing property currency with value $field")
                    return field
                }
                set(value) {
                    println("updating currency from $field to $value")
                    field = value
                }
        }

        val account = Account()

        account.currency = "RON"
        account.currency
    }

    @Test
    fun `property without backing field`() {
        class Account(val currency: String, val balance: Double) {
            val hasDebt: Boolean
                get() {
                    return balance < 0
                }
        }

        val account = Account(currency = "RON", balance = -1.0)

        assertTrue { account.hasDebt }
    }

    @Test
    fun `private setter`() {
        class Account {
            var currency: String = "EUR"
                private set
        }

        val account = Account()

//        account.currency = "RON"
        println(account.currency)
    }


    val String.lastChar: Char
        get() = get(length - 1)

    @Test
    fun `extension properties`() {
        println("Kotlin".lastChar)
    }

    var MutableList<Int>.last: Int
        get() = get(size - 1)
        set(value) {
            set(size - 1, value)
        }

    @Test
    fun `mutable extension property`() {
        val ns = mutableListOf(1, 2, 3)
        ns.last = 4
        println("Last element is ${ns.last}")
    }

    @Test
    fun `secondary constructor`() {
        class Client(val name: String) {
            var birthdate: LocalDate? = null

            constructor(name: String, birthdate: LocalDate) : this(name) {
                this.birthdate = birthdate
            }
        }
    }

    interface Identifiable {
        val id: String

        fun isSameAs(other: Identifiable) = id == other.id
    }

    @Test
    fun `inheritance demo`() {
        open class Person(val name: String)

        class Client : Person, Identifiable {
            override val id: String

            constructor(id: String, name: String) : super(name) {
                this.id = id
            }

            override fun isSameAs(other: Identifiable): Boolean =
                TODO("alternative implementation")
        }
    }

    @Test
    fun `lateinit props`() {
        data class Client(val firstName: String, val lastName: String) {
            val fullName: String by lazy {
                "$firstName $lastName"
            }
        }
    }

    @Test
    fun `data classes`() {
        data class Client(val firstName: String, val lastName: String)

        val james = Client("James", "Halliday")

        //destructuring
        val (first, last) = james

        println("First name: $first; Last name: $last")

        //copying
        val enrico = Client("Enrico", "Chiesa")
        val frederico = enrico.copy(firstName = "Frederico")
        println(enrico)
        println(frederico)
    }

    data class Client(val firstName: String, val lastName: String) {
        companion object {
            fun reduplicatedName(name: String): Client =
                Client(firstName = name, lastName = name)
        }
    }

    @Test
    fun `companion objects`() {
        val thomas = Client.reduplicatedName("Thomas")
    }
}
