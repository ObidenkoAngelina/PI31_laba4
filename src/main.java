import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя игрока: ");
        String playerName = scanner.nextLine();

        Grid dynamicGrid = new Grid(); // Создание одного объекта Grid
        dynamicGrid.initializeGrid(); // Инициализация сетки
        for (int row = 0; row < Grid.SIZE; row++) {
            dynamicGrid.hideNumbers(row);
        }
        dynamicGrid.printGrid();

        Player player = new Player(dynamicGrid, playerName);
        long startTime = System.currentTimeMillis(); // Запоминаем время начала
        player.play(startTime);

        System.out.println("Общее количество созданных экземпляров Grid: " + Grid.getGridCount()); // Выводим количество экземпляров Grid

        scanner.close();
    }
}
