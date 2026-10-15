// ============================================================
// Lab 6 - Abstraction
// File: VehicleDemo.java
// Student: Ronald Murape (H250475V)
// ============================================================
abstract class VehicleL6 {
    private final String plate;
    VehicleL6(String plate) { this.plate = plate; }   // EXPLAIN: abstract classes CAN have constructors

    // EXPLAIN: abstract -> no body; every concrete subclass MUST provide one
    abstract double fuelCostPerKm();

    // concrete method shared by all vehicles
    double tripCost(double km) {
        return km * fuelCostPerKm();
    }

    String getPlate() { return plate; }
}

class TruckL6 extends VehicleL6 {
    TruckL6(String plate) { super(plate); }
    @Override double fuelCostPerKm() { return 0.80; }
}

class MotorbikeL6 extends VehicleL6 {
    MotorbikeL6(String plate) { super(plate); }
    @Override double fuelCostPerKm() { return 0.15; }
}

public class VehicleDemo {
    public static void main(String[] args) {
        // Vehicle v = new Vehicle("X");   // COMPILE ERROR: Vehicle is abstract
        VehicleL6[] fleet = { new TruckL6("TRK-1"), new MotorbikeL6("MB-7") };
        for (VehicleL6 v : fleet) {
            System.out.printf("%s: 100 km costs %.2f%n", v.getPlate(), v.tripCost(100));
        }
    }
}
