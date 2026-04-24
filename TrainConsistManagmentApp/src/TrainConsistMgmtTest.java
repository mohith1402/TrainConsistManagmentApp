import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrainConsistMgmtTest {

    private boolean binarySearch(String[] arr, String target) {
        if (arr == null || arr.length == 0 || target == null) {
            return false;
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = arr[mid].compareTo(target);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    @Test
    public void testBinarySearch_BogieFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(bogies, "BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(binarySearch(bogies, "BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(bogies, "BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(bogies, "BG550"));
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        assertTrue(binarySearch(bogies, "BG101"));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        String[] bogies = {};
        assertFalse(binarySearch(bogies, "BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(binarySearch(bogies, "BG205"));
    }
}