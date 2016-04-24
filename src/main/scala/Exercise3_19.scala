import fpinscala.datastructures._
import Exercise3_7.foldRight

/*
 * Exercise 3.19
 * Write a function filter that removes elements from a list unless they satisfy a given predicate.
 * Use it to remove all odd numbers from a List[Int].
 *
 * def filter[A](as: List[A])(f: A => Boolean): List[A]
 */
object Exercise3_19 {

  def filter[A](as: List[A])(f: A => Boolean): List[A] = {
    foldRight(as, Nil:List[A])((a, acc) => if (f(a)) Cons(a, acc) else acc)
  }
}
