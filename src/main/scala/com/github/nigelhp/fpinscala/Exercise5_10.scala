package com.github.nigelhp.fpinscala

import fpinscala.laziness._

/*
 * Exercise 5.10
 * Write a function fibs that generates the infinite stream of Fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, and so on.
 */
object Exercise5_10 {
  def fibs: Stream[Int] = {
    def go(nMinus2: Int, nMinus1: Int): Stream[Int] =
      Stream.cons(nMinus2, go(nMinus1, nMinus2 + nMinus1))

    go(0, 1)
  }
}
