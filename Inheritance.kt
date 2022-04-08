/*
 * Javier Trejo
 * This program demonstrates simple inheritance in Kotlin.
 */

open class Car(brand: String, engineType: String, size: String) {
    private var numOfDoors = 0
    private var engineType = ""
    private var brand = ""
    private var size = ""

    fun getBrand(): String {
        return brand
    }
    fun getEngineType(): String {
        return engineType
    }
    fun setDoors(numOfDoors: Int) {
        this.numOfDoors = numOfDoors
    }
}

class Sedan(brand: String, engineType: String, size: String) : Car(brand, engineType, size) {
    var canTow = false

    fun setCanTow() {
        this.canTow = true
    }
}

class HatchBack(brand: String, engineType: String, size: String) : Car(brand, engineType, size) {
    private var hatchType = ""
    fun setHatchType(){
        this.hatchType = hatchType
    }
}

fun main(args: Array<String>){
    var hondaCar: Car = Car("Honda", "Inline 4 cylinder", "Compact")
    var bmwSedan: Sedan = Sedan("BMW", "Inline 6 cylinder", "Executive")

    hondaCar.setDoors(4)
    bmwSedan.setCanTow()

    var hondaHatchBack: Car = HatchBack("Honda", "Inline 4 cylinder", "Compact")
}