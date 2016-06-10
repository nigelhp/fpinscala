package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import exercise4_1.{Some, None}
import Exercise4_5._

class Exercise4_5Spec extends FlatSpec {

  "traverse1" should "return Some(Nil) when the input list is Nil" in {
    assert(traverse1(Nil) { _ => Some(42) } === Some(Nil))
  }

  it should "return Some(List(f(x))) when f(x) returns Some" in {
    assert(traverse1(List(42)) { n => Some(n.toString) } === Some(List("42")))
  }

  it should "return None when f(x) returns None" in {
    assert(traverse1(List(42)) { _ => None } === None)
  }

  it should "return Some(List(f(x), f(y))) when f(x) and f(y) return Some" in {
    assert(traverse1(List(42, 666)) { n => Some(n.toString) } === Some(List("42", "666")))
  }

  it should "return None when f(x) returns Some but f(y) returns None" in {
    assert(traverse1(List(42, -42)) { n => if (n.signum > 0) Some(n.toString) else None } === None)
  }

  "traverse2" should "return Some(Nil) when the input list is Nil" in {
    assert(traverse2(Nil) { _ => Some(42) } === Some(Nil))
  }

  it should "return Some(List(f(x))) when f(x) returns Some" in {
    assert(traverse2(List(42)) { n => Some(n.toString) } === Some(List("42")))
  }

  it should "return None when f(x) returns None" in {
    assert(traverse2(List(42)) { _ => None } === None)
  }

  it should "return Some(List(f(x), f(y))) when f(x) and f(y) return Some" in {
    assert(traverse2(List(42, 666)) { n => Some(n.toString) } === Some(List("42", "666")))
  }

  it should "return None when f(x) returns Some but f(y) returns None" in {
    assert(traverse2(List(42, -42)) { n => if (n.signum > 0) Some(n.toString) else None } === None)
  }

  "traverse3" should "return Some(Nil) when the input list is Nil" in {
    assert(traverse3(Nil) { _ => Some(42) } === Some(Nil))
  }

  it should "return Some(List(f(x))) when f(x) returns Some" in {
    assert(traverse3(List(42)) { n => Some(n.toString) } === Some(List("42")))
  }

  it should "return None when f(x) returns None" in {
    assert(traverse3(List(42)) { _ => None } === None)
  }

  it should "return Some(List(f(x), f(y))) when f(x) and f(y) return Some" in {
    assert(traverse3(List(42, 666)) { n => Some(n.toString) } === Some(List("42", "666")))
  }

  it should "return None when f(x) returns Some but f(y) returns None" in {
    assert(traverse3(List(42, -42)) { n => if (n.signum > 0) Some(n.toString) else None } === None)
  }

  "sequenceViaTraverse" should "return Some(Nil) when the input list is Nil" in {
    assert(sequenceViaTraverse(Nil) === Some(Nil))
  }

  it should "return Some(List(x)) when the input list is List(Some(x))" in {
    assert(sequenceViaTraverse(List(Some(42))) === Some(List(42)))
  }

  it should "return None when the input list is List(None)" in {
    assert(sequenceViaTraverse(List(None)) === None)
  }

  it should "return Some(List(x, y)) when the input list is List(Some(x), Some(y))" in {
    assert(sequenceViaTraverse(List(Some(42), Some(666))) === Some(List(42, 666)))
  }

  it should "return None when the input list is List(Some(x), None, Some(y))" in {
    assert(sequenceViaTraverse(List(Some(42), None, Some(666))) === None)
  }
}
