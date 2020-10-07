package lesson5_racing_game;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private int throughput;
    private Semaphore semaphore;

    public Tunnel(int length, int throughput) {
        this.length = length;
        this.throughput = throughput;
        this.semaphore = new Semaphore(throughput);
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готова к этапу: " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начала этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончила этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}