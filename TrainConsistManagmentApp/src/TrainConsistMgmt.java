/*
 * UC6: Map Bogie to Capacity (HashMap)
 *
 * @author Mohith
 * @version 6.0
 */

import java.util.HashMap;
import java.util.Map;

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC6 Map Bogie to Capacity (HashMap)\n");

        Map<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 120);
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            if (entry.getKey().equals("AC Chair")) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            } else {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}