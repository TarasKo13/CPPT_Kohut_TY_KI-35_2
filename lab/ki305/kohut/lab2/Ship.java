package ki305.kohut.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Клас Ship
public class Ship {
    private final Engine engine; // Двигун
    private final Crew crew; // Екіпаж
    private final Cargo cargo; // Вантаж
    private final String shipName; // рядок з назвою
    private final int maxCargoWeight;  // Максимальна вантажопідйомність
    private final int passengerCapacity; // Пасажирська місткість
    private double speed; // Поточна швидкість
    private double fuelLevel; // Рівень палива (у відсотках, від 0 до 100)
    private PrintWriter fout; // фути

    // Конструктор за замовчуванням
    public Ship() throws FileNotFoundException {
        this("Unnamed Ship", 100, 50);
    }

    // Конструктор з параметрами
    public Ship(String shipName, int maxCargoWeight, int passengerCapacity) throws FileNotFoundException {
        this.engine = new Engine();
        this.crew = new Crew();
        this.cargo = new Cargo();
        this.shipName = shipName;
        this.maxCargoWeight = maxCargoWeight;
        this.passengerCapacity = passengerCapacity;
        this.speed = 0;
        this.fuelLevel = 100; // Повний бак на початку
        fout = new PrintWriter(new File("ShipLog.txt"));
    }

    // Метод для запуску двигуна
    public void startEngine() {
        if (fuelLevel > 0) {
            engine.start();
            log("Engine started.");
        } else {
            log("Cannot start engine: fuel is empty.");
            System.out.println("Cannot start engine: fuel is empty.");
        }
    }

    // Метод для зупинки двигуна
    public void stopEngine() {
        engine.stop();
        log("Engine stopped.");
    }

    // Метод для завантаження вантажу
    public void loadCargo(int weight) {
        if (cargo.getWeight() + weight <= maxCargoWeight) {
            cargo.load(weight);
            log("Cargo loaded: " + weight + " tons.");
        } else {
            log("Cannot load cargo: exceeds maximum weight.");
            System.out.println("Cannot load cargo: exceeds maximum weight.");
        }
    }

    // Метод для розвантаження вантажу
    public void unloadCargo() {
        cargo.unload();
        log("Cargo unloaded.");
    }

    // Метод для заправки паливом
    public void refuel(double fuel) {
        if (fuel > 0 && fuelLevel + fuel <= 100) {
            fuelLevel += fuel;
            log("Refueled " + fuel + "%.");
        } else {
            log("Cannot refuel: invalid amount.");
            System.out.println("Cannot refuel: invalid amount.");
        }
    }

    // Метод для встановлення швидкості
    public void setSpeed(double newSpeed) {
        if (engine.isRunning() && fuelLevel > 0) {
            speed = newSpeed;
            fuelLevel -= newSpeed * 0.1; // Припустимо, що швидкість зменшує рівень палива
            if (fuelLevel < 0) fuelLevel = 0;
            log("Speed set to " + speed + " knots.");
        } else {
            log("Cannot set speed: engine is not running or fuel is empty.");
            System.out.println("Cannot set speed: engine is not running or fuel is empty.");
        }
    }

    // Метод для початку плавання
    public void sail() {
        if (engine.isRunning() && crew.isReady() && fuelLevel > 0) {
            log("The ship is sailing.");
            System.out.println(shipName + " is now sailing at " + speed + " knots.");
        } else {
            log("Failed to sail: engine, crew, or fuel not ready.");
            System.out.println("Cannot sail. Engine, crew, or fuel not ready.");
        }
    }

    // Метод для зупинки корабля
    public void dock() {
        stopEngine();
        speed = 0;
        log("Ship docked.");
        System.out.println(shipName + " has docked.");
    }

    // Метод для отримання інформації про корабель
    public void info() {
        System.out.println("Ship name: " + shipName);
        System.out.println("Engine status: " + (engine.isRunning() ? "Running" : "Stopped"));
        System.out.println("Fuel level: " + fuelLevel + "%");
        System.out.println("Current speed: " + speed + " knots");
        System.out.println("Crew readiness: " + (crew.isReady() ? "Ready" : "Not Ready"));
        System.out.println("Cargo weight: " + cargo.getWeight() + " tons");
        System.out.println("Max cargo capacity: " + maxCargoWeight + " tons");
        System.out.println("Passenger capacity: " + passengerCapacity);
    }

    // Закриття ресурсів
    public void dispose() {
        fout.close();
    }

    // Логування подій
    private void log(String message) {
        fout.println(shipName + ": " + message);
        fout.flush();
    }

    // Внутрішній клас Engine
    public static class Engine {
        private boolean running = false;

        public void start() { running = true; }
        public void stop() { running = false; }
        public boolean isRunning() { return running; }
    }

    // Внутрішній клас Crew
    public static class Crew {
        private boolean ready = true; // за замовчуванням екіпаж готовий

        public void setReady(boolean status) { ready = status; }
        public boolean isReady() { return ready; }
    }

    // Внутрішній клас Cargo
    public static class Cargo {
        private int weight = 0;

        public void load(int weight) { this.weight += weight; }
        public void unload() { this.weight = 0; }
        public int getWeight() { return weight; }
    }
}
