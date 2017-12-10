package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise10_12.foldableIndexedSeq
import fpinscala.monoids.MapMerge.mapMergeMonoid
import fpinscala.monoids.Monoid

/*
 * Exercise 10.18
 * A bag is like a set, except that it's represented by a map that contains one entry per element with that
 * element as the key, and the value under that key is the number of times the element appears in the bag.
 * Use monoids to compose a "bag" from an IndexedSeq.
 *   def bag[A](as: IndexedSeq[A]): Map[A, Int]
 */
object Exercise10_18 {

  type Bag[A] = Map[A, Int]

  private object Bag {
    def unit[A](a: A): Bag[A] =
      Map(a -> 1)

    val countMonoid = new Monoid[Int] {
      override def zero: Int = 0
      override def op(x: Int, y: Int): Int = x + y
    }
  }

  def bag[A](as: IndexedSeq[A]): Bag[A] =
    foldableIndexedSeq.foldMap(as)(Bag.unit)(mapMergeMonoid(Bag.countMonoid))
}
