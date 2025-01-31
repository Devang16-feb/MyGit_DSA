// Given an array of integers arr[], the task is to find 
// the first equilibrium point in the array.

// The equilibrium point in an array is an index 
// (0-based indexing) such that the sum of all elements 
// before that index is the same as the sum of elements 
// after it. Return -1 if no such point exists. 

class Solution 
{
    public static int findEquilibrium(int arr[]) 
    {
        int totalSum=0;
        for(int i: arr)
        {
            totalSum+=i;
        }
        int currSum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(currSum==totalSum-currSum-arr[i])
            {
                return i;
            }
            currSum+=arr[i];
        }
        return -1;
    }
}