package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_11._
import org.scalatest.{FreeSpec, Matchers}

class Exercise6_11Spec extends FreeSpec with Matchers {

  private trait Fixture {
    def buy(candies: Int = 1): List[Input] =
      List.fill(candies)(Seq(Coin, Turn)).flatten
  }

  "A candy dispenser" - {
    "when empty" - {
      "does nothing when a coin is inserted" in {
        val machineBefore = Machine(locked = true, candies = 0, coins = 1)

        val (_, machineAfter) = simulateMachine(List(Coin)).run(machineBefore)

        machineAfter shouldBe machineBefore
      }

      "does nothing when the knob is turned" in {
        val machineBefore = Machine(locked = true, candies = 0, coins = 1)

        val (_, machineAfter) = simulateMachine(List(Turn)).run(machineBefore)

        machineAfter shouldBe machineBefore
      }
    }

    "when locked (and not empty)" - {
      "is unlocked when a coin is inserted" in {
        val machineBefore = Machine(locked = true, candies = 1, coins = 1)

        val (_, machineAfter) = simulateMachine(List(Coin)).run(machineBefore)

        machineAfter shouldBe Machine(locked = false, candies = 1, coins = 2)
      }

      "does nothing when the knob is turned" in {
        val machineBefore = Machine(locked = true, candies = 1, coins = 1)

        val (_, machineAfter) = simulateMachine(List(Turn)).run(machineBefore)

        machineAfter shouldBe machineBefore
      }
    }

    "when unlocked" - {
      "does nothing when a coin is inserted" in {
        val machineBefore = Machine(locked = false, candies = 1, coins = 1)

        val (_, machineAfter) = simulateMachine(List(Coin)).run(machineBefore)

        machineAfter shouldBe machineBefore
      }

      "dispenses candy and becomes locked when the knob is turned" in {
        val machineBefore = Machine(locked = false, candies = 1, coins = 1)

        val (_, machineAfter) = simulateMachine(List(Turn)).run(machineBefore)

        machineAfter shouldBe Machine(locked = true, candies = 0, coins = 1)
      }
    }
  }

  "accepts multiple inputs in turn" in new Fixture {
    val machineBefore = Machine(locked = true, candies = 5, coins = 10)

    val (contents, machineAfter) = simulateMachine(buy(4)).run(machineBefore)

    machineAfter shouldBe Machine(locked = true, candies = 1, coins = 14)
    withClue("coins"){ contents._1 shouldBe 14 }
    withClue("candies") { contents._2 shouldBe 1 }
  }
  
  "does nothing when there are no inputs" in new Fixture {
    val machineBefore = Machine(locked = true, candies = 5, coins = 10)

    val (contents, machineAfter) = simulateMachine(buy(0)).run(machineBefore)

    machineAfter shouldBe Machine(locked = true, candies = 5, coins = 10)
    withClue("coins"){ contents._1 shouldBe 10 }
    withClue("candies") { contents._2 shouldBe 5 }
  }
}