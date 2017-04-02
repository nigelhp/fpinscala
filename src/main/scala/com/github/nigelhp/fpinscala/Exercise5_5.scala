package com.github.nigelhp.fpinscala

import fpinscala.laziness.Stream.{cons, empty}
import fpinscala.laziness._

/*
 * Exercise 5.5
 * Use foldRight to implement takeWhile.
 */
object Exercise5_5 {
  def takeWhile[A](stream: Stream[A])(p: A => Boolean): Stream[A] =
    stream.foldRight(empty[A])((a, acc) => if (p(a)) cons(a, acc) else empty[A])
}
