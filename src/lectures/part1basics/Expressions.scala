package lectures.part1basics

object Expressions extends App{

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // +
  // -
  // *
  // /
  // & (bitwise and)
  // | (bitwise or)
  // ^ (bitwise xor)
  // << (bitwise left shift)
  // >> (bitwise right shift)
  // >>> (bitwise right shift with zero extension) SPECIFIC TO SCALA

  println(1 == x)
  // ==
  // !=
  // >
  // >=
  // <
  // <=

  println(!(1 == x))
  // !
  // &&
  // ||

  var aVariable = 2
  aVariable += 3 // ALSO WORKS WITH -= *= /= ....... SIDE EFFECTS
  println(aVariable)

  // Instructions (DO) VS. Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)


  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN!!!

  // EVERYTHING IN SCALA IS AN EXPRESSION

  val aWeirdValue = (aVariable = 3) // Unit == void
  println(aWeirdValue)

  // SIDE EFFECTS: println(), whiles, reassigning

  // CODE BLOCKS

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // EXERCISES

  // 1. What is the difference between "hello world" and println("hello world")
  // Ans: The former is a String, it has a value "hello world",
  // the latter is a side-effect, which means, it has a Unit() value

  // 2. What is the value of this expression

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

  // Ans: The value is 42, because it is the last expression inside the code block

}
