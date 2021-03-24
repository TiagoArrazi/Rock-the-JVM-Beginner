package lectures.part2oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. Class parameters are promoted to fields
  val jim = Person("Jim", 34) // in CCs we don't need to use "new" because of the built-in companion object
  println(jim.name)

  // 2. Sensible toString
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val jim2 = Person("Jim", 34) // in CCs we don't need to use "new" because of the built-in companion object
  println(jim == jim2)

  // 4. CCs have handy copy methods
  val jim3 = jim.copy()
  val jim4 = jim.copy(age = 45)
  println(jim3)
  println(jim4)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)
  println(mary)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Expand MyList - use case classes and case objects
   */

}
