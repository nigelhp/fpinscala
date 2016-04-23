import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_15.concatenate

class Exercise3_15Spec extends FlatSpec {

  "concatenate" should "return the empty list when the input list is empty" in {
    assert(concatenate(Nil) === Nil)
  }

  it should "return the empty list when the input list contains only empty lists" in {
    assert(concatenate(List(Nil, Nil)) === Nil)
  }

  it should "return the child list when the input list contains one non-empty list" in {
    assert(concatenate(List(List(1))) === List(1))
  }

  it should "return the child non-empty list when the input list contains one non-empty and one empty list" in {
    assert(concatenate(List(List(1), Nil)) === List(1))
  }

  it should "return a list of two elements when the input list contains two lists of one element" in {
    assert(concatenate(List(List(1), List(2))) === List(1, 2))
  }

  it should "return all elements in the first child list followed by all elements in the second child list" in {
    assert(concatenate(List(List(1, 2), List(3, 4))) === List(1, 2, 3, 4))
  }

  it should "concatenate all elements of the child lists" in {
    assert(concatenate(List(List(1), Nil, List(2, 3), Nil, List(4, 5, 6))) === List(1, 2, 3, 4, 5, 6))
  }
}
