/*
 * UC13: Performance Comparison (Loops vs Streams)
 *
 * @author Mohith
 * @version 13.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }
}

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC13 Performance Comparison (Loops vs Streams)\n");

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));
            bogies.add(new Bogie("General", 90));
        }

        long loopStartTime = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long loopEndTime = System.nanoTime();
        long loopDuration = loopEndTime - loopStartTime;

        long streamStartTime = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long streamEndTime = System.nanoTime();
        long streamDuration = streamEndTime - streamStartTime;

        System.out.println("Loop Execution Time (ns): " + loopDuration);
        System.out.println("Stream Execution Time (ns): " + streamDuration);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}