package AI;

import java.util.*;

class RailwayEdge {
    int source;
    int destination;
    int cost;

    RailwayEdge(int source, int destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }
}

public class KruskalsApplication {

    static int findParent(int parent[], int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }

        return findParent(parent, parent[vertex]);
    }

    static void union(int parent[], int u, int v) {
        int parentU = findParent(parent, u);
        int parentV = findParent(parent, v);

        parent[parentU] = parentV;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Application: Connecting Cities by Railway Tracks");

        System.out.print("Enter number of cities: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of railway tracks: ");
        int edgesCount = sc.nextInt();

        RailwayEdge edges[] = new RailwayEdge[edgesCount];

        System.out.println("Enter source city, destination city and railway cost:");
        for (int i = 0; i < edgesCount; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int cost = sc.nextInt();

            edges[i] = new RailwayEdge(source, destination, cost);
        }

        Arrays.sort(edges, (a, b) -> a.cost - b.cost);

        int parent[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int selectedEdges = 0;
        int totalCost = 0;

        System.out.println("Railway tracks selected:");

        for (int i = 0; i < edgesCount && selectedEdges < vertices - 1; i++) {
            int sourceParent = findParent(parent, edges[i].source);
            int destinationParent = findParent(parent, edges[i].destination);

            if (sourceParent != destinationParent) {
                System.out.println(edges[i].source + " - " + edges[i].destination + " : " + edges[i].cost);

                totalCost = totalCost + edges[i].cost;
                selectedEdges++;

                union(parent, edges[i].source, edges[i].destination);
            }
        }

        System.out.println("Total minimum railway cost = " + totalCost);

        sc.close();
    }
}

//-------------------------------------------------------------------------------------
// Algorithm: Kruskal's Algorithm for Minimum Railway Cost

// 1. Start program

// 2. Input number of cities(vertices)

// 3. Input number of railway tracks(edges)

// 4. Store source city, destination city and cost

// 5. Sort all railway tracks in ascending order of cost

// 6. Initialize parent array
//    Each city is its own parent initially

// 7. Select railway tracks one by one:
//      a. Find parent of source city
//      b. Find parent of destination city

// 8. If parents are different:
//      a. Select railway track
//      b. Add cost to total cost
//      c. Perform union operation

// 9. Repeat until vertices-1 tracks selected

// 10. Print selected railway tracks

// 11. Print minimum railway cost

// 12. End

//====================================================================================

// Example Inputs

// Enter number of cities:
// 4

// Enter number of railway tracks:
// 5

// Enter source city, destination city and railway cost:

// 0 1 10
// 0 2 6
// 0 3 5
// 1 3 15
// 2 3 4


// Output:

// Railway tracks selected:

// 2 - 3 : 4
// 0 - 3 : 5
// 0 - 1 : 10

// Total minimum railway cost = 19

//======================================================================================
// Kruskal's Algorithm Application
// Connects cities using minimum railway cost
// without forming cycles.


// class RailwayEdge
// Represents railway connection(edge)
// between two cities.


// int source
// Starting city.


// int destination
// Ending city.


// int cost
// Railway track cost.


// RailwayEdge constructor
// Initializes source, destination and cost.


// findParent(int parent[], int vertex)
// Finds root parent of city.
// Used for cycle detection.


// if(parent[vertex] == vertex)
// Means city is its own parent/root.


// union(int parent[], int u, int v)
// Connects two sets/components.


// Arrays.sort(edges, (a,b) -> a.cost - b.cost)
// Sorts railway tracks by minimum cost.


// parent[]
// Stores parent/root of each city.


// parent[i] = i
// Initially every city is separate.


// selectedEdges
// Counts number of railway tracks selected.


// totalCost
// Stores minimum total railway cost.


// if(sourceParent != destinationParent)

// Prevents cycle formation.
// Selects only valid railway tracks.


// totalCost = totalCost + edges[i].cost
// Adds selected railway cost.


// union(parent, source, destination)
// Merges connected cities/components.


// Kruskal's Algorithm:
// Greedy algorithm.
// Always selects minimum cost edge first.


// MST (Minimum Spanning Tree):
// - Connects all cities
// - Minimum total cost
// - No cycles


// main()
// Driver function of program.
// Execution starts from here.
