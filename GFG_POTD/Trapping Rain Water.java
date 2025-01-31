// Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 


class Solution 
{
    public int maxWater(int arr[]) 
    {
        int rMax = 0;
        int lMax = 0;
        int Trap = 0;
        int i = 0, j = arr.length-1;
        
        while(i < j)
        {
            if(lMax < arr[i])
            {
                lMax = arr[i];
            }
            
            if(rMax < arr[j])
            {
                rMax = arr[j];
            }
            
            if(arr[i] <= arr[j])
            {
                Trap += lMax - arr[i];
                i++;
            }
            else
            {
                Trap += rMax - arr[j];
                j--;
            }
        }
        return Trap;
        // code here
    }
}