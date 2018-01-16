package com.github.nigelhp.fpinscala

import fpinscala.applicative.Applicative
import fpinscala.monads.Functor

import scala.language.higherKinds

/*
 * Exercise 12.2
 * The name applicative comes from the fact that we can formulate the Applicative interface using an alternate
 * set of primitives, unit and the function apply, rather than unit and map2.
 * Show that this formulation is equivalent in expressiveness by defining map2 and map in terms of unit and apply.
 * Also establish that apply can be implemented in terms of map2 and unit.
 */
object Exercise12_2 {
  trait ApplyApplicative[F[_]] extends Functor[F] {
    def unit[A](a: => A): F[A]
    def apply[A, B](fab: F[A => B])(fa: F[A]): F[B]

    override def map[A, B](fa: F[A])(f: A => B): F[B] =
      apply(unit(f))(fa)

    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = {
      val fbc = map(fa)(f.curried)
      apply(fbc)(fb)
    }
  }

  trait Map2Applicative[F[_]] extends Applicative[F] {
    def apply[A, B](fab: F[A => B])(fa: F[A]): F[B] = {
      map2(fab, fa) { (f, a) =>
        f(a)
      }
    }
  }
}
