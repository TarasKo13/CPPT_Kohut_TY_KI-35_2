package ki305.kohut.lab3;

/**
 * Клас Frigate представляє фрегат з озброєнням, наслідує базовий клас Ship.
 */
public class Frigate extends Ship implements Armed {
    private int weaponCount; // Кількість зброї на борту

    public Frigate(String name, int displacement, int speed, int weaponCount) {
        super(name, displacement, speed);
        this.weaponCount = weaponCount;
    }

    @Override
    public void fireWeapon() {
        if (weaponCount > 0) {
            System.out.println("Фрегат " + name + " здійснив постріл!");
            weaponCount--;
        } else {
            System.out.println("У фрегата " + name + " немає боєприпасів!");
        }
    }

    @Override
    public void reloadWeapons(int ammo) {
        weaponCount += ammo;
        System.out.println("Фрегат " + name + " поповнив боєприпаси. Кількість зброї: " + weaponCount);
    }
}
