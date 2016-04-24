import fpinscala.datastructures._

import Exercise3_7.foldRight

/*
 * Exercise 3.17
 * Write a function that turns each value in a List[Double] into a String.
 * You can use the expression d.toString to convert some d: Double to a String.
 */
object Exercise3_17 {

  def asStrings(list: List[Double]): List[String] = {
    foldRight(list, Nil: List[String])((d, acc) => Cons(d.toString, acc))
  }
}
