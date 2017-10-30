package com.github.nigelhp.fpinscala

import fpinscala.monoids.Monoid

/*
 * Exercise 10.2
 * Give a Monoid instance for combining Option values.
 *   def optionMonoid[A]: Monoid[Option[A]]
 */
object Exercise10_2 {
  def optionMonoid[A]: Monoid[Option[A]] = new Monoid[Option[A]] {
    override def op(a1: Option[A], a2: Option[A]): Option[A] = a1.orElse(a2)
    override val zero = None
  }
}
