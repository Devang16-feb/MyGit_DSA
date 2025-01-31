// Given an array arr[] containing integers and an integer k,
// your task is to find the length of the longest subarray 
// where the sum of its elements is equal to the given value k. 
// If there is no subarray with sum equal to k, return 0.

import java.util.HashMap;
import java.util.Map;

class Solution 
{
    public int longestSubarray(int[] arr, int k) 
    {
        int iSum = 0, iResult = 0, prevIndex = -1, length = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        
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