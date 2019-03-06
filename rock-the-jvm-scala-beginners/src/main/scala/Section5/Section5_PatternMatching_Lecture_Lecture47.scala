package Section5

import scala.util.Random

object Section5_PatternMatching_Lecture_Lecture47 extends App {

  //switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the one"
    case 2 => "double"
    case 3 => "third time"
    case _ => "something else"
  }

  println(x)
  println(description)

  //1.Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"HI, my name is $n and my age is $a"
    case Person(n, a) => s"HI, my name is $n and my age is $a"
    case _ => "I dont know who i am"
  }
  println(greeting)

  /*
  1. cases are matched in order
  2. what if no cases matches ? MatchError
  3. type of teh PM expressions? unified type of all teh types in the cases
   */

  //PM on sealed classes
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(somebreed) => println(s"matched a dog of breed $somebreed")
  }

  //match everything
  val isEven =  x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  //WHY?
  val isEvenCond = if (x % 2 == 0) true else false
  val isEbenNormal = x % 2 == 0

/*
Excercise
Simple fnctn use PM
takes and Expr => Human readable form
Sum(Number(2),Number(3)) => 2 + 3
Prod(Sum(Number(2),Number(1)), Number(3)) => (2 + 1) * 3
Sum(Prod(Number(2),Number(1)), Number(3)) => 2 * 1 + 3
 */

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr


  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1,e2) => {
      def maybeShowParanthesis(expr: Expr) = expr match {
        case Number(_) => show(expr)
        case Prod(_,_) => show(expr)// Logic here is 'Prod' takes 2 args. Nad return type of 'maybeShowParanthesis' has return type String.
          //Return type of String is show(expr) but how does it makes sense? Because when it again return 'show' function it MUST print
          //maybeShowParanthesis(e1) + " * " + maybeShowParanthesis(e2).
        case _ => "(" + show(expr) +")"
      }

      maybeShowParanthesis(e1) + " * " + maybeShowParanthesis(e2)
    }
  }


  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(3)), Number(4))))
  println(show(Sum(Prod(Number(2), Number(3)), Number(4))))



}
