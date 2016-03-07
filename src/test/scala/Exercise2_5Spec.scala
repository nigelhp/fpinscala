import Exercise2_5.compose
import org.scalatest.FlatSpec

class Exercise2_5Spec extends FlatSpec {

  "compose" should "compose two functions" in {
    val f = compose((b: Int) => b.toString, (a: Int) => a * 10)

    assert(f(1) === "10")
    assert(f(2) === "20")
  }
}
