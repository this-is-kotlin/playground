package _07_testing

import _03_collections.isPalindrome
import io.kotest.assertions.show.show
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.*

fun bePalindrome(): Matcher<String?> = neverNullMatcher { value ->
    MatcherResult(
        passed = value.isPalindrome(),
        failureMessageFn = { "${value.show().value} should be palindrome" },
        negatedFailureMessageFn = { "${value.show().value} should not be palindrome" }
    )
}

class PalindromeSpec : FreeSpec({

    "radar should be palindrome" {
        "radar" should bePalindrome()
    }

    "kotlin should not be palindrome" {
        "kotlin" shouldNot bePalindrome()
    }

    "let's trigger some failures to check the messages".config(enabled = false) - {
        "false negative" {
            "radar" shouldNot bePalindrome()
        }
        "false positive" {
            "kotlin" should bePalindrome()
        }
        "what about null" {
            null shouldNot bePalindrome()
        }
    }
})
