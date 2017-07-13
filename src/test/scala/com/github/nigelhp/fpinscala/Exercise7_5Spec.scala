package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise7_5.sequence
import fpinscala.parallelism.Par

class Exercise7_5Spec extends ParallelFixture {
  "sequence" should "convert a sequence of parallel tasks into a parallel task that returns a sequence of results" in { es =>
    val tasks = List(Par.unit(1), Par.unit(2), Par.unit(3))
    val s = sequence(tasks)

    assert(s(es).get === List(1, 2, 3))
  }
}
