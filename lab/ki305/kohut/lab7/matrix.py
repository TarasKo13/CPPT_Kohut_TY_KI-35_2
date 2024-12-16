def generate_matrix_with_center(size):
    """
    Генерує квадратну матрицю із заштрихованою центральною областю.
    :param size: Розмір квадратної матриці (повинно бути непарним)
    :return: Матриця з центральним квадратом
    """
    matrix = []
    center_start = size // 4
    center_end = size - center_start

    for i in range(size):
        row = []
        for j in range(size):
            # Заповнюємо центр матриці (заштрихована область)
            if center_start <= i < center_end and center_start <= j < center_end:
                row.append("1")  # Заштрихована область
            else:
                row.append(" ")  # Порожні комірки
        matrix.append(row)
    return matrix


def display_matrix(matrix, file_name="output.txt"):
    """
    Виводить матрицю на екран і записує у файл.
    :param matrix: Матриця для виводу
    :param file_name: Ім'я файлу для запису
    """
    with open(file_name, "w") as file:
        print("Результат матриці:")
        for row in matrix:
            output_row = " ".join(row)
            print(output_row)
            file.write(output_row + "\n")
