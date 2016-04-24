import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_18.map

class Exercise3_18Spec extends FlatSpec {

  "map" should "return an empty list when the input list is empty" in {
    assert(map(Nil)(_.toString) === Nil)
  }

  it should "be able to implement the increment feature of exercise 3.16" in {
    assert(map(List(1, 2, 3))(_ + 1) === List(2, 3, 4))
  }

  it should "be able to implement the asStrings feature of exercise 3.17" in {
    assert(map(List(3.1419, 2.71828, 42.0))(_.toString) === List("3.1419", "2.71828", "42.0"))
  }
}
