package ki305.kohut.lab3;

/**
 * Клас FrigateDriver демонструє роботу з класом Frigate.
 */
public class FrigateDriver {
    public static void main(String[] args) {
        Frigate frigate = new Frigate("Гетьман Сагайдачний", 3500, 30, 5);
        System.out.println("Корабель: " + frigate.getName());
        frigate.increaseSpeed(10);
        frigate.fireWeapon();
        frigate.fireWeapon();
        frigate.reloadWeapons(3);
        frigate.fireWeapon();
        frigate.decreaseSpeed(5);
    }
}
