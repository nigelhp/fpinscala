package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_5.nonNegativeInt
import fpinscala.state.RNG.{Rand, unit}

/*
 * Exercise 6.8
 * Implement flatMap, and then use it to implement nonNegativeLessThan.
 *   def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B]
 */
object Exercise6_8 {
  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] =
    rng => {
      val (a, rng1) = f(rng)
      g(a)(rng1)
    }

  /*
   * generate a random integer between 0 (inclusive) and n (exclusive)
   */
  def nonNegativeLessThan(n: Int): Rand[Int] =
    flatMap(nonNegativeInt) { i =>
      val mod = i % n
      if (i + (n - 1) - mod >= 0) unit(mod)
      else nonNegativeLessThan(n)
    }
}