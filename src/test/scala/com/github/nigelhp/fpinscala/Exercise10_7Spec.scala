package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise10_1.intAddition
import com.github.nigelhp.fpinscala.Exercise10_7.foldMap
import org.scalatest.FlatSpec

class Exercise10_7Spec extends FlatSpec {
  "foldMap for indexedSeq" should "return the empty value when the indexed seq is empty" in {
    assert(foldMap(IndexedSeq.empty[String], intAddition)(_.toInt) === 0)
  }

  it should "return the mapped value when the indexed seq contains a single element" in {
    assert(foldMap(IndexedSeq("1"), intAddition)(_.toInt) === 1)
  }

  it should "return the result of combining the mapped values when the indexed seq contains two elements" in {
    assert(foldMap(IndexedSeq("1", "2"), intAddition)(_.toInt) === 3)
  }

  it should "return the result of combining the mapped values when the indexed seq contains more than two elements" in {
    assert(foldMap(IndexedSeq("1", "2", "3", "4", "5"), intAddition)(_.toInt) === 15)
  }
}