package com.github.nigelhp.fpinscala

import fpinscala.monoids.Monoid
import fpinscala.parallelism.Par
import fpinscala.parallelism.Par.Par

/*
 * Exercise 10.8
 * Also implement a parallel version of foldMap using the library we developed in chapter 7.
 * Hint: Implement par, a combinator to promote Monoid[A] to a Monoid[Par[A]], and then use
 * this to implement parFoldMap.
 *
 *   def par[A](m: Monoid[A]): Monoid[Par[A]]
 *   def parFoldMap[A,B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): Par[B]
 */
object Exercise10_8 {
  def par[A](m: Monoid[A]): Monoid[Par[A]] = new Monoid[Par[A]] {
    override def zero: Par[A] = Par.unit(m.zero)
    override def op(a1: Par[A], a2: Par[A]): Par[A] = Par.map2(a1, a2)(m.op)
  }

  def parFoldMap[A,B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): Par[B] = {
    Exercise10_7.foldMap(v, par(m)) { a =>
      Par.lazyUnit(f(a))
    }
  }
}