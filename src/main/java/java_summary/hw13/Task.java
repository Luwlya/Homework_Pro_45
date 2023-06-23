package java_summary.hw13;
//+1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз, порядок должен быть
// именно ABСABСABС. Используйте wait/notify/notifyAll.
//

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        final Object monitor1 = new Object();
        final Object monitor2 = new Object();
        final Object monitor21 = new Object();
        CountDownLatch latch = new CountDownLatch(3);
        Thread thread1 = createThread('A', monitor1, monitor2, latch);
        Thread thread2 = createThread('B', monitor2, monitor21, latch);
        Thread thread3 = createThread('C', monitor21, monitor1, latch);
        thread1.start();
        thread2.start();
        thread3.start();
        latch.await();
        synchronized (monitor1) {
            monitor1.notify();
        }
    }

    @Override
    public void run() {
    }

    private static Thread createThread(char input, Object monitor1, Object monitor2, CountDownLatch latch) {
        return new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    latch.countDown();
                    synchronized (monitor1) {
                        monitor1.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(input);
                synchronized (monitor2) {
                    monitor2.notify();
                }
            }
        });
    }
}
