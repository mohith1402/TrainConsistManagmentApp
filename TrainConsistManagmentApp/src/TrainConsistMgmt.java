/*
 * UC20: Exception Handling During Search Operations
 *
 * @author Mohith
 * @version 20.0
 */

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC20 Exception Handling During Search\n");

        String[] bogieIds = {};

        String searchId = "BG101";

        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        boolean found = false;
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Result: Bogie " + searchId + " found.");
        } else {
            System.out.println("Result: Bogie " + searchId + " not found.");
        }

        System.out.println("\nUC20 execution completed...");
    }
}
