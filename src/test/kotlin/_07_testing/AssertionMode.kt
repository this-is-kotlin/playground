package _07_testing

import _02_functions.isPalindrome
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.AssertionMode

class FakeTest : FreeSpec({
    assertions = AssertionMode.Error

    "I'm here just for code coverage" {
        "word".isPalindrome()
    }
})
