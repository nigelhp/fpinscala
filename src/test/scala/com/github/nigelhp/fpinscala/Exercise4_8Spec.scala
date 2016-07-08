package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import Exercise4_8.map2
import exercise4_6._


private case class Person(name: Name, age: Age)
private sealed class Name(val value: String)
private sealed class Age(val value: Int)


class Exercise4_8Spec extends FlatSpec {

  private def mkName(name: String): Either[String, Name] =
    if (name == "" || name == null) Left("Name is empty.")
    else Right(new Name(name))

  private def mkAge(age: Int): Either[String, Age] =
    if (age < 0) Left("Age is out of range.")
    else Right(new Age(age))


  "map2" should "return a name error when the Person name is invalid" in {
    assert(map2(mkName(""), mkAge(23))(Person(_, _)) === Left(List("Name is empty.")))
  }

  it should "return an age error when the Person age is invalid" in {
    assert(map2(mkName("Batman"), mkAge(-1))(Person(_, _)) === Left(List("Age is out of range.")))
  }

  it should "return a name error and an age error when both the Person name and age are invalid" in {
    val result = map2(mkName(""), mkAge(-1))(Person(_, _))

    result match {
      case Left(errors) =>
        assert(errors.contains("Name is empty."))
        assert(errors.contains("Age is out of range."))
        assert(errors.length === 2)
      case _ => fail("Result was not a Left as expected.")
    }
  }

  it should "return a Person when both the name and age are valid" in {
    val result = map2(mkName("Batman"), mkAge(23))(Person(_, _))

    result match {
      case Right(person) =>
        assert(person.name.value === "Batman")
        assert(person.age.value === 23)
      case _ => fail("Result was not a Right as expected.")
    }
  }
}
