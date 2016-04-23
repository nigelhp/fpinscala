import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_16.increment

class Exercise3_16Spec extends FlatSpec {

  "increment" should "return the empty list when the input list is empty" in {
    assert(increment(Nil: List[Int]) === Nil)
  }

  it should "increment the value of a single element list by one" in {
    assert(increment(List(-1)) === List(0))
    assert(increment(List(1)) === List(2))
  }

  it should "increment all values in multiple element list by one" in {
    assert(increment(List(1, 2, 3)) === List(2, 3, 4))
  }
}
