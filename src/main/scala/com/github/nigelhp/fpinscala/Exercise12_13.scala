package com.github.nigelhp.fpinscala

import fpinscala.applicative.{Applicative, Traverse}

import scala.language.higherKinds

/*
 * Exercise 12.13
 * Write Traverse instances for List, Option, and Tree.
 *   case class Tree[+A](head: A, tail: List[Tree[A]])
 */
object Exercise12_13 {
  val listTraverse = new Traverse[List] {
    override def traverse[G[_]:Applicative, A, B](as: List[A])(f: A => G[B]): G[List[B]] = {
      val g = implicitly[Applicative[G]]
      as.foldRight(g.unit(List.empty[B])) { (a, gbs) =>
        g.map2(f(a), gbs)(_ :: _)
      }
    }
  }

  val optionTraverse = new Traverse[Option] {
    override def traverse[G[_]:Applicative, A, B](aOpt: Option[A])(f: A => G[B]): G[Option[B]] = {
      val g = implicitly[Applicative[G]]
      aOpt.fold(g.unit(None: Option[B])) { a =>
        g.map(f(a))(Some(_))
      }
    }
  }

  case class Tree[+A](head: A, tail: List[Tree[A]])

  val treeTraverse = new Traverse[Tree] {
    override def traverse[G[_]:Applicative, A, B](tree: Tree[A])(f: A => G[B]): G[Tree[B]] = {
      val g = implicitly[Applicative[G]]

      val gHead = f(tree.head)
      val gTail = listTraverse.traverse(tree.tail)(traverse(_)(f))
      g.map2(gHead, gTail)(Tree(_, _))
    }
  }
}
