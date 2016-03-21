import org.scalatest.FlatSpec

import Exercise3_6._
import fpinscala.datastructures._

class Exercise3_6Spec extends FlatSpec {

  "init" should "return the empty list when the input list is empty" in {
    assert(init(Nil) === Nil)
  }

  it should "return the empty list when the input list contains only one element" in {
    assert(init(List(1)) === Nil)
  }

  it should "return only the head element when the input list contains two elements" in {
    assert(init(List(1, 2)) === List(1))
  }

  it should "return only the first two elements when the input list contains three elements" in {
    assert(init(List(1, 2, 3)) == List(1, 2))
  }

  it should "return all but the last element when the input list contains many elements" in {
    assert(init(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4))
  }
}
