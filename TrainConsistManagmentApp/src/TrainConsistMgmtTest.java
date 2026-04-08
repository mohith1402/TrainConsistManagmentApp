import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainConsistMgmtTest {

    // Helper method simulating the grouping logic from UC9
    private Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        assertTrue(groupedBogies.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 70));

        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        assertEquals(1, groupedBogies.size());
        assertTrue(groupedBogies.containsKey("Sleeper"));
        assertEquals(2, groupedBogies.get("Sleeper").size());
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        assertEquals(3, groupedBogies.size());
        assertTrue(groupedBogies.containsKey("Sleeper"));
        assertTrue(groupedBogies.containsKey("AC Chair"));
        assertTrue(groupedBogies.containsKey("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 56));

        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        assertEquals(2, groupedBogies.get("Sleeper").size());
        assertEquals(1, groupedBogies.get("AC Chair").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        // Verify the original list is unaltered
        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals("AC Chair", bogies.get(1).name);
    }
}