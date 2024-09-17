package Recursion_Practice;
//Remove Duplicates in String
public class Recursion6 
{
    public static boolean[] map = new boolean[26];

    public static void RemoveDupli(String Str, int idx, String newString)
    {
        if(idx == Str.length())
        {
            System.out.println("Updated String is : "+newString);
            return;
        }
        char currChar = Str.charAt(idx);
        if(map[currChar - 'a'] == true)
        {
            RemoveDupli(Str, idx+1, newString);
        }
        else
        {
            newString += currChar;
            map[currChar - 'a'] = true;
            RemoveDupli(Str, idx+1, newString);
        }
    }
    public static void main(String[] args) 
    {
        String str = "abbccda";
        String newString = "";

        RemoveDupli(str, 0, newString);

    }
}
