// Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.


class Solution 
{
    static boolean satisfy(int[][] mat, int i, int j, int num)
    {
        for(int r = 0; r<9; r++)
        {
            if(mat[i][r] == num || mat[r][j] == num)
            {
                return false;
            }
        }
        
        int Starting_Row = i - i%3;
        int Starting_Col = j - j%3;
        
        for(int r=0; r<3; r++)
        {
            for(int c=0; c<3; c++)
            {
                if(mat[r+Starting_Row][c+Starting_Col] == num)
                {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean solve(int[][] mat)
    {
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(mat[i][j] == 0)
                {
                    for(int num=1; num<=9; num++)
                    {
                        if(satisfy(mat, i, j, num) == true)
                        {
                            mat[i][j] = num;
                            // Agar Sarre Blank Bhar Gaye to Return true Ho jayenga
                            if(solve(mat) == true) // Recursively Call tofind another blank Element 
                            {
                                return true;
                            }
                            mat[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) 
    {
        solve(mat);
        // code here
    }
}