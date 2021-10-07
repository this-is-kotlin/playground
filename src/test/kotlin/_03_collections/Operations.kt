package _03_collections

import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertSame

class Operations {
    val names = listOf("Josh", "Martin", "Venkat")
    val interests = listOf("Spring", "Scala", "JVM")

    @BeforeEach
    fun printInput() {
        println("names: $names")
        println("interests: $interests")
        println("======")
    }

    @Test
    fun map() {
        val lengths = names.map { it.length }
        println(lengths)
    }

    @Test
    fun `map doesnt work as intended`() {
        val chars = names.map { it.split("") }

        println(chars)
    }

    @Test
    fun `flatMap is the solution`() {
        val chars = names.flatMap { it.split("") }

        println(chars)
    }

    @Test
    fun `associate creates pairs from a single source`() {
        val lengths = names.associateWith { it.length }

        println(lengths)
    }

    @Test
    fun `zip pairs two sources`() {
        val texts = names.zip(interests) { n, i -> "$n does $i" }

        println(texts)
    }

    @Test
    fun `filter leaves out some elements`() {
        val chars = names
            .flatMap { it.split("") }
            .filter { it.isNotEmpty() }

        //no more unwanted empty strings
        println(chars)
    }

    @Test
    fun `filterNotNull keeps it's promise`() {
        val interests = listOf("Spring", "Scala", "JVM", null)

        println(interests.filterNotNull())
    }

    @Test
    fun `returns the first match or null`() {
        val result: String? = interests.find { it.length < 4 }

        println(result)
    }

    @Test
    fun `groupBy creates a map`() {
        val interestsByInitialisms: Map<Char, List<String>> = interests.groupBy { it.first() }

        println(interestsByInitialisms.javaClass)
        println(interestsByInitialisms)
    }

    @Test
    fun `sorting needs a comparator`() {
        val sortedInterests = interests.sortedBy { it }

        println(sortedInterests)
    }

    @Test
    fun `combine using fold`() {
        val charCount = interests.fold(0) { sum, s -> sum + s.length }

        println(charCount)
    }

    @Test
    fun `sumOf is a shortcut`() {
        val charCount = interests.sumOf { it.length }

        println(charCount)
    }

    @Test
    fun `iterating using onEach - looks a bit like Stream peek`() {
        val res = interests.onEach { println(it) }

        assertSame(interests, res)
    }

    @Test
    fun `iterating using forEach`() {
        val res = interests.forEach { println(it) }

        assertSame(Unit, res)
    }

}
