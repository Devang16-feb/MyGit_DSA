public class Ascii_Table2 
{
    public static void main(String[] args) 
    {
        System.out.println("ASCII Table:");
        System.out.println("Character\tDecimal\tHexadecimal\tOctal");
        
        for (int i = 32; i <= 126; i++) 
        {
            char ch = (char) i;
            String hex = Integer.toHexString(i);
            String octal = Integer.toOctalString(i);
            
            System.out.printf("%c\t\t%d\t%s\t\t%s%n", ch, i, hex, octal);
        }
        
    }    
}
