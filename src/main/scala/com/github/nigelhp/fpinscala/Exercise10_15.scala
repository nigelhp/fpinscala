package com.github.nigelhp.fpinscala

import fpinscala.monoids.Foldable

import scala.language.higherKinds

/*
 * Exercsie 10.15
 * Any Foldable structure can be turned into a List.
 * Write this conversion in a generic way:
 *   def toList[A](fa: F[A]): List[A]
 */
object Exercise10_15 {
  trait FoldableToList[F[_]] extends Foldable[F] {
    def toList[A](as: F[A]): List[A] =
      foldLeft(as)(List.empty[A])((acc, a) => a :: acc).reverse

    // or alternatively
//    def toList[A](as: F[A]): List[A] =
//      foldRight(as)(List.empty[A])(_ :: _)
  }
}
