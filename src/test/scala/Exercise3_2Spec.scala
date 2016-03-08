import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_2.tail

class Exercise3_2Spec extends FlatSpec {

  "a list" should "return all but the first element of a list when asked for the tail" in {
    assert(tail(List(1, 2, 3, 4, 5)) === List(2, 3, 4, 5))
  }

  "it" should "return Nil when asked for the tail of a Nil list" in {
    assert(tail(Nil) === Nil)
  }
}
