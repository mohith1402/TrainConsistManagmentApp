import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainConsistMgmtTest {

    private List<Bogie> loopFilter(List<Bogie> bogies) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    private List<Bogie> streamFilter(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    public void testLoopFilteringLogic() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> result = loopFilter(bogies);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).type);
    }

    @Test
    public void testStreamFilteringLogic() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> result = streamFilter(bogies);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).type);
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("General", 90));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        List<Bogie> loopResult = loopFilter(bogies);
        List<Bogie> streamResult = streamFilter(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) { }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        assertTrue(elapsedTime > 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<Bogie> largeDataset = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeDataset.add(new Bogie("Sleeper", 72));
            largeDataset.add(new Bogie("First Class", 24));
        }

        List<Bogie> loopResult = loopFilter(largeDataset);
        List<Bogie> streamResult = streamFilter(largeDataset);

        assertEquals(10000, loopResult.size());
        assertEquals(10000, streamResult.size());
    }
}