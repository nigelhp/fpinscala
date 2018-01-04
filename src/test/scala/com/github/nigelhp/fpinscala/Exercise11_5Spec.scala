package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

/*
 * Exercise 11.5
 * Think about how replicateM will behave for various choices of F.
 * For example, how does it behave in the List monad?
 * What about Option?
 * Describe in your own words the general meaning of replicateM.
 */
class Exercise11_5Spec extends FlatSpec {

  private trait Fixture {
    val value: Int = 42

    val listMonad = new Exercise11_4[List] {
      override def unit[A](a: => A): List[A] = List(a)
      override def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] = fa.flatMap(f)
    }

    val optionMonad = new Exercise11_4[Option] {
      override def unit[A](a: => A): Option[A] = Option(a)
      override def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] = fa.flatMap(f)
    }
  }

  "replicateM" should "return an empty list for the List monad when empty" in new Fixture {
    assert(listMonad.replicateM(0, List.empty) === List(List.empty))
    assert(listMonad.replicateM(1, List.empty) === List.empty)
    assert(listMonad.replicateM(2, List.empty) === List.empty)
  }

  it should "return a list of all lists of length n for the List monad when non-empty" in new Fixture {
    assert(listMonad.replicateM(0, List(1, 2, 3)) === List(List.empty))
    assert(listMonad.replicateM(1, List(1, 2, 3)) === List(List(1), List(2), List(3)))
    assert(listMonad.replicateM(2, List(1, 2, 3)) === List(
      List(1, 1), List(1, 2), List(1, 3), List(2, 1), List(2, 2), List(2, 3), List(3, 1), List(3, 2), List(3, 3)))
  }

  it should "return None for the Option monad when None" in new Fixture {
    assert(optionMonad.replicateM(0, None) === Some(List.empty))
    assert(optionMonad.replicateM(1, None) === None)
    assert(optionMonad.replicateM(2, None) === None)
  }

  it should "return Some list of value repeated n times for the Option monad when Some" in new Fixture {
    assert(optionMonad.replicateM(0, Some(value)) === Some(List.empty))
    assert(optionMonad.replicateM(1, Some(value)) === Some(List(value)))
    assert(optionMonad.replicateM(2, Some(value)) === Some(List(value, value)))
  }
}
