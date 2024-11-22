import java.util.Random;
import java.util.Scanner;
class Grid {
    public static final int SIZE = 9;
    private char[][] cells = new char[SIZE][SIZE];
    private boolean[][] visible = new boolean[SIZE][SIZE];
    private Random random = new Random();

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
}
