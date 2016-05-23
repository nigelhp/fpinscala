package com.github.nigelhp.fpinscala

import fpinscala.datastructures._

/*
 * Exercise 3.2
 * Implement the function tail for removing the first element of a List.
 * Note that the function takes constant time.
 * What are different choices you could make in your implementation if the List is Nil?
 * We'll return to this question in the next chapter.
 */
object Exercise3_2 {

  def tail[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case Cons(_, t) => t
  }

  /* options for scenario when List is Nil:
   * - return Nil (as per Clojure)
   * - throw an Exception (as per Scala standard library)
   * - change signature to return an Option[List]
   */
}
