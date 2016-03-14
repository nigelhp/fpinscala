import Exercise3_4.drop
import org.scalatest.FlatSpec

class Exercise3_4Spec extends FlatSpec {

  "drop 0" should "leave a non-empty list intact" in {
    assert(drop(List(1, 2, 3), 0) === List(1, 2, 3))
  }

  "drop 1" should "remove the head from a non-empty list" in {
    assert(drop(List(1, 2, 3), 1) === List(2, 3))
  }

  "drop 2" should "retain only the last element from a three element list" in {
    assert(drop(List(1, 2, 3), 2) === List(3))
  }

  "drop n" should "remove all elements from a list of size n" in {
    assert(drop(List(1, 2, 3), 3) === Nil)
  }

  "drop n+1" should "throw an exception when the list has size n" in {
    intercept [UnsupportedOperationException] {
      drop(List(1, 2, 3), 4)
    }
  }

  "drop 0" should "leave an empty list intact" in {
    assert(drop(Nil, 0) == Nil)
  }

  "drop 1" should "throw an exception when the list is empty" in {
    intercept [UnsupportedOperationException] {
      drop(Nil, 1)
    }
  }
}
