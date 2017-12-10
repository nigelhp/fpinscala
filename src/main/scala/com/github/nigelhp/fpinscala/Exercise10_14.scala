package com.github.nigelhp.fpinscala

import fpinscala.monoids.{Foldable, Monoid}

/*
 * Exercise 10.14
 * Write a Foldable[Option] instance.
 */
object Exercise10_14 {
  val foldableOption = new Foldable[Option] {
    override def foldRight[A, B](as: Option[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: Option[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)

    override def foldMap[A, B](as: Option[A])(f: A => B)(mb: Monoid[B]): B =
      as.fold(mb.zero)(f)
  }
}
