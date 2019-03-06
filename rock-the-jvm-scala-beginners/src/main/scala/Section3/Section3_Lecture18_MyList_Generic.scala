////Please uncomment out befor esunning. COmemted it as the class name MyList[+A] was conflicting with Section3_ExpandingMyList_Lecture20.scala.
//
//package Section3
//
//abstract class MyList[+A] {
//
//  /*
//  head = first element of the list
//  tail = remainder of the list
//  isEmpty = is this list empty
//  add(int) => new list with this element added
//  toString =>  string representation of the list
//   */
//
//  def head: A
//  def tail: MyList[A]
//  def isEmpty: Boolean
//  def add[B >: A](element: B): MyList[B]
//  def printElement:String //Polymorphic call // As the same printElement method will be overrideen in syb classes.
//  override def toString: String = "[" + printElement + "]" //override keyword is use here because toString, equals and hashcode method are present in AnyRef class.
//
//}
//
//object Empty extends MyList[Nothing]{
//
//  def head: Nothing = throw new NoSuchElementException
//  def tail: MyList[Nothing] = throw new NoSuchElementException
//  def isEmpty: Boolean = true
//  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
//  def printElement: String = ""
//
//}
//
//class Cons[+A](h: A, t:MyList[A]) extends MyList[A]{
//
//  def head: A = h
//  def tail: MyList[A] = t
//  def isEmpty: Boolean = false
//  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
//  def printElement: String = {
//    if (t.isEmpty) "" + h
//    else h + " " + t.printElement
//  }
//}
//
//object listTest extends App{
//
//  val listOfNumbers: MyList[Int] = Empty //We need the Empty object to return empty for any type thats why we use Nothing.
//  val listOfText: MyList[String] = Empty //We need the Empty object to return empty for any type thats why we use Nothing.
//
//  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  val listOfStrings = new Cons("Hello", new Cons("Scala", new Cons("!", Empty)))
//
//  println(listOfIntegers.toString)
//  println(listOfStrings.toString)
//
//}
//
