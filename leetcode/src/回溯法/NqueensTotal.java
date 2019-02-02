package »ØËÝ·¨;

public class NqueensTotal {
	 private boolean[] colUsed;
	    private boolean[] diagonals45Used;
	    private boolean[] diagonals135Used;
	    private int n;
	    private int total;

	    public int totalNQueens(int n) {     
	    colUsed = new boolean[n];
	    diagonals45Used = new boolean[2 * n - 1];
	    diagonals135Used = new boolean[2 * n - 1];
	    this.n = n;
	    backtracking(0);
	    return total;
	    }
	    
	    private void backtracking(int row) {
	    if (row == n) {
	        ++total;
	        return;
	    }

	    for (int col = 0; col < n; col++) {
	        int diagonals45Idx = row + col;
	        int diagonals135Idx = n - 1 - (row - col);
	        if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx]) {
	            continue;
	        }
	       
	        colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = true;
	        backtracking(row + 1);
	        colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = false;
	        
	    }
	 }
	    
}
