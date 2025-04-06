object Types {


  def main(args: Array[String]): Unit = {
    val someLevelOne = new myLevel1[Int](10)

    someLevelOne.show()
  }




  /*
   * Generics  : Level one generic that takes an level zero type argument
   */
  private class myLevel1[A](a: A) {
    def show(): Unit = print(a)
  }

  



}
