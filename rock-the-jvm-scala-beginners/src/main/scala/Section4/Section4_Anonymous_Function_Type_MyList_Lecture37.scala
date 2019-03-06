//package Section4
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
//  def map[B](transformer: A => B): MyList[B]
//  def flatMap[B](transformer: A => MyList[B]): MyList[B]
//  def filter(predicate: A => Boolean): MyList[A]
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
//  def map[B](transformer: Nothing => B): MyList[B] = Empty
//  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
//  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
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
//  def filter(predicate: A => Boolean): MyList[A] =
//    if (predicate(h)) new Cons(h, t.filter(predicate)) //predicate.apply(h) or predicate(h) are same.
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
//  def map[B](transformer: A => B): MyList[B] = {
//    new Cons(transformer(h), t.map(transformer))
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
//  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
//    transformer.apply(h) ++ t.flatMap(transformer)
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
//  println(listOfIntegers.map(_ * 2).toString) //elem => elem * 2 === _ * 2
//
//
//  //  println(listOfIntegers.map(new Function1[Int, Int] {
//  //    override def apply(elem: Int): Int = elem * 2
//  //  }).toString)
//  //
//  ////  println(listOfIntegers.map(new MyTransformer[Int, Int] {
//  ////    override def transform(elem: Int): Int = elem * 2
//  ////  }).toString)
//  ////
//  ////
//  ////  println(listOfIntegers.filter(new MyPredicate[Int] {
//  ////    override def test(elem: Int) =  (elem % 2 == 0)
//  ////  }).toString)
//  //
//  //
//  //  println(listOfIntegers.filter(new Function1[Int, Boolean] {
//  //    override def apply(elem: Int) =  (elem % 2 == 0)
//  //  }).toString)
//  //
//  //  println((listOfNumbers ++ listOfIntegers).toString)
//  //
//  //
//  //  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
//  //    override def apply(elem: Int): MyList[Int] =  new Cons(elem, new Cons(elem + 1, Empty))
//  //  }).toString)
//  //
//  //  //  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
//  //  //    override def transform(elem: Int): MyList[Int] =  new Cons(elem, new Cons(elem + 1, Empty))
//  //  //  }).toString)
//
//  println(listOfIntegers.filter(_ % 2 == 0).toString) //elem => elem % 2 == 0 === _ % 2 == 0
//
//  println((listOfNumbers ++ listOfIntegers).toString)
//
//
//  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString) // _ cannot be used here because _ can only be used one time.
//  //Since here we need to use elem 2 times so we cannot use _.
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
