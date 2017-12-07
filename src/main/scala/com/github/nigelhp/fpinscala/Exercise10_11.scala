package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise10_10.wcMonoid
import com.github.nigelhp.fpinscala.Exercise10_7.foldMap
import fpinscala.monoids.{Part, Stub, WC}

/*
 * Exercise 10.11
 * Use the WC monoid to implement a function that counts words in a String by recursively
 * splitting it into substrings and counting the words in those substrings.
 */
object Exercise10_11 {
  def wordCount(s: String): Int =
    wcCount(foldMap(s.toIndexedSeq, wcMonoid) { c =>
      if (c.isWhitespace) Part("", 0, "") else Stub(c.toString)
    })

  private def wcCount(wc: WC): Int =
    wc match {
      case Stub(chars) =>
        stubWordCount(chars)
      case Part(lstub, count, rstub) =>
        stubWordCount(lstub) + count + stubWordCount(rstub)
    }

  private def stubWordCount(stub: String): Int =
    if (stub.isEmpty) 0 else 1
}