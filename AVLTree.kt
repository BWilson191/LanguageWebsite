package com.example.kotlinavl

/* Andrew Moorcorft
 *  This class implements a AVL Tree from java ported into Kotlin.
 *  For the sake of this example only insert and find are made to
 *  operate on the tree
 */
class KotlinAVLTree {
     private var root :AVLNode;

    constructor(key: Int){
        root = AVLNode(key,0,null,null)
    }

    fun main(){
        val mytree = KotlinAVLTree(8)
        mytree.insert(4)
        mytree.insert(9)
        mytree.find(9)
    }

    fun find(key: Int) : Int{
        var curr = root
        while(curr != null){
            if(curr.key == key){
                return key
            }
            if(curr.key < key){
                curr = curr.right!!
            } else {
                curr = curr.left!!
            }
        }
        return curr;
    }

    fun insert(key : Int){
        root = insert(root, key);
    }

    private fun insert(n : AVLNode, key :Int): AVLNode {
        if(n == null){
            return AVLNode(key, null,null,null)
        }
        if(n.key > key){
            n.left
        } else if(n.key < key) {
            n.right = insert(n.right!!, key)
        }
        return rebalanceTree(n);
    }

    private fun updateHeight(n : AVLNode) {
        if(height(n.left!!) > height(n.right!!)){
            n.height = 1 + height(n.left!!)
        } else  {
            n.height = 1 + height(n.right!!)
        }

    }

    private fun height(n: AVLNode) : Int{
        if(n == null) {
            return -1
        }
        return n.height!!
    }

    private fun getBalance(n: AVLNode) : Int{
        if(n == null) {
            return 0
        }
        return height(n.right!!) - height(n.left!!)
    }

    private fun rotateRight(n : AVLNode) : AVLNode{
        var tmp = n
        var leftNode = tmp.left
        var rightNode = tmp.right
        leftNode!!.right = tmp
        tmp.left = rightNode
        updateHeight(tmp)
        updateHeight(leftNode)
        return leftNode
    }

    private fun rotateLeft(n : AVLNode) : AVLNode{
        var tmp = n
        var rightNode = tmp.right
        var leftNode = tmp.left
        rightNode!!.left = tmp
        tmp.right = leftNode
        updateHeight(tmp)
        updateHeight(rightNode)
        return rightNode
    }

    private fun rebalanceTree(n : AVLNode) : AVLNode{
        var tmp = n
        updateHeight(tmp)
        val treeBalance = getBalance(tmp)
        if(treeBalance > 1){
            if(height(tmp.right!!.right!!) > height(tmp.right!!.left!!)){
                tmp = rotateLeft(n)
            } else {
                tmp.right = rotateRight(n.right!!)
                tmp = rotateLeft(n)
            }
        } else if (treeBalance < -1){
            if(height(n.left!!.left!!) > height(n.left!!.right!!)){
                tmp = rotateRight(n)
            } else {
                tmp.left = rotateLeft(tmp.left!!)
                tmp = rotateRight(n)
            }
        }
        return tmp
    }
}