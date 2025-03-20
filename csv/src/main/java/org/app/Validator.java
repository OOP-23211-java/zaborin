package org.app;

/**
 * Проверяет аргумент командной строки.
 */
public class Validator {

    /**
     * Проверяет аргумент командной строки, содержащий путь к файлу.
     *
     * @param args аргументы командной строки
     * @return путь к файлу, если аргумент корректен
     * @throws IllegalArgumentException если аргумент некорректен
     */
    public static String validateFileArgument(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Ошибка: требуется указать путь к файлу.");
        }

        String fileName = args[0];

        if (fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ошибка: путь к файлу не может быть пустым.");
        }

        if (!fileName.endsWith(".txt")) {
            throw new IllegalArgumentException("Ошибка: файл должен иметь расширение .txt");
        }

        return fileName;
    }
}
