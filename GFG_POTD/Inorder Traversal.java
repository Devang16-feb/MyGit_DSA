// Given a Binary Tree, your task is to return its In-Order Traversal.

// An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).

// Follow Up: Try solving this with O(1) auxiliary space.

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}

class Solution 
{
    void inorder(Node root, ArrayList<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    
    ArrayList<Integer> inOrder(Node root) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        return list;
        // Code
    }
}