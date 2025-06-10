public class Decimal_To_Hexa 
{
    public static String Hexadecimal(int decimal)
    {
        String OctalString = "";

        while (decimal > 0) 
        {
            int remainder = decimal % 16;
            if(remainder >=0 && remainder <= 9) 
            {
                OctalString = remainder + OctalString;
            }
            else
            {
                OctalString = (char)('A' + remainder % 10) + OctalString;
            }
            decimal = decimal / 16;
        }
        return OctalString;
    }
    public static void main(String[] args) {
        char ch = '@';
        int decimal = (int) ch;

        System.out.println("Decimal value: " + decimal);
        System.out.println("Heaxadecimal value: " + Hexadecimal(decimal));
    }
    
}
