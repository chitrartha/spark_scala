package Section2

object Section2_SmartOperationsOnString_Lecture9 extends App{

  val str: String = "Hello learning scala"

  println(str.charAt(2))
  println(str.substring(1,7))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", ","))
  println(str.toLowerCase)
  println(str.length)


  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println("a" +:  aNumberString :+ "z")
  println(str.length)
  println(str.take(2))

  //Scala specific: String Interpolators

  //S-interpolators
  val name = "David"
  val age = 12

  val greeting = s"Hello, i am $name and i am $age years old"
  val anotherGreeting = s"Hello, i am $name and i will be turning ${age + 1} years old."

  //F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f"
  println(myth)
  //David can eat 1.20
  //

  //raw-interpolators
  println(raw"This is a \n newline")
  //raw will ignore any escape characters.
  //But in below expample cannot neglect it as escape alreday has newline processed in it.
  val escape= "This is a \n newline"
  println(raw"$escape")
  println(escape)



}
