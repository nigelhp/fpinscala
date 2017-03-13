package com.github.nigelhp.fpinscala

import fpinscala.laziness._

/*
 * Write the function takeWhile for returning all starting elements of a Stream that
 * match the given predicate.
 */
object Exercise5_3 {
  def takeWhile[A](stream: Stream[A])(p: A => Boolean) : Stream[A] =
    stream match {
      case Cons(h, t) if p(h()) => Stream.cons(h(), takeWhile(t())(p))
      case _ => Stream.empty
    }
}
