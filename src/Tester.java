public class Tester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// This creates a 22x22 2D-Array, which represents a 20x20 grid.
		int[][] petridish = new int[22][22];
		Life app = new Life (petridish);
		int generation = 0;
		int initialBacteriaNum = app.countLiving(petridish); 
		System.out.println("Starting Generation = " + generation + "\n");
		app.screenDump(petridish);
		// This calculates the "Game of Life" for the next five generations.
		for (int i = 0; i < 5; i++) {
			app.nextGen(petridish);
			generation++;
		}
		// This displays the "Game of Life" for the end of the next five generations.
		System.out.println();
		System.out.println("Ending Generation = " + generation + "\n");
		app.screenDump(petridish);
		System.out.println();
		System.out.println("Number in Row 10 ---> " + app.countRow(petridish, 10));
		System.out.println("Number in Column 10 ---> " + app.countCol(petridish, 10));
		System.out.println("Number of living organisms ---> " + app.countLiving(petridish));
	}
}
