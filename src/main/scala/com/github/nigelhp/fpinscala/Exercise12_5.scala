package com.github.nigelhp.fpinscala

import fpinscala.monads.Monad

import scala.language.reflectiveCalls

/*
 * Exercise 12.5
 * Write a monad instance for Either.
 *   def eitherMonad[E]: Monad[({type f[x] = Either[E, x]})#f]
 */
object Exercise12_5 {
  def eitherMonad[E]: Monad[({type f[x] = Either[E, x]})#f] = new Monad[({type f[x] = Either[E, x]})#f] {
    override def unit[A](a: => A): Either[E, A] = Right(a)
    override def flatMap[A, B](fa: Either[E, A])(f: A => Either[E, B]): Either[E, B] = fa.flatMap(f)
  }
}
