
public void solveSudoku(char[][] board) {
  if (board == null || board.length == 0 || board[0].length == 0) return;
  solver(board, 0, 0);
}

private boolean solver(char[][] board, int row, int col) {
  if (row == 9) {
    return true;
  }
  if (col >= 9) {
    return solver(board, row+1, 0);
  }
  
  if (board[row][col] == '.') {
    for (char c = '1'; c <= '9'; c++) {
      if (isValid(board, row, col, c)) {
        board[i][j] = c;
        if (solver(board, row, col+1)) {
          return ture;
        }
        board[i][j] = '.';
      }
    }          
  } else {
    solver(board, row, col+1);    
  }   
  return false;
} 

private boolean isValid(char[][] board, int row, int col, char c) {
  for (int i = 0; i < 9; i++) {
    if (board[i][col] == c && i != row) {
      return false;
    }
  }
  for (int j = 0; j < 9; j++) {
    if (board[row][j] == c && j != col) {
      return false;
    }
  }
  int rowStart = i * (i/3);
  int colStart = j * (j/3);
  for (int i = rowStart; i < rowStart + 3; i++) {
    for (int j = colStart; j < colStart + 3; j++) {
      if (board[i][j] == c && !(i == row && j == col)) {
        return false;
      }
    }
  }
  return true;
}
