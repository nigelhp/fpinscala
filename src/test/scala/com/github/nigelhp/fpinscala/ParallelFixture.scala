package com.github.nigelhp.fpinscala

import java.util.concurrent.{ExecutorService, Executors}

import org.scalatest.{Outcome, fixture}

class ParallelFixture extends fixture.FlatSpec {

  override type FixtureParam = ExecutorService

  override protected def withFixture(test: OneArgTest): Outcome = {
    /*
     * Note that tests will likely deadlock if a fixed size pool is used, given the initial implementation of Par.
     */
    val fixture = Executors.newCachedThreadPool()
    try withFixture(test.toNoArgTest(fixture))
    finally fixture.shutdownNow()
  }
}
