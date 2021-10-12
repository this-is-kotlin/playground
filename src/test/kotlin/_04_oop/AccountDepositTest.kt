package _04_oop

import org.junit.jupiter.api.BeforeEach
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

data class Account(
    val iban: String,
    val type: String,
    val currency: String,
    val balance: BigDecimal
) {

    fun deposit(amount: BigDecimal): Account = Account(iban, type, currency, balance + amount)
}

class AccountDepositTest {


    lateinit var account: Account

    @BeforeEach
    fun setup() {
        account = Account("NL77 ..", "Current", "EUR", "100".toBigDecimal())
    }

    @Test
    fun `should add the deposited amount to the balance`() {
        assertEquals(
            "103.5".toBigDecimal(),
            account.deposit("3.5".toBigDecimal()).balance
        )
    }

}
