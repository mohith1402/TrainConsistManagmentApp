import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class TrainConsistMgmtTest {

    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("General", -10);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("AC Chair", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new PassengerBogie("First Class", -5);
            fail("Expected InvalidCapacityException to be thrown");
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("First Class", 24);
        assertEquals("First Class", bogie.type);
        assertEquals(24, bogie.capacity);
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("AC Chair", 56);
        PassengerBogie b3 = new PassengerBogie("First Class", 24);

        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
    }
}