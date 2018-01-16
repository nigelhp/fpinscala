package com.github.nigelhp.fpinscala

import fpinscala.applicative.Applicative

import scala.language.higherKinds

/*
 * Exercise 12.1
 * Transplant the implementations of as many combinators as you can from Monad to Applicative,
 * using only map2 and unit, or methods implemented in terms of them.
 *
 *   def sequence[A](fas: List[F[A]]): F[List[A]]
 *   def replicateM[A](n: Int, fa: F[A]): F[List[A]]
 *   def product[A, B](fa: F[A], fb: F[B]): F[(A, B)]
 */
trait Exercise12_1[F[_]] extends Applicative[F] {
  def sequence[A](fas: List[F[A]]): F[List[A]] =
    traverse(fas)(identity)

  def replicateM[A](n: Int, fa: F[A]): F[List[A]] =
    sequence(List.fill(n)(fa))

  def product[A, B](fa: F[A], fb: F[B]): F[(A, B)] =
    map2(fa, fb)(_ -> _)
}
