// Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution 
{
    ArrayList<Integer> countDistinct(int arr[], int k) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        
        int iStart = 0, iCount = 0;
        int iEnd = k -1;
        
        for(int i=0; i<arr.length; i++)
        {
            if(i > iEnd)
            {
                if(mp.get(arr[iStart]) > 1)
                {
                    iCount++;
                }
                
                mp.put(arr[iStart], mp.get(arr[iStart]) - 1);
                if (mp.get(arr[iStart]) == 0) 
                {
                    mp.remove(arr[iStart]);
                }
                
                iStart++;
                iEnd--;
                iCount--;
            }
            
            if (!mp.containsKey(arr[i])) 
            {
                mp.put(arr[i], 1);
                iCount++;
            } 
            else 
            {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
            
            if (i >= iEnd) 
            { 
                list.add(iCount);
            }
        }
        
        return list;
        
        // code here
    }
}