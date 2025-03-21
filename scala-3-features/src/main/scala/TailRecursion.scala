
@tailrec
def tailRecursiveLength(list: List[String], accumulator: Long): Long = list match {
  case Nil => accumulator
  case head :: tail => tailRecursiveLength(tail, accumulator + 1)
}
