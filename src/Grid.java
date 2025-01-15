import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
class Grid {
    public static final int SIZE = 9;
    protected char[][] cells = new char[SIZE][SIZE];
    private boolean[][] visible = new boolean[SIZE][SIZE];
    private Random random = new Random();
    private static int gridCount = 0; // Статическое поле для подсчета экземпляров Grid
    private Move[] moves; // Массив для хранения ходов
    private int moveCount; // Счетчик ходов

    public Grid() {
        // Инициализация массива visible
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                visible[row][col] = true; // Сначала все ячейки видимые
            }
        }
        gridCount++;
        moves = new Move[SIZE * SIZE]; // Максимальное количество ходов
        moveCount = 0; // Изначально 0 ходов
    }

    public static int getGridCount() { // Статический метод для получения количества экземпляров Grid
        return gridCount;
    }

    protected void initializeGrid() {
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
        while (hiddenCount < 1) { // Скрываем 1 число
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

        try {
            // Запрос ввода номера строки
            System.out.print("Введите номер строки (0-8): ");
            row = scanner.nextInt();

            // Запрос ввода номера колонки
            System.out.print("Введите номер колонки (0-8): ");
            col = scanner.nextInt();

            // Проверка корректности введенных индексов
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                throw new IllegalArgumentException("Некорректный выбор ячейки.");
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
                throw new IllegalArgumentException("Неверное число. Пожалуйста, введите число от 1 до 9.");
            }

            // Сравнение введенного числа с фактическим значением ячейки
            boolean isCorrect = cells[row][col] == '0' + number;
            if (isCorrect) {
                visible[row][col] = true;
                System.out.println("Правильное число! Ячейка открыта.");
            } else {
                System.out.println("Неправильное число!");
            }

            // Сохранение хода
            moves[moveCount++] = new Move(row, col, isCorrect);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: введите целое число.");
            scanner.next(); // Очистка неверного ввода
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    public void printResults() {
        int correctMoves = 0;
        int incorrectMoves = 0;

        for (int i = 0; i < moveCount; i++) {
            if (moves[i].isCorrect) {
                correctMoves++;
            } else {
                incorrectMoves++;
            }
        }

        System.out.println("Количество правильных ходов: " + correctMoves);
        System.out.println("Количество неправильных ходов: " + incorrectMoves);
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

