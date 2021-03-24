import java.util.*;


class SudokuProblem{

	public static void checkIfPresent(int[][] sudoku, int[] rows, int[] cols, int[][] grids, int i, int j, int num){

		if(
			(rows[i] & (1 << num)) == 0 &&
			(cols[j] & (1 << num)) == 0 &&
			(grids[i / 3][j / 3] & (1 << num)) == 0
		  ){
		  	// rows[i] ^= (1 << num);
		  	// cols[j] ^= (1 << num);
		  	// grids[i / 3][j / 3] ^= (1 << num);
			System.out.println("Number not present");
			return;
		}
		System.out.println("Number present");
	}

	public static void main(String[] args){

		int[][] sudoku = {

			{3, 0, 6, 5, 0, 8, 4, 0, 0},
			{5, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 8, 7, 0, 0, 0, 0, 3, 1},
			{0, 0, 3, 0, 1, 0, 0, 8, 0},
			{9, 0, 0, 8, 6, 3, 0, 0, 5},
			{0, 5, 0, 0, 9, 0, 6, 0, 0},
			{1, 3, 0, 0, 0, 0, 2, 5, 0},
			{0, 0, 0, 0, 0, 0, 0, 7, 4},
			{0, 0, 5, 2, 0, 6, 3, 0, 0}

		};
		int[] rows = new int[9];
		int[] cols = new int[9];
		int[][] grids = new int[3][3];


		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				int digit = sudoku[i][j];
				rows[i] |= (1 << digit);
				cols[j] |= (1 << digit);
				grids[i / 3][j / 3] |= (1 << digit); 
			}
		}

		 
		int row = 0;
		int col = 3;
		int num = 7; 

		checkIfPresent(sudoku, rows, cols, grids, row, col, num);

	}
}