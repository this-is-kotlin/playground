package _03_collections

import org.junit.jupiter.api.BeforeEach
import java.math.BigInteger
import kotlin.test.Test

class Sequences {

    val words: List<String> = listOf("tech", "radar", "on", "kotlin", "android", "101")

    @BeforeEach
    fun printData() {
        println(words)
        println("======")
    }

    @Test
    fun `sequences are lazy, lists are eager`() {
        words
            //comment .asSequence to see the difference
            .asSequence()
            .onEach { println(it) }
            .filter { it.isPalindrome() }
            .map { it.length }
            .first()
    }

    @Test
    fun `reusing the sequence computes again`() {
        val longWords = words
            //comment .asSequence to see the difference
            .asSequence()
            .onEach { print("$it ") }
            .filter { it.length > 5 }

        longWords.forEach { print("$it ") }
        longWords.forEach { print("$it ") }
    }

    @Test
    fun `onEach is intermediate`() {
        words.asSequence()
            .onEach { println(it) }
    }

    @Test
    fun `forEach is terminal`() {
        words.asSequence()
            .forEach { println(it) }

    }

    @Test
    fun `infinite sequences are useful`() {
        fun generatePrimes(): Sequence<BigInteger> =
            generateSequence(1) { it + 1 }
                .map { it.toBigInteger() }
                .filter { it.isProbablePrime(100) }

        val n = 10

        //first n primes
        generatePrimes().take(n).forEach(::println)

        val nthPrime = generatePrimes().drop(n - 1).first()
        println("the ${n}th prime number is $nthPrime")
    }
}

fun String.isPalindrome() = this.reversed() == this
