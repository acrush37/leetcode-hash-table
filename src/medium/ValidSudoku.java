package medium;

/*
    Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        boolean[][][] f = new boolean[9][10][3];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    int k = board[i][j] - 48, p = i / 3 * 3 + j / 3;
                    if (f[i][k][0] || f[j][k][1] || f[p][k][2]) return false;
                    f[i][k][0] = f[j][k][1] = f[p][k][2] = true;
                }

        return true;
    }

}
