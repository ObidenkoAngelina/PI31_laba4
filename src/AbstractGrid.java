abstract class AbstractGrid {
    public static final int SIZE = 9;
    protected char[][] cells = new char[SIZE][SIZE];
    protected boolean[][] visible = new boolean[SIZE][SIZE]; // Измените на protected

    public AbstractGrid() {
        // Инициализация массива visible
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                visible[row][col] = true; // Сначала все ячейки видимые
            }
        }
    }

    public abstract void initializeGrid(); // Абстрактный метод для инициализации сетки
    public abstract void hideNumbers(int row); // Абстрактный метод для скрытия чисел
    public abstract void printGrid(); // Абстрактный метод для печати сетки

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