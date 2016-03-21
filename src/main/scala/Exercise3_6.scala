import fpinscala.datastructures._

import scala.annotation.tailrec

/*
 * Exercise 3.6
 * Not everything works out so nicely.  Implement a function, init, that returns a List consisting of
 * all but the last element of a List.  So, given List(1, 2, 3, 4), init will return List(1, 2, 3).
 * Why can't this function be implemented in constant time like tail?
 *
 * def init[A](l: List[A]): List[A]
 */
object Exercise3_6 {

  private def reverse[A](l: List[A]): List[A] = {
    @tailrec
    def loop(remaining: List[A], acc: List[A]): List[A] = remaining match {
      case Nil => acc
      case Cons(h, t) => loop(t, Cons(h, acc))
    }

    loop(l, Nil)
  }

  def init[A](l: List[A]): List[A] = {
    @tailrec
    def loop(remaining: List[A], acc: List[A]): List[A] = remaining match {
      case Nil => Nil
      case Cons(_, Nil) => reverse(acc)
      case Cons(h, t) => loop(t, Cons(h, acc))
    }

    loop(l, Nil)
  }

  /*
   * Cannot be implemented in constant time, as we must traverse all the elements of a singly-linked list
   * in order to identify the last element.  Time is therefore proportional to the length of the list.
   */
}
