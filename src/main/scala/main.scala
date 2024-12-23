@main def hello(): Unit = {
   println("Hello")
   val a: Dog = new Dog("Bruno")
   a.x= "kiki"
   a.toEat()
   println(a.writeName(getName))
   val x = 3
   assert(x == 3)
   val g: Option[Int] = if 1 + x == 4 then Some(3) else null
   print(g.get)
}

class Mammal(var x : String ) extends Animal{
   override def toEat(): Unit = {
      println("I am eating")
   }

}

def getName(): String  = {
   "kwame"
}

trait Animal {
   def toEat(): Unit
}

class Dog(t: String) extends Mammal(t) {
   val y = 10

   def writeName(fun : ()=> String): String = {
      fun()
   }
}
