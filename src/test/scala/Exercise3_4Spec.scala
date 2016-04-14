import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_4.drop

class Exercise3_4Spec extends FlatSpec {

  "drop 0" should "return an unchanged list when the list is not empty" in {
    assert(drop(List(1, 2, 3), 0) === List(1, 2, 3))
  }

  "drop 1" should "remove the head when the list is not empty" in {
    assert(drop(List(1, 2, 3), 1) === List(2, 3))
  }

  "drop 2" should "retain only the last element when the list has three elements" in {
    assert(drop(List(1, 2, 3), 2) === List(3))
  }

  "drop n" should "remove all elements when the list has size n" in {
    assert(drop(List(1, 2, 3), 3) === Nil)
  }

  "drop n+1" should "remove all elements when the list has size n" in {
    assert(drop(List(1, 2, 3), 3) === Nil)
  }

  "drop 0" should "return the empty list when the list is empty" in {
    assert(drop(Nil, 0) === Nil)
  }

  "drop 1" should "return the empty list when the list is empty" in {
    assert(drop(Nil, 1) === Nil)
  }
}
