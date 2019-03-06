package Section3

object Section3_Lecture10 extends App{

  val person = new person("John", 26)
  //println(person.age)// Throws error when person class fields, i.e no val added to it [age: Int]
  println(person.age)// Adding val removes teh error [val age: Int]
  println(person.x)
  person.greet("Daniel")
  person.selfGreet()
}

class person(name: String, val age: Int) //Constructor If we want to access age like person.age it gives error.
//Class parameters are NOT FIELDS. To convert into fields add val/var befor ethe parameter.
{
  //body

  val x = 2 // The variables inside class are basically field. So it can be accessed by person.x
  println(1 + 3)

  //method
  def greet(name: String): Unit = println(s"${this.name} says, Hi $name") //this.name is the name passed in class.

  //overloading
  def selfGreet(): Unit = println(s"Hi, $name")//this.name is self implied here and refres to the name parameter of the class. But above method since the name of the method was name
  //That's whjy we had to explicitly mention this.name

  //multiple constructors
  def this(name: String) = this(name,0) //Auxillary constructor calls teh primary constructor. But it alwsays need a sceondary constructor.
  def this() = this("john doe") // In this example the default value of name is "John doe". Instead we can do this by class person(name: String = "John Doe", val age: Int)

}