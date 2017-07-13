package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise7_5.sequence
import fpinscala.parallelism.Par._

/*
 * Exercise 7.6
 * Implement parFilter, which filters the elements of a list in parallel.
 *   def parFilter[A](as: List[A])(f: A => Boolean): Par[List[A]]
 */
object Exercise7_6 {
  def parFilter[A](as: List[A])(f: A => Boolean): Par[List[A]] = {
    val pars = as.map(a => lazyUnit[List[A]](if (f(a)) List(a) else Nil))
    val lists = sequence(pars)
    map(lists) { _.flatten }
  }
}
