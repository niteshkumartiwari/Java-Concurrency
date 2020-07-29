package intro;

@FunctionalInterface
interface IVehicle {
    public void start();
    default void applyBrakes(){
        System.out.println("Applying Brakes");
    }
    static void showLicense(){
        System.out.println("Driving License");
    }
}
public class Test {
    public static void main(String[] args) {
        IVehicle vehicle= ()-> System.out.println("Starting the Vechicle");
        vehicle.start();
        vehicle.applyBrakes();
        IVehicle.showLicense();
    }
}
