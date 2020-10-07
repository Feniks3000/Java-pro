package lesson5_racing_game;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private final Track race;
    private final CyclicBarrier cyclicBarrier;
    private final CountDownLatch allCarsStart;
    private final CountDownLatch allCarsFinish;
    private final Lock winnerLock;
    private final int speed;
    private final String name;

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public Car(Track race, int speed, CyclicBarrier cyclicBarrier, CountDownLatch allCarsStart, CountDownLatch allCarsFinish, Lock winnerLock) {
        this.race = race;
        this.cyclicBarrier = cyclicBarrier;
        this.allCarsStart = allCarsStart;
        this.allCarsFinish = allCarsFinish;
        this.winnerLock = winnerLock;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Машина " + CARS_COUNT;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готова");
            allCarsStart.countDown();
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Выехала на трассу
        for (Stage stage : race.getStages()) {
            stage.go(this);
        }
        if (winnerLock.tryLock()) {
            System.out.println(">>> Победитель гонки: " + getName());
        }
        allCarsFinish.countDown();
    }
}