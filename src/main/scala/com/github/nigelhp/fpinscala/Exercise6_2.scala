package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_1.nonNegativeInt
import fpinscala.state._

/*
 * Exercise 6.2
 * Write a function to generate a Double between 0 and 1, not including 1.
 * Note: You can use Int.MaxValue to obtain the maximum positive integer value, and you can use
 * x.toDouble to convert an x: Int to a Double.
 *   def double(rng: RNG): (Double, RNG)
 */
object Exercise6_2 {
  def double(rng: RNG): (Double, RNG) = {
    val (n, nextRng) = nonNegativeInt(rng)
    val d = n / (Int.MaxValue + 1.0D)
    (d, nextRng)
  }
}
