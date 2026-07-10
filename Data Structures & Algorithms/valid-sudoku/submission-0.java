class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.') {
                    if(!validateCell(board,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean validateCell(char [][] board, int row, int col) {

        boolean [] data = new boolean[9];
        for(int i=0;i<9;i++) {
            //row
            if(i!=col && board[row][i] == board[row][col]) {
                return false;
            }
            //col
            if(i!=row && board[i][col]==board[row][col]) {
                return false;
            }
        }
        int startRow = 3*(row/3), startCol = 3*(col/3);
        for(int i=startRow;i<=startRow+2;i++) {
            for(int j=startCol;j<=startCol+2;j++) {
                if(i==row && j==col){
                    continue;
                }
                if(board[i][j]==board[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}
