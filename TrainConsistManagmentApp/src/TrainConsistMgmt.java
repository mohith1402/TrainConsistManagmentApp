/*
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 *
 * @author Mohith
 * @version 3.0
 */

import java.util.HashSet;
import java.util.Set;

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC3 Track Unique Bogie IDs\n");

        Set<String> bogies = new HashSet<>();

        bogies.add("B6101");
        bogies.add("B6102");
        bogies.add("B6103");
        bogies.add("BG104");

        bogies.add("B6101");
        bogies.add("B6102");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies + "\n");

        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.\n");

        System.out.println("UC3 uniqueness validation completed...");
    }
}