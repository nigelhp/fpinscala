package com.github.nigelhp.fpinscala

import fpinscala.monads.Monad

import scala.language.higherKinds

/*
 * Exercise 11.12
 * There's a third minimal set of monadic combinators: map, unit, and join,
 * Implement join in terms of flatMap.
 *   def join[A](mma: F[F[A]]): F[A]
 */
trait Exercise11_12[F[_]] extends Monad[F] {
  def join[A](mma: F[F[A]]): F[A] =
    flatMap(mma)(identity)
}
