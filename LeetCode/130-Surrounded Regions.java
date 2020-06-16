/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.


*/

class Solution {
    public void solve(char[][] board) {
        int rows  = board.length;
        if(rows==0) return;
        int columns = board[0].length;
        if(columns == 0) return;
        for(int i=0;i<rows;i++){
            if(board[i][0]=='O') boundaryDFS(board, i, 0, rows, columns);
            if(board[i][columns-1]=='O')boundaryDFS(board, i, columns-1, rows, columns);
        }
        for(int i=0;i<columns;i++){
            if(board[0][i]=='O')boundaryDFS(board, 0, i, rows, columns);
            if(board[rows-1][i]=='O')boundaryDFS(board, rows-1, i, rows, columns);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='*'){
                    board[i][j]='O';
                }
            }
        }
    }
    public static void boundaryDFS(char[][] board, int row, int column, int rows, int columns){
        if(row<0 || row>rows || column<0 || column>columns){return;}
        if(board[row][column]=='O'){
            board[row][column]='*';
        }
        if(row>0 && board[row-1][column]=='O'){
            boundaryDFS(board, row-1, column, rows, columns);
        }
        if(row<rows-1 && board[row+1][column]=='O'){
            boundaryDFS(board, row+1, column, rows, columns);
        }
        if(column>0 && board[row][column-1]=='O'){
            boundaryDFS(board, row, column-1, rows, columns);
        }
        if(column<columns-1 && board[row][column+1]=='O'){
            boundaryDFS(board, row, column+1, rows, columns);
        }
    }
}