package Section4

object Section4_Tuples_And_Map_Lecture43 extends App{

  //tuples = finite ordered lists
  //Tuple2 is syntactic sugar
  val aTuple = new Tuple2(2, "Hello scala")//Tuple2[Int, String] = (Int, String)
  val alsoTuple = (2, "Hello scala")

  println(alsoTuple._1)
  println(alsoTuple.copy(_2 = "goodbye java"))
  println(alsoTuple.swap)

  //Map - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Dan" -> 666)
  //a -> b is syntactic sugar for (a,b)
  println(phonebook)

  //map ops
  println(phonebook.contains("Jim"))

  val phonebook2 = Map(("Jim", 555), "Dan" -> 666).withDefaultValue(-1)
  println(phonebook2.contains("Mary")) // returns -1 because thats what withDefaultValue does if no key present.

  //add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  //Since map are immutable it does not changes existing alements rather add.
  println(newPhonebook)

  //functionals on map
  //map, flatMap, filter

  println(newPhonebook.map(pair => pair._1.toLowerCase -> pair._2))
  //Map(jim -> 555, dan -> 666, mary -> 678)

  //filterkeys
  println(newPhonebook.filterKeys(_.startsWith("J")))
  //mapValues
  println(newPhonebook.mapValues(_*10))

  //conversions to other collections
  println(phonebook.toList)
  //List((Jim,555), (Dan,666))
  println(List(("Dan", 1234)).toMap)
  //Map(Dan -> 1234)
  val names = List("Dan", "Jim", "Angela", "Bob", "Mary", "James")

  println(names.groupBy(name => name.charAt(0)))
  //Map(J -> List(Jim, James), A -> List(Angela), M -> List(Mary), B -> List(Bob), D -> List(Dan))

  /*
  1. What would happen if i had 2 original entries "Jim" -> 555 and "JIM" -> 9007

     !!!careful with mapping keys.
  2. Overly simplified social network based on maps
     Person = String
     - add a person to the network
     - remove
     - friend(mutual)
     - unfriend

     - no. of friends of a person
     - person with most friends
     - how many people have NO friends
     - if there is a social connection b/w people or not(yes or no)


   */

  //1.
  val phonebook3 = Map(("Jim", 555), "JIM" -> 666)
  println(phonebook3.map(pair => pair._1.toLowerCase -> pair._2))
  //Map(jim -> 666) // Since both the keys have same name.
  //!!!careful with mapping keys.

  println(phonebook3("Jim"))

  //2.
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {

    network + ((person , Set())) // Or (person -> List()) //Here using Set as we want unique no. of person.
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {

    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
    //network + (a -> (friendsA :+ b)) + (b -> (friendsB :+ a)) if using List instead of Set. we used set to avoid duplicates of friends in list.
  }


  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {

    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }

  val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))


  //no. of friends of a person
  // Jim,Bob,Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Jim", "Bob")
  val testNet = friend(jimBob, "Jim", "Mary")

  println(testNet)
  //Map(Bob -> Set(Jim), Mary -> Set(Jim), Jim -> Set(Bob, Mary))

  def nFriends(network: Map[String, Set[String]], person: String) : Int = {

    if (!network.contains(person)) 0
    else network(person).size
  }

  println(nFriends(testNet, "Jim"))


  //person with most friends
  def mostFreinds(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }




  //how many people have NO friends
  //if there is a social connection b/w people or not(yes or no)









}
