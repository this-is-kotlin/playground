package _03_collections

import java.util.stream.Stream
import kotlin.test.Test

class Complexities {

    @Test
    fun `iteration that has O(1) complexity`() {
        val arrayList = (0..10_000_000).toList()

        /*
         * the complexity is O(1) as the size of the list does not change the number of
         * operations, which is always 100
         */
        for (i in 0..100) {
            println("the element on index$i is ${arrayList[i]}")
        }

        /*
         * More context:
         * ns has a size dependent on the input, but no matter how big is ns,
         * the algorithm does 3 O(1) operations => the complexity of printFist3 is O(1)
         */
        fun printFirst3(ns: List<Int>) {
            println(ns[0])
            println(ns[1])
            println(ns[2])
        }

        /*
         * printFirst3Iter is semantically identical to printFirst3,
         * thus it has the same time complexity
         */
        fun printFirst3Iter(ns: List<Int>) {
            for (i in 0..2) {
                println(ns[i])
            }
        }

        /*
         * We can increase the size of the constant without affecting the time complexity
         * Doing 100 times an O(1) operation => 100*O(1) => O(1)
         */
        fun printFirst100(ns: List<Int>) {
            for (i in 0 until 100) {
                println("the element on index$i is ${ns[i]}")
            }
        }

        printFirst100(arrayList)
    }

}
