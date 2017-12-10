package com.github.nigelhp.fpinscala

import fpinscala.datastructures.{Branch, Leaf, Tree}
import fpinscala.monoids.{Foldable, Monoid}

/*
 * Recall the binary Tree data type from chapter 3.
 * Implement a Foldable instance for it.
 *
 *   sealed trait Tree[+A]
 *   case class Leaf[A](value: A) extends Tree[A]
 *   case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
 */
object Exercise10_13 {
  val foldableTree = new Foldable[Tree] {
    override def foldRight[A, B](as: Tree[A])(z: B)(f: (A, B) => B): B =
      as match {
        case Leaf(a) => f(a, z)
        case Branch(l, r) =>
          val rb = foldRight(r)(z)(f)
          foldRight(l)(rb)(f)
      }

    override def foldLeft[A, B](as: Tree[A])(z: B)(f: (B, A) => B): B =
      as match {
        case Leaf(a) => f(z, a)
        case Branch(l, r) =>
          val lb = foldLeft(l)(z)(f)
          foldLeft(r)(lb)(f)
      }

    override def foldMap[A, B](as: Tree[A])(f: A => B)(mb: Monoid[B]): B =
      as match {
        case Leaf(a) => f(a)
        case Branch(l, r) => mb.op(foldMap(l)(f)(mb), foldMap(r)(f)(mb))
      }
  }
}