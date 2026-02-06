class Solution {
    public void solveSudoku(char[][] board) {
        if(solve(0, board)){}
    }

    public boolean isSafe(int r, int c, char num, char[][] board){

        for(int i=0;i<9;i++){
            if(board[i][c]== num || board[r][i]== num) return false;
        }

        int row = (r/3)*3;
        int col = (c/3)*3;

        for(int i = row; i< row + 3; i++){
            for(int j = col; j< col + 3;j++){
                if(board[i][j]== num) return false;
            }
        }
        return true;
    }


    public boolean solve(int row, char[][] board){

        if(row==9) return true;

        for(int c=0;c<9;c++){

            if(board[row][c]=='.'){

                for(char num= '1';num<= '9';num++){
                    if(isSafe(row, c, num, board)){
                        board[row][c] = num;

                        if(solve(row, board)) return true;
                        board[row][c] = '.';
                    }
                }

                return false;
            }
        }

        return solve(row+1, board);
    }
                          
}

// t.c is exponential... 9^81 on a worst case
// s.c = O(1)
