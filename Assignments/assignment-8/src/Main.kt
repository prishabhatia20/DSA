//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val tree = RedBlackTree()
    tree.insert(0)
    tree.printTree(true)
    tree.insert(1)
    tree.printTree(true)
    tree.insert(5)
    tree.printTree(true)
    print(tree.lookup(0))
    print(tree.lookup(20))
}