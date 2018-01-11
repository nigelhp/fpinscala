package com.github.nigelhp.fpinscala

import fpinscala.monads.Functor

import scala.language.higherKinds

/*
 * Exercise 11.13
 * Implement either flatMap or compose in terms of join and map.
 */
trait Exercise11_13[F[_]] extends Functor[F] {
  def unit[A](a: => A): F[A]
  def join[A](mma: F[F[A]]): F[A]

  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B] =
    join(map(fa)(f))

  def compose[A, B, C](f: A => F[B], g: B => F[C]): A => F[C] =
    a => join(map(f(a))(g))
}
