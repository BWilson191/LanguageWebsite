/* Name: Ezekiel Holmes
 * Description: A complex quickSorting program written in Kotlin (ported from a Java example)
 * Prints a sorted (smallest to largest) array of integers ranging from 1-10
 */
fun swap(arr:Array<Int>, i: Int, j: Int) {
    var temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun partition(arr:Array<Int>, low: Int, hi: Int): Int {
    var pivot = arr[hi]
    var i = low -1
    
    for(j in low..hi) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j)
        }
    }
    swap(arr, i+1, hi)
    return (i+1)
}

fun quickSort(numbers:Array<Int>, low: Int, hi: Int) {
	if (low < hi) {
        var part = partition(numbers, low, hi)
        quickSort(numbers, low, part - 1)
        quickSort(numbers, part+1, hi)
    }
}

fun main() {
	val nums = arrayOf<Int>(5,10,2,3,7,4,1,9,8,6)
    
    quickSort(nums, 0, nums.size - 1)
        
    nums.forEach{
        System.out.print(it)
        print(", ")
    }
}