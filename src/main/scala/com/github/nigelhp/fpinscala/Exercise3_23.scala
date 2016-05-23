package com.github.nigelhp.fpinscala

import fpinscala.datastructures._

/*
 * Exercise 3.23
 * Generalize the function you just wrote so that it's not specific to integers or addition.
 * Name your generalized function zipWith.
 */
object Exercise3_23 {

  def zipWith[A, B, C](as: List[A], bs: List[B])(f: (A, B) => C): List[C] = (as, bs) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case(Cons(ah, at), Cons(bh, bt)) => Cons(f(ah, bh), zipWith(at, bt)(f))
  }
}
