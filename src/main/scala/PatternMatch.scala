object PatternMatch extends App {
/*
 * This will be about pattern matching
 *  val variable = object match {
 *      case object(n,a) => f"$n do something with n or do something with $a"
 * }
 */


  val tuple = ("Kwame", "Ama")
  val pat = tuple match
    

    /*
     * Pattern match with tuple
     */
    case (first, last) => f"$first is a boy and $last is a girl"
  println(pat)
//
//  val patObject = Person match
//    case Person(n, a) => f"My name is $n and I am $a years old"
    
    
//  println(patObject)
val x: Person = Person("Kwame", 29)

  c(x)


  val someName: kwame = "kwame"
}

case class Person(name: String, age: Int) {
  def apply(): Unit = {
    println(
      f"""Your name is $name
         |Your age is $age
         |""".stripMargin)
  }

}


type kwame = String


def c(person: Person): Unit = person match
  case Person(first, second) => println(s"$first -> $second")
  case _ => println("Match")



