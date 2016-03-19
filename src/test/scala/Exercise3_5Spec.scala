import Exercise3_5.dropWhile
import org.scalatest.FlatSpec

import fpinscala.datastructures._

class Exercise3_5Spec extends FlatSpec {

  "dropWhile" should "return an empty list when the input list is empty" in {
    assert(dropWhile[Int](Nil, {_ => true}) === Nil)
    assert(dropWhile[Int](Nil, {_ => false}) === Nil)
  }

  it should "return an empty list if the predicate returns true for all list elements" in {
    assert(dropWhile[Int](List(1, 2, 3), {_ => true}) === Nil)
  }

  it should "return the original list if the predicate returns false for the first list element" in {
    assert(dropWhile[Int](List(1, 2, 3), {i => i != 1}) === List(1, 2, 3))
  }

  it should "return the tail of the original list if the predicate returns false for the second list element" in {
    assert(dropWhile[Int](List(1, 2, 3), {i => i == 1}) === List(2, 3))
  }

  it should "return only the last item of the list if the predicate returns false for the last list element" in {
    assert(dropWhile[Int](List(1, 2, 3), {i => i < 3}) === List(3))
  }
}