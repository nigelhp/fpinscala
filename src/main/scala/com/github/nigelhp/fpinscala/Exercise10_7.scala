package com.github.nigelhp.fpinscala

import fpinscala.monoids.Monoid

/*
 * Exercise 10.7
 * Implement a foldMap for IndexedSeq.
 * Your implementation should use the strategy of splitting the sequence in two, recursively processing each half,
 * and then adding the answers together with the monoid.
 *   def foldMapV[A,B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B
 */
object Exercise10_7 {
  def foldMap[A, B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B =
    v match {
      case IndexedSeq() => m.zero
      case IndexedSeq(h) => f(h)
      case _ =>
        val (left, right) = v.splitAt(v.length / 2)
        m.op(foldMap(left, m)(f), foldMap(right, m)(f))
    }
}