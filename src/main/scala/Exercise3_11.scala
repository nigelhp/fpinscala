import fpinscala.datastructures._
import Exercise3_10.foldLeft

/*
 * Exercise 3.11
 * Write sum, product, and a function to compute the length of a list using foldLeft.
 */
object Exercise3_11 {

  def sum(list: List[Int]): Int = foldLeft(list, 0)(_ + _)

  def product(list: List[Int]): Int = foldLeft(list, 1)(_ * _)

  def length[A](list: List[A]): Int = foldLeft(list, 0)((acc, _) => acc + 1)
}
