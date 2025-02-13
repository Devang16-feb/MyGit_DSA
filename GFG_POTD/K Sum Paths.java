// Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).

import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution 
{
    private int solve(Node root,  Map<Integer, Integer> mp, int currSum, int k)
    {
        if (root == null) 
        {
            return 0;
        }

        currSum += root.data;
        int ans = 0;

        if (mp.containsKey(currSum - k)) 
        {
            ans += mp.get(currSum - k);
        }

        if (mp.containsKey(currSum)) 
        {
            mp.put(currSum, mp.get(currSum) + 1);
        } 
        else 
        {
            mp.put(currSum, 1);
        }

        ans += solve(root.left, mp, currSum, k);
        ans += solve(root.right, mp, currSum, k);

        mp.put(currSum, mp.get(currSum) - 1);

        return ans;
    }
    public int sumK(Node root, int k) 
    {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        
        int iCount = solve(root, mp, 0, k);
        
        return iCount;
    }
}