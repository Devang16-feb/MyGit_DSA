// Given an array of strings, return all groups of strings that are anagrams. 
// The strings in each group must be arranged in the order of their appearance 
// in the original array. Refer to the sample case for clarification.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) 
    {
        // code here
       Map<String, List<String>> map = new HashMap<>();
       
       for(String str : arr)
       {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String st = new String(chars);
            
            if(!map.containsKey(st))
            {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(st,list);
            }
            else
            {
                map.get(st).add(str);
            }
       }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        for (List<String> list : map.values()) 
        {
            result.add(new ArrayList<>(list)); // Create a new ArrayList from each List
        }

        return result;
    }
}