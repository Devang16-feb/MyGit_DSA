package Recursion_Practice;
// find the number of ways in which you can invite n people to your party, Single or in Pairs
// O[2^n]
public class Recursion13 
{
    public static int CallGuest(int n)
    {
        if(n <= 1) // Base case
        { 
            return 1;
        }
        // Single
        int ways1 = CallGuest(n-1);

        //Pair
        int ways2 = (n-1) * CallGuest(n-2);

        return ways1 + ways2;
    }
    public static void main(String[] args) 
    {
        int n = 4;
        System.out.println(CallGuest(n));
    }
}
