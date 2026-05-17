package AI;

import java.util.Scanner;

public class PrimsApplication {
    static final int INF = 99999;

    static int findMinVertex(int key[], boolean visited[], int vertices) {
        int min = INF;
        int minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    static void prims(int graph[][], int vertices) {
        int parent[] = new int[vertices];
        int key[] = new int[vertices];
        boolean visited[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            key[i] = INF;
            visited[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < vertices - 1; count++) {
            int u = findMinVertex(key, visited, vertices);

            if (u == -1) {
                break;
            }

            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int totalCost = 0;

        System.out.println("Cable connections selected:");

        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + " : " + graph[i][parent[i]]);
            totalCost = totalCost + graph[i][parent[i]];
        }

        System.out.println("Total minimum cable cost = " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Application: Connecting Computer Labs with Minimum Cable Cost");

        System.out.print("Enter number of labs: ");
        int vertices = sc.nextInt();

        int graph[][] = new int[vertices][vertices];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        prims(graph, vertices);

        sc.close();
    }
}

//------------------------------------------------------------------------------

// Algorithm: Prim's Minimum Spanning Tree Algorithm

// 1. Start program

// 2. Input number of labs(vertices)

// 3. Input adjacency matrix

// 4. Initialize:
//      key[] = INF
//      visited[] = false

// 5. Set starting vertex key = 0

// 6. Repeat vertices-1 times:
//      a. Find unvisited vertex with minimum key
//      b. Mark vertex as visited
//      c. Update key values of adjacent vertices

// 7. Store parent of each selected vertex

// 8. Print selected cable connections

// 9. Print minimum total cable cost

// 10. End

//==============================================================================

// Example Inputs

// Enter number of labs:
// 5

// Enter adjacency matrix:

// 0 2 0 6 0
// 2 0 3 8 5
// 0 3 0 0 7
// 6 8 0 0 9
// 0 5 7 9 0


// Output:

// Cable connections selected:

// 0 - 1 : 2
// 1 - 2 : 3
// 0 - 3 : 6
// 1 - 4 : 5

// Total minimum cable cost = 16

//=================================================================================
// Prim's Algorithm Application
// Connects computer labs with minimum cable cost
// using Minimum Spanning Tree (MST).


// static final int INF = 99999
// Represents infinity/large value.


// int graph[][]
// Adjacency matrix representation of graph.
// graph[i][j] stores cable cost.


// findMinVertex(key, visited, vertices)

// Finds unvisited vertex with minimum key value.


// key[]
// Stores minimum edge cost needed
// to connect each vertex.


// visited[]
// Tracks visited vertices.
// true -> visited
// false -> not visited.


// parent[]
// Stores parent vertex of MST.


// key[0] = 0
// Starts MST from vertex 0.


// parent[0] = -1
// Root vertex has no parent.


// int u = findMinVertex(...)

// Selects minimum cost vertex.


// visited[u] = true
// Marks selected vertex visited.


// if(graph[u][v] != 0 && !visited[v]
//    && graph[u][v] < key[v])

// Updates smaller edge cost if found.


// parent[v] = u
// Stores MST connection.


// key[v] = graph[u][v]
// Updates minimum cost.


// totalCost
// Stores total minimum cable cost.


// Prim's Algorithm:
// Greedy MST algorithm.
// Selects minimum edge step-by-step.


// MST (Minimum Spanning Tree):
// - Connects all vertices
// - Minimum total cost
// - No cycles


// Used in:
// - Network design
// - Cable connections
// - Railway networks
// - Electrical wiring


// main()
// Driver function of program.
// Execution starts from here.
