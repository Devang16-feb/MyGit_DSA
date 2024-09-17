package Recursion_Practice;
// print keyPad Combination
// Time Complexity : O[4^n]
public class Recursion9 
{
    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void printComb(String str, int idx, String comb)
    {
        if(idx == str.length()) // Base Case
        {
            System.out.println(comb);
            return;
        }
        char CurrChar = str.charAt(idx);
        String mapping = keypad[CurrChar - '0'];

        for(int i = 0; i<mapping.length(); i++)
        {
            printComb(str, idx+1, comb+mapping.charAt(i));
        }
    }
    public static void main(String[] args) 
    {
        String ptr = "23";
        printComb(ptr, 0, "");
    }
}
