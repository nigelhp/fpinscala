import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_3.setHead

class Exercise3_3Spec extends FlatSpec {

  "setHead" should "change the head of an existing list" in {
    assert(setHead(9, List(1, 2, 3)) === List(9, 2, 3))
    assert(setHead(9, List(1)) === List(9))
  }

  it should "not replace the first element of an empty list" in {
    assert(setHead(9, Nil) === Nil)
  }
}
