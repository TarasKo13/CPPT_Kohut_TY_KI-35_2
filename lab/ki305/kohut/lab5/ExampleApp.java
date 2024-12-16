package ki305.kohut.lab5;

import java.io.IOException;
import java.util.Scanner;

/**
 * Клас ExampleApp - основний клас для запуску програми та взаємодії з користувачем.
 */
public class ExampleApp {
    public static void main(String[] args) {
        Example example = new Example(); // Створення об'єкта для обчислення
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть значення x: ");
        try {
            example.setX(scanner.nextDouble()); // Зчитуємо значення x від користувача
            Writer writer = new Writer(example.calculate()); // Обчислення та створення Writer з результатом

            // Робота з двійковим файлом
            writer.wrBin("Res.bin");
            System.out.println("Результат з двійкового файлу: " + writer.rdBin("Res.bin"));

            // Робота з текстовим файлом
            writer.wrTxt("Res.txt");
            System.out.println("Результат з текстового файлу: " + writer.rdTxt("Res.txt"));

        } catch (ArithmeticException | IOException ex) {
            System.out.println("Помилка: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Невірний ввід. Спробуйте ще раз.");
        } finally {
            scanner.close(); // Закриваємо ресурс Scanner
        }
    }
}
