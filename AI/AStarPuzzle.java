package AI;
import java.util.*;

class State implements Comparable<State> {
    int[][] a = new int[3][3];
    int x, y, g, h;

    public int compareTo(State s) {
        return (this.g + this.h) - (s.g + s.h);
    }
}

public class AStarPuzzle {
    static int[][] goal = new int[3][3];

    static void print(State s) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(s.a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
    }

    static boolean isGoal(State s) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (s.a[i][j] != goal[i][j])
                    return false;
        return true;
    }

    static int heuristic(State s) {
        int h = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = s.a[i][j];
                if (val != 0) {
                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            if (goal[r][c] == val) {
                                h += Math.abs(i - r) + Math.abs(j - c);
                            }
                        }
                    }
                }
            }
        }
        return h;
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }

    static String getKey(State s) {
        String key = "";
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                key += s.a[i][j];
        return key;
    }

    static State inputState(Scanner sc, String msg) {
        State s = new State();
        System.out.println(msg);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter value at (" + i + "," + j + "): ");
                s.a[i][j] = sc.nextInt();
                if (s.a[i][j] == 0) {
                    s.x = i;
                    s.y = j;
                }
            }
        }
        s.g = 0;
        return s;
    }

    static void solve(State start) {
        PriorityQueue<State> pq = new PriorityQueue<>();
        HashSet<String> vis = new HashSet<>();

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        start.h = heuristic(start);
        pq.add(start);
        vis.add(getKey(start));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            System.out.println("Current State:");
            print(cur);
            System.out.println("Number of moves: " + cur.g);
            System.out.println("Heuristic cost: " + cur.h);
            System.out.println("-------------------");

            if (isGoal(cur)) {
                System.out.println("Goal State Reached!");
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (valid(nx, ny)) {
                    State next = new State();

                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            next.a[i][j] = cur.a[i][j];

                    int temp = next.a[cur.x][cur.y];
                    next.a[cur.x][cur.y] = next.a[nx][ny];
                    next.a[nx][ny] = temp;

                    next.x = nx;
                    next.y = ny;
                    next.g = cur.g + 1;
                    next.h = heuristic(next);

                    String key = getKey(next);
                    if (!vis.contains(key)) {
                        pq.add(next);
                        vis.add(key);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        State start = inputState(sc, "Enter initial state (0 for blank):");

        System.out.println("Enter goal state:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                goal[i][j] = sc.nextInt();

        System.out.println("Initial State:");
        print(start);

        solve(start);
    }
}





















// A* (A-Star) Algorithm
// A* is an AI search algorithm used to find the shortest/best path to goal state.
// It is commonly used in:
// - 8 Puzzle Problem
// - GPS Navigation
// - Robot Path Finding
// - Games and AI Search Problems

// A* Formula:
// f(n) = g(n) + h(n)

// f(n) -> Total estimated cost
// g(n) -> Actual cost from start node to current node
// h(n) -> Heuristic estimated cost from current node to goal

// In this program:
// g = number of moves made
// h = Manhattan Distance heuristic

// Manhattan Distance:
// Calculates distance of each tile from its correct position.

// -------------------------------------------------------------

// class State implements Comparable<State>
// Represents one puzzle state.
// Comparable is used so PriorityQueue can sort states based on cost.


// int[][] a
// Stores 3x3 puzzle matrix.


// int x, y
// Position of blank tile (0).


// int g
// Number of moves from start state.


// int h
// Heuristic cost (estimated distance from goal).


// compareTo(State s)
// Compares states based on f(n) = g + h.
// State with smaller cost gets higher priority.


// static int[][] goal
// Stores goal state puzzle.


// print(State s)
// Prints current puzzle state.


// isGoal(State s)
// Checks whether current state matches goal state.
// Returns true if goal reached.


// heuristic(State s)
// Calculates Manhattan Distance heuristic value.
// Lower heuristic means state is closer to goal.


// Math.abs()
// Returns absolute value.
// Used in Manhattan Distance calculation.


// valid(int x, int y)
// Checks whether puzzle move is inside matrix boundary.


// getKey(State s)
// Converts puzzle state into string.
// Used for checking visited states.


// inputState(Scanner sc, String msg)
// Takes puzzle input from user.
// Also finds blank tile position.


// solve(State start)
// Main A* search function.


// PriorityQueue<State> pq
// Stores states in sorted order based on lowest cost.
// A* always explores best state first.


// HashSet<String> vis
// Stores visited states to avoid repeated processing.


// dx[] and dy[]
// Arrays used for movement directions.
// Left, Right, Up, Down movement.


// pq.poll()
// Removes and returns state with minimum cost.


// if (isGoal(cur))
// Stops program when goal state is reached.


// State next = new State()
// Creates new child state after movement.


// next.g = cur.g + 1
// Increases move count.


// next.h = heuristic(next)
// Calculates heuristic for new state.


// vis.contains(key)
// Prevents revisiting already explored states.


// Scanner sc
// Used for user input.


// main()
// Driver function of program.
// Takes initial state and goal state input.
// Calls solve() function.


//------------------------------------------------------------------------

// Algorithm: A* (A-Star) Algorithm for 8 Puzzle Problem

// 1. Start program

// 2. Input initial state and goal state

// 3. Calculate heuristic value h(n)
//    using Manhattan Distance

// 4. Add initial state into Priority Queue

// 5. Repeat until queue becomes empty:

//      a. Remove state with minimum f(n)

//      b. Print current state

//      c. Check if current state is goal state
//            If yes:
//                Print solution
//                Stop

//      d. Generate all possible next states
//         by moving blank tile:
//            - Left
//            - Right
//            - Up
//            - Down

//      e. For each valid next state:
//            Calculate:
//            g(n) = number of moves
//            h(n) = heuristic cost
//            f(n) = g(n) + h(n)

//      f. If state not already visited:
//            Add into Priority Queue

// 6. Repeat process until goal state reached

// 7. End


// A* Formula:
// f(n) = g(n) + h(n)

// g(n):
// Actual cost from start state

// h(n):
// Estimated cost to reach goal

// f(n):
// Total estimated cost


// Heuristic Used:
// Manhattan Distance

// Math.abs(i-r) + Math.abs(j-c)


// Priority Queue:
// Always selects state with minimum cost first.

//========================================================
// Priority Queue Execution in A* 8 Puzzle

// Priority Queue stores states according to
// smallest f(n) = g(n) + h(n)

// Smallest cost state stays at FRONT.


// Initial State:
// 1 2 3
// 4 0 6
// 7 5 8

// g = 0
// h = 2
// f = 2


// Queue after inserting initial state:

// FRONT -> | State(f=2) | <- REAR


// pq.poll()
// Removes state with minimum cost.


// Generate next possible states:


// State 1 (Move LEFT)
// 1 2 3
// 0 4 6
// 7 5 8

// g=1 h=3 f=4


// State 2 (Move RIGHT)
// 1 2 3
// 4 6 0
// 7 5 8

// g=1 h=3 f=4


// State 3 (Move DOWN)
// 1 2 3
// 4 5 6
// 7 0 8

// g=1 h=1 f=2


// Priority Queue after insertion:

// FRONT -> | State(f=2) | State(f=4) | State(f=4) | <- REAR


// pq.poll()
// Removes best state first.

// Removed:
// State(f=2)


// Remaining Queue:

// FRONT -> | State(f=4) | State(f=4) | <- REAR


// Generate next states from best node.

// Goal State:
// 1 2 3
// 4 5 6
// 7 8 0

// g=2 h=0 f=2


// Insert goal state:

// FRONT -> | Goal(f=2) | State(f=4) | State(f=4) | <- REAR


// pq.poll()
// Goal state selected first because
// it has minimum cost.


// Goal State Reached.
