package com.github.nigelhp.fpinscala

import exercise4_1.{Option, Some}
import Exercise4_3.map2

/*
 * Exercise 4.4
 * Write a function sequence that combines a list of Options into one Option
 * containing a list of all the Some values in the original list.  If the
 * original list contains None even once, the result of the function should be
 * None; otherwise the result should be Some with a list of all the values.
 * Here is its signature:
 *   def sequence[A](a: List[Option[A]]): Option[List[A]]
 */

object Exercise4_4 {
  // low-level pattern matching on the list
  def sequence1[A](a: List[Option[A]]): Option[List[A]] = a match {
    case Nil => Some(Nil)
    case head :: tail => head.flatMap(h => {
      sequence1(tail).map { t => h :: t }
    })
  }

  def sequence2[A](a: List[Option[A]]): Option[List[A]] = {
    val initial: Option[List[A]] = Some(Nil)
    a.foldRight(initial) { (opt, acc) => map2(opt, acc) { _ :: _ } }
  }
}
