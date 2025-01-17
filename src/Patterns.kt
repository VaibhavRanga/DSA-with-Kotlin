fun main() {
    val n = 5

    for (row in 0..<n) {
        for (col in 0..<n) {
            if (row - col >= 0) {
                print("* ")
            }
        }
        println()
    }

    println()

    for (row in 0..<n) {
        for (col in 0..<n) {
            if (row + col >= n - 1) {
                print("* ")
            } else {
                print("  ")
            }
        }
        println()
    }

    println()

    for (row in 0..<n) {
        for (stars in 0..row) {
            print("*")
        }
        for (spaces in 0..<(2 * (n - row - 1))) {
            print(" ")
        }
        for (stars in 0..row) {
            print("*")
        }
        println()
    }
    for (row in n - 1 downTo 0) {
        for (stars in 0..row) {
            print("*")
        }
        for (spaces in 0..<(2 * (n - row - 1))) {
            print(" ")
        }
        for (stars in 0..row) {
            print("*")
        }
        println()
    }

    println()

    for (row in 0..<n) {
        for (spaces in 0..<n - row - 1) {
            print(" ")
        }
        var count = row + 1
        for (num in 0..row) {
            print(count--)
        }
        count = 2
        for (num in 1..row) {
            print(count++)
        }
        println()
    }

    println()

    for (row in 0..<n) {
        for (spaces in 0..<n - row - 1) {
            print(" ")
        }
        for (num in 0..row) {
            print("${row + 1} ")
        }
        println()
    }
}