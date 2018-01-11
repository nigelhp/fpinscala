package com.github.nigelhp.fpinscala

import fpinscala.monads.Monad

/*
 * Exercise 11.17
 * The identity monad is given by the following type:
 *   case class Id[A](value: A)
 *
 * Implement map and flatMap as methods on this class, and give an implementation for Monad[Id].
 */
object Exercise11_17 {
  case class Id[A](value: A) {
    def flatMap[B](f: A => Id[B]): Id[B] =
      f(value)

    def map[B](f: A => B): Id[B] =
      flatMap(f.andThen(Id(_)))
  }

  object Id {
    val idMonad = new Monad[Id] {
      override def unit[A](a: => A): Id[A] = Id(a)
      override def flatMap[A, B](fa: Id[A])(f: A => Id[B]): Id[B] = fa.flatMap(f)
    }
  }
}
