object HW7 {
  def main(args: Array[String]): Unit = {

    // ====PROBLEM #1====
    def values(fun: (Int) => Int, low: Int, high: Int) = {
      (low to high by 1).map(i => (i, fun(i))).mkString(", ")
    }
    println("Results: " + values(x => x * x, -5, 5) + "\n")

    // ====PROBLEM #2====
    val arrMax = Array(22, 0, -1, 29, 11).reduceLeft(Math.max(_, _))
    println("Max: " + arrMax + "\n");

    // ====PROBLEM #3====
    def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
      inputs.map(fun).reduceLeft(Math.max(_, _))
    }
    println("Max result: " + largest(x => 10 * x - x * x, 1 to 10))

    // ====PROBLEM #4====
    def largestAt(fun: (Int) => Int, inputs: Seq[Int]) = {
      // maxBy: Finds element which yields the largest
      // value measured by function fun (Scaladoc)
      inputs.maxBy { fun }
    }
    val maxInput = largestAt(x => 10 * x - x * x, 1 to 10)
    println("\nMax input: " + maxInput + "\n")

    // ====PROBLEM #5====
    val arrOfStrings = Array("Hello", "Hey", "Hi", "Howdy")
    val arrOfInts = Array(5, 3, 2, 5)
    val sameLength = arrOfStrings.corresponds(arrOfInts)(_.length == _)

    print(arrOfStrings.mkString(", ") + " == " + (arrOfInts.mkString(", ")))
    println("\nSame length: " + sameLength)
  }
}