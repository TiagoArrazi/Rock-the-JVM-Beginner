package lectures.part2oop

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangsOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)
  // only methods with single parameter

  // "operators" in Scala

  val tom = new Person("Tom", "Fight Club")
  println(mary hangsOutWith tom)

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  println(x == y)
  // unary_ prefix only works with + - ~ !

  println(!mary)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  /*
   1. Overload the + operator
    mary + "the rockstar" => new person "Mary (the rockstar)"

   2. Add an age to the Person class
    Add an unary + operator => new person with the age + 1
    +mary => mary with the age incrementer

   3. Add a "learns" method in the Person class => "Mary learns Scala"
    Add a learnsScala method, calls learns method with "Scala"
    Use it in postfix notation

   4. Overload the apply method
    mary.apply(2) => "Mary watched Inception 2 times"

   */

  class PersonExercise(val name: String, val age: Int, favoriteMovie: String) {
    def +(nickName: String): PersonExercise = new PersonExercise(s"$name ($nickName)", age, favoriteMovie)
    def unary_+ : PersonExercise = new PersonExercise(name, age + 1, favoriteMovie)
    def learns(what: String) = s"$name learns $what"
    def learnsScala: String = learns("Scala")
    def apply(timesWatched: Int) = s"$name watched $favoriteMovie $timesWatched times"
  }

  val tiago = new PersonExercise("Tiago", 22, "Interstellar")

  val tiagoTheRockstar = tiago + "The Rockstar"
  println(tiagoTheRockstar.name)

  val olderTiago = +tiago
  println(olderTiago.age)

  println(tiago learns "Scala")
  println(tiago learnsScala)

  println(tiago(6))
}
