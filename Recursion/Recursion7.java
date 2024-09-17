package Recursion_Practice;

public class Recursion7 
{
    public static void subsequences(String str, int idx, String newString)
    {
        if(idx == str.length())
        {
            System.out.println(newString);
            return;
        }
        char currentChar = str.charAt(idx);

        // to be
        subsequences(str, idx+1, newString+currentChar);
        //or not to be
        subsequences(str, idx+1, newString);
    }
    public static void main(String[] args) 
    {
        String Ptr = "abc";
        String nweString = "";

        subsequences(Ptr, 0, nweString);
    }   
}
