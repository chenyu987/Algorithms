/*
This question is about implementing a basic elimination algorithm for Candy Crush.

Given an m x n integer array board representing the grid of candy where board[i][j] represents the type of candy. A value of board[i][j] == 0 represents that the cell is empty.

The given board represents the state of the game following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:

If three or more candies of the same type are adjacent vertically or horizontally, crush them all at the same time - these positions become empty.
After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will drop until they hit a candy or bottom at the same time. No new candies will drop outside the top boundary.
After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
If there does not exist more candies that can be crushed (i.e., the board is stable), then return the current board.
You need to perform the above rules until the board becomes stable, then return the stable board.

Input: board = [[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]
Output: [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]
Example 2:

Input: board = [[1,3,5,5,2],[3,4,3,3,1],[3,2,4,5,2],[2,4,4,5,5],[1,4,4,1,1]]
Output: [[1,3,0,0,0],[3,4,0,5,2],[3,2,0,3,1],[2,4,0,5,2],[1,4,3,1,1]]
*/

class Solution {
    public int[][] candyCrush(int[][] board) {
        boolean end = false;
        while(!end){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if((i<board.length-2) && Math.abs(board[i][j])==Math.abs(board[i+1][j]) && Math.abs(board[i][j]) == Math.abs(board[i+2][j])){
                        board[i+1][j] = -Math.abs(board[i][j]);
                        board[i+2][j] = -Math.abs(board[i][j]);
                        board[i][j] = -Math.abs(board[i][j]);
                    }

                    if((j < board[0].length-2) && Math.abs(board[i][j]) == Math.abs(board[i][j+1]) && Math.abs(board[i][j])==Math.abs(board[i][j+2])){
                        board[i][j+1] = -Math.abs(board[i][j]);
                        board[i][j+2] = -Math.abs(board[i][j]);
                        board[i][j] = -Math.abs(board[i][j]);
                    }

                }
            }
            end = true;
            for(int i=0;i<board[0].length;i++){
                int tmp = board.length-1;
                for(int j=board.length-1;j>-1;j--){
                    if(board[j][i] < 0){
                        end = false;
                    }
                    else{
                        board[tmp][i] = board[j][i];
                        tmp--;
                    }
                }
                
                while(tmp > -1){
                    board[tmp][i] = 0;
                    tmp--;
                }
                
            }
        }
        return board;
    }
}
