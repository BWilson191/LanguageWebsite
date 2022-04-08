package com.example.kotlinavl

/* Andrew Moorcorft
 *  This class implements a AVLNode fo the AVLTree. Using Kotlin's
 *  data class, a quick implementation of a data node can be made.
 *  Since Kotlin takes care of all the functions for data classes
 */
data class AVLNode(var key: Int, var height: Int?, var left : AVLNode?, var right :AVLNode?){

}