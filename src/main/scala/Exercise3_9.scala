import fpinscala.datastructures._
import Exercise3_7.foldRight

/*
 * Exercise 3.9
 * Compute the length of a list using foldRight.
 * def length[A](as: List[A]): Int
 */
object Exercise3_9 {

  def length[A](list: List[A]):Int = {
    foldRight(list, 0)((_, count) => count + 1)
  }
}
