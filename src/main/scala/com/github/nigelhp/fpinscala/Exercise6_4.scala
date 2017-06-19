package com.github.nigelhp.fpinscala

import fpinscala.state._

/*
 * Exercise 6.4
 * Write a function to generate a list of random integers:
 *   def ints(count: Int)(rng: RNG): (List[Int], RNG)
 */
object Exercise6_4 {
  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    (1 to count).foldLeft((List.empty[Int], rng)) { (acc, _) =>
      val (i, nextRng) = acc._2.nextInt
      (i :: acc._1, nextRng)
    }
  }
}
