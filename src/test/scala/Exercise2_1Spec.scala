import Exercise2_1.fib
import org.scalatest.FlatSpec

class Exercise2_1Spec extends FlatSpec {

  "Fibonacci(0)" should "be 0" in {
    assert(fib(0) === 0)
  }

  "Fibonacci(1)" should "be 1" in {
    assert(fib(1) === 1)
  }

  "Fibonacci(2)" should "be 1" in {
    assert(fib(2) === 1)
  }

  "Fibonacci(3)" should "be 2" in {
    assert(fib(3) === 2)
  }

  "Fibonacci(4)" should "be 3" in {
    assert(fib(4) === 3)
  }

  "Fibonacci(5)" should "be 5" in {
    assert(fib(5) === 5)
  }
}
