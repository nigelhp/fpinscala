import scala.annotation.tailrec

/*
 * Exercise: 2.1
 * Write a recursive function to get the nth Fibonacci number.
 * The first two Fibonacci numbers are 0 and 1.  The nth number is always the sum
 * of the previous two - the sequence begins 0,1,1,2,3,5.  Your definition should
 * use a local tail-recursive function.
 *
 * def fib(n: Int): Int
 */
object Exercise2_1 {

  def fib(n: Int): Int = {
    @tailrec
    def loop(count: Int, nMinus2: Int, nMinus1: Int): Int =
      if (count == 0) nMinus2
      else loop(count - 1, nMinus1, nMinus2 + nMinus1)

    loop(n, 0, 1)
  }
}
