import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TrainConsistMgmtTest {

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Test
    public void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }

    @Test
    public void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }

    @Test
    public void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }

    @Test
    public void testSort_SingleElementArray() {
        int[] capacities = {50};
        int[] expected = {50};

        bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }

    @Test
    public void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};

        bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }
}