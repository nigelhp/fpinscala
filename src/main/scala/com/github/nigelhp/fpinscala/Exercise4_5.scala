package com.github.nigelhp.fpinscala

import exercise4_1.{Option, Some}
import Exercise4_3.map2
import Exercise4_4.{sequence2 => sequence}

/*
 * Exercise 4.5
 *   def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]]
 * Implement this function.
 * It's straightforward to do using map and sequence, but try for a more
 * efficient implementation that only looks at the list once.  In fact,
 * implement sequence in terms of traverse.
 */
object Exercise4_5 {
  // staightforward, but involves multiple traversals of a
  def traverse1[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =
    sequence(a.map(f))

  // low-level pattern matching
  def traverse2[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
    case Nil => Some(Nil)
    case head :: tail => f(head).flatMap(h =>
      traverse2(tail)(f).map { t => h :: t })
  }

  // higher-order functional approach (note reliance on exercise 4.3's map2)
  def traverse3[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    val initial: Option[List[B]] = Some(Nil)
    a.foldRight(initial) { (value, acc) => map2(f(value), acc) { _ :: _ } }
  }
}
