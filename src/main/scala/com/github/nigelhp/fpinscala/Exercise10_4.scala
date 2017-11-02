package com.github.nigelhp.fpinscala

import fpinscala.monoids.Monoid
import fpinscala.property.{Gen, Prop}

/*
 * Use the property-based testing framework we developed in part 2 to implement a property for the monoid laws.
 * Use your property to test the monoids we've written.
 *   def monoidLaws[A](m: Monoid[A], gen: Gen[A]): Prop
 */
object Exercise10_4 {
  def monoidLaws[A](m: Monoid[A], gen: Gen[A]): Prop = {
    val identityProp = Prop.forAll(gen) { a =>
      m.op(a, m.zero) == a &&
        m.op(m.zero, a) == a
    }

    val associativityProp = Prop.forAll(for {
      a <- gen
      b <- gen
      c <- gen
    } yield (a, b, c)) { v =>
      m.op(v._1, m.op(v._2, v._3)) == m.op(m.op(v._1, v._2), v._3)
    }

    identityProp.&&(associativityProp)
  }
}