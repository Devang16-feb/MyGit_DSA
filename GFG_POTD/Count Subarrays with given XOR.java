// Given an array of integers arr[] and a number k, 
// count the number of subarrays having XOR of their 
// elements as k.

import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) 
    {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int iCount =0;
        int X_OR = 0;
        
        for(int i=0; i<arr.length; i++)
        {
            X_OR = X_OR ^ arr[i];
            
            if(X_OR == k)
            {
                iCount++;
            }
            
            if(mp.containsKey(X_OR ^ k))
            {
                iCount += mp.get(X_OR ^ k);
            }
            
            if(mp.containsKey(X_OR))
            {
                mp.put(X_OR, mp.get(X_OR)+1);
            }
            else
            {
                mp.put(X_OR, 1);
            }
        }
        
        return iCount;
    }
}