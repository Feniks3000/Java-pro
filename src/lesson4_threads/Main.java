package lesson4_threads;

/**
 * Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 * Используйте wait/notify/notifyAll.
 */

public class Main {
    private static final Object monitor = new Object();
    private static volatile char currentChar = 'A';
    private static final int countChars = 5;

    private static final char A = 'A';
    private static final char B = 'B';
    private static final char C = 'C';

    public static void main(String[] args) {
        new Thread(() -> {
            printChar(A, B);
        }).start();

        new Thread(() -> {
            printChar(B, C);
        }).start();

        new Thread(() -> {
            printChar(C, A);
        }).start();
    }

    private static void printChar(char processingChar, char nextChar) {
        try {
            for (int i = 0; i < countChars; i++) {
                synchronized (monitor) {
                    while (Main.currentChar != processingChar) {
                        monitor.wait();
                    }
                    System.out.print(processingChar);
                    Main.currentChar = nextChar;
                    monitor.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
