package Section3

object Section3_Scala_objects_lecture14 extends App {

  //scala DOES NOT HAVE class-level functionality("static")
  object Person{

    //"static"/"class"-level functionality
    val N_EYES = 2
    def canFly: Boolean = {false}

    //factory method
    def apply (mother: Person, father: Person): Person = new Person("Bobbie")

  }
  //object will have no parameters.

  class Person(val name: String){

    //instance level functionality
  }
  //Companions

  println(Person.N_EYES)
  println(Person.canFly)

  //scala object = SINGLETON INSTANCE
  val mary = Person //No parameter means object and everytime it will be refered to the same singleton instance.
  val tom = Person
  println(mary == tom)
  //true

  val person1 = new Person("mary")
  val person2 = new Person("tom")
  println(person1 == person2)
  //false

  val bobbie = Person.apply(person1, person2)
  val bobbieSibling = Person(person1, person2) //Kind of a constructor

  //Scala Applications = scala object with
  //def main(args: Array[String]): Unit


}




