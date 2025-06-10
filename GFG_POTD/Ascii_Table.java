public class Ascii_Table 
{
    public static void main(String[] args) 
    {
        System.out.println("ASCII Table:");
        System.out.println("Character\tDecimal\tHexadecimal\tOctal");
        
        for (int i = 0; i < 256; i++) 
        {
            char ch = (char) i;
            String hex = Integer.toHexString(i);
            String octal = Integer.toOctalString(i);
            
            System.out.printf("%c\t\t%d\t%s\t\t%s%n", ch, i, hex, octal);
        }
        
    }
}
