package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App{

  @tailrec
  def factorialFunc(n: Int, accumulator: Int = 1): Int = {
    if (n <= 1) accumulator
    else factorialFunc(n - 1, n * accumulator)
  }

  val fact10 = factorialFunc(10)

  def savePicture(format: String = "jpeg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture")
  savePicture(width = 800)

}
