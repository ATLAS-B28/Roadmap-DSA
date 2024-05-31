def main(args: Array[String]): Unit = {
    val x = 2
    x match {
        case 1 => println("One")
        case 2 => println("Two")
        case 5 => println("Five")
        case _ => println("Other")
    }

    /*
    Pattern matching can be used with various types in Scala, including:
    Literals: You can match against specific literal values like numbers, strings, or characters.
    Variables: You can match against variables to extract their values.
    Constructors: You can match against constructors of custom types to extract their values.
    Sequences: You can match against sequences (lists, arrays, etc.) to extract their elements.
    Tuples: You can match against tuples to extract their elements.
    */

    case class Person(name: String, age: Int) 

    val persons = Person("Abhijeet", 21)
    persons match
        case Person("Aditya", 21) => println("Aditya is 21 years old")
        case Person(name, age) => println(s"$name is $age years old.")

    val nums2 = List(1,2,3,4,5)
    nums2 match {
        case List(1,2,3) => println("First three numbers are 1, 2, 3")
        case List(a, b, c, d, e) => println(s"First element: $a, last element: $e")
        case _ => println("No match") 
    }
    
}