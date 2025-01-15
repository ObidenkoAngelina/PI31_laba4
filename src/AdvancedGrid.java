class AdvancedGrid extends Grid {

    // Перегруженный метод printGrid, который добавляет дополнительную информацию
    public void printGrid(String additionalInfo) {
        // Вызов базового метода printGrid без параметров
        super.printGrid();
        // Вывод дополнительной информации
        System.out.println("Дополнительная информация: " + additionalInfo);
    }

    // Перегруженный метод printGrid без параметров
    public void printGrid() {
        // Просто вызывает базовый метод
        super.printGrid();
    }
}