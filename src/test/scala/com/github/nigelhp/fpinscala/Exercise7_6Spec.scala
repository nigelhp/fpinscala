package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise7_6.parFilter

class Exercise7_6Spec extends ParallelFixture {

  "parFilter" should "return an empty list when the input list is empty" in { es =>
    val par = parFilter(List.empty[Int])(_ => true)

    assert(par(es).get === List.empty[Int])
  }

  it should "return an empty list when the input list contains a single value but it fails the predicate" in { es =>
    val par = parFilter(List(42))(_ => false)

    assert(par(es).get === List.empty[Int])
  }

  it should "return a singleton list when the input list contains a single value and it satisfies the predicate" in { es =>
    val par = parFilter(List(42))(_ => true)

    assert(par(es).get === List(42))
  }

  it should "be able to filter the even numbers from a list containing many values" in { es =>
    val par = parFilter(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))(n => n % 2 == 0)

    assert(par(es).get === List(2, 4, 6, 8, 10))
  }
}
