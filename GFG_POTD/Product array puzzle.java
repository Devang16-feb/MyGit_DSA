// Given an array, arr[] construct a product array, res[] 
// where each element in res[i] is the product of all elements 
// in arr[] except arr[i]. Return this resultant array, res[].
// Note: Each element is res[] lies inside the 32-bit integer range.

class Solution 
{
    public static int[] productExceptSelf(int arr[]) 
    {
        int n = arr.length, totalProd = 1, zeroCnt = 0;
        int[] res = new int[n];
        
        for(int i: arr)
        {
            if(i==0)
            {
                zeroCnt++;
            }
            else
            {
                totalProd*=i;
            } 
        }
        
        if(zeroCnt > 1)
        {
            return res;
        }
        
        if(zeroCnt == 1)
        {
            for(int i=0;i<n;i++)
            {
                if(arr[i]==0)
                {
                    res[i]=totalProd;
                }
            }
            return res;
        }
        
        for(int i=0;i<n;i++)
        {
            res[i] = totalProd/arr[i];
        }
        
        return res;
    }
}