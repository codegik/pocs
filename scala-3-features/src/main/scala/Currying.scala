/** 
 * Currying is the process of converting a function with multiple arguments into a sequence of functions 
 * that take one argument. Each function returns another function that consumes the following argument.
 */
  
def add(x: Int)(y: Int): Int = x + y

def addThree(x: Int)(y: Int)(z: Int): Int = x + y + z