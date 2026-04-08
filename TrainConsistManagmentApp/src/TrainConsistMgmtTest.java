import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrainConsistMgmtTest {

    private boolean validateSafety(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));
    }

    @Test
    public void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        assertTrue(validateSafety(bogies));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        assertFalse(validateSafety(bogies));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        assertTrue(validateSafety(bogies));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Chemicals"));

        assertFalse(validateSafety(bogies));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();

        assertTrue(validateSafety(bogies));
    }
}