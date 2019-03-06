package Section4

import scala.util.{Failure, Random, Success, Try}

object Section4_Handling_Failures_Lecture46  extends App{

//create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No string for you")

  //Try objects via apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  //syntax sugar
  val anotherPotentialFailure = Try {
    //code that might throw
  }


  //utilities
  print(potentialFailure.isSuccess)


  //orElse
  def backupMethod(): String = "A valid result"
  val fallBackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))


  //If you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallBack = betterBackupMethod orElse betterBackupMethod


  //map, flatMap, filter
  println(aSuccess.map(_*2))
  println(aSuccess.filter(_ > 10))
  println(aSuccess.flatMap(x => Success(x * 10)))


  //for-comprehensions

  /*
  Excercise
   */


  val host = "localhost"
  val port = "80"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>....</html>"
      else throw new RuntimeException("Connection error")

    }

    def getSafe(url: String): Try[String] = Try(get(url)) // Added later as part of solnt to the problem.

  }

  object HttpService {

    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection ={
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took place")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port)) // Added later as part of solnt to the problem
  }

  //If you get the html page from the connection , print it to the console i.e all renderHTML.
  val possibleConnection = HttpService.getSafeConnection(host, port)
  //Since the return type is Try, thats why we use flatMap as it takes care of handling Some or None as per the result returned by Try.
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  //shorthand version
  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)


  //for-comprehension versions
  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  }renderHTML(html)

  /*

  try {
    connection = HttpService.getConnection(host, port)
    try {
      page = onnection.get("/home")
      renderHTML(page)
    } catch (some other exception) {

    }
  } catch (exception) {

  }
  */
}
