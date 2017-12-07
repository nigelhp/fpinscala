package com.github.nigelhp.fpinscala

import fpinscala.monoids.{Monoid, Part, Stub, WC}

/*
 * Exercise 10.10
 * Write a monoid instance for WC and make sure that it meets the monoid laws.
 *   val wcMonoid: Monoid[WC]
 */
object Exercise10_10 {
  val wcMonoid = new Monoid[WC] {
    override def op(l: WC, r: WC): WC =
      (l, r) match {
        // identity law dictates that op(zero, stub) and op(stub, zero) -> stub
        case (Stub(lchars), Stub(rchars)) =>
          Stub(lchars ++ rchars)
        // identity law dictates that op(zero, part) -> part
        case (Stub(chars), Part(lstub, count, rstub)) =>
          Part(chars ++ lstub, count, rstub)
        // identity law dictates that op(part, zero) -> part
        case (Part(lstub, count, rstub), Stub(chars)) =>
          Part(lstub, count, rstub ++ chars)
        case (Part(llstub, lcount, lrstub), Part(rlstub, rcount, rrstub)) if (lrstub ++ rlstub).isEmpty =>
          Part(llstub, lcount + rcount, rrstub)
        case (Part(llstub, lcount, lrstub), Part(rlstub, rcount, rrstub)) =>
          Part(llstub, lcount + 1 + rcount, rrstub)
      }

    /*
     * 2 options here:
     * - Stub("")
     * - Part("", 0, "")
     */
    override def zero: WC = Stub("")
  }
}