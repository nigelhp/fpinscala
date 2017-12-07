package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise10_10.wcMonoid
import fpinscala.monoids.{Part, Stub}
import org.scalatest.FlatSpec

class Exercise10_10Spec extends FlatSpec {

  "A WC Monoid" should "return the original Stub when it is combined with zero" in {
    val stub = Stub("hello")

    assert(wcMonoid.op(stub, wcMonoid.zero) === stub)
    assert(wcMonoid.op(wcMonoid.zero, stub) === stub)
  }

  it should "return the original Part when it is combined with zero" in {
    val part = Part("ab", 2, "yz")

    assert(wcMonoid.op(part, wcMonoid.zero) === part)
    assert(wcMonoid.op(wcMonoid.zero, part) === part)
  }

  it should "have an associative operation for stubs" in {
    val foo = Stub("foo")
    val bar = Stub("bar")
    val baz = Stub("baz")

    assert(wcMonoid.op(foo, wcMonoid.op(bar, baz)) === wcMonoid.op(wcMonoid.op(foo, bar), baz))
  }

  it should "have an associative operation for parts" in {
    val part1 = Part("ab", 1, "cd")
    val part2 = Part("ef", 2, "gh")
    val part3 = Part("ij", 3, "kl")

    assert(wcMonoid.op(part1, wcMonoid.op(part2, part3)) === wcMonoid.op(wcMonoid.op(part1, part2), part3))
  }

  it should "have an associative operation for a mix of stubs and parts" in {
    val stub1 = Stub("foo")
    val part = Part("ef", 2, "gh")
    val stub2 = Stub("bar")

    assert(wcMonoid.op(stub1, wcMonoid.op(part, stub2)) === wcMonoid.op(wcMonoid.op(stub1, part), stub2))
  }
}