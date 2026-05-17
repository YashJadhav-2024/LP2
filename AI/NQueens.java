package AI;
import java.util.Scanner;
public class NQueens
{
    static int N ;


    static boolean isSafe(int board[][],int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i][col]==1)
                return false;     
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]==1)
                return false;
        }

        for(int i=row,j=col;i>=0 && j<N;i--,j++)
        {
            if(board[i][j]==1)
                return false;
        }

    return true;
    }
     static boolean solveNQ(int board[][],int row)
     {
        if(row==N)
            return true;

        for(int col=0;col<N;col++)
        {
            if(isSafe(board,row,col))
            {
                board[row][col]=1;

                if(solveNQ(board, row+1))
                    return true;

            }
            board[row][col]=0;
        }

return false;
     }
     static void printSolution(int board[][])
     {
        for(int i = 0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(board[i][j] + "");
            }
            System.out.println();
        }
     }

     public static void main(String args[])
     {
       System.out.println("Enter the amount of Queens");
       Scanner sc =new Scanner(System.in);
       N=sc.nextInt();
        int board[][]=new int[N][N];

        if(solveNQ(board,0))
            printSolution(board);

        else
            System.out.println("No Solution");
    
    }
}

































// N-Queens Problem using Backtracking

// The N-Queens problem places N queens on an N x N chessboard
// such that no two queens attack each other.

// A queen can attack:
// - Horizontally
// - Vertically
// - Diagonally

// Goal:
// Place all queens safely on board.

// -------------------------------------------------------------

// import java.util.Scanner
// Used for taking user input.


// static int N
// Stores number of queens and board size.


// int board[][]
// Represents chessboard.
// 0 -> Empty cell
// 1 -> Queen placed


// isSafe(int board[][], int row, int col)
// Checks whether queen can be safely placed at given position.


// Vertical Check
// Checks same column in previous rows.


// if(board[i][col] == 1)
// Returns false if another queen exists in same column.


// Left Diagonal Check
// Checks upper-left diagonal for queen attack.


// for(int i=row,j=col; i>=0 && j>=0; i--,j--)


// Right Diagonal Check
// Checks upper-right diagonal for queen attack.


// for(int i=row,j=col; i>=0 && j<N; i--,j++)


// return true
// Position is safe for queen placement.


// solveNQ(int board[][], int row)
// Main recursive backtracking function.


// if(row == N)
// Means all queens are placed successfully.


// for(int col=0; col<N; col++)
// Tries placing queen in every column of current row.


// if(isSafe(board,row,col))
// Places queen only if position is safe.


// board[row][col] = 1
// Places queen on board.


// solveNQ(board, row+1)
// Recursively tries placing queen in next row.


// Backtracking
// board[row][col] = 0
// Removes queen if solution not possible.
// Tries next position.


// printSolution(int board[][])
// Prints final chessboard solution.


// System.out.print(board[i][j] + "")
// Prints board values.


// Scanner sc
// Takes input from user.


// nextInt()
// Reads integer value for number of queens.


// main()
// Driver function of program.
// Takes board size input.
// Calls solveNQ().
// Prints solution if exists.


// Backtracking Concept:
// Try -> Check -> Move Forward
// If failure occurs:
// Return back and try another position.


// Example for N = 4
// One possible solution:

// 0 1 0 0
// 0 0 0 1
// 1 0 0 0
// 0 0 1 0

// Here:
// 1 = Queen
// 0 = Empty space

//------------------------------------------------------------

// Backtracking:
// Technique where program tries one solution.
// If it fails, it goes back and tries another possibility.

// In N-Queens:
// 1. Place queen
// 2. Check if safe
// 3. Move to next row
// 4. If no solution possible:
//    remove queen and try another position

// Example:
// board[row][col] = 1 -> Place queen
// board[row][col] = 0 -> Remove queen (Backtrack)


// Branch and Bound:
// Optimization technique.
// Branch -> Try different possible choices.
// Bound -> Stop exploring invalid paths early.

// In this program:
// isSafe(board,row,col)
// acts like bounding condition.
// Unsafe positions are rejected immediately.

// Example:
// If queen already exists in same column or diagonal:
// no need to continue checking that path.
// Program skips that position immediately.

// Example:
// Q _ _ _
// _ Q _ _

// Trying to place another queen diagonally attacking existing queen
// is rejected immediately.

// N-Queens mainly uses:
// Backtracking with pruning/bounding.
//----------------------------------------------------------
// Algorithm: N-Queens using Backtracking

// 1. Start program

// 2. Input number of queens N

// 3. Create N x N chessboard initialized with 0

// 4. Start placing queens row by row

// 5. For each column in current row:
//      a. Check if position is safe
//      b. If safe:
//            Place queen
//            Recursively place queen in next row

// 6. If all queens are placed:
//      Print solution
//      Stop

// 7. If no safe position found:
//      Remove previously placed queen
//      Try next column (Backtracking)

// 8. If all possibilities fail:
//      Print "No Solution"

// 9. End

//-----------------------------------------------------------------
// Algorithm: Branch and Bound

// 1. Start program

// 2. Divide problem into branches (possible choices)

// 3. For each branch:
//      a. Check if branch is valid/safe
//      b. If branch is invalid:
//            Reject it immediately (Bound)
//      c. Else:
//            Continue exploring that branch

// 4. Store best possible solution found so far

// 5. Continue until all valid branches are explored

// 6. Print best solution

// 7. End

// Example in N-Queens:
// If queen attacks another queen in same row,
// column or diagonal:
// reject that position immediately.

//-----------------------------------------------------------------------

// Difference Between Backtracking and Branch & Bound

// Backtracking:
// - Tries one solution at a time
// - If solution fails, goes back and tries another
// - Uses recursion
// - Explores more possibilities
// - Simpler approach

// Example in N-Queens:
// Place queen
// If next rows fail:
// remove queen and try another position


// Branch and Bound:
// - Optimization technique
// - Rejects invalid paths early
// - Uses pruning/bounding
// - Reduces unnecessary searching
// - Faster and more optimized

// Example in N-Queens:
// If queen attacks another queen:
// skip that position immediately


// In this program:
// Main technique used:
// Backtracking

// isSafe() provides small pruning idea
// similar to Branch and Bound.
