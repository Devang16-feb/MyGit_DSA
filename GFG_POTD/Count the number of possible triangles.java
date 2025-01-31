// Given an integer array arr[]. Find the number 
// of triangles that can be formed with three 
// different array elements as lengths of three 
// sides of the triangle. 

// A triangle with three given sides is only possible 
// if sum of any two sides is always greater than 
// the third side.

import java.util.Arrays;

class Solution 
{
    static int countTriangles(int arr[]) 
    {
        Arrays.sort(arr);
        int ans=0;
        for(int i=arr.length-1;i>=0;i--)
        {
            int st=0, end=i-1;
            while(st<end)
            {
                if(arr[st]+arr[end]>arr[i])
                {
                    ans+=end-st;
                    end--;
                }
                else 
                {
                    st++;
                }
            }
        }
        return ans;
    }
}