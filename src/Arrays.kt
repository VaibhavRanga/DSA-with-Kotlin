import kotlin.math.*

fun main() {
//    largestInArray()
//    reverseArray()
//    pairsInArray()
//    printSubArrays()
//    maxSubArraySumUsingPrefixSumArray()
//    kadaneAlgorithm()
//    rainwaterTrapping()
//    buySellStockForMaxProfit()
    duplicatesInArray()
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

fun rainwaterTrapping() {
    val numArray = arrayOf(4, 2, 0, 6, 3, 2, 5)

    val leftMaxArray = IntArray(numArray.size)
    leftMaxArray[0] = numArray[0]
    for (i in 1..<numArray.size) {
        leftMaxArray[i] = max(leftMaxArray[i - 1], numArray[i])
    }

    val rightMaxArray = IntArray(numArray.size)
    rightMaxArray[rightMaxArray.size - 1] = numArray[numArray.size - 1]
    for (i in numArray.size - 2 downTo 0) {
        rightMaxArray[i] = max(numArray[i], rightMaxArray[i + 1])
    }
    var answer = 0
    for (i in 0..<numArray.size - 1) {
        val waterLevel = min(leftMaxArray[i], rightMaxArray[i])
        answer += (waterLevel - numArray[i])
    }

    println(answer)
}

fun buySellStockForMaxProfit() {
    val numArray = arrayOf(7, 1, 5, 3, 6, 4)
    var maxProfit = Int.MIN_VALUE
    var buyPrice = Int.MAX_VALUE

    for (i in 0..<numArray.size) {
        if (buyPrice < numArray[i]) {
            val profit = numArray[i] - buyPrice
            maxProfit = max(maxProfit, profit)
        } else {
            buyPrice = numArray[i]
        }
    }

    println(maxProfit)
}

fun duplicatesInArray() {
    val numArray = arrayOf(1, 2, 3, 3)
    var areDuplicates = false

    for (i in 0..<numArray.size) {
        for (j in i + 1..<numArray.size) {
            if (numArray[i] == numArray[j]) {
                areDuplicates = true
            }
        }
    }
    println(areDuplicates)
}