// You are given an integer target and an array arr[]. 
// You have to find number of pairs in arr[] which sums 
// up to target. It is given that the elements of the 
// arr[] are in sorted order.

// Note: pairs should have elements of distinct indexes. 

import java.util.HashMap;

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int iCount = 0;
        
        for(int num: arr)
        {
            int Complement = target - num;
            
            if(map.containsKey(Complement))
            {
                iCount += map.get(Complement);
            }
  
            if(map.containsKey(num))
            {
                map.put(num, map.get(num)+1);
            }
            else
            {
                map.put(num, 1);
            }
        }
        
        return iCount;
    }
}