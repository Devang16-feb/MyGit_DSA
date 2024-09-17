package Recursion_Practice;

import java.util.Scanner;

// Check if an Array is Sorted(Strictly Increasing)
//O(N)
public class Recursion4 
{
    public static boolean ChkSorted(int Arr[], int idx)
    {
        if(idx == Arr.length-1)
        {
            return true;
        }
        if(Arr[idx] < Arr[idx+1])
        {
            //Array is Sorted till now
            return ChkSorted(Arr, idx+1);
        }
        else
        {
            return false;
        }
        
    }
    public static void main(String[] args) 
    {
        try (Scanner Sobj = new Scanner(System.in)) 
        {
            System.out.println("Enter the size of Array:\n");
            int iSize = Sobj.nextInt();

            System.out.println("Enter the elements in array:");

            int Brr[] = new int[iSize];

            for(int i=0; i<iSize; i++)
            {
                Brr[i] = Sobj.nextInt();
            }

            boolean bRet = ChkSorted(Brr, 0);

            if(bRet == true)
            {
                System.out.println("Array is Sorted");
            }
            else
            {
                System.out.println("Array is not sorted");
            }
        }
    }
}
