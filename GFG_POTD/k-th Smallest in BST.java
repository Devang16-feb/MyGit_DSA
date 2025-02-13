// Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.

import java.util.ArrayList;
import java.util.List;

class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class Solution 
{
    public void inorder(Node root, List<Integer> temp)
    {
        if(root == null)
        {
            return;
        }
        
        inorder(root.left, temp);
        temp.add(root.data);
        inorder(root.right, temp);
    }
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) 
    {
        List<Integer> temp = new ArrayList<>();
        
        inorder(root, temp);
        
        if(k > temp.size()) return -1;
        return temp.get(k-1);
        // Write your code here
    }
}