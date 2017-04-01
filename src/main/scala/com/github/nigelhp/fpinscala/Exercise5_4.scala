package com.github.nigelhp.fpinscala

import fpinscala.laziness._

/*
 * Exercise 5.4
 * Implement forAll, which checks that all elements in the Stream match a given predicate.
 * Your implementation should terminate the traversal as soon as it encounters a non-matching value.
 * def forAll(p: A => Boolean): Boolean
 */
object Exercise5_4 {
  def forAll[A](stream: Stream[A])(p: A => Boolean): Boolean =
    stream.foldRight(true)((a, b) => p(a) && b)

// low-level pattern matching ...
//  import scala.annotation.tailrec
//
//  @tailrec
//  def forAll[A](stream: Stream[A])(p: A => Boolean): Boolean =
//    stream match {
//      case Cons(h, t) if p(h()) => forAll(t())(p)
//      case Cons(h, _) if !p(h()) => false
//      case Empty => true
//    }
}
