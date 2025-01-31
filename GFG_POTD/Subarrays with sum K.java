// // Given an unsorted array of integers, find the number 
// of subarrays having sum exactly equal to a given number k.

import java.util.HashMap;

class Solution 
{
    public int countSubarrays(int arr[], int k) 
    {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int iCount = 0, iSum = 0;
        
        for(int i=0; i<arr.length; i++)
        {
            iSum += arr[i];
            
            if(iSum == k)
            {
                iCount++;
            }
            
            if(mp.containsKey(iSum-k))
            {
                iCount += mp.get(iSum - k);
            }
            
            if(mp.containsKey(iSum))
            {
                mp.put(iSum, mp.get(iSum) + 1);
            }
            else
            {
                mp.put(iSum, 1);
            }
        }
        return iCount;
        // code here
    }
}