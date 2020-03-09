package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		Cell start = maze.getCell(randGen.nextInt(maze.cells.length), randGen.nextInt(maze.cells[0].length));
				
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(start);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.setBeenVisited(true);
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		
		ArrayList unvisitedNeighborsList = getUnvisitedNeighbors(currentCell);
		
		//C. if has unvisited neighbors,
		if(unvisitedNeighborsList.isEmpty() == false) {
			Cell selection = maze.getCell(randGen.nextInt(unvisitedNeighborsList.size()), randGen.nextInt(unvisitedNeighborsList.size()));
			uncheckedCells.push(selection);
			removeWalls(selection, currentCell);
			currentCell = selection;
			currentCell.setBeenVisited(true);
			selectNextPath(currentCell);
		}
		
			//C1. select one at random.
			
			//C2. push it to the stack
		
			//C3. remove the wall between the two cells

			//C4. make the new cell the current cell and mark it as visited
		
			//C5. call the selectNextPath method with the current cell
			
			
		//D. if all neighbors are visited
		if(unvisitedNeighborsList.isEmpty() == true) {
			if(uncheckedCells.isEmpty() == false) {
				currentCell = uncheckedCells.pop();
				selectNextPath(currentCell);
			}
		}
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX()+1 == c2.getX() && c1.getY() == c2.getY() && c1.getX()+1 < width) {
			c1.setEastWall(false);
		}
		else if(c1.getX() == c2.getX() && c1.getY()+1 == c2.getY() && c1.getY()+1 < height){
			c1.setSouthWall(false);
		}
		else if(c1.getX()-1 == c2.getX() && c1.getY() == c2.getY() && c1.getX()-1 > 0) {
			c1.setWestWall(false);
		}
		else if(c1.getX() == c2.getX() && c1.getY()-1 == c2.getY() && c1.getY() > 0) {
			c1.setNorthWall(false);
		}
		
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> unvisited = new ArrayList<Cell>();
		if(maze.getCell(c.getX()+1, c.getY()).hasBeenVisited() == false && c.getX() < width) {
			unvisited.add(maze.getCell(c.getX()+1, c.getY()));
		}
		else if(maze.getCell(c.getX(), c.getY()+1).hasBeenVisited() == false && c.getY() < height) {
			unvisited.add(maze.getCell(c.getX(), c.getY()+1));
		}
		else if(maze.getCell(c.getX()-1, c.getY()).hasBeenVisited() == false && c.getX() > 0) {
			unvisited.add(maze.getCell(c.getX()-1, c.getY()));
		}
		else if(maze.getCell(c.getX(), c.getY()-1).hasBeenVisited() == false && c.getY() > 0) {
			unvisited.add(maze.getCell(c.getX(), c.getY()-1));
		}
		
		return unvisited;
	}
}
