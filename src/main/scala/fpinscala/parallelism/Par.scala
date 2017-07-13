package fpinscala.parallelism

import java.util.concurrent.{Callable, ExecutorService, Future, TimeUnit}

object Par {
  type Par[A] = ExecutorService => Future[A]

  private case class UnitFuture[A](get: A) extends Future[A] {
    override def isDone = true
    override def isCancelled: Boolean = false
    override def cancel(evenIfRunning: Boolean): Boolean = false
    override def get(timeout: Long, timeUnit: TimeUnit): A = get
  }

  def unit[A](a: A): Par[A] =
    (_: ExecutorService) => UnitFuture(a)

  def map2[A,B,C](a: Par[A], b: Par[B])(f: (A,B) => C): Par[C] =
    (es: ExecutorService) => {
      val af = a(es)
      val bf = b(es)
      UnitFuture(f(af.get, bf.get))
    }

  def map[A,B](pa: Par[A])(f: A => B): Par[B] =
    map2(pa, unit(())) { (a, _) =>
      f(a)
    }

  def fork[A](a: => Par[A]): Par[A] =
    es => es.submit(new Callable[A] {
      override def call(): A =
        a(es).get
    })

  def lazyUnit[A](a: => A): Par[A] =
    fork(unit(a))
}
