package _03_collections

import org.junit.jupiter.api.BeforeEach
import java.util.*
import java.util.stream.Stream
import kotlin.test.Test
import kotlin.test.assertEquals
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

    public inline fun <T> Iterable<T>.fold(operation: (acc: T, T) -> T): T? {
        val iterator = this.iterator()
        return if (iterator.hasNext()) {
            var accumulator = iterator.next()
            for (element in iterator) accumulator = operation(accumulator, element)
            accumulator
        } else null
    }

    @Test
    fun `combine using fold`() {
        val charCount = interests.fold(0) { sum, s -> sum + s.length }


//        fun <T> List<T>.fold(f: (T, T) -> T): T? =
//            if (this.isEmpty()) null
//            else this.subList(1, this.size).fold(this[0], f)


        val sumNullable: Int? = listOf(1, 2, 3, 4).fold { sum, s -> sum + s }
        val sumNullable2: Int? = emptyList<Int>().fold { sum, s -> sum + s }

        println(sumNullable)
        println(sumNullable2)

    }

    @Test
    fun `sumOf is a shortcut`() {
        val charCount = interests.sumOf { it.length }

        println(charCount)
    }

    @Test
    fun `fold using java streams`() {
//        val s = Stream.of("1", "2", "3", "4")
//            .reduce(0) { sum, v -> sum + v.length }

//        println(s)
//        assertEquals(10, s)

        //without initial returns an Optional
        val o = emptyList<Int>().stream()
            .reduce { sum, v -> sum + v }

        println(o)
        assertSame(Optional.empty(), o)
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
