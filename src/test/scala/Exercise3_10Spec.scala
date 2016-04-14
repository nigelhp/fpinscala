import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_10.foldLeft

class Exercise3_10Spec extends FlatSpec {

  private val nil: List[Int] = Nil

  "foldLeft" should "return the seed value when the input list is empty" in {
    assert(foldLeft(nil, 10)((acc, i) => 666) === 10)
  }

  it should "combine the seed value with the elements of the input list" in {
    assert(foldLeft(List(1), 10)(_ + _) === 11)
  }

  it should "support calculating the sum of all the elements of the input list" in {
    assert(foldLeft(nil, 0)(_ + _) === 0)
    assert(foldLeft(List(1, 2, 3, 4, 5), 0)(_ + _) === 15)
  }

  it should "support calculating the product of all the elements of the input list" in {
    assert(foldLeft(nil, 1)(_ * _) === 1)
    assert(foldLeft(List(1, 2, 3, 4, 5), 1)(_ * _) === 120)
  }

  it should "traverse from left to right" in {
    assert(foldLeft(List(1), 10)(_ - _) === 9)
    assert(foldLeft(List(1, 2, 3, 4, 5), 0)(_ - _) === -15)

    assert(foldLeft(List(2, 3, 4), ("", 1))((acc, i) => {(acc._1 + s"(${acc._2}+$i)", acc._2 + i)}) ===
      ("(1+2)(3+3)(6+4)", 10))
  }
}
