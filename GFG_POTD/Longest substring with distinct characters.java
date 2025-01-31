// Given a string s, find the length of the longest substring with all distinct characters. 

import java.util.HashMap;

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        
        HashMap<Character, Integer> mp = new HashMap<>();
        char []arr = s.toCharArray();
        int i = 0, j = 0, iAns = 0, iMax = 0;
        
        for(j=0; j<arr.length; j++)
        {
            if(mp.containsKey(arr[j]))
            {
                while(arr[i] != arr[j])
                {
                    mp.remove(arr[i]);
                    i++;
                }
                mp.remove(arr[i]);
                i++;
            }
            mp.put(arr[j], 1);
            
            iAns = j - i + 1;
            if(iMax < iAns)
            {
                iMax = iAns;
            }
        }
        
        return iMax;
    }
}