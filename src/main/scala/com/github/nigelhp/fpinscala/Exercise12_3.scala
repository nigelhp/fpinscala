package com.github.nigelhp.fpinscala

import scala.language.higherKinds

/*
 * Exercise 12.3
 * The apply method is useful for implementing map3, map4, and so on, and the pattern is straightforward.
 * Implement map3 and map4 using only unit, apply, and the curried method available on functions.
 *
 *   def map3[A, B, C, D](fa: F[A], fb: F[B], fc: F[C])(f: (A, B, C) => D): F[D]
 *   def map4[A, B, C, D, E](fa: F[A], fb: F[B], fc: F[C], fd: F[D])(f: (A, B, C, D) => E): F[E]
 */
trait Exercise12_3[F[_]] extends Exercise12_2.Map2Applicative[F] {
  def map3[A, B, C, D](fa: F[A], fb: F[B], fc: F[C])(f: (A, B, C) => D): F[D] = {
    val fbcd = apply(unit(f.curried))(fa)
    val fcd = apply(fbcd)(fb)
    apply(fcd)(fc)
  }

  def map4[A, B, C, D, E](fa: F[A], fb: F[B], fc: F[C], fd: F[D])(f: (A, B, C, D) => E): F[E] = {
    val fbcde = apply(unit(f.curried))(fa)
    val fbcd = apply(fbcde)(fb)
    val fbc = apply(fbcd)(fc)
    apply(fbc)(fd)
  }
}
