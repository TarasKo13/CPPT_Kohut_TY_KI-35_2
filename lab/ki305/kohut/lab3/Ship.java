package ki305.kohut.lab3;

/**
 * Абстрактний клас Ship представляє загальні характеристики корабля.
 */
public abstract class Ship {
    protected String name;
    protected int displacement; // Водотоннажність
    protected int speed; // Швидкість

    public Ship(String name, int displacement, int speed) {
        this.name = name;
        this.displacement = displacement;
        this.speed = speed;
    }

    // Абстрактний метод для стрільби (реалізується в підкласах)
    public abstract void fireWeapon();

    // Метод для збільшення швидкості корабля
    public void increaseSpeed(int increment) {
        speed += increment;
        System.out.println("Швидкість збільшена до: " + speed);
    }

    // Метод для зменшення швидкості корабля
    public void decreaseSpeed(int decrement) {
        speed -= decrement;
        System.out.println("Швидкість зменшена до: " + speed);
    }

    // Метод для отримання назви корабля
    public String getName() {
        return name;
    }
}

