def main(args: Array[String]): Unit = {
    //list - linear collection of elements that can of the type. it can be mutable and immutable
    val nums = List(1,2,3,4,5)
    val evenNum = nums.filter(_ % 2 == 0)
    println(evenNum)
    //mutable list
    val nums2 = collection.mutable.ListBuffer(1,2,3,4,5,6,7,8,9,10)
    nums2 += 6
    nums2 -= 4
    println(nums2.mkString(", "))
    //set - unordered collection unique elements, can be mutable and immutable
    val fruits = Set("apple", "banana", "orange")
    val moreFruits = fruits + "grape"
    println(moreFruits)
    //mutable set using hashset
    val fruits2 = collection.mutable.HashSet("apple", "banana", "orange")
    fruits2 += "grape"
    fruits2 -= "banana"
    println(fruits2.mkString(", "))
    //map - unordered collection of key-value pairs, can be mutable and immutable
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    println(colors("red"))
    println(colors.keys)
    println(colors.values)
    //mutbale map
    val studentScore = collection.mutable.Map("Aditya" -> 90, "Ajith" -> 85, "Abhijit" -> 95)
    studentScore("Aditya") = 100
    for score <- studentScore do println(score)
    //option - a type that can be either Some or None
    val someValue: Option[Int] = Some(47)
    val value = someValue.getOrElse(0)
    println(value)
    //tuple - a fixed-size collection of elements of same type.
    val pair = ("Aditya", 21, "Vienna")
    val (name, age, city) = pair
    println(s"Name: $name, Age: $age, City: $city")
    //mutable tuple
    val persons = collection.mutable.ArrayBuffer("Aditya", 21, "Paris")
    persons(0) = "Abhijit"
    println(persons.mkString(", "))
    //array - fixed-sized chunks of memory reserved
    val nums1 = Array(1,2,3,4,5,6)
    println(nums1(0))
    val names = Array("Aditya", "Ajathshatru", "Abhijit")
    println(names.mkString(", "))
}