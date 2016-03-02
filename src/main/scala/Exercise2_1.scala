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
    if (n == 0) 0
    else if (n == 1) 1
    else fib(n-1) + fib(n-2)
  }
}
