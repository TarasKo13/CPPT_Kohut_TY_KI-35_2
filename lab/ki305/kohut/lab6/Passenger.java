package ki305.kohut.lab6;

/**
 * Клас Passenger представляє пасажира із визначеним пріоритетом.
 */
public class Passenger implements Comparable<Passenger> {
    private String name;
    private int priority; // Пріоритет пасажира

    /**
     * Конструктор для створення пасажира.
     * @param name ім'я пасажира.
     * @param priority пріоритет пасажира.
     */
    public Passenger(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Passenger other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Passenger{name='" + name + "', priority=" + priority + "}";
    }
}
