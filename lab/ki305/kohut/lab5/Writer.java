package ki305.kohut.lab5;

import java.io.*;

/**
 * Клас Writer - відповідає за запис та читання результатів у текстовий і двійковий файли.
 */
public class Writer {
    private double result;

    // Конструктор за замовчуванням
    public Writer() { }

    // Конструктор з параметром результату
    public Writer(double result) {
        this.result = result;
    }

    // Метод для встановлення значення результату
    public void setResult(double result) {
        this.result = result;
    }

    // Метод для отримання значення результату
    public double getResult() {
        return this.result;
    }

    // Метод для запису результату у текстовий файл
    public void wrTxt(String fName) throws IOException {
        try (PrintWriter writer = new PrintWriter(fName)) {
            writer.printf("%f", result); // Запис результату у текстовий файл
        }
    }

    // Метод для зчитування результату з текстового файлу
    public double rdTxt(String fName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fName))) {
            result = Double.parseDouble(reader.readLine()); // Читання результату
        }
        return result;
    }

    // Метод для запису результату у двійковий файл
    public void wrBin(String fName) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fName))) {
            dos.writeDouble(result); // Запис результату у двійковий файл
        }
    }

    // Метод для зчитування результату з двійкового файлу
    public double rdBin(String fName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fName))) {
            result = dis.readDouble(); // Читання результату
        }
        return result;
    }
}
