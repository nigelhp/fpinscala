package com.github.nigelhp.fpinscala

import fpinscala.laziness.Stream.cons
import fpinscala.laziness._

/*
 * Exercise 5.8
 * Generalize ones slightly to the function constant, which returns an infinite Stream of a given value.
 *   def constant[A](a: A): Stream[A]
 */
object Exercise5_8 {
  def constant[A](a: A): Stream[A] =
    cons(a, constant(a))
}
