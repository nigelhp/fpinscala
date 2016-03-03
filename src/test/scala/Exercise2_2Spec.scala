import org.scalatest.FlatSpec

import Exercise2_2.isSorted

class Exercise2_2Spec extends FlatSpec {

  "isSorted" should "return true when the array is empty" in {
    assert(isSorted(Array.empty[Int], (x: Int, y: Int) => false))
  }

  it should "return true when the array contains a single value" in {
    assert(isSorted(Array(1), (x: Int, y: Int) => false))
  }

  "isSorted ascending" should "return true when the array contains two ascending values" in {
    assert(isSorted(Array(1, 2), (x: Int, y: Int) => x <= y))
  }

  it should "return true when the array contains two equal values" in {
    assert(isSorted(Array(1, 1), (x: Int, y: Int) => x <= y))
  }

  it should "return false when the array contains two descending values" in {
    assert(!isSorted(Array(2, 1), (x: Int, y: Int) => x <= y))
  }

  it should "return true when the array contains all ascending values" in {
    assert(isSorted(Array(1, 2, 3), (x: Int, y: Int) => x <= y))
  }

  it should "return true when the array contains all equal values" in {
    assert(isSorted(Array(1, 1, 1), (x: Int, y: Int) => x <= y))
  }

  it should "return false when the array is not sorted in ascending order" in {
    assert(!isSorted(Array(1, 2, 1), (x: Int, y: Int) => x <= y))
  }

  "isSorted descending" should "return true when the array contains two descending values" in {
    assert(isSorted(Array(2, 1), (x: Int, y: Int) => x >= y))
  }

  it should "return true when the array contains two equal values" in {
    assert(isSorted(Array(1, 1), (x: Int, y: Int) => x >= y))
  }

  it should "return false when the array contains two ascending values" in {
    assert(!isSorted(Array(1, 2), (x: Int, y: Int) => x >= y))
  }

  it should "return true when the array contains all descending values" in {
    assert(isSorted(Array(3, 2, 1), (x: Int, y: Int) => x >= y))
  }

  it should "return true when the array contains all equal values" in {
    assert(isSorted(Array(1, 1, 1), (x: Int, y: Int) => x >= y))
  }

  it should "return false when the array is not sorted in descending order" in {
    assert(!isSorted(Array(3, 2, 3), (x: Int, y: Int) => x >= y))
  }
}
