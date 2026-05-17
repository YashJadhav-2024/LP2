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
