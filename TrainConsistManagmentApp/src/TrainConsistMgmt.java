/*
 * UC18: Linear Search for Bogie ID (Array-Based Searching)
 *
 * @author Mohith
 * @version 18.0
 */

public class UseCase18TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC18 Linear Search for Bogie ID\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String targetId = "BG309";

        System.out.println("Train Consist: ");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }
        System.out.println("\n\nSearching for: " + targetId);

        boolean isFound = false;
        int foundIndex = -1;

        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(targetId)) {
                isFound = true;
                foundIndex = i;
                break;
            }
        }

        if (isFound) {
            System.out.println("Result: Bogie " + targetId + " found at position " + foundIndex);
        } else {
            System.out.println("Result: Bogie " + targetId + " not found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}
