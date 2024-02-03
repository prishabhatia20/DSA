fun main() {
    // How would you reverse the elements in a stack
    // (i.e., put the elements at the top of the stack on the bottom and vice-versa)?
    // You can use as many additional stacks and queues as temporary storage in your approach.

    // Create stack & add Strings to it
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


    // Create a temp queue
    val temp = MyQueue<String>()
    print("Original Stack: ")

    // Iterate through the stack, pop the top element off, and add it to the queue
    while (!stack.isEmpty()) {
        val element: String? = stack.pop()
        print(element)
        if (element != null) {
            temp.enqueue(element)
        }
    }


    // Iterate through the queue, pop the bottom element off, and add it to the stack
    while (!temp.isEmpty()) {
        val element: String? = temp.dequeue()
        if (element != null) {
            stack.push(element)
        }
    }

    // Print the final reversed stack
    println()
    print("Reversed Stack: ")
    while (!stack.isEmpty()) {
        print(stack.pop())
    }

}