// Given a binary tree, the diameter (also known as the width) is defined as the number of 
// edges on the longest path between two leaf nodes in the tree. This path may or may not 
// pass through the root. Your task is to find the diameter of the tree.

class Node 
{
    int data;
    Node left;
    Node right;
    Node(int data) 
    {
        this.data = data;
        left = null;
        right = null;
    }
}


class Solution 
{
    int Diameter = 0;
    int height(Node root)
    {
        // Base case:
        if(root == null)
        {
            return 0;
        }
        
        int LH = height(root.left);
        int RH = height(root.right);
        
        Diameter = Math.max((LH+RH), Diameter); // To Find diameter;
        
        return Math.max(LH, RH)+1;
    }
    
    int diameter(Node root) 
    {
        height(root);
        return Diameter;
        // Your code here
    }
}