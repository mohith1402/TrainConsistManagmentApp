/*
 * UC11: Validate Train ID & Cargo Codes (Regex)
 *
 * @author Mohith
 * @version 11.0
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC11 Validate Train ID and Cargo Code\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        Pattern trainIdPattern = Pattern.compile("^TRN-\\d{4}$");
        Pattern cargoCodePattern = Pattern.compile("^PET-[A-Z]{2}$");

        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);

        boolean isTrainIdValid = trainIdMatcher.matches();
        boolean isCargoCodeValid = cargoCodeMatcher.matches();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}