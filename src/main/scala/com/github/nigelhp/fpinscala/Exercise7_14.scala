package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise7_13.{chooser => flatMap}
import fpinscala.parallelism.Par
import fpinscala.parallelism.Par.Par

/*
 * Exercise 7.14
 * Implement join.
 * Can you see how to implement flatMap using join?  And can you implement join using flatMap?
 */
object Exercise7_14 {
  def join[A](a: Par[Par[A]]): Par[A] =
    s => {
      val parA = Par.run(s)(a).get()
      Par.run(s)(parA)
    }

  def flatMapUsingJoin[A,B](pa: Par[A])(choices: A => Par[B]): Par[B] = {
    val parParB = Par.map(pa)(choices(_))
    join(parParB)
  }

  def joinUsingFlatMap[A](a: Par[Par[A]]): Par[A] =
    flatMap(a)(identity)
}
