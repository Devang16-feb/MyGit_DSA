// Generates All Strings of n Bits

package Recursion_Practice;

public class Recursion15 
{
    public static char[] A;

    public static void binary(int n)
    {
        if(n<1)
        {
            System.out.println(A);
            return;
        }
        else
        {
            A[n-1] = '0';
            binary(n-1);
            A[n-1] = '1';
            binary(n-1);
        }
    }
    public static void main(String[] args) 
    {
        int n = 3;
        A = new char[n];
        binary(3);
    }
}