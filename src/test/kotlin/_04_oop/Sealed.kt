package _04_oop

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

class Sealed {

    sealed interface Account {
        val iban: String
        val balance: BigDecimal
    }

    data class CurrentAccount(
        override val iban: String,
        override val balance: BigDecimal
    ) : Account

    data class CreditAccount(
        override val iban: String,
        override val balance: BigDecimal,
        val creditLimit: BigDecimal,
        val interest: BigDecimal
    ) : Account

    data class SavingsAccount(
        override val iban: String,
        override val balance: BigDecimal,
        val interest: BigDecimal
    ) : Account

    object TechnicalAccount : Account {
        override val iban: String =
            "RO99TECH1234567812345678"
        override var balance: BigDecimal = ZERO
    }

    fun Account.withdraw(amount: BigDecimal): Pair<Account, BigDecimal> = when (this) {
        is CurrentAccount -> copy(balance = balance - amount) to amount
        is SavingsAccount -> copy(balance = balance - amount) to amount
        is CreditAccount ->
            if (balance - amount > creditLimit) copy(balance = balance - amount) to amount
            else this to ZERO
        is TechnicalAccount -> this to ZERO
    }
}
