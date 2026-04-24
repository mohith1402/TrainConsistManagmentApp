/*
 * UC15: Safe Cargo Assignment Using try-catch-finally
 *
 * @author Mohith
 * @version 15.0
 */

import java.util.Arrays;

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC16 Sort Passenger Bogies by Capacity (Bubble Sort)\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities: "+"\n"+ Arrays.toString(capacities));

        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        System.out.println(" ");
        System.out.println("Sorted Capacities (Ascending): "+"\n"+ Arrays.toString(capacities));
        System.out.println("\nUC16 manual sorting completed...");
    }
}