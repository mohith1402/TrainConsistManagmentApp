import org.junit.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrainConsistMgmtTest {

    private boolean validateTrainID(String trainId) {
        if (trainId == null) return false;
        Pattern pattern = Pattern.compile("^TRN-\\d{4}$");
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    private boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Pattern pattern = Pattern.compile("^PET-[A-Z]{2}$");
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(validateTrainID("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(validateTrainID("TRAIN12"));
        assertFalse(validateTrainID("TRN12A"));
        assertFalse(validateTrainID("1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(validateCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(validateCargoCode("PET123"));
        assertFalse(validateCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(validateTrainID("TRN-123"));
        assertFalse(validateTrainID("TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(validateCargoCode("PET-ab"));
        assertFalse(validateCargoCode("PET-Ab"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(validateTrainID(""));
        assertFalse(validateCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(validateTrainID("TRN-1234EXTRA"));
        assertFalse(validateCargoCode("PET-ABEXTRA"));
        assertFalse(validateTrainID("EXTRATRN-1234"));
    }
}