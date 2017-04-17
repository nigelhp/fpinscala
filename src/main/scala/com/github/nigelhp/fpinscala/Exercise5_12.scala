package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_11.unfold
import fpinscala.laziness._

/*
 * Exercise 5.12
 * Write fibs, from, constant, and ones in terms of unfold.
 */
object Exercise5_12 {
  def fibs: Stream[Int] =
    unfold((0, 1))(s => Some(s._1, (s._2, s._1 + s._2)))
}
