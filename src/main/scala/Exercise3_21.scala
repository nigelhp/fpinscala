import fpinscala.datastructures._
import Exercise3_20.flatMap

/*
 * Exercise 3.21
 * Use flatMap to implement filter.
 */
object Exercise3_21 {

  def filter[A](as: List[A])(f: A => Boolean): List[A] = {
    flatMap(as)(a => if (f(a)) List(a) else Nil)
  }
}
