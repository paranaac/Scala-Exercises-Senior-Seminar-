import java.util.Scanner
import java.io.File

object HW3 {
  def main(args: Array[String]): Unit = {
    // =========PROBLEM #1============
    def wordCount(file: String): Map[String, Int] = {
      var mp = Map.empty[String, Int].withDefaultValue(0)
      val sc = new Scanner(new File(file)).useDelimiter("[ ,.]+")
      while (sc.hasNext) {
        val token = sc.next().toUpperCase()
        mp = mp + (token -> (mp(token) + 1))
      }
      mp
    }
    /*  ===myFile===
     *  "The fact that some geniuses were laughed at does not imply that
     *  all who are laughed at are geniuses. They laughed at Columbus, they
     *  laughed at Fulton, they laughed at the Wright Brothers.
     *  But they also laughed at Bozo the Clown" - Carl Sagan
     *  ============
     */
    val myMap = wordCount("myFile")
    for ((k, v) <- myMap) println("\"" + k + "\"" + " occurs " +
      v + (if (v == 1) " time." else " times."))

    // =========PROBLEM #2============ 
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val props: scala.collection.Map[String, String] = System.getProperties()
    var max = 0
    for (k <- props.keySet) {
      if (k.length > max)
        max = k.length
    }
    for ((k, v) <- props) println(k.padTo(max, ' ') + " | " + v)

    // =========PROBLEM 3#============ 
    def Iteqgt(values: Array[Int], v: Int) = {
      val lt = values.count(_ < v)
      val eq = values.count(_ == v)
      val gt = values.count(_ > v)
      println((lt, eq, gt))
    }
    val myArr = Array(1, 4, 2, 5, 7, 0, -1, -2, -3)
    print("myArr: ")
    for (k <- myArr) print(k + " ")
    print("\nMy triple (<,=,>): ");
    Iteqgt(myArr, 2) // 5,1,3 expected
  }
}