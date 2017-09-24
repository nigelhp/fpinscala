package com.github.nigelhp.fpinscala

import fpinscala.parallelism.Par
import fpinscala.parallelism.Par._

/*
 * Exercise 7.11
 * Implement choiceN and then choice in terms of choiceN.
 */
object Exercise7_11 {
  def choiceN[A](n: Par[Int])(choices: List[Par[A]]): Par[A] =
    s => {
      val futIndex = Par.run(s)(n)
      Par.run(s)(choices(futIndex.get()))
    }

  def choice[A](cond: Par[Boolean])(t: Par[A], f: Par[A]): Par[A] = {
    val n = Par.map(cond) { b => if (b) 0 else 1 }
    choiceN(n)(List(t, f))
  }
}
