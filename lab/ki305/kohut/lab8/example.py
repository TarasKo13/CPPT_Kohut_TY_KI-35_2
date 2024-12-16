import math

class Example:
    def __init__(self, x=0):
        """Ініціалізує клас із заданим значенням x."""
        self.x = x

    def set_x(self, x):
        """Метод для встановлення значення x."""
        self.x = x

    def calculate(self):
        """
        Обчислює y = cos(2x) / ctg(3x - 1) з перевіркою на ділення на нуль.
        """
        if math.sin(3 * self.x - 1) == 0:
            raise ArithmeticError("Помилка: ділення на нуль")
        return math.cos(2 * self.x) / math.tan(3 * self.x - 1)
