package com.github.nigelhp.fpinscala

import scala.annotation.tailrec

/*
 * Exercise 2.2
 * Implement isSorted, which checks whether an Array[A] is sorted
 * according to a given comparison function:
 *
 * def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean
 */
object Exercise2_2 {
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def loop(n: Int): Boolean =
      if (n + 1 >= as.length) true
      else if (ordered(as(n), as(n + 1))) loop(n + 1)
      else false

    loop(0)
  }
}
