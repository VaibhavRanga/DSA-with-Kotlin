fun main() {
//    linearSearch()
    binarySearch()
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

fun binarySearch() {
    val numArray = arrayOf(32, 45, 67, 75, 98, 134, 180)
    val key = 180
    var index = -1
    var start = 0
    var end = numArray.size - 1

    while (start <= end) {
        val mid = (start + end) / 2

        if (key == numArray[mid]) {
            index = mid
            break
        } else if (key < numArray[mid]) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    println("Index: $index")
}