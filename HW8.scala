object HW8 {
  def main(args: Array[String]): Unit = {

    //======PROBLEM #2======
    def arrToTwoDim(array: Array[Double], col: Int): Array[Array[Double]] = {
      val myArr = array.grouped(col).toArray.map(_.toArray)
      myArr
    }
    val arr: Array[Double] = Array(1, 2, 3, 4, 5, 6)
    println("arr: " + arr.mkString(", "))
    println("twoDimArr col = 3: ")
    val twoDimArr = arrToTwoDim(arr, 3)
    print(twoDimArr.map(_.mkString(" ")).mkString("\n"))

    println("\ntwoDimArr col = 2: ")
    val twoDimArr2 = arrToTwoDim(arr, 2)
    print(twoDimArr2.map(_.mkString(" ")).mkString("\n"))

    //======PROBLEM #3======
    val arr2 = Array("Tom", "Fred", "Harry")
    val map = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)

    def intsInCollection(array: Array[String], map: Map[String, Int]) = {
      array.flatMap(map.get(_))
    }
    print("\narr2: " + arr2.mkString(", ") + "\nMap: ")
    for ((k, v) <- map) printf("%s -> %s  ", k, v)
    println("\nInts corresponding to array: " +
      intsInCollection(arr2, map).mkString(", "))
  }
}