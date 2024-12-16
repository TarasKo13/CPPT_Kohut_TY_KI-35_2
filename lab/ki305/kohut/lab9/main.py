# Main.py
from Frigate import Frigate

def main():
    frigate = Frigate("Гетьман Сагайдачний", 123, 32, ["Ракети", "Гармати"])
    print(frigate.get_info())
    print(frigate.get_armament())

    frigate.add_weapon("Торпеди")
    print(frigate.get_armament())

    frigate.set_speed(36)
    print(frigate.get_info())

if __name__ == "__main__":
    main()
