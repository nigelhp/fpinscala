package com.github.nigelhp.fpinscala

import fpinscala.state._

/*
 * Exercise 6.1
 * Write a function that uses RNG.nextInt to generate a random integer between 0 and Int.MaxValue (inclusive).
 * Make sure to handle the corner case when nextInt returns Int.MinValue, which doesn't have a non-negative
 * counterpart.
 *   def nonNegativeInt(rng: RNG): (Int, RNG)
 */
object Exercise6_1 {
  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (n, nextRng) = rng.nextInt
    val nonNegative = if (n < 0) -(n + 1) else n  // increment before unary minus to handle case where n == Int.MinValue
    (nonNegative, nextRng)
  }
}
