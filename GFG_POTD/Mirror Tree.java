// Given a binary tree, convert the binary tree to its Mirror tree.

// Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.     


class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} 

class Solution 
{
    void mirror(Node node) 
    {
        if(node == null) return;
        
        mirror(node.left);
        mirror(node.right);
        
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}