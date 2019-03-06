package Section3

object Section3_SyntacticSugar_MethodNotations_Lecture12 extends App{

  class person (val name: String, favouriteMovie: String, val age: Int = 0){
    def likes(movie: String): Boolean = { movie == favouriteMovie}
    def +(person: person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"${this.name}, what teh heck?" //Note the sapce between :. Its must.
    def isAlive: Boolean = {true}
    def apply(): String = {s"Hi my name is ${this.name} and my fav movie is ${this.favouriteMovie}  "}

    //Excercise
    //1.
    // def +(rockstar: String) : String = {this.name + " (" + rockstar + ")"} //This also works
    def +(rockstar: String) : person = new person(s"$name ($rockstar)", favouriteMovie) //This way it creates new person object.

    //2.
    def unary_+ : person = { new person(this.name, this.favouriteMovie, this.age + 1) } //Note the sapce between :. Its must.

    //3.
    def learns(learnWhat: String): String = {s"${this.name} learns $learnWhat" }
    def learnScala(): String  = this learns "scala" //this.learns("scala")

    //4.
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"
  }

  val mary = new person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes("Inception")) // Equivalent; Works with method with only one parameter.
  //infix notation = operator notation (syntatic sugar)

  //"Operators" in scala

  val tom = new person("Tom", "Fight club")
  println(mary + tom)

  //Method name can contain +,-,!,~. +  between numbers is method as well. 1.+(2)
  //Akka actors has ! ?

  //prefix notation
  val x = -1 //- is unary operator.
  val y = 1.unary_- //Above semantics is same as this.
  //Unary_prefix can only contain + - ! ~
  println(y)

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary isAlive)
  //postfix notation is only availbale to method which has no parameters. Used rarely.

  println(mary.apply())
  println(mary())//Equivalent


  /*
  1.Overload the + operator
  mary + "the rockstar" => new person "mary (the rockstar)"

  2.Add an age to the person class
  Add a unary + operator  => new personwith the age + 1
  +mary => mary with age incremenator

  3.Add a "learns" method in person class => "mary learns Scala"
  Add a learnscala method, call learns method with "scala"
  Use it in postfix noattion

  4.Overload teh apply method
  mary.apply(2) => "Mary watched Inception 2 times"

   */

  //Excercise
  //1.
  println((mary + "the rockstar").apply())
  println((mary + "the rockstar")())

  //2.
  println((+mary).age)

  //3.
  println(mary.learnScala())

  //4.
  println(mary(10))

}
