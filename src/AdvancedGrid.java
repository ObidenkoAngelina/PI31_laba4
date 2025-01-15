class AdvancedGrid extends Grid {
    // Перегруженный метод printGrid с дополнительной информацией
    public void printGrid(String additionalInfo) {
        super.printGrid(); // Вызов базового метода printGrid
        System.out.println("Дополнительная информация: " + additionalInfo);
    }

    // Перегруженный метод printGrid без параметров
    public void printGrid() {
        super.printGrid(); // Просто вызывает базовый метод
    }
}