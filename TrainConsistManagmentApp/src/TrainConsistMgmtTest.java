import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TrainConsistMgmtTest {

    @Test
    public void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        try {
            bogie.assignCargo("Petroleum");
            assertEquals("Petroleum", bogie.cargo);
        } catch (CargoSafetyException e) {
            fail("Exception should not be thrown for safe assignment");
        }
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        try {
            bogie.assignCargo("Petroleum");
            fail("CargoSafetyException should have been thrown");
        } catch (CargoSafetyException e) {
            assertTrue(e.getMessage().contains("Cannot assign Petroleum to a Rectangular bogie"));
        }
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        try {
            bogie.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Exception is expected and handled
        }
        assertNull(bogie.cargo);
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        GoodsBogie invalidBogie = new GoodsBogie("Rectangular");
        GoodsBogie validBogie = new GoodsBogie("Open");

        try {
            invalidBogie.assignCargo("Petroleum"); // This will fail
        } catch (CargoSafetyException e) {
            // Handled safely
        }

        try {
            // Program continues and executes next assignment
            validBogie.assignCargo("Coal");
        } catch (CargoSafetyException e) {
            fail("Should not throw exception here");
        }

        assertEquals("Coal", validBogie.cargo);
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        boolean finallyExecuted = false;

        try {
            bogie.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Handled safely
        } finally {
            finallyExecuted = true;
        }

        assertTrue(finallyExecuted);
    }
}