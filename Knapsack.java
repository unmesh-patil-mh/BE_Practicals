
import java.util.*;

class Knapsack {

    static void fractionalKnapsack(int n, int capacity,
                                   int[] weight, int[] profit) {

        double[] ratio = new double[n];

        // Calculate profit/weight ratio
        for (int i = 0; i < n; i++) {
            ratio[i] = (double) profit[i] / weight[i];
        }

        // Sort items by ratio in descending order
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {

                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    int t = weight[i];
                    weight[i] = weight[j];
                    weight[j] = t;

                    t = profit[i];
                    profit[i] = profit[j];
                    profit[j] = t;
                }
            }
        }

        double totalProfit = 0;

        // Select items using Greedy Method
        for (int i = 0; i < n; i++) {

            if (capacity >= weight[i]) {
                totalProfit += profit[i];
                capacity -= weight[i];
            }
            else {
                totalProfit += ratio[i] * capacity;
                break;
            }
        }

        System.out.println("Maximum Profit: " + totalProfit);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        fractionalKnapsack(n, capacity, weight, profit);

        sc.close();
    }
}
