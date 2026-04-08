/*
 * UC12: Safety Compliance Check for Goods Bogies
 *
 * @author Mohith
 * @version 12.0
 */

import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " -> " + cargo;
    }
}

public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC12 Safety Compliance Check for Goods Bogies\n");

        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies:");
        for (GoodsBogie b : bogies) {
            System.out.println(b);
        }

        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("\nSafety Compliance Result:"+ isSafe);
        System.out.println("Is Train Safe? " + isSafe);

        System.out.println("\nUC12 compliance check completed...");
    }
}