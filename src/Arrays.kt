fun main() {
//    linearSearch()
//    largestInArray()
//    binarySearch()
//    reverseArray()
//    pairsInArray()
//    printSubArrays()
//    maxSubArraySumUsingPrefixSumArray()
    kadaneAlgorithm()
}

fun linearSearch() {
    val numArray = arrayOf(12, 3, 23, 64, 33)
    val key = 64
    var index = -1
    val arraySize = numArray.size

    for (i in 0..<arraySize) {
        if (key == numArray[i]) {
            index = i
            break
        }
    }
    println(index)
}

fun largestInArray() {
    val numArray = arrayOf(23, 98, 8, 4, 334, 82, 56)
    var max = Int.MIN_VALUE

    numArray.forEachIndexed { idx, num ->
        if (max < num) {
            max = num
        }
    }
    println(max)
}

fun binarySearch() {
    val numArray = arrayOf(32, 45, 67, 75, 98, 134, 180)
    val key = 32
    var index = -1
    var start = 0
    var end = numArray.size - 1

    while (start <= end) {
        val mid = (start + end) / 2

        if (key == numArray[mid]) {
            index = mid
            break
        } else if (key < numArray[mid]) {
            end = mid
        } else {
            start = mid
        }
    }
    println(index)
}

fun reverseArray() {
    val numArray = arrayOf(32, 45, 67, 75, 98, 134, 180)
    var start = 0
    var end = numArray.size - 1

    while (start <= end) {
        val temp = numArray[start]
        numArray[start] = numArray[end]
        numArray[end] = temp
        start++
        end--
    }

    numArray.forEach {
        println(it)
    }
}

fun pairsInArray() {
    val numArray = arrayOf(2, 4, 6 ,8, 10)

    for (i in 0..<numArray.size - 1) {
        for (j in i + 1..<numArray.size) {
            print("(${numArray[i]}, ${numArray[j]}) ")
        }
        println()
    }
}

fun printSubArrays() {
    val numArray = arrayOf(2, 4, 6 ,8, 10)

    for (i in 0..<numArray.size) {
        for (j in i..<numArray.size) {
            for (k in i..j) {
                print("${numArray[k]} ")
            }
            println()
        }
    }
}

fun maxSubArraySumUsingPrefixSumArray() {
    val numArray = arrayOf(3, 7, -4, 9, 8, -2)
    val prefixSumArray = IntArray(numArray.size)
    val arraySize = prefixSumArray.size
    var maxSubArraySum = Int.MIN_VALUE

    prefixSumArray[0] = numArray[0]
    for (i in 1..<arraySize) {
        prefixSumArray[i] = prefixSumArray[i - 1] + numArray[i]
    }

    for (i in 0..<arraySize) {
        for (j in i..<arraySize) {
            val currentSum = if (i == 0) {
                prefixSumArray[j]
            } else {
                prefixSumArray[j] - prefixSumArray[i - 1]
            }
            if (maxSubArraySum < currentSum) {
                maxSubArraySum = currentSum
            }
        }
    }
    println(maxSubArraySum)
}

fun kadaneAlgorithm() {
    val numArray = arrayOf(-3, -7, -4, -9, -8, -2)
    var currentSum = 0
    var maxSum = Int.MIN_VALUE

    for (i in 0..<numArray.size) {
        currentSum += numArray[i]

        if (maxSum < currentSum) {
            maxSum = currentSum
        }
        if (currentSum < 0) {
            currentSum = 0
        }
    }
    println(maxSum)
}