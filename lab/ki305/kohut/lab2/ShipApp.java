package ki305.kohut.lab2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShipApp {
    public static void main(String[] args) {
        try {
            // Створення об'єкта корабля
            Ship ship = new Ship("Black Pearl", 500, 100);  // Назва корабля, макс. вантаж, пасажирська місткість
            Scanner scanner = new Scanner(System.in);

            // Меню для взаємодії з користувачем
            while (true) {
                System.out.println("\n--- Ship Control Menu ---");
                System.out.println("1. Start Engine");
                System.out.println("2. Stop Engine");
                System.out.println("3. Load Cargo");
                System.out.println("4. Unload Cargo");
                System.out.println("5. Refuel");
                System.out.println("6. Set Speed");
                System.out.println("7. Sail");
                System.out.println("8. Dock");
                System.out.println("9. Show Ship Info");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        ship.startEngine();
                        break;
                    case 2:
                        ship.stopEngine();
                        break;
                    case 3:
                        System.out.print("Enter cargo weight to load (tons): ");
                        int weight = scanner.nextInt();
                        ship.loadCargo(weight);
                        break;
                    case 4:
                        ship.unloadCargo();
                        break;
                    case 5:
                        System.out.print("Enter fuel amount to refuel (%): ");
                        double fuel = scanner.nextDouble();
                        ship.refuel(fuel);
                        break;
                    case 6:
                        System.out.print("Enter speed (knots): ");
                        double speed = scanner.nextDouble();
                        ship.setSpeed(speed);
                        break;
                    case 7:
                        ship.sail();
                        break;
                    case 8:
                        ship.dock();
                        break;
                    case 9:
                        ship.info();
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        ship.dispose();  // Закриття ресурсів
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Log file not found.");
            e.printStackTrace();
        }
    }
}
