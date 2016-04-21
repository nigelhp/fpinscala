import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_14.append

class Exercise3_14Spec extends FlatSpec {

  "append" should "return an empty list when both lists are empty" in {
    assert(append(Nil, Nil) === Nil)
  }

  it should "return the first list when the second list is empty" in {
    assert(append(List(1, 2, 3), Nil) === List(1, 2, 3))
  }

  it should "return the second list when the fist list is empty" in {
    assert(append(Nil, List(4, 5, 6)) === List(4, 5, 6))
  }

  it should "return the second list appended to the first list" in {
    assert(append(List(1, 2, 3), List(4, 5, 6)) === List(1, 2, 3, 4, 5, 6))
  }
}
