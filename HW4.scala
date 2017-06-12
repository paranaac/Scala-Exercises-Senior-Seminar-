// =====Problem 1=====
class Time(val hours: Int, val minutes: Int) {
  def before(other: Time): Boolean = {
    ((hours < other.hours) ||
      (hours == other.hours && minutes < other.minutes))
  }
}

// =====Problem 2=====
class Person(var age: Int = 0) {
  if (age < 0) age = 0
}

// =====Problem 3=====
// Val prevents it from being changed
// A parameter without val or var used inside at least one method it becomes a field.
class Person2(val name: String = "") {
  val nameSplit = name.split(' ')
  val fName = nameSplit(0)
  val lName = nameSplit(1)
}

// =====Problem 4=====
// The primary constructor
// It has explicit optional default values so the others are not necessary
class Car(val manf: String, val model: String, val year: Int = -1, val plate: String = "") {
  def this(manf: String, model: String, plate: String) = {
    this(manf, model, -1, plate)
  }
  def this(manf: String, model: String, year: Int) = {
    this(manf, model, year, "")
  }
  def this(manf: String, model: String) = {
    this(manf, model, -1, "")
  }
}

// =====Problem 5=====
// This form is better because it's more concise and easier to debug
class Employee(val name: String = "John Q. Public", var salary: Double = 0.0)

// =====Problem 6=====
object Conversions {
  def inchesToCentimeters(in: Double) = (2.54 * in)
  def gallonsToLiters(gal: Double) = (3.78541 * gal)
  def milesToKilometers(m: Double) = (1.60934 * m)
}

// =====Problem 7=====
class UnitConversion(val fact: Double) {
  def convert(x: Double) = fact * x
}
object inchesToCentimeters extends UnitConversion(2.54)
object gallonsToLiters extends UnitConversion(3.78541)
object milesToKilometers extends UnitConversion(1.60934)

// =====Problem 8=====
class Points(val xPt: Int, val yPt: Int) extends java.awt.Point(xPt, yPt)

object Points {
  def apply(x: Int, y: Int) = new Points(x, y)
}

object HW4 {
  def main(args: Array[String]): Unit = {
    println("=====Problem 1=====")
    val t1 = new Time(22, 15)
    val t2 = new Time(11, 30)
    val t3 = new Time(11, 31)
    println("11:30 before 22:15 = " + t2.before(t1))
    println("22:15 before 11:30 = " + t1.before(t2))
    println("11:30 before 11:31 = " + t2.before(t3))
    println("11:31 before 11:30 = " + t3.before(t2))

    println("=====Problem 2=====")
    val p1 = new Person(-15)
    println("Person 1 age = " + p1.age)
    val p2 = new Person(15)
    println("Person 1 age = " + p2.age)

    println("=====Problem 3=====")
    val p3 = new Person2("Bob Smith")
    println(p3.lName + ", " + p3.fName)
    val p4 = new Person2("Jon Snow")
    println(p4.lName + ", " + p4.fName)

    println("=====Problem 4=====")
    val c1 = new Car("Chevrolet", "Sonic")
    println("C1 manf: " + c1.manf + "  C1 model: " + c1.model)
    println("C1 plate: " + c1.plate + "  C1 year: " + c1.year + "\n")
    val c2 = new Car("Ford", "Bronco", 1996, "CLY-7201")
    println("C2 manf: " + c2.manf + "  C2 model: " + c2.model)
    println("C2 plate: " + c2.plate + "  C2 year: " + c2.year)

    println("=====Problem 5=====")
    val e1 = new Employee()
    println("Name: " + e1.name + " Salary: " + e1.salary)
    val e2 = new Employee("Joe Blue", 50000)
    println("Name: " + e2.name + " Salary: " + e2.salary)

    println("=====Problem 6=====")
    println(Conversions.inchesToCentimeters(55))
    println(Conversions.gallonsToLiters(6))
    println(Conversions.milesToKilometers(100))

    println("=====Problem 7=====")
    println(inchesToCentimeters.convert(55))
    println(gallonsToLiters.convert(6))
    println(milesToKilometers.convert(100))

    println("=====Problem 8=====")
    val pt1 = Points(3, 4)
    println(pt1)
    val pt2 = Points(9, 6)
    println(pt2)
  }
}