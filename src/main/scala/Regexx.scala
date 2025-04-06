object Regexx extends App {




  val email = "k".r
  val mylist = List("a","b")
  val arr = List("1", "3", "3", "7", "c", "0", "d", "3")


//  val fin: List[Char] = arr.filter(x => "[^\\s]".r.matches((x.toString)))
//    .map(x => ("\\w".r) replaceAllIn(x, "T") charAt(0))


  val fin: List[Char] = arr.filter(x => "[^\\s]".r.matches((x.toString)))
    .map(x => ("\\w".r) replaceAllIn(x, "T") charAt (0))


  val answer = email.replaceAllIn("kwame","x" )

  println(answer)

  var someV:String = ""
  for a <- fin do { someV += a }

  println(someV)
}
