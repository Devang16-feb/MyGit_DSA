// Given the root of a binary tree. Check whether it is a BST or not.
// Note: We are considering that BSTs can not contain duplicate Nodes.
// A BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

import java.util.ArrayList;
import java.util.List;

class Solution 
{
    void inorder(Node root, List<Integer> h)
    {
        if(root == null)
        {
            return;
        }
        
        inorder(root.left, h);
        h.add(root.data); 
        inorder(root.right, h);
    }
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) 
    {
        List<Integer> h = new ArrayList<>();
        inorder(root, h);
        
        for(int i=1; i<h.size(); i++)
        {
            if(h.get(i) <= h.get(i - 1))
            {
                return false;
            }
        }
        return true;
        // code here.
    }
}