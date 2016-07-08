package com.github.nigelhp.fpinscala

import exercise4_6._

/*
 * Exercise 4.8
 * In this implementation, map2 is only able to report one error, even if both
 * the name and age are invalid.  What would you need to change in order to keep
 * both errors?  Would you change map2 or the signature of mkPerson?  Or could
 * you create a new data type that captures this requirement better than Either
 * does, with some additional structure?  How would orElse, traverse, and
 * sequence behave differently for that data type?
 */
object Exercise4_8 {
  def map2[E, A, B, C](a: Either[E, A], b: Either[E, B])(f: (A, B) => C): Either[List[E], C] =
    (a, b) match {
      case (Left(ea), Left(eb)) => Left(List(ea, eb))
      case (Left(ea), Right(_)) => Left(List(ea))
      case (Right(_), Left(eb)) => Left(List(eb))
      case (Right(a), Right(b)) => Right(f(a, b))
    }
}
