/*
    We start from last digit of second number multiply it with first number.
    Then we multiply second digit of second number with first number, and so on.
    We add all these multiplications. While adding, we put i-th multiplication shifted.
    The approach used in below solution is to keep only one array for result.
    We traverse all digits first and second numbers in a loop and add the result at appropriate position.
*/

export class LargeNumber {

    multiply(num1: String, num2: String): String {
        let len1 = num1.length
        let len2 = num2.length

        if (len1 == 0 || len2 == 0)
            return "0"

        // will keep the result number in vector in reverse order
        let result = new Array(len1 + len2).fill(0)

        // Below two indexes are used to
        // find positions in result.
        let indexN1 = 0
        let indexN2 = 0

        // Go from right to left in num1
        for (let i = len1 - 1; i > -1; i--) {
            let carry = 0
            let n1 = parseInt(num1[i])

            // To shift position to left after every
            // multiplication of a digit in num2
            indexN2 = 0

            // Go from right to left in num2
            for (var j = len2 - 1; j > -1; j--) {
                // Take current digit of second number
                let n2 = parseInt(num2[j])

                // Multiply with current digit of first number
                // and add result to previously stored result
                // at current position.
                let summ = n1 * n2 + result[indexN1 + indexN2] + carry

                // Carry for next iteration
                carry = Math.floor(summ / 10)

                // Store result
                result[indexN1 + indexN2] = summ % 10

                indexN2 += 1
            }

            // store carry in next cell
            if (carry > 0)
                result[indexN1 + indexN2] += carry

            // To shift position to left after every
            // multiplication of a digit in num1.
            indexN1 += 1

            // print(result)
        }
        // ignore '0's from the right
        let i = result.length - 1
        while (i >= 0 && result[i] == 0)
            i -= 1

        // If all were '0's - means either both or
        // one of num1 or num2 were '0'
        if (i == -1)
            return "0"

        result.reverse()
        return result.join("")
    }
}
