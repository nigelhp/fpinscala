package com.github.nigelhp.fpinscala


/*
 * Exercise 8.3
 * Assuming the following representation of Prop, implement && as a method of Prop.
 *   trait Prop { def check: Boolean }
 */
object Exercise8_3 {
  trait Prop {
    def check: Boolean
    def &&(p: Prop): Prop =
      new Prop {
        override def check: Boolean =
          Prop.this.check && p.check
      }
  }
}
