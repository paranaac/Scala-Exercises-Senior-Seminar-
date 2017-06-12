object HW6 {
  def main(args: Array[String]): Unit = {

    //=====PROBLEM #1=====
    import scala.io.Source
    println("====Original File====")
    val lines = Source.fromFile("src/file1.txt").getLines.toArray
    for (i <- lines) println(i)
    println()
    println("====Reversed Lines====")
    val linesInReverse = lines.reverse
    for (i <- linesInReverse) println(i)
    println()

    //=====PROBLEM #2=====
    println("====Words With More Than 12 Characters====");
    val wordsInFile = Source.fromFile("src/file1.txt").mkString.split("""\s+""");
    val longWords = wordsInFile.filter(_.length > 12)
    longWords.foreach(println _)
    println()

    //=====PROBLEM #3=====
    val lines2 = Source.fromFile("src/file2.txt").mkString.split("""\s+""");
    println("====Original File====")
    for (i <- lines2) println(i)
    println("====Numbers Information====")
    val numbers = lines2.map { x => (x.toDouble) }
    println("Sum: " + numbers.sum)
    println("Avg: " + numbers.sum / numbers.length)
    println("Max: " + numbers.max)
    println("Min: " + numbers.min)
  }
}