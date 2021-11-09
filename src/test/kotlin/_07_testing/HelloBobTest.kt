package _07_testing

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloBobTest {

    private lateinit var outBackup: PrintStream
    private val out = ByteArrayOutputStream()

    @BeforeTest
    fun setup() {
        outBackup = System.out
        System.setOut(PrintStream(out))
    }

    @Test
    fun `should greet Bob`() {
        main(*arrayOf("Bob"))

        assertEquals("Hello, Bob!", out.toString().trim())
    }

    @Test
    fun `should greet the world`() {
        main(*emptyArray())

        assertEquals("Hello, World!", out.toString().trim())
    }

    @AfterTest
    fun teardown() {
        System.setOut(outBackup)
    }
}

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "World"
    println("Hello, $name!")
    (1..100).map(Int::toString).forEach {
        println(it.padStart(2))
    }
}
