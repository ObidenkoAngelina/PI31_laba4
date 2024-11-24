class StringHelper {
    // Метод для очистки строки от пробелов и преобразования первой буквы в верхний регистр
    public String cleanAndFormat(String input) {
        if (input == null || input.trim().isEmpty()) {
            return ""; // Возвращаем пустую строку, если входные данные null или пустые
        }
        String trimmedInput = input.trim(); // Удаляем пробелы по краям
        return Character.toUpperCase(trimmedInput.charAt(0)) + trimmedInput.substring(1).toLowerCase(); // Первая буква заглавная, остальные строчные
    }
}
