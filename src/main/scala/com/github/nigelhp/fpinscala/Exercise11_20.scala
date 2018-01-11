package com.github.nigelhp.fpinscala

import fpinscala.monads.Monad

/*
 * Exercise 11.20
 */
object Exercise11_20 {
  case class Reader[R, A](run: R => A)

  object Reader {
    def readerMonad[R] = new Monad[({type f[x] = Reader[R, x]})#f] {
      override def unit[A](a: => A): Reader[R, A] = Reader(_ => a)
      override def flatMap[A, B](fa: Reader[R, A])(f: A => Reader[R, B]): Reader[R, B] =
        Reader(r => {
          val fb = f(fa.run(r))
          fb.run(r)
        })
    }
  }
}
