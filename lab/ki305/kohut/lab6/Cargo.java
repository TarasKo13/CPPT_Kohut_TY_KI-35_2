package ki305.kohut.lab6;

/**
 * Клас Cargo представляє вантаж із вагою.
 */
public class Cargo implements Comparable<Cargo> {
    private String type;
    private int weight; // Вага вантажу

    /**
     * Конструктор для створення вантажу.
     * @param type тип вантажу.
     * @param weight вага вантажу.
     */
    public Cargo(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public int compareTo(Cargo other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "Cargo{type='" + type + "', weight=" + weight + "}";
    }
}
