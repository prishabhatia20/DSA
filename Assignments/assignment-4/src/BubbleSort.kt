fun bubbleSort(list: MutableList<Int>): MutableList<Int> {
    val size = list.lastIndex

    for (i in 0..size) {
        var swapped = false

        for (j in 0..size - i - 1) {
            if (list[j] > list[j + 1]) {
                var temp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temp
                swapped = true
            }
        }
        if (!swapped) {
            break
        }
    }
    return list
}