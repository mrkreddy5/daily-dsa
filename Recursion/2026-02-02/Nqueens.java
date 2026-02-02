class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> res = new ArrayList<>();

        backtrack(0,board,new ArrayList<>(),res);
        return res;
    }

    public void backtrack(int r,int[][] board, List<String> curr, List<List<String>> res){
        
        if(r==board.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int c=0;c<board.length;c++){
            if(isSafe(r,c,board)){
                board[r][c] = 1;

                char[] row = new char[board.length];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                curr.add(new String(row));


                backtrack(r+1,board, curr,res);

                curr.remove(curr.size()-1);
                board[r][c] = 0;   
            }        
        }
    }

    public boolean isSafe(int r, int c, int[][] board){

        for(int i=0;i<r;i++){
            if(board[i][c]==1) return false;
        }

        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1) return false;
        }

        for(int i=r-1,j=c+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]==1) return false;
        }

        return true;
    }
}


// Total T.c = O(n! . n) n! placing 1 queen per row , it has n chances , then n-1, n-2..1
// totally n! , and cost of isSafe() is n so totally n! . n
// space complexity is O(n^2) for board ,or Storing n strings
