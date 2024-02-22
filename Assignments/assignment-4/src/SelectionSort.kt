fun selectionSort(list: MutableList<kotlin.Int>): MutableList<kotlin.Int> {

    var swap_index = 0
    val size = list.lastIndex

    for (i in (0..size)) {
        var min_elem = list[i]
        for (j in (i + 1..size)) {
            if (list[j] < min_elem) {
                min_elem = list[j]
                swap_index = j
            }
        }
        var temp = list[i]
        list[i] = min_elem
        list[swap_index] = temp
    }

    return list
}
