import java.util.*;

public class RatInAMaze {

    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        List<String> res = new ArrayList<>();
        possibleWays(0, 0, grid, new StringBuilder(), res);

        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void possibleWays(int r, int c, int[][] grid,
                                    StringBuilder curr, List<String> res) {

        if (r < 0 || c < 0 || r >= grid.length || c >= grid.length || grid[r][c] == 0)
            return;

        if (r == grid.length - 1 && c == grid.length - 1) {
            res.add(curr.toString());
            return;
        }

        grid[r][c] = 0;

        curr.append('L');
        possibleWays(r, c - 1, grid, curr, res);
        curr.deleteCharAt(curr.length() - 1);

        curr.append('R');
        possibleWays(r, c + 1, grid, curr, res);
        curr.deleteCharAt(curr.length() - 1);

        curr.append('U');
        possibleWays(r - 1, c, grid, curr, res);
        curr.deleteCharAt(curr.length() - 1);

        curr.append('D');
        possibleWays(r + 1, c, grid, curr, res);
        curr.deleteCharAt(curr.length() - 1);

        grid[r][c] = 1;
    }
}


//  grid has n*n cells , it can be moved in any of the 4 directions , in the worst case
// Totl T.C = O( 4^(n*n)) , S.C = O(n*n) , Recursion stack = max depth in one path = n*n
