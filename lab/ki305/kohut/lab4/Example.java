package ki305.kohut.lab4;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас Example реалізує обчислення виразу y = cos(2x) / ctg(3x - 1)
 */
public class Example {
    private double x;

    /**
     * Конструктор за замовчуванням
     */
    public Example() {
        this.x = 0;
    }

    /**
     * Конструктор з параметром
     * @param x - вхідне значення в радіанах
     */
    public Example(double x) {
        this.x = x;
    }

    /**
     * Встановлює значення x
     * @param x - вхідне значення в радіанах
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Метод для обчислення y = cos(2x) / ctg(3x - 1)
     * @return результат обчислення
     * @throws CalcException у випадку ділення на нуль
     */
    public double calculate() throws CalcException {
        double denominator = Math.tan(3 * this.x - 1); // котангенс як 1/tan
        if (denominator == 0) {
            throw new CalcException("Ділення на нуль у обчисленні котангенса");
        } else {
            return Math.cos(2 * this.x) / denominator;
        }
    }

    /**
     * Метод для запису результату у файл
     * @param message - повідомлення для запису
     * @throws IOException якщо виникає помилка з файлом
     */
    public void logActivity(String message) throws IOException {
        try (FileWriter fw = new FileWriter("Result.txt", true)) {
            fw.write(message + "\n");
            System.out.println(message);
        } catch (IOException e) {
            throw new IOException("Помилка: перевірте файл");
        }
    }
}

/**
 * Клас CalcException для обробки помилок обчислення
 */
class CalcException extends ArithmeticException {
    public CalcException() {}

    public CalcException(String message) {
        super(message);
    }
}
