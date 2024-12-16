import matrix

def main():
    try:
        size = int(input("Введіть розмір матриці (непарне число): "))
        if size <= 0 or size % 2 == 0:
            print("Розмір матриці має бути додатнім непарним числом!")
            return

        generated_matrix = matrix.generate_matrix_with_center(size)
        matrix.display_matrix(generated_matrix)

    except ValueError:
        print("Помилка: введіть коректне число для розміру матриці!")

if __name__ == "__main__":
    main()
