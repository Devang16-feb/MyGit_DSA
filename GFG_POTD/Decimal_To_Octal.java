public class Decimal_To_Octal 
{
    public static String Octal(int decimal) 
    {
        int octal = 0;
        String octalString = "";

        while (decimal > 0) 
        {
            octal = decimal % 8;
            octalString = octal + octalString;
            decimal = decimal / 8;
        }
        return octalString;
    }

    public static void ASCIIlookuptable(char ch)
    {
        int decimal = (int)ch;

        System.out.println("Decimal value: " + decimal);
        System.out.println("Octal value: " + Octal(decimal));
    }
    public static void main(String[] args) 
    {
        char ch = '@';
        ASCIIlookuptable(ch);    
    }   
}
