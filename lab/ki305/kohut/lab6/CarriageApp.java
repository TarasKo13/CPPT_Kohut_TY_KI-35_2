package ki305.kohut.lab6;

/**
 * Клас CarriageApp для тестування роботи параметризованого класу Carriage.
 */
public class CarriageApp {
    public static void main(String[] args) {
        // Вагон для пасажирів
        Carriage<Passenger> passengerCarriage = new Carriage<>();
        passengerCarriage.addItem(new Passenger("Alice", 5));
        passengerCarriage.addItem(new Passenger("Bob", 10));
        passengerCarriage.addItem(new Passenger("Charlie", 3));

        // Виведемо максимального пасажира за пріоритетом
        System.out.println("Passenger with highest priority: " + passengerCarriage.findMaxItem());

        // Вагон для вантажів
        Carriage<Cargo> cargoCarriage = new Carriage<>();
        cargoCarriage.addItem(new Cargo("Coal", 200));
        cargoCarriage.addItem(new Cargo("Steel", 500));
        cargoCarriage.addItem(new Cargo("Wood", 300));

        // Виведемо найважчий вантаж
        System.out.println("Heaviest cargo: " + cargoCarriage.findMaxItem());
    }
}
