import fpinscala.datastructures._

import Exercise3_7.foldRight

/*
 * Exercise 3.18
 * Write a function map that generalizes modifying each element in a list while maintaining the structure of the
 * list.  Here is its signature:
 *
 * def map[A, B](as: List[A])(f: A => B): List[B]
 */
object Exercise3_18 {

  def map[A, B](as: List[A])(f: A => B): List[B] = {
    foldRight(as, Nil: List[B])((a, acc) => Cons(f(a), acc))
  }
}
