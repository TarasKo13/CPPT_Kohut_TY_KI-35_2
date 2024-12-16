# Ship.py
class Ship:
    def __init__(self, name, length, speed):
        """
        Ініціалізує корабель із заданими характеристиками.

        :param name: Назва корабля
        :param length: Довжина корабля (м)
        :param speed: Швидкість корабля (вузли)
        """
        self.name = name  # Назва корабля
        self.length = length  # Довжина корабля
        self.speed = speed  # Швидкість корабля

    def get_info(self):
        """
        Повертає інформацію про корабель.
        """
        return f"Назва корабля: {self.name}, Довжина: {self.length} м, Швидкість: {self.speed} вузлів"

    def set_speed(self, speed):
        """
        Встановлює нову швидкість корабля.

        :param speed: Нова швидкість (вузли)
        """
        if speed > 0:
            self.speed = speed
        else:
            raise ValueError("Швидкість повинна бути додатною.")
