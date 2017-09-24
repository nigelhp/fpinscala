package com.github.nigelhp.fpinscala

import fpinscala.parallelism.Par
import fpinscala.parallelism.Par.Par

/*
 * Exercise 7.13
 * Implement the new primitive chooser, and then use it to implement choice and choiceN.
 *   def chooser[A,B](pa: Par[A])(choices: A => Par[B]): Par[B]
 */
object Exercise7_13 {
  def chooser[A,B](pa: Par[A])(choices: A => Par[B]): Par[B] =
    s => {
      val a = Par.run(s)(pa).get()
      Par.run(s)(choices(a))
    }

  def choiceN[A](n: Par[Int])(choices: List[Par[A]]): Par[A] =
    chooser(n)(choices.apply)

  def choice[A](cond: Par[Boolean])(t: Par[A], f: Par[A]): Par[A] =
    chooser(cond) { b => if (b) t else f }
}
