import java.util.Random;
import java.util.Scanner;
class Grid {
    public static final int SIZE = 9;
    private char[][] cells = new char[SIZE][SIZE];
    private boolean[][] visible = new boolean[SIZE][SIZE];
    private Random random = new Random();

    public Grid() {
        // Инициализация массива visible
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                visible[row][col] = true; // Сначала все ячейки видимые
            }
        }
    }

    public void initializeGrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // Определяем начальное значение для каждой строки
                int startValue;
                if (row == 6) {
                    startValue = 3; // Шестая строка (индекс 6) должна начинаться с 3
                } else if (row == 7) {
                    startValue = 6; // Седьмая строка (индекс 7) должна начинаться с 6
                } else if (row == 8) {
                    startValue = 9; // Восьмая строка (индекс 8) должна начинаться с 9
                } else {
                    startValue = (row < 3) ? (row * 3 + 1) : (2 + (row - 3) * 3);
                }
                // Используем формулу для заполнения ячеек
                int value = (startValue + col - 1) % 9 + 1;
                cells[row][col] = (char) ('0' + value); // Преобразуем в символ
            }
        }
    }

    public void hideNumbers(int row) {
        int hiddenCount = 0;
        while (hiddenCount < 4) { // Скрываем 4 числа
            int col = random.nextInt(SIZE); // Генерируем случайный индекс колонки
            if (visible[row][col]) { // Проверяем, чтобы не скрыть уже скрытое
                visible[row][col] = false; // Скрыть это число
                hiddenCount++;
            }
        }
    }

    public void printGrid() {
        System.out.println("+---+---+---+---+---+---+---+---+---+");
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (visible[row][col]) {
                    System.out.print("| " + cells[row][col] + " "); // Печать видимых значений
                } else {
                    System.out.print("|   "); // Печать скрытых значений
                }
            }
            System.out.println("|");
            System.out.println("+---+---+---+---+---+---+---+---+---+");
        }
    }

    public void insertNumber(Scanner scanner) {
        int row, col, number;

        // Запрос ввода номера строки
        System.out.print("Введите номер строки (0-8): ");
        row = scanner.nextInt();

        // Запрос ввода номера колонки
        System.out.print("Введите номер колонки (0-8): ");
        col = scanner.nextInt();

        // Проверка корректности введенных индексов
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.println("Некорректный выбор ячейки.");
            return;
        }

        // Проверка, открыта ли ячейка
        if (visible[row][col]) {
            System.out.println("Эта ячейка уже открыта.");
            return;
        }

        // Запрос ввода числа
        System.out.print("Введите число (1-9): ");
        number = scanner.nextInt();

        // Проверка на корректность введенного числа
        if (number < 1 || number > 9) {
            System.out.println("Неверное число. Пожалуйста, введите число от 1 до 9.");
            return;
        }

        // Сравнение введенного числа с фактическим значением ячейки
        if (cells[row][col] == '0' + number) {
            visible[row][col] = true; // Открываем ячейку
            System.out.println("Правильное число! Ячейка открыта.");
        } else {
            System.out.println("Неправильное число!");
        }
    }

    public boolean allCellsVisible() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (!visible[row][col]) {
                    return false; // Если найдена закрытая ячейка
                }
            }
        }
        return true; // Все ячейки открыты
    }
}
