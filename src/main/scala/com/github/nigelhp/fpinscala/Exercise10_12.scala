package com.github.nigelhp.fpinscala

import fpinscala.monoids.{Foldable, Monoid}

import scala.language.higherKinds

/*
 * Exercise 10.12
 * Implement Foldable[List], Foldable[IndexedSeq], and Foldable[Stream].
 * Remember that foldRight, foldLeft, and foldMap can all be implemented in terms of each other,
 * but that might not be the most efficient implementation.
 */
object Exercise10_12 {
  private abstract trait AbstractFoldable[F[_]] extends Foldable[F] {
    override def foldMap[A, B](as: F[A])(f: A => B)(mb: Monoid[B]): B =
      foldLeft(as)(mb.zero) { (b, a) =>
        mb.op(b, f(a))
      }
  }

  val foldableList: Foldable[List] = new AbstractFoldable[List] {
    override def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: List[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)
  }

  val foldableIndexedSeq: Foldable[IndexedSeq] = new AbstractFoldable[IndexedSeq] {
    override def foldRight[A, B](as: IndexedSeq[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: IndexedSeq[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)
  }

  val foldableStream: Foldable[Stream] = new AbstractFoldable[Stream] {
    override def foldRight[A, B](as: Stream[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: Stream[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)
  }
}