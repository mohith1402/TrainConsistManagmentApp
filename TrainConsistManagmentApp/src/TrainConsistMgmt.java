
/*
 * UC1: Initialize Train and Display Consist Summary
 *
 * @author Mohith
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class TrainConsistMgmt {

    public static void main(String[] args) {
        // Display welcome banner
        System.out.println("=== Train Consist Management App ===");

        // Create a dynamic list to store train bogies
        List<String> trainConsist = new ArrayList<>();

        // Display initial consist information
        System.out.println("Train initialized successfully...");

        // Display the initial bogie count using size()
        System.out.println("Initial Bogie Count: " + trainConsist.size());

        // Print the current state of the train
        System.out.println("Current Train Consist: " + trainConsist);

        System.out.println("System ready for operations...");
    }
}