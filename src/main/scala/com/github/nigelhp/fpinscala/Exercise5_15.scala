package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_11.unfold
import fpinscala.laziness.Stream.empty
import fpinscala.laziness._

/*
 * Exercise 5.15
 * Implement tails using unfold.
 * For a given Stream, tails returns the Stream of suffixes of the input sequence, starting with the
 * original Stream.  For example, given Stream(1,2,3), it would return Stream(Stream(1,2,3), Stream(2,3),
 * Stream(3), Stream()).
 *   def tails: Stream[Stream[A]]
 */
object Exercise5_15 {
  def tails[A](s: Stream[A]): Stream[Stream[A]] =
    unfold(Some(s): Option[Stream[A]]) {
      case Some(s@Cons(_, as)) => Some(s -> Some(as()))
      case Some(Empty) => Some(empty -> None)
      case _ => None
    }
}
