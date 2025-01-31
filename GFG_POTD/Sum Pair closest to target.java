// Given an array arr[] and a number target, find a pair 
// of elements (a, b) in arr[], where a<=b whose sum 
// is closest to target.

// Note: Return the pair in sorted order and if there 
// are multiple such pairs return the pair with maximum 
// absolute difference. If no such pair exists return 
// an empty array.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        
        if(arr.length < 2)
        {
            return new ArrayList<>();
        }
        
        Arrays.sort(arr);
        
        int iStart = 0;
        int iEnd = arr.length - 1;
        int iDiff = Integer.MAX_VALUE;
        int[] brr = {0, 0}; 
        
        while(iStart < iEnd)
        {
            int iSum = arr[iStart] + arr[iEnd];
            
            if (Math.abs(target - iSum) < iDiff) 
            {
                iDiff = Math.abs(target - iSum);
                brr[0] = arr[iStart];
                brr[1] = arr[iEnd];
            }

            if (iSum < target) 
            {
                iStart++;
            } 
            else 
            {
                iEnd--;
            }
        }
        
        Arrays.sort(brr);
        
        List<Integer> list = new ArrayList<>();
        list.add(brr[0]);
        list.add(brr[1]);

        return list;
    }
}