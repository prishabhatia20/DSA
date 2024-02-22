fun insertionSort(list: MutableList<Int>): MutableList<Int> {
    val size = list.lastIndex

    for (index in 1..size) {
        val curr = list[index]

        var prev = index - 1

        while (prev >= 0 && curr < list[prev]) {
            list[prev + 1] = list[prev]
            prev -= 1

        }
        list[prev + 1] = curr
    }

    return list
}




