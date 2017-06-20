package com.github.nigelhp.fpinscala

import fpinscala.state.RNG.Rand
import fpinscala.state._

/*
 * Exercise 6.5
 * Use map to re-implement double in a more elegant way (see Exercise 6.2).
 */
object Exercise6_5 {
  /*
   * generate a random integer between 0 and Int.MaxValue (inclusive)
   */
  val nonNegativeInt: Rand[Int] =
    RNG.map(RNG.int) { n =>
      if (n < 0) -(n + 1) else n  // increment before unary minus to handle case where n == Int.MinValue
    }

  /*
   * generate a Double between 0 and 1, not including 1.
   */
  val double: Rand[Double] =
    RNG.map(nonNegativeInt) { _ / (Int.MaxValue + 1.0D) }
}
