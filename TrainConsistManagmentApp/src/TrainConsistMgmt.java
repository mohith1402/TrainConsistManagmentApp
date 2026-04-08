/*
 * UC15: Safe Cargo Assignment Using try-catch-finally
 *
 * @author Mohith
 * @version 15.0
 */

class CargoSafetyException extends Exception {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public void assignCargo(String cargo) throws CargoSafetyException {
        if (this.type.equals("Rectangular") && cargo.equals("Petroleum")) {
            throw new CargoSafetyException("Safety Violation: Cannot assign Petroleum to a Rectangular bogie.");
        }
        this.cargo = cargo;
    }
}

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC15 Safe Cargo Assignment Using try-catch-finally\n");

        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");

        try {
            System.out.println("Attempting safe assignment...");
            cylindricalBogie.assignCargo("Petroleum");
            System.out.println("Assigned Petroleum to Cylindrical bogie successfully.");

            System.out.println("\nAttempting unsafe assignment...");
            rectangularBogie.assignCargo("Petroleum");
            System.out.println("Assigned Petroleum to Rectangular bogie successfully.");

        } catch (CargoSafetyException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("\nValidation completion message executes.");
            System.out.println("Train Consist safety check finalized.");
        }

        System.out.println("\nProgram continues execution after exception handling...");
    }
}