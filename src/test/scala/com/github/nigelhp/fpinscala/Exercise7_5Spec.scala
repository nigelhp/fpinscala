package com.github.nigelhp.fpinscala

import java.util
import java.util.concurrent._

import com.github.nigelhp.fpinscala.Exercise7_5.sequence
import fpinscala.parallelism.Par
import org.scalatest.FlatSpec

class Exercise7_5Spec extends FlatSpec {

  private trait Fixture {
    // simplify testing by running tasks in the submission thread
    val es = new AbstractExecutorService {
      override def isTerminated: Boolean = false
      override def awaitTermination(l: Long, timeUnit: TimeUnit): Boolean = false
      override def shutdownNow(): util.List[Runnable] = new util.ArrayList[Runnable]()
      override def shutdown(): Unit = ()
      override def isShutdown: Boolean = false
      override def execute(runnable: Runnable): Unit = runnable.run()
    }
  }

  "sequence" should "convert a sequence of parallel tasks into a parallel task that returns a sequence of results" in new Fixture {
    val tasks = List(Par.unit(1), Par.unit(2), Par.unit(3))
    val s = sequence(tasks)

    assert(s(es).get === List(1, 2, 3))
  }
}
