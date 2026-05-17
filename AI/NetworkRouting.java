package AI;
import java.util.*;

public class NetworkRouting {
    private int vertices;
    private LinkedList<Integer>[] adj;
    private String[] routerNames;

    NetworkRouting(int v) {
        vertices = v;
        adj = new LinkedList[v];
        routerNames = new String[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addRouter(int id, String name) {
        routerNames[id] = name;
    }

    void addConnection(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void displayRouters() {
        System.out.println("\nRouters in Network:");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " - " + routerNames[i]);
        }
    }

    void displayNetwork() {
        System.out.println("\nNetwork Connections:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(routerNames[i] + " -> ");
            for (int neighbor : adj[i]) {
                System.out.print(routerNames[neighbor] + " ");
            }
            System.out.println();
        }
    }

    void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.println("\nDFS Traversal starting from " + routerNames[start] + ":");
        DFSUtil(start, visited);
        System.out.println();
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(routerNames[v] + " ");

        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.add(start);

        System.out.println("\nBFS Traversal starting from " + routerNames[start] + ":");

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(routerNames[v] + " ");

            for (int neighbor : adj[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of routers: ");
        int n = sc.nextInt();
        sc.nextLine();

        NetworkRouting network = new NetworkRouting(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of router " + i + ": ");
            String name = sc.nextLine();
            network.addRouter(i, name);
        }

        System.out.print("\nEnter number of connections: ");
        int edges = sc.nextInt();

        network.displayRouters();

        for (int i = 0; i < edges; i++) {
            System.out.print("\nEnter first router index for connection " + (i + 1) + ": ");
            int a = sc.nextInt();

            System.out.print("Enter second router index for connection " + (i + 1) + ": ");
            int b = sc.nextInt();

            network.addConnection(a, b);
        }

        network.displayNetwork();
        network.displayRouters();

        System.out.print("\nEnter starting router index for traversal: ");
        int start = sc.nextInt();

        network.DFS(start);
        network.BFS(start);

        sc.close();
    }
}
























// DFS and BFS Network Routing Program

// This program represents a computer network using Graph data structure.
// Routers are vertices/nodes.
// Connections between routers are edges.

// DFS -> Depth First Search
// BFS -> Breadth First Search

// -------------------------------------------------------------

// import java.util.*
// Imports utility classes like LinkedList, Queue and Scanner.


// class NetworkRouting
// Main class of program.


// int vertices
// Stores number of routers/nodes.


// LinkedList<Integer>[] adj
// Adjacency list representation of graph.
// Stores neighbors/connections of each router.


// String[] routerNames
// Stores names of routers.


// NetworkRouting(int v)
// Constructor.
// Initializes graph with given number of vertices.


// adj[i] = new LinkedList<Integer>()
// Creates linked list for every router.


// addRouter(int id, String name)
// Assigns name to router index.


// addConnection(int v, int w)
// Adds connection between two routers.
// Since graph is undirected:
// v -> w
// w -> v


// displayRouters()
// Displays all routers with indexes.


// displayNetwork()
// Prints adjacency list/network structure.


// DFS(int start)
// Starts DFS traversal from given router.


// boolean[] visited
// Tracks visited routers to avoid revisiting.


// DFSUtil(int v, boolean[] visited)
// Recursive helper function for DFS traversal.


// visited[v] = true
// Marks current router as visited.


// for (int neighbor : adj[v])
// Traverses all neighboring routers.


// if (!visited[neighbor])
// Visits only unvisited neighbors.


// DFS uses:
// - Recursion
// - Stack concept
// - Goes deep first before backtracking.


// BFS(int start)
// Starts Breadth First Search traversal.


// Queue<Integer> queue
// Queue used in BFS traversal.


// queue.add(start)
// Inserts starting router into queue.


// queue.poll()
// Removes front element from queue.


// BFS visits:
// - Level by level
// - Nearest neighbors first.


// visited[neighbor] = true
// Marks neighbor visited before adding to queue.


// Scanner sc
// Used for taking user input.


// nextInt()
// Takes integer input.


// nextLine()
// Takes string input.


// sc.close()
// Closes scanner object.


// main()
// Driver function of program.
// Takes router details and connections.
// Calls DFS and BFS traversal functions.

//======================================================

// Algorithm: DFS (Depth First Search)

// 1. Start program

// 2. Mark starting node as visited

// 3. Print current node

// 4. Visit first unvisited neighbor

// 5. Repeat steps 2-4 recursively
//    until no unvisited neighbor exists

// 6. Backtrack to previous node

// 7. Continue remaining unvisited neighbors

// 8. Stop when all nodes are visited


// DFS uses:
// - Recursion
// - Stack concept
// - Goes deep first


// -------------------------------------------------------------

// Algorithm: BFS (Breadth First Search)

// 1. Start program

// 2. Mark starting node as visited

// 3. Insert starting node into queue

// 4. Remove front node from queue

// 5. Print current node

// 6. Insert all unvisited neighbors into queue

// 7. Repeat until queue becomes empty

// 8. Stop when all nodes are visited


// BFS uses:
// - Queue data structure
// - Visits level by level
// - Nearest neighbors first

//=========================================================================

// DFS uses Recursion and Stack

// DFS goes deep into one path first.

// Example Graph:
// A -> B -> D
// A -> C

// DFS Traversal:
// A -> B -> D

// Recursion Stack:
// TOP
// | D |
// | B |
// | A |
// BOTTOM

// After finishing D,
// stack backtracks to B then A,
// then visits C.


// -------------------------------------------------------------

// BFS uses Queue

// BFS visits nodes level by level.

// Example Graph:
//      A
//     / \
//    B   C
//        |
//        D

// BFS Traversal:
// A -> B -> C -> D

// Queue Execution:

// FRONT -> | A | <- REAR

// Remove A
// Insert B,C

// FRONT -> | B | C | <- REAR

// Remove B

// FRONT -> | C | <- REAR

// Remove C
// Insert D

// FRONT -> | D | <- REAR


// DFS -> Deep first
// BFS -> Level first
