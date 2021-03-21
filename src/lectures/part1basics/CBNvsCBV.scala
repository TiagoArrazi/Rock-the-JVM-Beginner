package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit = {
    println(s"by value: $x") // 10847086501087530L
    println(s"by value: $x") // 10847086501087530L
  }

  def calledByName(x: => Long): Unit = {
    println(s"by name: $x") // System.nanotime()
    println(s"by name: $x") // System.nanotime()
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  printFirst(infinite(), 34) // java.lang.StackOverflow
  printFirst(34, infinite()) // 34, infinite() is never evaluated

}
