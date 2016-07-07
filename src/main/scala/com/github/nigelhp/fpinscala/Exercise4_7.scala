package com.github.nigelhp.fpinscala

import exercise4_6._

/*
 * Exercise 4.7
 * Implement sequence and traverse for Either.  These should return the first
 * error that's encountered, if there is one.
 *   
 *   def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]]
 *   def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]]
 */
object Exercise4_7 {

  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] =
    traverse(es)(ea => ea)

  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] =
    as match {
      case Nil => Right(Nil)
      case head :: tail => f(head).flatMap { b =>
        traverse(tail)(f).map { b :: _ }
      }
    }
}
