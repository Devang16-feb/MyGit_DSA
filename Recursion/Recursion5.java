package Recursion_Practice;
// TC = O[n + Count] and Count Max = n , So O[2n]~O[n]
public class Recursion5 
{
    public static void Display(String Ptr,int idx, int Count, String newString)
    {
        if(idx == Ptr.length())
        {
            for(int i=0; i<Count; i++)
            {
                newString += 'x';
            }

            System.out.println("Updated string is :"+newString);
            return;
        }
        char currChar = Ptr.charAt(idx);

        if(currChar == 'x')
        {
            Count++;
            Display(Ptr, idx+1, Count, newString);
        }
        else
        {
            newString += currChar; // Add
            Display(Ptr, idx+1, Count, newString);
        }
        

    }
    public static void main(String[] args) 
    {
        String Str = "axbcxxd";
        String newString = "";

        Display(Str, 0, 0, newString);

    }
    
}
