
fun main() {
    val expected =
        "0 59 38 33 30 17 8 63 \n" +
        "37 34 31 60 9 62 29 16 \n" +
        "58 1 36 39 32 27 18 7 \n" +
        "35 48 41 26 61 10 15 28 \n" +
        "42 57 2 49 40 23 6 19 \n" +
        "47 50 45 54 25 20 11 14 \n" +
        "56 43 52 3 22 13 24 5 \n" +
        "51 46 55 44 53 4 21 12 \n"
    val result =  KnightTour().solve()

    println(expected)
    println(result)

    if (expected == result) {
        println("Correct solution")
    } else {
        println("Wrong solution")
    }
}
