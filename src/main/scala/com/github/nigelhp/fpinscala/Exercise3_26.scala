package com.github.nigelhp.fpinscala

import fpinscala.datastructures._

/*
 * Exercise 3.26
 * Write a function maximum that returns the maximum element in a Tree[Int].
 * (Note: In Scala, you can use x.max(y) or x max y to compute the maximum of 
 * two integers x and y.)
 */
object Exercise3_26 {

  def maximum(tree: Tree[Int]): Int = tree match {
    case Leaf(i) => i
    case Branch(l, r) => maximum(l).max(maximum(r))
  }
}
