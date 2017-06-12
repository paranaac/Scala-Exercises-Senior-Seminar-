object HW2 {
  def main(args: Array[String]): Unit = {
    //=======PROBLEM 1=======
    def signum(x: Int): Int = {
      if (x > 0) 1 else if (x < 0) -1 else x
    }
    println("Signum[3]:\t" + signum(3))
    println("Signum[-5]:\t" + signum(-5))
    println("Signum[0]:\t" + signum(0))

    //=======PROBLEM 2=======
    def countdown(n: Int): Unit = {
      println((n to 0 by -1).mkString(", "))
    }
    print("Countdown[5]:\t")
    countdown(5)

    //=======PROBLEM 3=======
    def prod(s: String): Long = {
      s.foldLeft(1l)(_ * _)
    }
    println("Prod['Hello']:\t" + prod("Hello"))

    //=======PROBLEM 4=======
    def randomArray(n: Int): Array[Int] = {
      val arr1 = new Array[Int](n)
      for (x <- 0 to arr1.length - 1) arr1(x) = scala.util.Random.nextInt(n)
      arr1
    }
    print("randomArray[5]:\t"); for (x <- randomArray(5)) print(x + " ")

    //=======PROBLEM 5=======
    val arr2 = Array(1, 2, 3, 4, 5)
    def swapAdj(a: Array[Int]): Array[Int] = {
      val myArr = (for (i <- 0 to arr2.length - 1)
        yield if (i == arr2.length - 1) arr2(i)
      else if (i % 2 != 0) arr2(i - 1)
      else arr2(i + 1)).toArray
      myArr
    }
    val arr3 = swapAdj(arr2)
    print("\nOriginal[arr2]:\t"); for (x <- arr2) print(x + " "); println()
    print("swapAdj[arr2]:\t"); for (x <- arr3) print(x + " "); println()

    //=======PROBLEM 6=======
    def positiveNegative(a: Array[Int]): Array[Int] = {
      val posA = a.filter(_ > 0)
      val negA = a.filter(_ <= 0)
      val myArr2 = (posA ++ negA)
      myArr2
    }
    val arr4 = Array(6, 5, -3, 0, 2, 4, -6, -8)
    print("Original[arr4]:\t"); for (x <- arr4) print(x + " ");
    val arr5 = positiveNegative(arr4)
    print("\nposNeg[arr4]:\t"); for (x <- arr5) print(x + " "); println()
  }
}