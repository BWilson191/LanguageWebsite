/* Name: Ezekiel Holmes
*  Description: A simple summation program written in kotlin.
*  Prints "15" to the console on a new line.
*/

fun main(args: Array<String>) {
    val nums = arrayOf<Int>(1,2,3,4,5)
    var sum = 0

    for(i in 0..nums.size-1) {
        sum+=nums[i]  
    }

    println("$sum")
}