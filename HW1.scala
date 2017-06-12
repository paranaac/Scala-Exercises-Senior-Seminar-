// HOMEWORK #1 - DATABASE QUERIES USING FOR YIELD EXPRESSIONS
object Books {
  def main(args:Array[String]): Unit = {
    case class Book(title: String, authors: List[String])
    val books: List[Book] = List(
        Book(title = "Structure and Interpretation of Computer Programs", authors = List("Abelson, Harald", "Sussman, Gerald J.")),
        Book(title = "Introduction to Functional Programming", authors = List("Bird, Richard", "Wadler, Phil")),
        Book(title = "Effective Java", authors = List("Bloch, Joshua")),  
        Book(title = "Effective Java 2", authors = List("Bloch, Joshua")), 
        Book(title = "Java Puzzlers", authors = List("Bloch, Joshua", "Gafter, Neal")),  
        Book(title = "Scala Cookbook", authors = List("Alvin Alexander")))

    // Find the titles of the books whose author's name is "Bird"
    val Q1 = for(x<-books; auth<-x.authors; if auth.contains("Bird,")) yield x.title
    println("QUERIES:\n1. " + Q1)
   
    // Find all the books which have the word 'Programming' in the title
    val Q2 = for(x<-books; if x.title.contains("Programming")) yield x.title
    println("2. " + Q2)
    
    // Find the names of all authors who have written two or more books (Don't Display Duplicates)
    val Q3 = for(x1<-books; x2<-books; if (x1.title<x2.title); a1<-x1.authors; a2<-x2.authors; if (a1==a2)) yield a1
    println("3. " + Q3.distinct)
  }
}
