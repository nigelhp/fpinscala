package com.github.nigelhp.fpinscala

import fpinscala.monads.Monad

import scala.language.higherKinds

/*
 * Exercise 11.3
 * The sequence and traverse combinators can be implemented once and for all on Monad[F].
 *   def sequence[A](lma: List[F[A]]): F[List[A]]
 *   def traverse[A, B](la: List[A])(f: A => F[B]): F[List[B]]
 */
trait Exercise11_3[F[_]] extends Monad[F] {
  def sequence[A](lfa: List[F[A]]): F[List[A]] =
    lfa.foldRight(unit(List.empty[A])) { (fa, fas) =>
      map2(fa, fas)(_ :: _)
    }

  def traverse[A, B](la: List[A])(f: A => F[B]): F[List[B]] =
    la.foldRight(unit(List.empty[B])) { (a, fbs) =>
      map2(f(a), fbs)(_ :: _)
    }
}
