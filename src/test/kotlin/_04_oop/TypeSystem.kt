package _04_oop

import kotlin.test.Test

class TypeSystem {

    @Test
    fun `null assigned to val`() {
        //Nothing? can only have one value: null
        val x: Nothing? = null
    }

    @Test
    fun `returning Nothing`() {
        //DOES NOT COMPILE: cannot create an instance of Nothing
        //fun iReturnNothingContructor(): Nothing = Nothing()

        //OK: never returns - just throws
        fun iReturnNothingException(): Nothing = throw Exception()

        //DOES NOT COMPILE: a function that finishes returns Unit implicitly
        //fun iReturnNothingBody(): Nothing {}

        //OK: TODO() also evaluates to Nothing
        fun iReturnNothingTODO(): Nothing = TODO()

        //OK: the function never finishes, and the compiler knows it
        fun iReturnNothingInfinite(): Nothing { while(true) println(".") }
    }

}
