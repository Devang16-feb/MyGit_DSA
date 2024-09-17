package Recursion_Practice;

import java.util.ArrayList;

// Print All the subSets fo set of first n Natural numbers:
// O[2^n]
public class Recursion14 
{
    public static void PrintsubSet(ArrayList<Integer> subset)
    {
        for(int i = 0; i<subset.size(); i++)
        {
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }
    public static void findSubSets(int n, ArrayList<Integer> subset)
    {
        if(n == 0)
        {
            PrintsubSet(subset);
            return;
        }
        // Add Hoga
        subset.add(n);
        findSubSets(n-1, subset);

        //Add Nahi honga
        subset.remove(subset.size()-1);
        findSubSets(n-1, subset);
    }
    public static void main(String[] args) 
    {
        int n = 3;
        ArrayList<Integer> subSet = new ArrayList<>();
        findSubSets(n, subSet);
    }   
}
