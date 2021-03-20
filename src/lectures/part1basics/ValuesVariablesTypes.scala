package lectures.part1basics

object ValuesVariablesTypes extends App{

  val x: Int = 42
  val y = 42
  println(x)

  // VALS ARE IMMUTABLE
  // TYPES OF VALS ARE OPTIONAL
  // COMPILER CAN INFER TYPES

  val aString: String = "hello"

  //BASIC TYPES

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x // 4 BYTES
  val aShort: Short = 4613 // 2 BYTES
  val aLong: Long = 462276763453654L // 8 BYTES
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // VARIABLES

  var aVariable: Int = 4
  aVariable = 5 // SIDE EFFECTS


}
