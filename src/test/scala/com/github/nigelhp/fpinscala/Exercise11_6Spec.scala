package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

class Exercise11_6Spec extends FlatSpec {

  private trait Fixture {
    val listMonad = new Exercise11_6[List] {
      override def unit[A](a: => A): List[A] = List(a)
      override def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] = fa.flatMap(f)
    }

    val optionMonad = new Exercise11_6[Option] {
      override def unit[A](a: => A): Option[A] = Option(a)
      override def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] = fa.flatMap(f)
    }
  }

  "filterM for the listMonad" should "return a list containing an empty list when no elements satisfy the filter" in new Fixture {
    assert(listMonad.filterM(List(1, 2, 3, 4))(_ => List(false)) === List(List.empty))
  }

  it should "return a list containing a list with all elements when all elements satisfy the filter" in new Fixture {
    assert(listMonad.filterM(List(1, 2, 3, 4))(_ => List(true)) === List(List(1, 2, 3, 4)))
  }

  it should "return a list containing a list with all even values when only even values satisfy the filter" in new Fixture {
    assert(listMonad.filterM(List(1, 2, 3, 4))(n => List(n % 2 == 0)) === List(List(2, 4)))
  }

  it should "return an empty list if the filter returns an empty list for any of the elements" in new Fixture {
    assert(listMonad.filterM(List(1, 2, 3, 4))(n => if (n < 4) List(true) else List.empty) === List.empty)
  }

  "filterM for the optionMonad" should "return a Some containing an empty list when no elements satisfy the filter" in new Fixture {
    assert(optionMonad.filterM(List(1, 2, 3, 4))(_ => Some(false)) === Some(List.empty))
  }

  it should "return a Some containing a list with all elements when all elements satify the filter" in new Fixture {
    assert(optionMonad.filterM(List(1, 2, 3, 4))(_ => Some(true)) === Some(List(1, 2, 3, 4)))
  }

  it should "return a Some containing a list with all even values when only even values satisfy the filter" in new Fixture {
    assert(optionMonad.filterM(List(1, 2, 3, 4))(n => Some(n % 2 == 0)) === Some(List(2, 4)))
  }

  it should "return None if the filter returns None for any of the elements" in new Fixture {
    assert(optionMonad.filterM(List(1, 2, 3, 4))(n => if (n < 4) Some(true) else None) === None)
  }
}
