package Section4

import scala.util.Random

object Section4_Options_Lecture45 extends App{

  val myFirstOption: Option[Int] = Some(4)
  val notOption: Option[Int] = None

  //unsafe APIs
  def unSafeMethod(): String = null
  //val result = Some(unSafeMethod()) //WRONG as same as Some(null)
  val result = Option(unSafeMethod()) //Some or None //We should never do null checks ourselves, Option will take care.

  //chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unSafeMethod()).orElse(Option(backupMethod())) //unSafeMethod() is the prefered method.


  //Design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())


  //function on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE = DO NOT USE THIS because it can point to null.

  //map, flatMap, filter
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(_ > 10)) //None
  println(myFirstOption.flatMap(x => Option(x * 10))) //Some(40)

  //for comprehensions

  /*
  Excercise
   */

  val config: Map[String, String] = Map(
    "host" -> "192.168.5.4",
    "port" -> "80"
  )

  class Connection{
    def connect = "connected" //connect to some server
  }

  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }


    //Try to establish a connection, if so - print the correct method
    val host = config.get("host")
    val port = config.get("port")

    /*
    if (h != null)
      if (p != null)
        return Connection.apply(h,p)

    return null
     */
    //val connection = Connection.apply(host, port) // This wont work as return type of host and port is Option.
    val connection = host.flatMap(h => port.flatMap( p => Connection.apply(h, p)))

    /*
    if (c != null)
      return c.connect
    return null
     */
    //val connectionStatus = new Connection
    //connectionStatus.connect
    val connectionStatus = connection.map(c => c.connect) // Same thing as above 2 line.
    /*
    if (status != null)
      println(status)
     */
    connectionStatus.foreach(println)


    //chained calls
    config.get("host")
      .flatMap(host => config.get("port")
        .flatMap(port => Connection(host, port))
          .map(connection => connection.connect))
      .foreach(println)


    //for-comprehensions
    val forConnectionStatus = for {
      host <- config.get("host")
      port <- config.get("port")
      connection <- Connection(host, port)
    } yield connection.connect


  }

}
