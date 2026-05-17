package AI;

import java.util.*;

class ProfitJob {
    String id;
    int deadline;
    int profit;

    ProfitJob(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSchedulingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Application: Job Scheduling for Maximum Profit");

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        ProfitJob jobs[] = new ProfitJob[n];

        System.out.println("Enter job id, deadline and profit:");
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();

            jobs[i] = new ProfitJob(id, deadline, profit);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            if (jobs[i].deadline > maxDeadline) {
                maxDeadline = jobs[i].deadline;
            }
        }

        String result[] = new String[maxDeadline];
        boolean slot[] = new boolean[maxDeadline];

        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = jobs[i].deadline - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = jobs[i].id;
                    totalProfit = totalProfit + jobs[i].profit;
                    break;
                }
            }
        }

        System.out.println("Selected jobs:");
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");
            }
        }

        System.out.println("\nTotal profit = " + totalProfit);

        sc.close();
    }
}

//---------------------------------------------------------------------------
// Algorithm: Job Scheduling for Maximum Profit

// 1. Start program

// 2. Input number of jobs

// 3. For each job:
//      Input:
//      - Job ID
//      - Deadline
//      - Profit

// 4. Sort jobs in descending order of profit

// 5. Find maximum deadline

// 6. Create slots for scheduling jobs

// 7. For each job:
//      a. Check free slot before its deadline
//      b. If free slot found:
//            Assign job to slot
//            Add profit to total profit

// 8. Print selected jobs

// 9. Print total profit

// 10. End

//========================================================================================
// Example Inputs

// Enter number of jobs:
// 5

// Enter job id, deadline and profit:

// J1 2 100
// J2 1 19
// J3 2 27
// J4 1 25
// J5 3 15


// Output:

// Selected jobs:
// J3 J1 J5

// Total profit = 142

//========================================================================================
// Job Scheduling Application
// Uses Greedy Method to schedule jobs
// for maximum total profit.


// class ProfitJob
// Represents a job with:
// - Job ID
// - Deadline
// - Profit


// String id
// Stores job name/id.


// int deadline
// Stores deadline of job.


// int profit
// Stores profit earned after completing job.


// ProfitJob constructor
// Initializes id, deadline and profit.


// Scanner sc
// Used for taking user input.


// ProfitJob jobs[]
// Array storing all jobs.


// Arrays.sort(jobs, (a,b) -> b.profit - a.profit)
// Sorts jobs in descending order of profit.
// Highest profit jobs come first.


// int maxDeadline
// Stores largest deadline value.


// String result[]
// Stores selected/scheduled jobs.


// boolean slot[]
// Tracks occupied/free slots.
// true -> slot occupied
// false -> slot free


// for(int j = jobs[i].deadline-1; j>=0; j--)

// Checks slots backward from deadline.
// Tries to place job in latest possible free slot.


// if(!slot[j])

// If slot is free:
// assign job to that slot.


// totalProfit = totalProfit + jobs[i].profit
// Adds selected job profit.


// Greedy Technique:
// Always selects highest profit job first.


// Example:

// Jobs:
// J1 2 100
// J2 1 19
// J3 2 27

// Sorted by profit:
// J1 J3 J2

// Selected jobs:
// J3 J1

// Maximum profit obtained.


// main()
// Driver function of program.
// Execution starts from here.
