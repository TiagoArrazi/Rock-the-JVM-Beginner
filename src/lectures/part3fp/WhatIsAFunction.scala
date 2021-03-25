package lectures.part3fp

object WhatIsAFunction extends App {

  // DREAM: use functions as first class elements
  // PROBLEM: OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Function types Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
  1. Define a function which takes 2 strings and concatenates them
  2. Transform the myPredicate and myTransformer into function types (MyList)
  3. Define a function which takes an Int and returns another function which takes an Int and returns an Int
    - What's the type of this function
    - How to do it
   */

  // 1.
  val stringConcatenate = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = s"$v1$v2"
  }

  println(stringConcatenate("A", "B"))

  // 2.
  // ***

  // 3.
  // Function1[Int, Function1[Int, Int]]
  val superAdder: Int => Int => Int = new (Int => Int => Int) {
    override def apply(v1: Int): Int => Int = new (Int => Int) {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function

}

trait MyFunction[A, B] {
  def apply(element: A): B = ???
}
