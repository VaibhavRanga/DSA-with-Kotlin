fun main() {
    bubbleSort()
    selectionSort()
}

fun bubbleSort() {
    val numArray = arrayOf(5, 4, 1, 3, 2)

    for (i in 0..<numArray.size - 1) {
        var swaps = 0
        for (j in 0..<numArray.size - 1 - i) {
            if (numArray[j] > numArray[j + 1]) {
                swaps++
                val temp = numArray[j]
                numArray[j] = numArray[j + 1]
                numArray[j + 1] = temp
            }
        }
        if (swaps == 0) {
            break
        }
    }

    for (i in 0..<numArray.size) {
        print("${numArray[i]} ")
    }
    println()
}

fun selectionSort() {
    val numArray = arrayOf(5, 4, 1, 3, 2)

    for (i in 0..<numArray.size - 1) {
        var minPos = i
        for (j in i + 1..<numArray.size) {
            if (numArray[minPos] > numArray[j]) {
                minPos = j
            }
        }
        val temp = numArray[minPos]
        numArray[minPos] = numArray[i]
        numArray[i] = temp
    }

    for (i in 0..<numArray.size) {
        print("${numArray[i]} ")
    }
    println()
}