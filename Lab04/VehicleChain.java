// ============================================================
// Lab 4 - Exercise solutions
// File: VehicleChain.java  (Intermediate: multilevel Vehicle->Car->ElectricCar)
// Student: Ronald Murape (H250475V)
// ============================================================
class VehicleL4 {
    VehicleL4() { System.out.println("Vehicle constructor"); }
}
class CarL4 extends VehicleL4 {
    CarL4() { System.out.println("Car constructor"); }
}
class ElectricCar extends CarL4 {
    ElectricCar() { System.out.println("ElectricCar constructor"); }
}

public class VehicleChain {
    public static void main(String[] args) {
        System.out.println("--- creating ElectricCar ---");
        new ElectricCar();
    }
}
