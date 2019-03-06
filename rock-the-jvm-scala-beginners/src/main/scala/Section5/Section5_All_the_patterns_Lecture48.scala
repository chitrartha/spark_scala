package Section5

import Section4.{Cons, MyList, Empty}

object Section5_All_the_patterns_Lecture48 extends App{

  //1 - Constants
  val x: Any = "scala"
  val constants = x match {
    case 1 => "a number"
    case "scala" => "The SCALA"
    case true => "teh truth"
    case Section5_All_the_patterns_Lecture48 => "a singleton object"
  }


  //2 - match anything
  //2.1 wildcard

  val matchAnything =  x match {
    case _ =>
  }

  //2.2 variable
  val matchvariable =  x match {
    case somethhing => s"$somethhing"
  }

  //3 Tuples
  val aTuple = (1,2)
  val matchTuple =  aTuple match {
    case (1,2) =>
    case(something,2) => s"$something"
  }

  val nestedTuple = (1,(2,3))
  val matchNestedTuple =  nestedTuple match {
    case (_,(2,v)) =>
  }
  //PM can be nested!

  //4 case classes - constructor pattern
  val aList: MyList[Int] = Cons(1,Cons(2, Empty))
  val matchNestedTuple =  nestedTuple match {
    case (_,(2,v)) =>
  }


}
