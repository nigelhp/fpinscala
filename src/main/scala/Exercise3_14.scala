import fpinscala.datastructures._
import Exercise3_7.foldRight

/*
 * Exercise 3.14
 * Implement append in terms of either foldLeft or foldRight.
 */
object Exercise3_14 {

  def append[A](a1: List[A], a2: List[A]): List[A] = {
    // foldRight is used so that order is maintained
    foldRight(a1, a2)(Cons(_, _))
  }
}
