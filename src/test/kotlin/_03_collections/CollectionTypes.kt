package _03_collections

import kotlin.test.Test
import kotlin.test.assertFalse

class ListExamples {
    @Test
    fun `readonly list`() {
        val ns: List<Int> = listOf(1, 2, 3, 4, 5, 6)
        println("Default implementation is: ${ns.javaClass}")

//        ns.add(7)
        println(ns[2])

        val concat = ns + listOf(7, 8, 9)
        println("Concatenated lists: $concat")
        println("Is it the same list instance? ${concat === ns}")
    }

    @Test
    fun `mutable list`() {
        val ns: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6)
        println("Default implementation is: ${ns.javaClass}")
        println("Initial list: $ns")

        ns -= 6
        ns[2] = 10
        println("Mutated list: $ns")

        ns += listOf(7, 8, 9)
        println("Concatenated lists: $ns")
    }

}

class SetExamples {

    @Test
    fun `immutable set`() {
        val ns: Set<Int> = setOf(1, 2, 3, 4, 2)
        println(ns.javaClass)
        println(ns)
    }

    @Test
    fun `mutable set`() {
        val names: MutableSet<String?> = mutableSetOf("Josh", "Martin", "Venkat", null, null)
        println(names.javaClass)

        names -= "Josh"

        println(names)

        val otherNames = setOf("Andrei", "Roman")

        val allNames = names union otherNames
        println(allNames)
    }
}

class MapExamples {

    @Test
    fun `make pairs`() {
        val p: Pair<Int, String> = 1 to "one"

        println("the pair is ${p.first} to ${p.second}")

        val (n, word) = p
        println("$n is $word")
    }

    @Test
    fun `immutable map`() {
        val designers: Map<String, String> = mapOf(
            "Scala" to "Martin Odersky",
            "Java" to "James Gosling",
            "Kotlin" to "JetBrains",
            "Groovy" to "James Strachan",
            "Closure" to "Rich Hickey"
        )

        println(designers.javaClass)

        val designerOfScala = designers["Scala"]
        println(designerOfScala)

        assertFalse { "Haskell" in designers }
    }

    @Test
    fun `mutable map`() {
        val dictionary = mutableMapOf(1 to "one", 2 to "two")

        dictionary[3] = "three"

        dictionary += 4 to "four"

        println(dictionary)
        println(dictionary.keys)
        println(dictionary.values)
        println(dictionary.entries)
    }
}

class ImmutabilityExample {

    @Test
    fun `set mutation hack`() {
        val immutable: Set<Int> = setOf(1, 2, 3, 4)
        val mutable = immutable as MutableSet
        mutable += 5
        println(immutable)
    }
}


