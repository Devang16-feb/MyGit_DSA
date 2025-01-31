// The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

// Given an integer n, find all distinct solutions to the n-queens puzzle.
// You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
// For eg. below figure represents a chessboard [3 1 4 2].

import java.util.ArrayList;

class Solution 
{
    public void solve(int colo, int n, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> sol,boolean[] col, boolean[] ldiag, boolean[] rdiag) 
    {
        if (colo == n) 
        {
            ans.add(new ArrayList<>(sol));
            return;
        }

        for (int i = 0; i < n; i++) 
        {
            if (!col[i] && !ldiag[colo - i + n - 1] && !rdiag[i + colo]) 
            {
                sol.add(i + 1);
                col[i] = true;
                ldiag[colo - i + n - 1] = true;
                rdiag[i + colo] = true;

                solve(colo + 1, n, ans, sol, col, ldiag, rdiag);

                sol.remove(sol.size() - 1);
                col[i] = false;
                ldiag[colo - i + n - 1] = false;
                rdiag[i + colo] = false;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) 
    {
        boolean[] col = new boolean[n];
        boolean[] ldiag = new boolean[2 * n - 1];
        boolean[] rdiag = new boolean[2 * n - 1];
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> sol = new ArrayList<>();
        
        solve(0, n, ans, sol, col, ldiag, rdiag);
        
        return ans;
        // code here
    }
}