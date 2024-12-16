package ki305.kohut.lab6;

import java.util.ArrayList;

/**
 * Параметризований клас Carriage для моделювання вагону.
 * @param <T> тип об'єктів, які можуть зберігатися у вагоні.
 */
public class Carriage<T extends Comparable<T>> {
    private ArrayList<T> items; // Ліст для зберігання об'єктів у вагоні

    /**
     * Конструктор ініціалізує порожній вагон.
     */
    public Carriage() {
        items = new ArrayList<>();
    }

    /**
     * Метод додає об'єкт до вагону.
     * @param item об'єкт для додавання.
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Метод видаляє перший об'єкт із вагону.
     * @return видалений об'єкт або null, якщо вагон порожній.
     */
    public T removeItem() {
        if (!items.isEmpty()) {
            return items.remove(0);
        }
        return null;
    }

    /**
     * Метод знаходить максимальний елемент у вагоні.
     * @return максимальний елемент або null, якщо вагон порожній.
     */
    public T findMaxItem() {
        if (items.isEmpty()) {
            return null;
        }

        T max = items.get(0);
        for (T item : items) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    /**
     * Метод повертає кількість об'єктів у вагоні.
     * @return кількість об'єктів.
     */
    public int getItemCount() {
        return items.size();
    }
}
