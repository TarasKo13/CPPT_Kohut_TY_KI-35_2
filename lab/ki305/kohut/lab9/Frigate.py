# Frigate.py
from Ship import Ship

class Frigate(Ship):
    def __init__(self, name, length, speed, armament):
        """
        Ініціалізує фрегат із заданими характеристиками.

        :param name: Назва корабля
        :param length: Довжина корабля (м)
        :param speed: Швидкість корабля (вузли)
        :param armament: Список озброєння
        """
        super().__init__(name, length, speed)  # Виклик конструктора базового класу
        self.armament = armament  # Озброєння фрегата

    def add_weapon(self, weapon):
        """
        Додає зброю до списку озброєння.

        :param weapon: Назва зброї
        """
        self.armament.append(weapon)

    def get_armament(self):
        """
        Повертає список озброєння.
        """
        return f"Озброєння {self.name}: {', '.join(self.armament)}"
