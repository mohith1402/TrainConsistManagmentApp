/*
 * UC14: Handle Invalid Bogie Capacity (Custom Exception)
 *
 * @author Mohith
 * @version 14.0
 */

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    String type;
    int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }
}

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC14 Handle Invalid Bogie Capacity (Custom Exception)\n");

        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + validBogie.type + ", Capacity: " + validBogie.capacity);

            System.out.println("\nAttempting to create a bogie with invalid capacity (-10)...");
            PassengerBogie invalidBogie = new PassengerBogie("General", -10);

        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}