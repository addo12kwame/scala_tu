object Functional  {
  class Person(name: String) {
    def apply(age: Int): Unit = println(f"$name is $age years old")
  }

  def main(args: Array[String]): Unit = {
    val person1 = new Person("Kwame")
    person1(29) // === to the person1.apply(29)
    /*
 * Scala runs on jvm
 * Functional programming
 * - compose functions
 * - pass functions as arguments
 * - return functions as results
 */


    val myList = List(19, 25, 36).map(x => x % 10)
    println(myList)




    //val stringCon = new Function[String,String]{
    //  override def apply(v1: String): String = v1 + "Kwame"
    //  }

    // Regular map
    val map1 = List(1, 2, 3, 4).map(x => x + 1)

    // Flatmap with filter changed
    val map2 = List(1, 2, 3, 4).flatMap(x => List(x, x * x))
    //  .filter(x=>x%2 == 0)


    // We can always write filter even shorter with .filter(_ %2 == 0) which is the same as .filter(x=>x%2 == 0)
    // This eliminates the repeating x twice
    println(map2.filter(_ % 2 == 0))


    // For comprehension
    val t = for {
      j <- List(1, 2, 3)
      p <- List("a", "b", "c")
    } yield f"$j - $p"


    var aList = List("a", "b", "c")


    val aList2: List[String] = aList.flatMap(x => List("b"))

    aList = "a" +: aList

    val newSet = aList.toSet
    println(aList2)
    //println(newSet)
    //println(t)


    val patMatch = aList(3) match
      case "a" => "Found"
      case "b" => "This is B"
      case _ => "This is C"


    println(patMatch)
    println(t)
    //println(stringCon("I love Scala"))


    val oneHalf = new Rational(1, 2)
    val someLarge = new Rational(66, 42)
    val twoThirds = new Rational(2,3)

    val answer = oneHalf * twoThirds + oneHalf

    println(answer)
  }


}