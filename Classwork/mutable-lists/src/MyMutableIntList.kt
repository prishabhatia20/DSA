class MyMutableIntList {

    var myArray = intArrayOf()
    var next_slot:Int = 0

    /**
     * Add [element] to the end of the list
     */
    fun add(element: Int) {
        if (myArray.isEmpty()) {
            myArray = IntArray(1)
            myArray[next_slot] = element
        }
        if (myArray.size - 1 > next_slot) {
            myArray[next_slot] = element
        }
        else {

            val temp_list = myArray
            myArray = IntArray(myArray.size * 2)
            for (i in 0..next_slot) {
                myArray[i] = temp_list[i]
            }
        }

        next_slot += 1


    }

    /**
     * Remove all elements from the list
     */
    fun clear() {
        myArray = IntArray(myArray.size)
    }

    /*
     * @return the size of the list
     */
    fun size(): Int {
        return myArray.size

    }

    /**
     * @param index the index to return
     * @return the element at [index]
     */
    operator fun get(index: Int):Int {
        return myArray[index]

    }

    /**
     * Store [value] at position [index]
     * @param index the index to set
     * @param value to store at [index]
     */
    operator fun set(index: Int, value: Int) {
        myArray[index] = value

    }
}