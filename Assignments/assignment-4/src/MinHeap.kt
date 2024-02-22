class MinHeap {

    private var heap:MutableList<Int> = mutableListOf()

    fun insert(element: Int) {
        heap.add(element)

        var index = heap.lastIndex

        while (index > 0 && heap[(index - 1) / 2] > heap[index]) {
            val parent = (index - 1) / 2
            val temp = heap[index]
            heap[index] = heap[parent]
            heap[parent] = temp

            index = parent

        }

    }

    fun getHeap(): MutableList<Int> {
        return heap
    }

    private fun bubbleDown(index: Int, size: Int) {
        while (true) {
            var left = 2 * index + 1
            var right = 2 * index + 1
            var smallest = index

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left
            }
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right
            }
            if (smallest != index) {
                val temp = heap[index]
                heap[index] = heap[smallest]
                heap[smallest] = temp
            }
            else {
                break
            }
        }
    }

    fun delete(element: Int) {
        var index = 0
        var size = heap.lastIndex
        for (i in 0..size) {
            if (heap[i] == element) {
                index = i
                break
            }
        }

        heap.removeAt(index)
        bubbleDown(index, size)


    }

    fun peek(): Int {
        return heap[0]
    }

}