package Section3

object Scetion3_Caseclasses_Lecture21 extends App{

  /*
  equals,hashCode toString
   */

  case class Person(name: String, age: Int)

  //1. class parameters are field.

  val jim = new Person("Jim", 34)
  println(jim.name)

  //2. sensible toString
  println(jim.toString)
  //println(instance) = println(instance.toString()) //Syntactic sugar.
  println(jim)
  //If we had not used case class and then printed the instance => Section2.Scetion3_Caseclasses_Lecture21$Person@27f674d

  //3. equals and haschCode implemented out of teh box.
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) //returns true
  //If it would not been case class then it would have returned false since case clas sby default has equal in it.

  //4. Case classes have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //5. CCs have companion objects.
  val thePerson =  Person
  val mary = Person("Mary", 23) //Companion objects apply method works as same as constructor.

  //6. CCs are serializable
  //Akka and other distributed system it is useful.

  //7. CCs have extracted patterns = CCs can be used in pattern matching

  case object UnitedKingdom{
    def name:String = "UK"
  }
  //case object are same as case classes only there is no companion object.





}
