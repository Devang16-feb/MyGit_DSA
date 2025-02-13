import java.util.HashSet;
import java.util.Set;

class Complete
{
    public static String Sandwiched_Vowel(String str) 
    { 
        StringBuilder sb = new StringBuilder();
        char[] chr = str.toCharArray();
        String vowels = "aeiouAEIOU";
        Set<Character> vowelSet = new HashSet<>();
        
        for(char ch : vowels.toCharArray())
        {
            vowelSet.add(ch);
        }
        
        for(int i = 0; i < chr.length; i++)
        {
            if(i > 0 && i < chr.length - 1 && vowelSet.contains(chr[i]) && !vowelSet.contains(chr[i-1]) && !vowelSet.contains(chr[i+1]))
            {
                // Skip the sandwiched vowel
                continue;
            }
            sb.append(chr[i]);
        }
        
        return sb.toString();
    }
}