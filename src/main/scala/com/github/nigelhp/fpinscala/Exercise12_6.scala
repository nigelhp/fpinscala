package com.github.nigelhp.fpinscala

import fpinscala.applicative.{Applicative, Failure, Success, Validation}

import scala.language.reflectiveCalls

/*
 * Exercise 12.6
 * Write an Applicative instance for Validation that accumulates errors in Failure.
 * Note that in the case of Failure there's always at least one error, stored in head.  The rest of the errors
 * accumulate in the tail.
 */
object Exercise12_6 {
  def validationApplicative[E]: Applicative[({type f[x] = Validation[E, x]})#f] = new Applicative[({type f[x] = Validation[E, x]})#f] {
    override def unit[A](a: => A): Validation[E, A] = Success(a)

    override def map2[A, B, C](fa: Validation[E, A], fb: Validation[E, B])(f: (A, B) => C): Validation[E, C] =
      (fa, fb) match {
        case (Success(a), Success(b)) => Success(f(a, b))
        case (Failure(ha, ta), Failure(hb, tb)) => Failure(ha, ta ++: hb +: tb)
        case (Failure(h, t), _) => Failure(h, t)
        case (_, Failure(h, t)) => Failure(h, t)
      }
  }
}
