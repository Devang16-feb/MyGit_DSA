package Recursion_Practice;
// Count Total path in maze to move from (0,0) to (n,m) 
// Back tracking Used 
// O[2^n]

public class Recursion11 
{
    public static int CountPaths(int i, int j, int n, int m)
    {
        if(i == n || j == m) // Base Case
        {
            return 0;
        }
        if(i == n-1 && j == m-1) // Base Case
        {
            return 1;
        }
        // move dounWords:

        int DownPaths = CountPaths(i+1, j, n, m);

        // Right Move

        int RightPaths = CountPaths(i, j+1, n, m);

        return DownPaths + RightPaths;
    }
    public static void main(String[] args) 
    {
        int n = 3, m = 3;

        int totalPaths = CountPaths(0, 0, n, m);

        System.out.println(totalPaths);
    }
}
