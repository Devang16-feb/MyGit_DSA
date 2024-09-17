// Find First and Last occurence of element in string
// O(N)
package Recursion_Practice;

public class Recursion3 
{
    public static int First = -1;
    public static int Last = -1;

    public static void findOccurence(String str, int idx,char element)
    {
        if(idx == str.length())
        {
            System.out.println(First);
            System.out.println(Last);
            return;
        }

        char currChar = str.charAt(idx);

        if(currChar == element)
        {
            if(First == -1)
            {
                First = idx;
            }
            else
            {
                Last = idx;
            }
        }
        findOccurence(str, idx+1, element);
    }
    public static void main(String[] args) 
    {
        String str = "abaacdaefaah";
        findOccurence(str, 0, 'a');
    }
    

}
