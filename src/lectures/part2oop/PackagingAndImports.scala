package lectures.part2oop

import lectures.part2oop.OOBasics.Writer
import playground.{Bar => elBar, Foo => elFoo}


object PackagingAndImports extends App{

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 34) // OOBasics.Writer = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello()
  println(SPEED_OF_LIGHT)

  // imports
  val foo = new elFoo
  val bar = new elBar

  // default imports
  // java.lang - String, Object, Exception ...
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
