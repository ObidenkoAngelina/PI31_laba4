import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringHelper stringHelper = new StringHelper();
        try {
            System.out.println("Введите имя игрока: ");
            String playerName = scanner.nextLine();
            playerName = stringHelper.cleanAndFormat(playerName);

            AdvancedGrid dynamicGrid = new AdvancedGrid(); // Создание объекта AdvancedGrid
            dynamicGrid.initializeGrid(); // Инициализация сетки
            for (int row = 0; row < Grid.SIZE; row++) {
                dynamicGrid.hideNumbers(row);
            }

            // Используем перегруженный метод printGrid с дополнительной информацией
            dynamicGrid.printGrid("Игра началась!");

            Player player = new Player(dynamicGrid, playerName);
            long startTime = System.currentTimeMillis(); // Запоминаем время начала
            player.play(startTime);

            System.out.println("Общее количество созданных экземпляров Grid: " + Grid.getGridCount());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close(); // Закрытие сканера в любом случае
        }
    }
}
