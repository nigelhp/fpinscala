package com.github.nigelhp.fpinscala

import fpinscala.monoids.Monoid

/*
 * Exercise 10.16
 * The real power of monoids comes from the fact that they compose.
 * This means, for example, that if types A and B are monoids, then the tuple type (A, B) is also a monoid
 * (called their product).
 *
 * Prove it.  Notice that your implementation of op is obviously associative so long as A.op and B.op are
 * both associative.
 *   def productMonoid[A, B](A: Monoid[A], B: Monoid[B]): Monoid[(A, B)]
 */
object Exercise10_16 {
  def productMonoid[A, B](A: Monoid[A], B: Monoid[B]): Monoid[(A, B)] = new Monoid[(A, B)] {
    override def zero: (A, B) = A.zero -> B.zero
    override def op(p1: (A, B), p2: (A, B)): (A, B) = A.op(p1._1, p2._1) -> B.op(p1._2, p2._2)
  }
}
