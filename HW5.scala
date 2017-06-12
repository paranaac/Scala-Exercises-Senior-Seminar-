//=======PROBLEM 1=======
import scala.collection.mutable.ArrayBuffer
abstract class Item {
  def price: Double
  def description: String
}
class SimpleItem(val description: String, val price: Double) extends Item {}

class Bundle extends Item {
  var itemList = ArrayBuffer.empty[Item]
  def price: Double = {
    var sum = 0.0
    for (i <- itemList) {
      sum = sum + i.price;
    }
    sum
  }
  def description: String = {
    var descr = ""
    var count = 1;
    for (i <- itemList) {
      descr += "Item #" + count + ": " + i.description + " ($" + i.price + ")\n"
      count += 1
    }
    descr
  }
  def addItemToBundle(item: Item) = {
    itemList += item
  }
}

//=======PROBLEM 2=======
class Point(val x: Double, val y: Double) {
  def coordinates: String = "[x: " + x + ", y: " + y + "]"
}
class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y) {
  def description: String = "Label: " + label + " " + coordinates
}

//=======PROBLEM 3=======
abstract class Shape {
  def centerPoint: Point
}
class Square(val x: Double, val y: Double, val width: Double, val height: Double) extends Shape {
  def centerPoint = new Point(x + width / 2, y + height / 2)
}
class Circle(val midPoint: Point, val radius: Double) extends Shape {
  def centerPoint = midPoint
}

//=======PROBLEM 4=======
class Square2(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {
  def this(width: Int) {
    this(0, 0, width)
  }
  def this() {
    this(0, 0, 0)
  }
}

object HW5 {
  def main(args: Array[String]): Unit = {

    //=======PROBLEM 1=======
    val s1 = new SimpleItem("Wireless Mouse", 9.95)
    val s2 = new SimpleItem("Mechanical Keyboard", 75.25)
    val s3 = new SimpleItem("4K Monitor", 675.99)
    val pcBundle = new Bundle

    pcBundle.addItemToBundle(s1)
    pcBundle.addItemToBundle(s2)
    pcBundle.addItemToBundle(s3)

    print("Items in your bundle:\n" + pcBundle.description)
    println("Total bundle price: $" + pcBundle.price)
    println()

    //=======PROBLEM 2=======
    val p1 = new LabeledPoint("Black Thursday", 1929, 230.07)
    println(p1.description)
    println()

    //=======PROBLEM 3=======
    val pt1 = new Point(23.0, 45.0)
    val c1 = new Circle(pt1, 16)
    println("Circle midpoint: " + c1.centerPoint.coordinates)

    val sq1 = new Square(33, 33, 40, 40)
    println("Square midpoint: " + sq1.centerPoint.coordinates)
    println()

    //=======PROBLEM 4=======
    val square1 = new Square2()
    println(square1)

    val square3 = new Square2(100)
    println(square3)

    val square2 = new Square2(44, 33, 90)
    println(square2)
  }
}