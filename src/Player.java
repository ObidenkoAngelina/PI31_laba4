import java.util.Random;
import java.util.Scanner;
class Player {
    private Grid grid; // Ссылка на объект Grid
    private String name;

    public Player(Grid grid, String name) {
        this.grid = grid;
        this.name = name;
    }

    public void play(long startTime) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игрок " + name + " начинает игру...");
        while (!grid.allCellsVisible() && !isTimeUp(startTime)) {
            grid.insertNumber(scanner); // Ввод числа пользователем
            grid.printGrid(); // Печать обновленной сетки
        }

        if (isTimeUp(startTime)) { // Проверка на истечение времени
            System.out.println("Ваше время вышло! Игрок " + name + " проиграл!");
        } else {
            System.out.println("Все ячейки открыты! Игрок " + name + " победил!"); // Сообщение о победе
        }
        // Печать результатов
        grid.printResults();
        scanner.close();
    }

    private boolean isTimeUp(long startTime) {
        return (System.currentTimeMillis() - startTime) >= 300000; // Возвращает true, если время истекло
    }
}
