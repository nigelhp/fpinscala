import org.scalatest.FlatSpec

import scala.{Option => _}

class Exercise4_1Spec extends FlatSpec {

  "map" should "return None when invoked on a None" in {
    val option: Option[Int] = None

    assert(option.map(i => i * i) === None)
  }

  it should "return the result of the supplied function as a Some when invoked on a Some" in {
    assert(Some(42).map(i => i * i) === Some(1764))
  }

  "flatMap" should "return None when invoked on a None" in {
    val option: Option[Int] = None

    assert(option.flatMap(_ => Some(42)) === None)
  }

  it should "return the result of the supplied function when invoked on a Some" in {
    assert(Some(42).flatMap(_ => Some(666)) === Some(666))
    assert(Some(42).flatMap(_ => None) === None)
  }

  "getOrElse" should "return the else value when invoked on a None" in {
    assert(None.getOrElse(666) === 666)
  }

  it should "return the contained value when invoked on a Some" in {
    assert(Some(42).getOrElse(666) === 42)
  }

  "orElse" should "return the else Option when invoked on a None" in {
    assert(None.orElse(Some(42)) === Some(42))
  }

  it should "return the original Option when invoked on a Some" in {
    assert(Some(42).orElse(Some(666)) === Some(42))
  }

  "filter" should "return None when invoked on a None" in {
    assert(None.filter(_ => true) === None)
    assert(None.filter(_ => false) === None)
  }

  it should "return None when invoked on a Some with a successful predicate" in {
    assert(Some(42).filter(i => i < 0) === None)
  }

  it should "return the original Option when invoked on a Some with an unsuccessful predicate" in {
    assert(Some(42).filter(i => i > 0) === Some(42))
  }
}
