package com.github.nigelhp.fpinscala

import fpinscala.monads.Monad

import scala.language.higherKinds

/*
 * Exercise 11.7
 * Implement the Kleisli composition function compose.
 *   def compose[A,B,C](f: A => F[B], g: B => F[C]): A => F[C]
 */
trait Exercise11_7[F[_]] extends Monad[F] {
  def compose[A,B,C](f: A => F[B], g: B => F[C]): A => F[C] =
    a => flatMap(f(a))(g)
}
