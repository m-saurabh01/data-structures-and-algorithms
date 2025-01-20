package Graph;

public class FirstCompletelyPaintedRowAndColumn {
	
		  public int firstCompleteIndex(int[] arr, int[][] mat) {
		    final int m = mat.length;
		    final int n = mat[0].length;
		    int[] rows = new int[m];
		    int[] cols = new int[n];
		    int[] numToRow = new int[m * n + 1];
		    int[] numToCol = new int[m * n + 1];

		    for (int i = 0; i < m; ++i)
		      for (int j = 0; j < n; ++j) {
		        numToRow[mat[i][j]] = i;
		        numToCol[mat[i][j]] = j;
		      }

		    for (int i = 0; i < arr.length; ++i) {
		      if (++rows[numToRow[arr[i]]] == n)
		        return i;
		      if (++cols[numToCol[arr[i]]] == m)
		        return i;
		    }

		    throw new IllegalArgumentException();
		  }
	

}
