package AI;

import java.util.*;

class RoadEdge {
    int source;
    int destination;
    int cost;

    RoadEdge(int source, int destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }
}

public class MinimumSpanningTreeApplication {

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

        System.out.println("Application: Connecting Cities with Minimum Road Cost");

        System.out.print("Enter number of cities: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of roads: ");
        int edgesCount = sc.nextInt();

        RoadEdge edges[] = new RoadEdge[edgesCount];

        System.out.println("Enter source city, destination city and road cost:");
        for (int i = 0; i < edgesCount; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int cost = sc.nextInt();

            edges[i] = new RoadEdge(source, destination, cost);
        }

        Arrays.sort(edges, (a, b) -> a.cost - b.cost);

        int parent[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int selectedEdges = 0;

        System.out.println("Roads selected for minimum cost connection:");

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

        System.out.println("Total minimum road cost = " + totalCost);
    }
}

//-----------------------------------------------------------------------
// Algorithm: Minimum Spanning Tree using Kruskal's Algorithm

// 1. Start program

// 2. Input number of cities(vertices)

// 3. Input number of roads(edges)

// 4. Store all roads with source, destination and cost

// 5. Sort all roads in ascending order of cost

// 6. Initialize parent array
//    Each city is its own parent initially

// 7. Select roads one by one:
//      a. Find parent of source city
//      b. Find parent of destination city

// 8. If parents are different:
//      a. Add road to MST
//      b. Add cost to total cost
//      c. Perform union operation

// 9. Repeat until vertices-1 roads selected

// 10. Print minimum road cost

// 11. End

//==========================================================
// Example Inputs

// Enter number of cities:
// 4

// Enter number of roads:
// 5

// Enter source city, destination city and road cost:

// 0 1 10
// 0 2 6
// 0 3 5
// 1 3 15
// 2 3 4


// Output:

// Roads selected for minimum cost connection:

// 2 - 3 : 4
// 0 - 3 : 5
// 0 - 1 : 10

// Total minimum road cost = 19

//=====================================================================
// Minimum Spanning Tree Application
// Uses Kruskal's Algorithm to connect cities
// with minimum total road cost.


// class RoadEdge
// Represents a road(edge) between two cities.


// int source
// Starting city.


// int destination
// Ending city.


// int cost
// Cost/weight of road.


// RoadEdge constructor
// Initializes source, destination and cost.


// findParent(int parent[], int vertex)
// Finds parent/root of vertex.
// Used to detect cycles.


// if(parent[vertex] == vertex)
// Means vertex is root parent.


// union(int parent[], int u, int v)
// Connects two sets/components.


// Arrays.sort(edges, (a,b) -> a.cost - b.cost)
// Sorts roads in ascending order of cost.


// parent[]
// Stores parent of each city for Union-Find.


// parent[i] = i
// Initially every city is its own parent.


// totalCost
// Stores total minimum road cost.


// selectedEdges
// Counts number of roads selected in MST.


// if(sourceParent != destinationParent)
// Prevents cycle formation.
// Selects only valid roads.


// totalCost = totalCost + edges[i].cost
// Adds selected road cost to MST total.


// union(parent, source, destination)
// Merges connected components.


// Kruskal's Algorithm:
// Always selects minimum cost edge first.


// MST (Minimum Spanning Tree):
// Connects all vertices with:
// - Minimum total cost
// - No cycles


// main()
// Driver function of program.
// Execution starts from here.
