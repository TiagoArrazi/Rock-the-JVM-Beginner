package lectures.part2oop

object OOBasics extends App{

  val person = new Person("John", 26)
  person.greet("Daniel")
  person.greet()

  val writer = new Writer("Tiago", "Arrazi", 1998)
  println(writer.fullName())

  val novel = new Novel("My Story", 2018, writer)
  novel.authorAge()
  novel.isWrittenBy()

  val newRelease = novel.copy(2021)
  newRelease.authorAge()
  newRelease.isWrittenBy()

  val counter = new Counter(10)
  counter.currentCount()

  val newIncrementedCounterBy1 = counter.incrementCounter()
  newIncrementedCounterBy1.currentCount()

  val newDecrementedCounterBy1 = counter.decrementCounter()
  newDecrementedCounterBy1.currentCount()

  val newIncrementedCounterByX = counter.incrementCounter(5)
  newIncrementedCounterByX.currentCount()

  val newDecrementedCounterByX = counter.decrementCounter(5)
  newDecrementedCounterByX.currentCount()

  // constructor
  class Person(val name: String, val age: Int) {
    // body

    // method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

    // overloading
    def greet(): Unit = println(s"Hi, I am ${this.name}")

    // multiple constructors
    def this(name: String) = this(name, 0) // not practical
  }

  // class parameters are NOT FIELDS

  /*
    Novel and a Writer

    Writer: first name, surname, year
      - method fullName

    Novel: name, year of release, author
      - method authorAge
      - method isWrittenBy(author)
      - method copy (new year of release) = new instance of Novel

   */

  class Writer(val firstName: String, val surName: String, val year: Int) {
    def fullName(): String = s"${this.firstName} ${this.surName}"
  }

  class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {

    def authorAge(): Unit = println(s"The author was ${this.yearOfRelease - author.year} years old by the time this novel was written")

    def isWrittenBy(): Unit = println(s"This novel is written by ${author.fullName()}")

    def copy(yearOfRelease: Int): Novel = new Novel(this.name, yearOfRelease, author)

  }

  /*
    Counter class
     - receives an int value
     - method current count
     - method to increment/decrement => new Counter
     - overload inc/dec to receive an amount
   */

  class Counter(val count: Int) {

    def currentCount(): Unit = println(s"Current count is ${this.count}")

    def incrementCounter(): Counter = new Counter(this.count + 1)
    def incrementCounter(incVal: Int): Counter = new Counter(this.count + incVal)

    def decrementCounter(): Counter = new Counter(this.count - 1)
    def decrementCounter(decVal: Int): Counter = new Counter(this.count - decVal)

  }

}



