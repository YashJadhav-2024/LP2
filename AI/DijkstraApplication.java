package AI;

import java.util.Scanner;

public class DijkstraApplication {
    static final int INF = 99999;

    static int findMinDistance(int distance[], boolean visited[], int vertices) {
        int min = INF;
        int minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    static void dijkstra(int graph[][], int source, int vertices) {
        int distance[] = new int[vertices];
        boolean visited[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            distance[i] = INF;
            visited[i] = false;
        }

        distance[source] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = findMinDistance(distance, visited, vertices);

            if (u == -1) {
                break;
            }

            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && distance[u] != INF
                        && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        System.out.println("City \t Shortest Distance from Source");

        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Application: Finding Shortest Distance from One City");

        System.out.print("Enter number of cities: ");
        int vertices = sc.nextInt();

        int graph[][] = new int[vertices][vertices];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source city: ");
        int source = sc.nextInt();

        dijkstra(graph, source, vertices);

        sc.close();
    }
}

//--------------------------------------------------------------------------
// Algorithm: Dijkstra's Shortest Path Algorithm

// 1. Start program

// 2. Input number of cities(vertices)

// 3. Input adjacency matrix of graph

// 4. Input source city

// 5. Initialize:
//      distance[] = INF
//      visited[] = false

// 6. Set source distance = 0

// 7. Repeat vertices-1 times:
//      a. Find unvisited city with minimum distance
//      b. Mark city as visited
//      c. Update distances of neighboring cities

// 8. Print shortest distance from source
//    to all cities

// 9. End

//===================================================================================
// Example Inputs

// Enter number of cities:
// 5

// Enter adjacency matrix:

// 0 10 0 30 100
// 10 0 50 0 0
// 0 50 0 20 10
// 30 0 20 0 60
// 100 0 10 60 0

// Enter source city:
// 0


// Output:

// City    Shortest Distance from Source

// 0       0
// 1       10
// 2       50
// 3       30
// 4       60

//======================================================================================
// Dijkstra's Algorithm Application
// Finds shortest distance from one city
// to all other cities.


// static final int INF = 99999
// Represents infinity/very large value.


// int graph[][]
// Adjacency matrix representation of graph.
// graph[i][j] stores distance between cities.


// findMinDistance(distance, visited, vertices)

// Finds unvisited city with minimum distance.


// int min = INF
// Stores minimum distance value.


// visited[]
// Tracks visited cities.
// true -> city visited
// false -> city not visited.


// distance[]
// Stores shortest distance from source city.


// distance[source] = 0
// Distance from source to itself is zero.


// for(count = 0; count < vertices-1; count++)

// Repeats process for all cities.


// int u = findMinDistance(...)

// Selects nearest unvisited city.


// visited[u] = true
// Marks city as visited.


// Relaxation Condition:

// if(!visited[v] && graph[u][v] != 0
//    && distance[u] + graph[u][v] < distance[v])

// Updates shorter path if found.


// distance[v] = distance[u] + graph[u][v]

// Updates shortest distance.


// Adjacency Matrix Example:

// 0 10 0 30 100
// 10 0 50 0 0

// Means:
// City 0 -> City 1 = 10
// City 0 -> City 3 = 30


// Dijkstra's Algorithm:
// Greedy shortest path algorithm.


// Used in:
// - GPS Navigation
// - Network Routing
// - Maps
// - Internet Routing


// main()
// Driver function of program.
// Execution starts from here.
