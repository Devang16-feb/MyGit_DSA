package Recursion_Practice;

import java.util.HashSet;

// print all inique Subsequences of string :
// Time Complexity : O[2^n]
public class Recursion8
{
    public static void subsequences(String str, int idx, String newString, HashSet<String> set)
    {
        if(idx == str.length())
        {
            if(set.contains(newString))
            {
                return;
            }
            else
            {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currentChar = str.charAt(idx);

        // to be
        subsequences(str, idx+1, newString+currentChar, set);
        //or not to be
        subsequences(str, idx+1, newString, set);
    }
    public static void main(String[] args) 
    {
        String Ptr = "aaa";
        String nweString = "";
        HashSet<String> set = new HashSet<>();

        subsequences(Ptr, 0, nweString, set);
    }   
}
