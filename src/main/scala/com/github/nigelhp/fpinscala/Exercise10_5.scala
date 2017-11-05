package com.github.nigelhp.fpinscala

import fpinscala.monoids.Monoid

/*
 * Exercise 10.5
 * Implement foldMap.
 */
object Exercise10_5 {
  def foldMap[A,B](as: List[A], m: Monoid[B])(f: A => B): B =
    as.foldLeft(m.zero)((b, a) => m.op(b, f(a)))

  // simple implementation, but involves two iterations of the elements
  //  def foldMap[A,B](as: List[A], m: Monoid[B])(f: A => B): B =
  //    as.map(f).fold(m.zero)(m.op)
}
