package _02_functions

import kotlin.test.Test

class Extensions {

    @Test
    fun `extensions on string`() {
        fun String.duplicate() = this + this

        println("Kotlin".duplicate())
    }

    @Test
    fun `default parameters`() {
        fun String.duplicate(separator: String = "") = "$this$separator$this"

        println("Kotlin".duplicate(separator = " vs "))
    }

    @Test
    fun `palindrome strings`() {
        fun String.isPalindrome() = this == this.reversed()

        println("radar".isPalindrome())
    }
}
