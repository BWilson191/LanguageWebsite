/**
* Author: Samantha Farmer
* Description: Shows a linked list in Kotlin with push & pop operations.
*/
class LinkedList<T> {

  private var head: Node<T>? = null
  private var tail: Node<T>? = null
  private var size = 0

  fun isEmpty(): Boolean {
    return size == 0
  }

  override fun toString(): String {
    if (isEmpty()) {
      return "Empty list"
    } else {
      return head.toString()
    }
  }

  fun push(value: T): LinkedList<T> {
    head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun pop(): T? {
        if (!isEmpty()) size--
            val result = head?.value
            head = head?.next
        if (isEmpty()) {
            tail = null
        }

        return result
    }

}

fun main(){
    val list = LinkedList<Int>()
    list.push(3).push(1).push(2)
    println(list)

    val removed = list.pop()
    println("$removed was removed!")
    println(list)
}
