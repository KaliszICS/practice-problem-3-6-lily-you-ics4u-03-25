public class PracticeProblem {

	public static void main(String args[]) {
		String[][] maze = {
			{"", "", "", ""},
			{"", "", "", ""},
			{"", "", "", "F"},
			{"S", "", "", ""},
		  };
		
		System.out.println(searchMazeMoves(maze));
		System.out.println(noOfPaths(maze));

	}

	public static int searchMazeMoves(String[][] arr){
		int numMoves = 0;
		int row = arr.length - 1;
		int col = 0;
		return searchMazeMovesHelper(arr, row, col , numMoves);
	}
	
	public static int searchMazeMovesHelper(String[][] arr, int row, int col, int moves){
		//returns -1 when out of bounds
		if(row < 0 || col > arr[row].length-1){
			return -1;
		}
		
		//once it finds finish, return moves
		if(arr[row][col].equals("F")){
			return moves;
		}

		if(arr[row][col].equals("*")){
			return -1;
		}

		int movesUp = searchMazeMovesHelper(arr, row-1, col, moves + 1);
		int movesRight = searchMazeMovesHelper(arr, row, col+1, moves + 1);

		//why does this work?
		if(movesUp > movesRight){
			return movesUp;
		}
		else{
			return movesRight;
		}
	}

	public static int noOfPaths(String[][] arr){
		int row = arr.length-1;
		int col = 0;
		return noOfPathsHelper(arr, row, col);
	}
	public static int noOfPathsHelper(String[][] arr, int row, int col){
		if(row < 0 || col > arr[row].length-1){
			return 0; 
		}
		
		if(arr[row][col].equals("F")){
			return 1;
		}

		if(arr[row][col].equals("*")){
			return 0;
		}

		int movesUp = noOfPathsHelper(arr, row-1, col);
		int movesRight = noOfPathsHelper(arr, row, col+1);

		return movesUp + movesRight;
		
	}


	
}
