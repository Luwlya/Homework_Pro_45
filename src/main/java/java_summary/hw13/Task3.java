package java_summary.hw13;
// 3. Написать класс МФУ, на котором возможны одновременная печать и сканирование документов,
// при этом нельзя одновременно печатать два документа или сканировать (при печати в консоль выводится сообщения
// "отпечатано 1, 2, 3,… страницы", при сканировании тоже самое только "отсканировано…",
// вывод в консоль все также с периодом в 50 мс.)

public class Task3 {
    public static void main(String[] args) {
        MFU mfu = new MFU();
        Thread print1 = new Thread(() -> {
            mfu.print("hobbit", 10);
        });
        Thread print2 = new Thread(() -> {
            mfu.print("silmarillion", 7);
        });
        Thread scan1 = new Thread(() -> {
            mfu.scan("lord of the rings", 10);
        });
        Thread scan2 = new Thread(() -> {
            mfu.scan("biography", 7);
        });
        print1.start();
        print2.start();
        scan1.start();
        scan2.start();
    }
}

class MFU {
    final Object printMonitor = new Object();
    final Object scanMonitor = new Object();


    void print(String docName, int pages) {
        synchronized (printMonitor) {
            for (int i = 0; i < pages; i++) {
                System.out.println("Printing " + docName + " page " + (i + 1));
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void scan(String docName, int pages) {
        synchronized (scanMonitor) {
            for (int i = 0; i < pages; i++) {
                System.out.println("Scanning " + docName + " page " + (i + 1));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}