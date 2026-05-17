package AI;

import java.util.Scanner;

public class SelectionSortApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Application: Sorting Product Prices");

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int prices[] = new int[n];

        System.out.println("Enter product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (prices[j] < prices[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = prices[i];
            prices[i] = prices[minIndex];
            prices[minIndex] = temp;
        }

        System.out.println("Sorted prices:");
        for (int i = 0; i < n; i++) {
            System.out.print(prices[i] + " ");
        }

        sc.close();
    }
}






















// Algorithm: Selection Sort

// 1. Start program

// 2. Input number of elements

// 3. Store elements in array

// 4. For each position i:
//      a. Assume current index is minimum
//      b. Compare with remaining elements
//      c. Find smallest element

// 5. Swap smallest element
//    with current position

// 6. Repeat until array is sorted

// 7. Print sorted array

// 8. End


// Example:
// Array:
// 450 120 999 300 750

// Pass 1:
// Smallest = 120
// Swap with 450

// Array:
// 120 450 999 300 750

// Pass 2:
// Smallest = 300
// Swap with 450

// Array:
// 120 300 999 450 750

// Continue until fully sorted.

//======================================================================

// Selection Sort Application
// This program sorts product prices in ascending order
// using Selection Sort algorithm.


// import java.util.Scanner
// Imports Scanner class for user input.


// Scanner sc = new Scanner(System.in)
// Creates Scanner object for taking input.


// int n
// Stores number of products.


// int prices[] = new int[n]
// Array to store product prices.


// for loop for input
// Takes product prices from user and stores in array.


// Selection Sort Logic:

// Outer Loop:
// for(int i=0; i<n-1; i++)

// Represents current position where smallest element
// should be placed.


// int minIndex = i
// Assumes current element is smallest.


// Inner Loop:
// for(int j=i+1; j<n; j++)

// Searches remaining array for smaller element.


// if(prices[j] < prices[minIndex])

// Updates minIndex if smaller element found.


// Swapping:

// int temp = prices[i]
// prices[i] = prices[minIndex]
// prices[minIndex] = temp

// Swaps smallest element with current position.


// Example:

// Array:
// 450 120 999 300 750

// Pass 1:
// Smallest = 120
// Swap with 450

// Result:
// 120 450 999 300 750


// Pass 2:
// Smallest = 300
// Swap with 450

// Result:
// 120 300 999 450 750


// System.out.print()
// Prints sorted prices.


// sc.close()
// Closes Scanner object.


// main()
// Driver function of program.
// Execution starts from here.
