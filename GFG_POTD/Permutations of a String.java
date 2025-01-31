// Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution 
{
    private void solve(int i, int n, StringBuilder s, StringBuilder permu, Set<String> st)
    {
        if(permu.length() == n)
        {
            st.add(permu.toString());
            return;
        }
        for(int j=i; j<n; j++)
        {
            char temp = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, temp);
            
            permu.append(s.charAt(i));
            solve(i+1, n, s, permu, st);
            
            permu.deleteCharAt(permu.length()-1);
            
            s.setCharAt(j, s.charAt(i));
            s.setCharAt(i, temp);
        }
    }
    public ArrayList<String> findPermutation(String s) 
    {
        Set<String> st = new HashSet<>();
        StringBuilder permu = new StringBuilder();
        int n = s.length();
        solve(0, n, new StringBuilder(s), permu, st);
        
        return new ArrayList<>(st);
        // Code here
    }
}