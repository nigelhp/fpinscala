package com.github.nigelhp.fpinscala

import fpinscala.datastructures._

/*
 * Exercise 3.3
 * Using the same idea, implement the function setHead for replacing the first
 * element of a List with a different value.
 */
object Exercise3_3 {

  def setHead[A](head: A, list: List[A]): List[A] = list match {
    case Nil => Nil
    case Cons(_, t) => Cons(head, t)  
  }
}
