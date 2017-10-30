package com.github.nigelhp.fpinscala

import fpinscala.monoids.Monoid

/*
 * Exercise 10.1
 * Give Monoid instances for integer addition and multiplication as well as the Boolean operators.
 *   val intAddition: Monoid[Int]
 *   val intMultiplication: Monoid[Int]
 *   val booleanOr: Monoid[Boolean]
 *   val booleanAnd: Monoid[Boolean]
 */
object Exercise10_1 {
  val intAddition = new Monoid[Int] {
    override def op(a1: Int, a2: Int): Int = a1 + a2
    override val zero = 0
  }

  val intMultiplication = new Monoid[Int] {
    override def op(a1: Int, a2: Int): Int = a1 * a2
    override val zero = 1
  }

  val booleanOr = new Monoid[Boolean] {
    override def op(a1: Boolean, a2: Boolean): Boolean = a1 || a2
    override val zero = false
  }

  val booleanAnd = new Monoid[Boolean] {
    override def op(a1: Boolean, a2: Boolean): Boolean = a1 && a2
    override val zero = true
  }
}
