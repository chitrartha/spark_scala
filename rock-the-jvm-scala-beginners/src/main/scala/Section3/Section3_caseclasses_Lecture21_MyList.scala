//package Section3
//
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
//  def printElement:String //Polymorphic call // As the same printElement method will be overrideen in sub classes.
//  override def toString: String = "[" + printElement + "]" //override keyword is use here because toString, equals and hashcode method are present in AnyRef class.
//
//  def map[B](transformer: MyTransformer[A,B]): MyList[B]
//  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B]
//  def filter(predicate: MyPredicate[A]): MyList[A]
//
//  def ++[B >: A](list: MyList[B]): MyList[B]
//
//}
//
//
//
//case object Empty extends MyList[Nothing]{
//
//  def head: Nothing = throw new NoSuchElementException
//  def tail: MyList[Nothing] = throw new NoSuchElementException
//  def isEmpty: Boolean = true
//  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
//  def printElement: String = ""
//
//  def map[B](transformer: MyTransformer[Nothing,B]): MyList[B] = Empty
//  def flatMap[B](transformer: MyTransformer[Nothing,MyList[B]]): MyList[B] = Empty
//  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
//
//  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
//
//}
//
//case class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
//
//
//  def head: A = h
//  def tail: MyList[A] = t
//  def isEmpty: Boolean = false
//  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
//  def printElement: String = {
//    if (t.isEmpty) "" + h
//    else h + " " + t.printElement
//  }
//
//  /*
//  [1,2,3].filter(n % 2)
//  =[2,3].filter(n % 2)
//  =new Cons(2, [3].filter(n % 2))
//  =new Cons(2, Empty.filter(n % 2))
//  =new Cons(2, Empty)
// */
//  def filter(predicate: MyPredicate[A]): MyList[A] =
//    if (predicate.test(h)) new Cons(h, t.filter(predicate))
//    else t.filter(predicate)
//
//  /*
//  [1,2,3].map(n * 2)
//  =new Cons(2, [2,3].map(n*2))
//  =new Cons(2, new Cons(4, [3].map(n*2)))
//  =new Cons(2, new Cons(4, new Cons(6, Empty.map(n*2))))
//  =new Cons(2, new Cons(4, new Cons(6, Empty)))
//   */
//
//  def map[B](transformer: MyTransformer[A,B]): MyList[B] = {
//    new Cons(transformer.transform(h), t.map(transformer))
//  }
//
//
//  /*
//  [1,2,3].flatMap(n => n+1)
//  =[1,2] ++ [2,3].flatMap(n => n+1)
//  =[1,2] ++ [2,3] ++ [3].flatMap(n => n+1)
//  =[1,2] ++ [2,3] ++ [3,4] ++ Empty.flatMap(n => n+1)
//  =[1 2 2 3 3 4]
//   */
//  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B] = {
//    transformer.transform(h) ++ t.flatMap(transformer)
//  }
//
//  /*
//  [1,2] ++ [3,4,5]
//  =new Cons(1, [2] ++ [3,4,5] )
//  =new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
//  =new Cons(1, new Cons(2, [3, 4, 5]))
//  =new Cons(1, new Cons(2, [3, 4, 5]))
//  =new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))
//   */
//  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
//
//
//
//}
//
//trait MyPredicate[-T]{
//
//  def test(elem: T): Boolean
//}
//
//trait MyTransformer[-A,B]{
//
//  def transform(elem: A): B
//}
//
//object listTest extends App{
//
//  val listOfNumbers: MyList[Int] = Empty //We need the Empty object to return empty for any type thats why we use Nothing.
//  val listOfText: MyList[String] = Empty //We need the Empty object to return empty for any type thats why we use Nothing.
//
//  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  val anotherlistOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  val listOfStrings = new Cons("Hello", new Cons("Scala", new Cons("!", Empty)))
//
//  println(listOfIntegers.toString)
//  println(listOfStrings.toString)
//
//  println(listOfIntegers.map(new MyTransformer[Int, Int] {
//    override def transform(elem: Int): Int = elem * 2
//  }).toString)
//
//
//  println(listOfIntegers.filter(new MyPredicate[Int] {
//    override def test(elem: Int) =  (elem % 2 == 0)
//  }).toString)
//
//  println((listOfNumbers ++ listOfIntegers).toString)
//
//
//  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
//    override def transform(elem: Int): MyList[Int] =  new Cons(elem, new Cons(elem + 1, Empty))
//  }).toString)
//
//
//  println(listOfIntegers == anotherlistOfIntegers)
//
//
//}
//
///*
//1.Generic trait MyPredicate[-T] with a little method test(T) => Boolean
//
//2.Generic trait MyTransformer[-A,B] with a method transform(A) => B
//
//3.MyList:
//  -map(transformer) => MyList
//  -filter(MyPredicate) => MyList
//  -flatMap(transformer from A to MyList[B]) => MyList[B]
//
//  class EvenPredicate extends MyPredicate[Int] => Boolean
//  class StringToIntTransformer extends MyTransformer[String, Int] => Int
//
//  [1,2,3].map(n * 2) = [2,4,6]
//  [1,2,3,4].filter(n % 2) = 4
//  [1,2,3].flatMap(n => [n, n+1]) = [1,2,2,3,3,4]
//
//*/
//
