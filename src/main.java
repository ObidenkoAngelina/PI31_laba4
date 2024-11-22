import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Grid dynamicGrid = new Grid();
        dynamicGrid.initializeGrid();
        for (int row = 0; row < Grid.SIZE; row++) {
            dynamicGrid.hideNumbers(row);
        }
        dynamicGrid.printGrid();
    }
}
