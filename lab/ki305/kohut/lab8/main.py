from writer import Writer
from example import Example

if __name__ == "__main__":
    try:
        # Введення значення x
        x = float(input("Введіть значення x: "))
        eq = Example(x)  # Створення об'єкта Example

        # Обчислення результату
        result = eq.calculate()
        wr = Writer(result)  # Створення об'єкта Writer для збереження результату

        # Робота з двійковим файлом
        wr.wr_bin("Res.bin")
        print("Результат з двійкового файлу:", wr.rd_bin("Res.bin"))

        # Робота з текстовим файлом
        wr.wr_txt("Res.txt")
        print("Результат з текстового файлу:", wr.rd_txt("Res.txt"))

    except ArithmeticError as ex:
        print("Помилка:", ex)
    except ValueError:
        print("Помилка: введено невірний тип числа")
    except FileNotFoundError as ex:
        print("Помилка:", ex)
