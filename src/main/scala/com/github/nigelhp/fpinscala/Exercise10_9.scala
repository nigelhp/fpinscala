package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise10_7.foldMap
import fpinscala.monoids.Monoid

/*
 * Exercise 10.9
 * Use foldMap to detect whether a given IndexedSeq[Int] is ordered.
 */
object Exercise10_9 {

  /* A simple approach using standard types.
   * This implementation only supports ascending order.
   *
   * Left(msg) -> not ordered ascending (msg gives failing example)
   * Right(None) -> identity value (IndexedSeq is empty)
   * Right(Some(x)) -> ordered ascending (x is max / last value)
   */
  private val mIntAscending = new Monoid[Either[String, Option[Int]]] {
    override def op(a: Either[String, Option[Int]],
                    b: Either[String, Option[Int]]): Either[String, Option[Int]] =
      (a, b) match {
        case (Left(sa), _) => Left(sa)
        case (_, Left(sb)) => Left(sb)
        case (Right(None), Right(None)) => Right(None)
        case (Right(None), Right(Some(ib))) => Right(Some(ib))
        case (Right(Some(ia)), Right(None)) => Right(Some(ia))
        case (Right(Some(ia)), Right(Some(ib))) if ia <= ib => Right(Some(ib))
        case (Right(Some(ia)), Right(Some(ib))) => Left(s"[$ia] is not <= [$ib]")
      }

    override def zero: Either[String, Option[Int]] = Right(None)
  }

  def isOrderedAscending(iseq: IndexedSeq[Int]): Boolean = {
    val errorOrMaxInt = foldMap(iseq, mIntAscending)(i => Right(Some(i)))
    errorOrMaxInt.isRight
  }


  /*
   * An attempt to support both ascending & descending order.
   * Uses a custom ADT in the hope that this provides more clarity.
   */
  private sealed trait OrderingResult
  private case object Empty extends OrderingResult
  private case object Unordered extends OrderingResult
  private case class Equal(value: Int) extends OrderingResult
  private case class OrderedAscending(min: Int, max: Int) extends OrderingResult
  private case class OrderedDescending(max: Int, min: Int) extends OrderingResult

  private val mOrdered = new Monoid[OrderingResult] {
    override def op(a: OrderingResult, b: OrderingResult): OrderingResult =
      (a, b) match {
        case (Empty, other) => other
        case (other, Empty) => other
        case (Equal(x), Equal(y)) if x == y => Equal(y)
        case (Equal(x), Equal(y)) if x < y => OrderedAscending(x, y)
        case (Equal(x), Equal(y)) if x > y => OrderedDescending(x, y)
        case (Equal(x), OrderedAscending(min, max)) if x <= min => OrderedAscending(x, max)
        case (OrderedAscending(min, max), Equal(x)) if max <= x => OrderedAscending(min, x)
        case (Equal(x), OrderedDescending(max, min)) if x >= max => OrderedDescending(x, min)
        case (OrderedDescending(max, min), Equal(x)) if min >= x => OrderedDescending(max, x)
        case (OrderedAscending(lmin, lmax), OrderedAscending(rmin, rmax)) if lmax <= rmin => OrderedAscending(lmin, rmax)
        case (OrderedDescending(lmax, lmin), OrderedDescending(rmax, rmin)) if lmin >= rmax => OrderedDescending(lmax, rmin)
        case (_, _) => Unordered
      }

    override def zero: OrderingResult = Empty
  }

  def isOrdered(iseq: IndexedSeq[Int]): Boolean = {
    foldMap(iseq, mOrdered)(Equal) match {
      case Unordered => false
      case _ => true
    }
  }
}