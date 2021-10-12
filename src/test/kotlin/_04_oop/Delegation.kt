package _04_oop

import kotlin.reflect.KProperty
import kotlin.test.Test

class Verbose {
    class CensoredList(private val delegate: List<String>) : List<String> { //~30 lines of code
        companion object {
            fun censoredListOf(vararg args: String) = CensoredList(listOf(*args))
        }

        override fun contains(element: String): Boolean = delegate.contains(element)
        override fun listIterator(index: Int): ListIterator<String> =
            delegate.listIterator(index)

        override fun toString(): String =
            delegate.map { if (it == "spaghetti") "***" else it }.toString()

        override val size: Int
            get() = delegate.size

        override fun containsAll(elements: Collection<String>): Boolean =
            delegate.containsAll(elements)

        override fun get(index: Int): String = delegate.get(index)

        override fun indexOf(element: String): Int = delegate.indexOf(element)

        override fun isEmpty(): Boolean = delegate.isEmpty()

        override fun iterator(): Iterator<String> = delegate.iterator()

        override fun lastIndexOf(element: String): Int = delegate.lastIndexOf(element)

        override fun listIterator(): ListIterator<String> = delegate.listIterator()

        override fun subList(fromIndex: Int, toIndex: Int): List<String> =
            delegate.subList(fromIndex, toIndex)
    } // a lot of code

    @Test
    fun `test verbose delegation`() {
        val words = CensoredList.censoredListOf("giant", "spaghetti", "monster")
        println(words)
    }
}

class Idiomatic {
    class CensoredList(private val delegate: List<String>) : List<String> by delegate {
        companion object {
            fun censoredListOf(vararg args: String) = CensoredList(listOf(*args))
        }

        override fun toString(): String =
            delegate.map { if (it == "spaghetti") "***" else it }.toString()
    } //~7 lines of code

    @Test
    fun `test verbose delegation`() {
        val words = CensoredList.censoredListOf("giant", "spaghetti", "monster")
        println(words)
    }
}

class Properties {
    class User(val name: String) {
        val password: String by Mask()
    }

    class Mask {
        operator fun getValue(auditedClass: Any, property: KProperty<*>): String = "***"
    }


    @Test
    fun `password should be masked when printed`() {
        val user = User("parzival")

        println(user.password)
    }
}

