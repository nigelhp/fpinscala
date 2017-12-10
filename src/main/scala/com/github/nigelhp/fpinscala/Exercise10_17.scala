package com.github.nigelhp.fpinscala

import fpinscala.monoids.Monoid

import scala.Function.const

/*
 * Exercise 10.17
 * Write a monoid instance for functions whose results are monoids.
 *   def functionMonoid[A, B](B: Monoid[B]): Monoid[A => B]
 */
object Exercise10_17 {
  def functionMonoid[A, B](B: Monoid[B]): Monoid[A => B] = new Monoid[A => B] {
    override val zero: A => B =
      const(B.zero)

    override def op(f1: A => B, f2: A => B): A => B =
      a => B.op(f1(a), f2(a))
  }
}
