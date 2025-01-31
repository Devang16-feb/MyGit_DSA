// Given an array arr[] and an integer target. You have to 
// find the number of pairs in the array whose sum is 
// strictly less than the target.

import java.util.Arrays;

class Solution {
    int countPairs(int arr[], int target) 
    {
        // Your code here
        int iCount = 0, iSum = 0;
        Arrays.sort(arr);
        int iStart = 0;
        int iEnd = arr.length - 1;
        
        while(iStart < iEnd)
        {
            iSum = arr[iStart] + arr[iEnd];
            
            if(iSum>=target)
            {
                iEnd--;
            }
            else
            {
                iCount += iEnd - iStart;
                iStart++;
            }
        }
        
        
        return iCount;
    }
}