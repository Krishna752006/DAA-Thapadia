import java.util.*;

public class TSMP_LC {

    // Define the number of vertices and infinity value
    static int N;
    static final int INF = Integer.MAX_VALUE;

    // Node class to store each node along with the cost, level, and vertex
    static class Node {
        ArrayList<int[]> path = new ArrayList<>();
        int[][] reducedMatrix = new int[N][N];
        int cost;
        int vertex;
        int level;

		public String toString()
		{
			return ("cost " + cost + " vertex " + vertex + " level " + level);
		}
    }

    public static void main(String[] args) {
        // Define the cost matrix
  		Scanner sc=new Scanner(System.in);
		N = sc.nextInt();
		int adj[][] = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
		{
				adj[i][j] = sc.nextInt();
				if(adj[i][j] == 0)
					adj[i][j] = INF;
		}
        // Print the total cost of the tour
        System.out.println("Total cost is " + solve(adj));
    }

    // Function to allocate a new node
    static Node newNode(int[][] parentMatrix, ArrayList<int[]> path, int level, int i, int j) {
		System.out.println("newNode i " + i + " j " + j + " level " + level);
        Node node = new Node();
        node.path = (ArrayList<int[]>)path.clone();

        // Add this edge to the path
        if (level != 0) {
            node.path.add(new int[]{i, j});
        }

        // Copy data from parent matrix to current matrix
        for (int r = 0; r < N; r++) {
            node.reducedMatrix[r] = parentMatrix[r].clone();
        }

        // Change all entries of row i and column j to infinity
        // Also change the entry for vertex k to infinity
        if (level != 0) {
            for (int k = 0; k < N; k++) {
                node.reducedMatrix[i][k] = INF;
                node.reducedMatrix[k][j] = INF;
            }
            node.reducedMatrix[j][0] = INF;
        }

        // Update the level of node
        node.level = level;

        // Update the vertex number
        node.vertex = j;

        return node;
    }

    // Function to perform row reduction
    static int rowReduction(int[][] reducedMatrix, int[] row) {
        // Initialize row array to INF
        Arrays.fill(row, INF);

        // Row[i] contains minimum in row i
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (reducedMatrix[i][j] < row[i]) {
                    row[i] = reducedMatrix[i][j];
                }
            }
        }

        // Reduce the minimum value from each element in each row
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (reducedMatrix[i][j] != INF && row[i] != INF) {
                    reducedMatrix[i][j] -= row[i];
                }
            }
        }

        return 0;
    }

    // Function to perform column reduction
    static int columnReduction(int[][] reducedMatrix, int[] col) {
        // Initialize col array to INF
        Arrays.fill(col, INF);

        // Col[j] contains minimum in col j
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (reducedMatrix[i][j] < col[j]) {
                    col[j] = reducedMatrix[i][j];
                }
            }
        }

        // Reduce the minimum value from each element in each column
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (reducedMatrix[i][j] != INF && col[j] != INF) {
                    reducedMatrix[i][j] -= col[j];
                }
            }
        }

        return 0;
    }

    // Function to calculate the cost of the path
    static int calculateCost(int[][] reducedMatrix) {
        int cost = 0;
        int[] row = new int[N];
        rowReduction(reducedMatrix, row);
		//System.out.println("rowReduction "  + Arrays.deepToString(reducedMatrix));

        int[] col = new int[N];
        columnReduction(reducedMatrix, col);
		//System.out.println("columnReduction " + Arrays.deepToString(reducedMatrix));

        // Calculate the cost by adding the reduction values
        for (int i = 0; i < N; i++) {
            cost += (row[i] != INF) ? row[i] : 0;
            cost += (col[i] != INF) ? col[i] : 0;
        }
		System.out.println("Cost " + cost + " " + Arrays.deepToString(reducedMatrix));
        return cost;
    }

    // Function to print the path
    static void printPath(ArrayList<int[]> list) {
        for (int[] path : list) {
            System.out.println((path[0] + 1) + " -> " + (path[1] + 1));
        }
    }

    // Function to solve the TSP problem
    static int solve(int[][] CostGraphMatrix) {
        // Create a priority queue to store live nodes of the search tree
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        ArrayList<int[]> al = new ArrayList<>();

        // Create a root node and calculate its cost
        Node root = newNode(CostGraphMatrix, al, 0, -1, 0);
        root.cost = calculateCost(root.reducedMatrix);

        // Add root to the list of live nodes
        pq.add(root);

        // Continue until the priority queue becomes empty
        while (!pq.isEmpty()) {
            // Find a live node with the least estimated cost
            Node min = pq.poll();
			System.out.println("Node " + min);

            // Get the vertex number
            int i = min.vertex;

            // If all the cities have been visited
            if (min.level == N - 1) {
                min.path.add(new int[]{i, 0});
                printPath(min.path);
                return min.cost;
            }

            // Generate all the children of min
            for (int j = 0; j < N; j++) {
				//System.out.println("i " + i + " j " + j + " data " + min.reducedMatrix[i][j]);
                if (min.reducedMatrix[i][j] != INF) {
                    Node child = newNode(min.reducedMatrix, min.path, min.level + 1, i, j);
                    child.cost = min.cost + min.reducedMatrix[i][j] + calculateCost(child.reducedMatrix);
					System.out.println("Min cost @ node i " + i + " j " + j + " child.cost " + child.cost);
                    pq.add(child);
                }
            }
        }

        return 0;
    }
}