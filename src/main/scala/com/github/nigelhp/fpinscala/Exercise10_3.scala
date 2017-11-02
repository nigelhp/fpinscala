package com.github.nigelhp.fpinscala

import fpinscala.monoids.Monoid

/*
 * Exercise 10.3
 * A function having the same argument and return type is sometimes called an endofunction.
 * Write a monoid for endofunctions.
 *   def endoMonoid[A]: Monoid[A => A]
 */
object Exercise10_3 {
  def endoMonoid[A]: Monoid[A => A] = new Monoid[A => A] {
    override def op(a1: A => A, a2: A => A): A => A = a1.andThen(a2)
    override def zero = identity[A]
  }
}
