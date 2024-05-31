sealed trait LL[+A]

case object Empty extends LL[Nothing]

case class Node[A](elem: A, next: LL[A]) extends LL[A]

object LL {
    def apply[A](as: A*): LL[A] = {
        if(as.isEmpty) Empty
        else Node(as.head, apply(as.tail: _*))
    }

    def tail[A](list: LL[A]): LL[A] = {
        list match {
            case Empty => Empty
            case Node(_, tail) => tail
        }
    }

    def headOption[A](list: LinkedList[A]): Option[A] = {
     list match {
       case Empty => None
       case Node(data, _) => Some(data) // Access the data of the first Node
     }
    }
  

    def append[A](elem: A, list: LL[A]): LL[A] = {
        list match {
            case Empty => Node(elem, Empty)
            case Node(head, tail) => Node(head, append(elem, tail))
        }
    }

    def prepend[A](elem: A, list:LL[A]): (Option[A], LL[A]) = {
        list match {
            case Empty => (None, Empty)
            case Node(head, tail) => (Some(head), tail)
        }
    }

    def indexOf[A](elem: A, list: LL[A], id: Int = 0): Int ={
        list match {
            case Empty => -1
            case Node(elem, next) => 
                if (head == elem) id
                else indexOf(elem, tail, id + 1)
        }
    }
}

def main(args: Array[String]): Unit = {
    val list = LL(1,2,3,4,5,6,7,8,9,10)
    println(list)
}