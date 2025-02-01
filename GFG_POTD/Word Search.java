// You are given a two-dimensional mat[][] of size n*m containing English alphabets and a 
// string word. Check if the word exists on the mat. The word can be constructed by using 
// letters from adjacent cells, either horizontally or vertically. The same cell cannot 
// be used more than once.


class Solution {
    private boolean solve(char[][] mat, String word, int i, int j, int idx, boolean[][] vis) {
        // Base case
        if (idx == word.length()) return true;
        
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || vis[i][j] || mat[i][j] != word.charAt(idx)) 
            return false;
        
        // Recursive case
        vis[i][j] = true;
        if (solve(mat, word, i - 1, j, idx + 1, vis) || solve(mat, word, i + 1, j, idx + 1, vis) ||
            solve(mat, word, i, j - 1, idx + 1, vis) || solve(mat, word, i, j + 1, idx + 1, vis))
            return true;
        
        vis[i][j] = false;
        return false;
    }
    
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (solve(mat, word, i, j, 0, vis)) return true;
                }
            }
        }
        return false;
    }
}