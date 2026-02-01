class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]== word.charAt(0) && stringExistance(i,j,0,word,board,visited)) return true;
            }
        }
        return false;
    }

    public boolean stringExistance(int r,int c, int ch, String w, char[][] board, boolean[][] visited){

        if(ch==w.length()){
            return true;
        }

        if(r<0 || c<0 || r>=board.length || c>=board[0].length) return false;

        if(visited[r][c] || board[r][c] != w.charAt(ch)) return false;
            
        visited[r][c] = true;


        boolean found = 
            (stringExistance(r, c+1, ch+1, w, board, visited) ||
            stringExistance(r, c-1, ch+1, w, board, visited) ||
            stringExistance(r-1, c, ch+1, w, board, visited) ||
            stringExistance(r+1, c, ch+1, w, board, visited));

        visited[r][c] = false;

        return found;
    }
}



// both are asymptomatically same , the only difference is boolean array for visited separately 
// T.c = O(m.n. 4^L) 4^L ==> dfs can go in any four directions
// S.C = O(m.n. L) m.n for extra Boolean array , S.C = O(L) l= max depth 

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]== word.charAt(0) && stringExistance(i,j,0,word,board)) return true;
            }
        }
        return false;
    }

    public boolean stringExistance(int r,int c, int ch, String w, char[][] board){

        if(ch==w.length()){
            return true;
        }

        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c] != w.charAt(ch)) return false;

        
            
        char temp = board[r][c];
        board[r][c] = ' ';

        boolean found = 
            (stringExistance(r, c+1, ch+1, w, board) ||
            stringExistance(r, c-1, ch+1, w, board) ||
            stringExistance(r-1, c, ch+1, w, board) ||
            stringExistance(r+1, c, ch+1, w, board));

        board[r][c] = temp; 

        return found;
    }
}
