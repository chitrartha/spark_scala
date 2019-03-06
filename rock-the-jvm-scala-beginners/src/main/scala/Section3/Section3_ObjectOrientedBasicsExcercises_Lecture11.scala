package Section3

import scala.annotation.tailrec

object Section3_Lecture11 extends App {


  //1st problem
  val writer_obect = new writer("Bruce", "wayne", 34)
  println(writer_obect.fullName())

  val novelClass = new novelClass(novel = "Batman", yearOfRelease = 1990, author = "Bruce wayne", writer_obect)
  novelClass.displayNovelInfo()
  novelClass.authorAge()
  novelClass.isWrittenBy()
  novelClass.copyOfNovel(novel = "Batman", yearOfRelease = 2011, author = "Bruce wayne")
  novelClass.copyOfNovel(novel = "Superman", yearOfRelease = 2011, author = "myself")

  //2nd problem
  val counter_object = new counter(3)
  counter_object.inc()

  val counter_object2 = new counter(4)
  counter_object.dec(2)

}

//1st problem
/* Novel and Writer
Writer: Fname,sname, year
-method: Full name

Novel:Name, year of release, author
-authorAge
-isWrittenBy(Author)
-Copy(new year of release) = new instance of novel
 */

class writer(val fname: String = "chris", sname: String = "bale", val age: Int = 23){

  def fullName(): String = {
    this.fname + " " + this.sname
  }
}

class novelClass(val novel: String = "Batman", val yearOfRelease: Int = 1990, val author: String = "chris bale", val writer_type: writer){

  def displayNovelInfo(): Unit = { println(s"bookname: ${this.novel} yearOfRelease: ${this.yearOfRelease} author: ${this.author}") }

  def authorAge(): Unit = {
    if ( writer_type.fullName() == this.author ){
      println(this.yearOfRelease - writer_type.age)
    }
  }

  def isWrittenBy(): Unit = {
    if ( writer_type.fullName() == this.author ){
      println(this.author)
    }
  }

  def copyOfNovel(novel: String = "Batman", yearOfRelease: Int = 2011, author: String = "anonymous")= {

    val anotherNovelClass = new novelClass(novel, yearOfRelease, author, writer_type) // Immutability, we cannot change the existing object, so we create need obect.
    if ( author == writer_type.fullName() ) {
      anotherNovelClass.displayNovelInfo()
    }
    else { println(s"Please provide valid author and Novel name") }
  }
}


//2nd problem
/* Counter class
-method: Receives an int value
-Method current count
-Method to increment/decrement => new counter
-overload inc/dec to receive an element.
 */


class counter(val number_counter: Int){

  def inc() = {
    println("Incrementing..")
    println(this.number_counter + 1)
    new counter( this.number_counter + 1)
  }

  def dec() = {
    println("Decrementing..")
    println(this.number_counter - 1)
    new counter( this.number_counter - 1)
  }


  def inc(n: Int): counter = {
    if ( n <= 0 ) this
    else inc.inc(n-1)
  }


  def dec(n: Int): counter = {
    if ( n <= 0 ) this
    else dec.dec(n-1)
  }
}
