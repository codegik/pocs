/** 
 * Partial application is the process of reducing the number of arguments by applying some of them 
 * when the method or function is created. 
 */
  
  
def sum(x: Int, y: Int => Int): Int = y(x)

def multiply(x: Int)(y: Int): Int = x * y