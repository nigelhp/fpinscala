package com.github.nigelhp.fpinscala

import scala.Function.const
import scala.language.higherKinds

/*
 * Exercise 11.8
 * Implement flatMap in terms of compose.
 * It seems that we've found another minimal set of monad combinators: compose and unit.
 */
trait Exercise11_8[F[_]] {
  def unit[A](a: => A): F[A]
  def compose[A,B,C](f: A => F[B], g: B => F[C]): A => F[C]

  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B] =
    compose(const(fa), f)(())
}
