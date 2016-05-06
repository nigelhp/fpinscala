import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_24.hasSubsequence

class Exercise3_24Spec extends FlatSpec {

  "hasSubsequence" should "return false when the super-sequence is empty" in {
    assert(!hasSubsequence(Nil, List(1)))
  }

  it should "return false when the sub-sequence is empty" in {
    assert(!hasSubsequence(List(1), Nil))
  }

  it should "return false when the sub-sequence is longer than the super-sequence" in {
    assert(!hasSubsequence(List(1), List(1, 2)))
  }

  it should "return false when there is no intersection between the sequences" in {
    assert(!hasSubsequence(List(1), List(2)))
  }

  it should "return false when the sub-sequence partially matches the super-sequence" in {
    assert(!hasSubsequence(List(1, 2, 3), List(1, 2, 9)))
    assert(!hasSubsequence(List(1, 2, 3), List(1, 3, 3)))
    assert(!hasSubsequence(List(1, 2, 3), List(1, 3)))
  }

  it should "return false when the sub-sequence has matching values but in a different order" in {
    assert(!hasSubsequence(List(1, 2, 3), List(1, 3, 2)))
  }

  it should "return true when the second list is a sub-sequence of the first" in {
    assert(hasSubsequence(List(1, 2, 3), List(1)))
    assert(hasSubsequence(List(1, 2, 3), List(2)))
    assert(hasSubsequence(List(1, 2, 3), List(3)))
    assert(hasSubsequence(List(1, 2, 3), List(1, 2)))
    assert(hasSubsequence(List(1, 2, 3), List(2, 3)))
    assert(hasSubsequence(List(1, 2, 3), List(1, 2, 3)))
  }

  it should "return true when the second list is a partial sub-sequence and then a full sub-sequence of the first" in {
    assert(hasSubsequence(List(1, 1, 2), List(1, 2)))
    assert(hasSubsequence(List(1, 2, 1, 2, 3), List(1, 2, 3)))
    assert(hasSubsequence(List(1, 2, 1, 1, 2, 3), List(1, 2, 3)))
  }
}
