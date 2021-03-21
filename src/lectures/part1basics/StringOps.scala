package lectures.part1basics


object StringOps extends App{

  val aString: String = "Hello, I am learning Scala"

  println(aString.charAt(2))
  println(aString.substring(7, 11))
  println(aString.split(" ").toList)
  println(aString.startsWith("Hello"))
  println(aString.replace(" ", "-"))
  println(aString.toLowerCase())
  println(aString.toUpperCase())
  println(aString.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // prepending and appending
  println(aString.reverse)
  println(aString.take(2))

  // Scala-specific: String interpolators

  // S-interpolator
  val name = "David"
  val age = 12
  val greeting = s"Hello, my is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(greeting)
  println(anotherGreeting)

  // F-interpolator
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // Raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
