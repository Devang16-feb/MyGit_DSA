package Recursion_Practice;

// Print Permutations of String : All Posible Combination
// Time CompleXity : O[n!]

public class Recursion10 
{
    public static void printPerm(String str, String perm)
    {
        if(str.length() == 0)
        {
            System.out.println(perm);
            return;
        }
        for(int i=0; i<str.length(); i++)
        { 
            char currchar = str.charAt(i);
            // "abc" ->"ac" if CurrChar  = b
            String newStr = str.substring(0, i)+ str.substring(i+1);
            printPerm(newStr, perm+currchar); 

        }
    }
    public static void main(String[] args) 
    {
        String str = "abc";
        printPerm(str, "");
    }
}
