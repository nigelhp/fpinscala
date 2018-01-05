package com.github.nigelhp.fpinscala

import fpinscala.monads.Monad

import scala.language.higherKinds

/*
 * Exercise 11.6
 * Implement the function filterM.
 * It's a bit like filter, except that instead of a function from A => Boolean, we have an A => F[Boolean].
 * Implement this function, and then think about what it means for various data types.
 *   def filterM[A](ms: List[A])(f: A => F[Boolean]): F[List[A]]
 */
trait Exercise11_6[F[_]] extends Monad[F] {
  def filterM[A](as: List[A])(f: A => F[Boolean]): F[List[A]] = {
    val empty = unit(List.empty[A])
    as.foldRight(empty) { (a, facc) =>
      map2(f(a), facc) { (bool, acc) =>
        if (bool) a :: acc else acc
      }
    }
  }
}
