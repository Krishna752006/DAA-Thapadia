import java.util.*;

class Maze 
{ 
	private int size; 
	Maze(int N){
		this.size = N;
	}
	
	boolean solveMaze(int maze[][]) { 
		//WRITE YOUR CODE HERE
		if(maze[0][0] == 0) return false;
		return solve(maze,0,0);
	} 
	boolean solve(int[][] maze,int i,int j)
	{
	    if(i == size-1 && j == size-1 && maze[i][j] == 1)
	    return true;
	    if(i == size || j == size)
	    return false;
	    if(maze[i][j] == 0)
	    return false;
	    return (solve(maze,i+1,j)) || (solve(maze,i,j+1));
	}

}
public class Solution{
	public static void main(String args[]) 
	{ 
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Maze m = new Maze(n); 
		int maze[][] = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				maze[i][j]=sc.nextInt();
		System.out.println(m.solveMaze(maze)); 
	} 
} 