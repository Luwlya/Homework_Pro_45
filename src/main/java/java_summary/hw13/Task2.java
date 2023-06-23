package java_summary.hw13;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// 2. Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл (штук по 10 записей,
// с периодом в 20 мс)
public class Task2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Writer writer = new FileWriter("out.txt")) {
            Thread thread1 = writeToFile(writer, "A");
            Thread thread2 = writeToFile(writer, "B");
            Thread thread3 = writeToFile(writer, "C");
            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();
        }

    }

    private static Thread writeToFile(Writer writer, String prefix) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    synchronized (writer) {
                        writer.write(prefix + i + "\n");
                    }
                    Thread.sleep(20);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
