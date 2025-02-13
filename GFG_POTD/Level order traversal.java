// Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) 
    {
        // CodeGenius
        ArrayList< ArrayList <Integer>> a=new  ArrayList <>();
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(root); 
        
        while (!q.isEmpty()) 
        { 
            ArrayList <Integer> temp=new ArrayList <Integer>();
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                Node t = q.poll(); 
                temp.add(t.data);

                if (t.left != null) 
                { 
                    q.add(t.left); 
                } 
    
                if (t.right != null) 
                { 
                    q.add(t.right); 
                }
            }
          a.add(temp);  
        }
            return a;
    }
}