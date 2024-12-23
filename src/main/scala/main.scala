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
 */
class Bird extends flyable with Animal() with Builder {

   override def canFly: Boolean = true

   override def canSwim: Boolean = false

   override def toEat: Unit = println("Eating corn")

   override def build(): Unit = println("Building bird nest")
}