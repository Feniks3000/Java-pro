package lesson5_racing_game;

/*
Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого их них уходит разное время.
В тоннель не может заехать одновременно больше половины участников (условность).
Попробуйте все это синхронизировать.
Только после того, как все завершат гонку, нужно выдать объявление об окончании.
Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final int CARS_COUNT = 9;
    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    public static final CountDownLatch allCarsStart = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch allCarsFinish = new CountDownLatch(CARS_COUNT);
    public static final Lock winnerLock = new ReentrantLock();

    public static void main(String[] args) {
        Track race = generateTrack();
        Car[] cars = generateCars(race);

        for (Car car : cars) {
            new Thread(car).start();
        }

        startRace();
        finishRace();
    }

    private static Car[] generateCars(Track race) {
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 40 + (int) (Math.random() * 30 - 10), cyclicBarrier, allCarsStart, allCarsFinish, winnerLock);
        }
        System.out.println(">>> Участники гонки: " + Arrays.toString(cars));
        return cars;
    }

    private static Track generateTrack() {
        Random random = new Random();
        Track race = new Track(new Road(random.nextInt(100) + 50), new Tunnel(50, CARS_COUNT / 2), new Road(random.nextInt(100) + 100));
        System.out.println(">>> Трасса для соревнований: " + race);
        return race;
    }

    private static void finishRace() {
        try {
            allCarsFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>> Гонка закончилась - все машины прибыли к финишу");
    }

    private static void startRace() {
        try {
            allCarsStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>> Все машины на старте");
        System.out.println(">>> Гонка началась!");
    }
}
