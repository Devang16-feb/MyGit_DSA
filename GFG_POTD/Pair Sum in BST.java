// Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
class Solution 
{
    public void inorder(Node root, List<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    boolean findTarget(Node root, int target) 
    {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        int num1 = -1, num2 = -1;
        inorder(root, list);
        
        for(int num : list)
        {
            if(mp.containsKey(num))
            {
                mp.put(num, mp.get(num)+1);
            }
            else
            {
                mp.put(num, 1);
            }
        }
        int k = target;
        while(k != 1)
        {
            num1 = k-1;
            num2 = target - num1;
            
            if(mp.containsKey(num1) && mp.get(num1)>= 1)
            {
                mp.put(num1, mp.get(num1)-1);
                if(mp.containsKey(num2) && mp.get(num2)>= 1)
                {
                    mp.put(num2, mp.get(num2)-1);
                    return true;
                }
            }
            k -= 1;
        }
        return false;
    }
}