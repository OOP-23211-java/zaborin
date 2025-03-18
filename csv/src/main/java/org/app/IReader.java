package org.app;
import java.io.IOException;
/**
 * Интерфейс {@code IReader} определяет метод для чтения строк
 * и поддерживает автоматическое закрытие ресурсов.
 *
 */
public interface IReader extends AutoCloseable {
    String readLine() throws IOException;
}
