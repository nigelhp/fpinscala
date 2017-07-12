package com.github.nigelhp.fpinscala

import fpinscala.parallelism.Par._

/*
 * Exercise 7.5
 * Write this function, called sequence.
 * No additional primitives are required.  Do not call run.
 *   def sequence[A](ps: List[Par[A]]): Par[List[A]]
 */
object Exercise7_5 {
  def sequence[A](ps: List[Par[A]]): Par[List[A]] =
    ps match {
      case Nil => unit(Nil)
      case h :: t => map2(h, sequence(t)) { _ :: _ }
    }
}
