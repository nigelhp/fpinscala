package com.github.nigelhp.fpinscala

import fpinscala.laziness._

/*
 * Exercise 5.16
 * Generalize tails to the function scanRight, which is like a foldRight that returns a stream of the
 * intermediate results.  For example:
 *   Stream(1,2,3).scanRight(0)(_ + _).toList -> List(6,5,3,0)
 *
 * This example should be equivalent to the expression List(1+2+3+0, 2+3+0, 3+0, 0).
 * Your function should reuse intermediate results so that traversing a Stream with n elements
 * always takes time linear in n.  Can it be implemented using unfold?  How, or why not?
 * Could it be implemented using another function we've written?
 */
object Exercise5_16 {
  def scanRight[A, B](s: Stream[A], z: B)(fn: (A, => B) => B): Stream[B] =
    s.foldRight(Stream(z)) {
      case (a, sb@Cons(b, _)) =>
        val next = fn(a, b())
        Stream.cons(next, sb)
      case _ => throw new AssertionError()
    }
}

/*
 * We cannot use unfold easily - as it traverses from left to right.
 */