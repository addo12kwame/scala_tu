import scala.annotation.targetName
import scala.collection.mutable.ArrayBuffer

/*
 * Author : Kwame
 * Date : 12/23/2024
 */


/*
 * Using the @main annotation, the hello() is wrapped, made entry to the code
 */
@main def hello(): Unit = {
   println("Hello")
   val a: Dog = new Dog("Bruno")
   a.x = "kiki"
   a.toEat
   println(a.writeName(getName))
   val x = 3

   assert(x == 3) // Using the assert statement in scala

   // Using Option to counter the null pointer exception
   val g: Option[Int] = if 1 + x == 4 then Some(3) else null
   println(g.get)


   // You can omit the parenthesis
   val aBat = new Bat
   println(aBat.canFly)
   aBat.impTrue



   val aBird = new Bird


   // This is called infix notation
   // When you have a method that has only one argument it can be called this way
   // The signature is infix notation = OBJECT METHOD ARGUMENT
   // This is the same as aBird.eats("Corn")
   aBird eats "Corn" // == aBird.eats("Corn")


//   anonymous class

   val phil1 = new Philosopher {
      def ?!(thought: String): Unit = {
         println(thought)
      }
   }

//   Using infix notation
   phil1 ?! "I am a good boy"


   Mysingleton("Kwame")



   println(Dog.canLiveIndefinitely)


   // Case class instantiated which is the same as calling the apply method
   val personOne = Person("Kwame",30) //Person.apply("Kwame", 30)


   val someString : String = null

   try
      println(someString.length)
   catch // This is how or signature for the try, catch and finally clause
      case e: Exception => println("Some error occurred")

   finally
      println("Issue resolved")


   val aniImpl : AniImpl[String] = new AniImpl[String]
   aniImpl.add("Dog")
   aniImpl.add("Cat")
   aniImpl.add("Fish")
   aniImpl.printList()
}



/*
 * Mammal implements the animal trait
 */
class Mammal(var x : String ) extends Animal{
   override def toEat: Unit = {
      println("I am eating")
   }
}



def getName(): String  = {
   "kwame"
}


/*
 * Traits are like interfaces but can have implementations
 */
trait Animal {
   def toEat: Unit
}


/*
 * Fields in scala are by default public
 * You can restrict by using private or protected
 * Private only the class has access to the method
 * Protected means descendants have access to the field or method
 */
class Dog(t: String) extends Mammal(t) {
   val y = 10
   def writeName(fun : ()=> String): String = {
      fun()
   }
}


/*
 * Bat extends the abstract class flyable and implements the canFly and canSwim methods
 * Notice that the already implemented from the abstract class is fine
 */
class Bat extends flyable{
   override def canFly: Boolean = true
   override def canSwim: Boolean = true
}



/*
 *This abstract classes have methods that needs to be implemented
 *It also can have methods that are already implemented
 */
abstract class flyable {
   def canFly: Boolean
   def canSwim: Boolean
   def impTrue: Unit = println(" This is implemented")
}


/*
 *Creating a trait (Interface)
 */
trait Builder() {
   def build(): Unit
}


/*
 * You can extend one class but implement multiple traits like below
 * You can chain multiple trait using the "with" keyword
 * Multi trait is called " Mixin"
 */
class Bird extends flyable with Animal() with Builder {

   override def canFly: Boolean = true

   override def canSwim: Boolean = false

   override def toEat: Unit = println("Eating corn")

   override def build(): Unit = println("Building bird nest")

   def eats(x :String): Unit = println(s" Bird is eating $x")
}


def printWord(x: String): Unit = println(x)

trait Philosopher {
   def ?!(thought: String): Unit // ?! is a valid method
}


/*
 * Object type is a singleton object
 * It creates a class and also get a single instance of the class Mysingleton
 * Only that instance exists
 * You can also create an "apply" method in the singleton instance and
 * Call it as Mysingleton.apply(x) or Mysingleton(x)
 */
object Mysingleton {
   val name : String = "My first singleton object"
   val notes : String =
      """
        |This is singleton can only be instantiated once.
        |In this case you can just use the name of the instance and you good to go
        |Mysingleton.field or Mysingleton.method()
        |""".stripMargin

   def apply(x: String) = println(
      f"""Singleton $x can be called like a method when apply is implemented
         |Mysingleton() == Mysingleton.apply()
         |""".stripMargin)
}


/*
 * Companions can access each other's private fields/methods
 * NB: the object cannot access fields/methods of instance of the companion class
 * Singleton Dog and instances of Dog are different things
 * Companion helps you define static fields/methods
 */
object Dog {
val canLiveIndefinitely = false
}

/*
 * Case classes
 * Case classes = lightweight data structures with some boilerplate
 * sensible equals and hash code
 * quick serialization
 * Implicit companion with apply method. You can instantiate without the new key word
 * like val newPerson = Person("kwame",29)
 */
case class Person(name: String,age: Int) {
}

abstract class MyAnimals[T] {
   val myList: ArrayBuffer[T]
   def printList(): Unit
   def add(x: T): Unit
}


class AniImpl[T] extends MyAnimals[T] {

   override val myList: ArrayBuffer[T] =  new ArrayBuffer[T]()
   override def add(x : T): Unit = myList += x
   override def printList(): Unit = myList.foreach(x=> println(x))
}