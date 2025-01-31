// Given an array arr of 0s and 1s. Find and 
// return the length of the longest subarray 
// with equal number of 0s and 1s.

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxLen(int[] arr) 
    {
        int iSum = 0, iResult = 0, prevIndex = -1, length = 0, k = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == 0)
            {
                arr[i] = -1;
            }
        }
        
        for(int i=0; i<arr.length; i++)
        {
            iSum += arr[i];
            
            if(iSum == k)
            {
                iResult = i +1;
            }
            
            if(mp.containsKey(iSum - k))
            {
                prevIndex = mp.get(iSum - k);
                length = i - prevIndex;
                
                if(length > iResult)
                {
                    iResult = length;
                }
            }
            
            if(!mp.containsKey(iSum))
            {
                mp.put(iSum, i);
            }
        }
        return iResult;
    }
}