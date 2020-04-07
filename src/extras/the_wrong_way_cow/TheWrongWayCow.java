//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;


public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the x,y coordinate position of the
        // head (letter 'c') of the wrong way cow!
    	/*
    	int midind = 0;
    	int lastind = 0;
    	int wrongind = 0;
    	int[] finalCoord;
    	String direction = null;
    	
        for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				
				//if direction is right
				if(field[i][j] == 'c') {
					//if next letter is o
					for (int x = 0; x < field.length; x++) {
						if(field[i+x][j] == 'o') {
							midind = i+x;
							break;
						}
					}
					//if next letter is w set direction to right
					for (int y = 0; y < field.length; y++) {
						if(field[midind+y][j] == 'w') {
							lastind = midind+y;
							direction = "right";
							
						}
					}
				}
				if(direction.equals("right")) {
					for (int r = 0; r < field.length; r++) {
						//if next letter is in wrong direction
						if(field[lastind+r][j] != 'c') {
							wrongind = lastind+r;
							break;
						}
					}
					for (int a = 0; a < field.length; a++) {
						if(field[wrongind+a][j] == 'c') {
							finalCoord = new int[] {wrongind+a, j};
							return finalCoord;
						}
					}
				}
				//if direction is left
				
			}
		}
		*/
    	String direction = null;
    	int r = 0;
    	int l = 0;
    	int u = 0;
    	int d = 0;
    	int[] rightC = null;
    	int[] leftC = null;
    	int[] upC = null;
    	int[] downC = null;
    	//int up = 0;
    	for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[0].length; y++) {
				if(field[x][y] == 'c') {
					if(field.length > x+2 && field[x+1][y] == 'o' && field[x+2][y] == 'w') {
						direction = "down";
						d++;
						downC = new int[] {y, x};
					}
					else if(x-2 > 0 && field[x-1][y] == 'o' && field[x-2][y] == 'w') {
						direction = "up";
						u++;
						upC = new int[] {y, x};
						//up = x;
					}
					else if(y-2 > 0 && field[x][y-1] == 'o' && field[x][y-2] == 'w') {
						direction = "left";
						l++;
						leftC = new int[] {y, x};
					}
					else if(y+2 < field[0].length && field[x][y+1] == 'o' && field[x][y+2] == 'w') {
						direction = "right";
						r++;
						rightC = new int[] {y, x};
					}
				}				
			}
		}
		//System.out.println("hi" + u + " ," + d);

    	//simple
		if(d < r && d > 0) {
			return downC;
		}
		//ex1
		if(l < r && l > 0) {
			return leftC;
		}
		//ex2
		if(r < d && r > 0) {
			return rightC;
		}
		//wwcE
		if(r < l && r > 0) {
			return rightC;
		}
		//wwcN
		if(u < d && u > 0) {
			return upC;
		}
		//wwcS
		if(r < u && r > 0) {
			return rightC;
		}
		
		
    	return null;
    
    }
}
