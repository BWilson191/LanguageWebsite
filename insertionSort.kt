/**
 * Name: Eli Sorensen
 * Description: This program demonstrates function calls using Kotlin,
 * by way of the insertion sort algorithm. It prints an array before
 * sorting, then again after. It also contains KDocs comments, the Kotlin
 * flavor of Javadoc.
 *
 * @author elijahsorensen
 * @version CS 354: Spring 2022
 */
fun main(args: Array<String>) {
    var array: IntArray = intArrayOf(9, 0, 8, 7, 6, 5, 4, 1, 3, 2)

    println("Array before horrible runtime insertion sort...")
    printArray(array)

    println("Array after horrible runtime insertion sort...")

    insertionSort(array)
    printArray(array)
}

/**
 * Uses insertion sort to sort an array of integers.
 *
 * @param a the array to sort
 */
fun insertionSort(a: IntArray) {

    var i = 1;

    while (i < a.size) {
        var x = a[i]
        var j = i - 1

        while (j >= 0 && a[j] > x) {
            a[j + 1] = a[j]
            j -= 1
        }

        a[j + 1] = x
        i += 1
    }

}

/**
 * Iterates through and prints an array of integers.
 *
 * @param a the array to print
 */
fun printArray(a: IntArray) {

    print("<")
    for (i in 0 until a.size) {
        print(a[i])
        if (i != a.size - 1) {
            print(", ")
        }
    }
    print(">")

    println()

}