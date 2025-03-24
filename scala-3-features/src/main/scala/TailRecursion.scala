import scala.annotation.tailrec

@tailrec
def tailRecursiveLength(list: List[String], accumulator: Long = 0): Long = list match {
  case Nil => accumulator
  case head :: tail => tailRecursiveLength(tail, accumulator + 1)
}

def recursiveLength(list: List[String]): Long = list match {
  case Nil => 0
  case head :: tail => 1 + recursiveLength(tail)
}