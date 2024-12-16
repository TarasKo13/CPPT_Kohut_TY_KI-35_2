package ki305.kohut.lab5;

/**
 * Клас Example - обчислює функцію y = cos(2x) / ctg(3x - 1) для введеного значення x.
 */
public class Example {
    private double x;

    // Конструктор за замовчуванням
    public Example() {
        this.x = 0;
    }

    // Конструктор з параметром x
    public Example(double x) {
        this.x = x;
    }

    // Метод для встановлення значення x
    public void setX(double x) {
        this.x = x;
    }

    // Метод для обчислення функції y = cos(2x) / ctg(3x - 1)
    public double calculate() throws ArithmeticException {
        double denominator = Math.sin(3 * x - 1); // Обчислення знаменника (sin)
        if (denominator == 0) { // Перевірка на ділення на нуль
            throw new ArithmeticException("Помилка: ділення на нуль у знаменнику.");
        }
        return Math.cos(2 * x) / denominator; // Обчислення результату
    }
}
