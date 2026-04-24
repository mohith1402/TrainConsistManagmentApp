/*
 * UC19: Binary Search for Bogie ID (Optimized Searching)
 *
 * @author Mohith
 * @version 19.0
 */

import java.util.Arrays;

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC19 Binary Search for Bogie ID\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String targetId = "BG309";

        Arrays.sort(bogieIds);

        System.out.println("Sorted Train Consist:");
        System.out.println(Arrays.toString(bogieIds));
        System.out.println("\nSearching for: " + targetId);

        int left = 0;
        int right = bogieIds.length - 1;
        boolean isFound = false;
        int foundIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = bogieIds[mid].compareTo(targetId);

            if (comparison == 0) {
                isFound = true;
                foundIndex = mid;
                break;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (isFound) {
            System.out.println("Result: Bogie " + targetId + " found at index " + foundIndex);
        } else {
            System.out.println("Result: Bogie " + targetId + " not found");
        }

        System.out.println("\nUC19 binary search completed...");
    }
}
