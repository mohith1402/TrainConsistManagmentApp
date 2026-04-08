/*
 * UC10: Count Total Seats in Train (reduce)
 *
 * @author Mohith
 * @version 10.0
 */

import java.util.ArrayList;
import java.util.List;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC10 Count Total Seats in Train\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Train Consist:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // AGGREGATE SEATING CAPACITY USING STREAMS AND REDUCE
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        System.out.println("\nUC10 aggregation completed...");
    }
}