//package Section3
//
//abstract class MyList {
//
///*
//head = first element of the list
//tail = remainder of the list
//isEmpty = is this list empty
//add(int) => new list with this element added
//toString =>  string representation of the list
// */
//
//  def head: Int
//  def tail: MyList
//  def isEmpty: Boolean
//  def add(n: Int): MyList
//  def printElement:String //Polymorphic call // As the same printElement method will be overrideen in syb classes.
//  override def toString: String = "[" + printElement + "]" //override keyword is use here because toString, equals and hashcode method are present in AnyRef class.
//
//}
//
//object Empty extends MyList{
//
//  def head: Int = throw new NoSuchElementException
//  def tail: MyList = throw new NoSuchElementException
//  def isEmpty: Boolean = true
//  def add(element: Int): MyList = new Cons(element, Empty)
//  def printElement: String = ""
//
//}
//
//class Cons(h: Int, t:MyList) extends MyList{
//
//  def head: Int = h
//  def tail: MyList = t
//  def isEmpty: Boolean = false
//  def add(element: Int): MyList = new Cons(element, this)
//  def printElement: String = {
//    if (t.isEmpty) "" + h
//    else h + " " + t.printElement
//  }
//}
//
//object listTest extends App{
//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.head)
//  println(list.isEmpty)
//  println(list.toString)
//  println(list.add(4).head)
//  println(list.add(4).toString)
//  println(list.add(4).tail)
//
//}
//
//
//
//
