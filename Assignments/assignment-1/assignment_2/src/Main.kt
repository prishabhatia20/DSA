fun main() {
    // How would you reverse the elements in a stack
    // (i.e., put the elements at the top of the stack on the bottom and vice-versa)?
    // You can use as many additional stacks and queues as temporary storage in your approach.

    val stack = MyStack<String>()
    stack.push("Hello")
    stack.push(" ")
    stack.push("world")
    stack.push("!")
    stack.push(" ")
    stack.push("This")
    stack.push(" ")
    stack.push("is")
    stack.push(" ")
    stack.push("my")
    stack.push(" ")
    stack.push("homework")
    stack.push(".")


    val temp = MyQueue<String>()
    print("Original Stack: ")
    while (!stack.isEmpty()) {
        val element: String? = stack.pop()
        print(element)
        if (element != null) {
            temp.enqueue(element)
        }
    }


    while (!temp.isEmpty()) {
        val element: String? = temp.dequeue()
        if (element != null) {
            stack.push(element)
        }
    }

    println()
    print("Reversed Stack: ")
    while (!stack.isEmpty()) {
        print(stack.pop())
    }

}