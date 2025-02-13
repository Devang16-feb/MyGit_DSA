// Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.


class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

class Solution 
{
    int max=Integer.MIN_VALUE;
    
    int path(Node root)
    {
        if(root==null) return 0;
        
        int l=Math.max(0,path(root.left));
        int r=Math.max(0,path(root.right));
        
        max=Math.max(max,root.data+l+r);
        
        return root.data+Math.max(l,r);
    }
    int findMaxSum(Node node) 
    {
        path(node);
        return max;
    }
}