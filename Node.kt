/** 
* Node Class 
* Shows the basics of linking nodes.
*/
data class Node<T>(var value: T, var next: Node<T>? = null){
    override fun toString(): String{
        return if (next != null){
            "$value -> ${next.toString()}"
        }
        else{
            "$value"
        }
    }
}

fun main(){
    //linking nodes
    val nodeA = Node(value = 1) 
    val nodeB = Node(value = 2) 
    val nodeC = Node(value = 3) 
    val nodeD = Node(value = 4) 

    nodeA.next = nodeB
    nodeB.next = nodeC
    nodeC.next = nodeD
    println(nodeA)



}