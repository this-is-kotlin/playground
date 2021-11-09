package _07_testing

import _02_functions.isPalindrome
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class PalindromeDynamicSpec : FreeSpec({

    listOf("radar", "level", "lol").forEach {
        "$it should be palindrome" {
            it should bePalindrome()
        }
    }
})

class PalindromeWithDataSpec : FreeSpec({

    "should be palindrome: " - {
        withData("radar", "level", "lol") { word ->
            word should bePalindrome()
        }
    }
})

class PalindromeDDDNamedSpec : FreeSpec({

    withData(
        nameFn = { (word, expected) ->
            "$word should ${if (expected) "" else "not"} be palindrome"
        },
        "radar" to true,
        "42" to false
    ) { (word, expected) ->
        word.isPalindrome() shouldBe expected
    }
})
