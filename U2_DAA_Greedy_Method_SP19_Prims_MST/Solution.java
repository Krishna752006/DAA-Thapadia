import java.util.Scanner;

class Solution {

    // Number of vertices in the graph
    private static int V;

    // A utility function to find the vertex with the minimum key value,
    // from the set of vertices not yet included in the MST
    int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    // A utility function to print the constructed MST stored in parent[]
    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Function to construct and print the MST for a graph represented using an adjacency matrix
    void primMST(int graph[][]) {
        int parent[] = new int[V];  // Array to store constructed MST
        int key[] = new int[V];     // Key values used to pick the minimum weight edge in the cut
        Boolean mstSet[] = new Boolean[V];  // To represent set of vertices included in the MST

        // Initialize all keys as INFINITE and mstSet[] as false
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include the first vertex in the MST
        key[0] = 0;       // Make the key 0 so that this vertex is picked first
        parent[0] = -1;   // First node is always the root of the MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in the MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non-zero only for adjacent vertices of u
                // mstSet[v] is false for vertices not yet included in the MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of vertices
        V = sc.nextInt();

        // Initialize the adjacency matrix
        int[][] graph = new int[V][V];

        // Read the graph as an adjacency matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        Solution t = new Solution();
        t.primMST(graph);
    }
}
