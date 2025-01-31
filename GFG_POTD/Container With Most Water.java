// Given an array arr[] of non-negative integers, where each element arr[i] represents 
// the height of the vertical lines, find the maximum amount of water that can be contained 
// between any two lines, together with the x-axis.

// Note: In the case of a single vertical line it will not be able to hold water.

class Solution {

    public int maxWater(int arr[]) 
    {
        int s = 0, e = arr.length-1, maxarea = 0, area = 0;
        int iMin = 0;
        
        while(s < e)
        {
            if(arr[s] <= arr[e])
            {
                iMin = arr[s];
            }
            else
            {
                iMin = arr[e];
            }
            area = iMin * (e-s);
            
            if(maxarea < area)
            {
                maxarea = area;
            }
            
            if(arr[s] < arr[e])
            {
                s++;
            }
            else
            {
                e--;
            }
        }
        return maxarea;
        // Code Here
    }
}