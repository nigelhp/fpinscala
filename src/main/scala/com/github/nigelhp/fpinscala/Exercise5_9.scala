package com.github.nigelhp.fpinscala

import fpinscala.laziness.Stream.cons
import fpinscala.laziness._

/*
 * Exercise 5.9
 * Write a function that generates an infinite stream of integers, starting from n, then n+1, n+2 and so on.
 *   def from(n: Int): Stream[Int]
 */
object Exercise5_9 {
  def from(n: Int): Stream[Int] =
    cons(n, from(n + 1))
}
