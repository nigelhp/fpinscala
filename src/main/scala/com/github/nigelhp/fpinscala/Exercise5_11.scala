package com.github.nigelhp.fpinscala

import fpinscala.laziness.Stream.{cons, empty}
import fpinscala.laziness._

/*
 * Exercise 5.11
 * Write a more general stream-building function called unfold.
 * It takes an initial state, and a function for producing both the next state and the next value in the
 * generated stream.
 *   def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A]
 */
object Exercise5_11 {
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] =
    f(z).map { case (a, s) =>
      cons(a, unfold(s)(f))
    }.getOrElse(empty)
}
