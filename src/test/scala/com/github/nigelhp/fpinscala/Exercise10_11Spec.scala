package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise10_11.wordCount
import org.scalatest.FlatSpec

class Exercise10_11Spec extends FlatSpec {
  "wordCount" should "return 0 for the empty string" in {
    assert(wordCount("") === 0)
  }

  it should "return 1 for 'a'" in {
    assert(wordCount("a") === 1)
  }

  it should "return 1 for 'abc'" in {
    assert(wordCount("abc") === 1)
  }

  it should "return 1 for 'a,'" in {
    assert(wordCount("a,") === 1)
  }

  it should "return 2 for 'a,b'" in {
    assert(wordCount("a,b") === 1)
  }

  it should "return 5 for 'lorem ipsum dolor sit amet, '" in {
    assert(wordCount("lorem ipsum dolor sit amet, ") === 5)
  }

  it should "return 9 for 'The quick brown fox jumps over the lazy dog'" in {
    assert(wordCount("The quick brown fox jumps over the lazy dog") === 9)
  }
}