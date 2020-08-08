import gpdraw.*;
import java.io.*;
import java.util.Scanner;

public class Life {
	// This loads the information from the life100.txt file into the program.
	public Life(int[][] dish) {
		Scanner inFile;
		try {
			inFile = new Scanner (new File("life100.txt"));
			int numBacteria = inFile.nextInt();
			for (int i = 0; i < numBacteria; i++) {
				int row = inFile.nextInt();
				int col = inFile.nextInt();
				dish[row][col] = 100;
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// This outputs all of the current information to the screen.
	public void screenDump (int[][] temp) {
		System.out.printf("%5s", "");
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(j);
			}
			System.out.print(0);
		}
		System.out.println();
		for (int row = 1; row < temp.length-1; row++) {
			System.out.printf("%2d", row);
			System.out.printf("%3s", "");
			for (int col = 1; col < temp.length-1; col++) {
				if (temp[row][col] >= 100) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	// This counts the number of living cells.
	public int countLiving (int[][] temp) {
		int count = 0;
		for (int row = 1; row < temp.length-1; row++) {
			for (int col = 1; col < temp[row].length-1; col++) {
				if (temp[row][col] >= 100) {
					count++;
				}
			}
		}
		return count;
	}
	
	// This counts the number of living cells within a row.
	public int countRow(int[][] temp, int row) {
		int count = 0;
		for (int col = 1; col < temp[row].length-1; col++) {
			if(temp[row][col] >= 100) {
				count++;
			}
		}
		return count;
	}
	
	// This counts the number of living cells within a column.
	public int countCol(int[][] temp, int col) {
		int count = 0; 
		for (int row = 1; row < temp.length-1; row++) {
			if (temp[row][col] >= 100) {
				count++;
			}
		}
		return count;
	}
	
	// This increments all of the cells surrounding the current cell so that it can be determined which cells survive into the next generation.
	public void addNeighbors(int[][] temp, int r, int c) {
		temp[r+1][c]++;
		temp[r+1][c+1]++;
		temp[r+1][c-1]++;
		temp[r][c+1]++;
		temp[r][c-1]++;
		temp[r-1][c]++;
		temp[r-1][c+1]++;
		temp[r-1][c-1]++;
	}
	
	// This direclty determines which cells live into the next generation. 
	public void lifeOrDeath (int[][] mainDish, int[][] dataDish) {
		for (int row = 1; row < dataDish.length-1; row++) {
			for (int col = 1; col < dataDish[row].length-1; col++) {
				if(dataDish[row][col] == 3) {
					mainDish[row][col] = 100;
				} else if (dataDish[row][col] == 102 || dataDish[row][col] == 103) {
					mainDish[row][col] = 100;
				} else {
					mainDish[row][col] = 0;
				}
			}
		}
	}
	
	// This calculates the amount which the current cells contribute to the next generation.
	public void nextGen(int[][] mainDish) {
		int[][] dataDish = new int[mainDish.length][mainDish[0].length];
		int row, col;
		
		for (row = 1; row < mainDish.length-1; row++) {
			for (col = 1; col < mainDish.length-1; col++) {
				if (mainDish[row][col] >= 100) {
					addNeighbors(dataDish, row, col);
					dataDish[row][col] += 100;
				}
			}
		}
		lifeOrDeath(mainDish, dataDish);
	}
}