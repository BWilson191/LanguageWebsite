/** Samantha Farmer
* Shows how to use a scanner and store inputed variables
* Prints a statement based on the users answers and calculates age.
*/
import java.util.Scanner

fun main(args: Array<String>){

    val reader = Scanner(System.`in`)
    print("Please enter your name: ")
    var name = readLine()
    print("Please enter your birth year: ")
    var year: Int = reader.nextInt()
    print("Please enter your favorite animal: ")
    var animal = readLine()

    var age: Int = 2022 - year

    println("You were born in $year making you $age years old and your favorite animal is $animal, how cute!")
}   

