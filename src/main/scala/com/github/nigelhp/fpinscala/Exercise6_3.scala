package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_2.double
import fpinscala.state._

/*
 * Exercise 6.3
 * Write functions to generate an (Int, Double) pair, a (Double, Int) pair,
 * and a (Double, Double, Double) 3-tuple.  You should be able to reuse the
 * functions you've already written.
 *   def intDouble(rng: RNG): ((Int, Double), RNG)
 *   def doubleInt(rng: RNG): ((Double, Int), RNG)
 *   def double3(rng: RNG): ((Double, Double, Double), RNG)
 */
object Exercise6_3 {
  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (i, tmpRng) = rng.nextInt
    val (d, nextRng) = double(tmpRng)
    ((i, d), nextRng)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val (numbers, nextRng) = intDouble(rng)
    (numbers.swap, nextRng)
  }

  def double3(rng: RNG): ((Double, Double, Double), RNG) = {
    val (d1, rng1) = double(rng)
    val (d2, rng2) = double(rng1)
    val (d3, rng3) = double(rng2)
    ((d1, d2, d3), rng3)
  }
}
