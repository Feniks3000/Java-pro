package lesson5_racing_game;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начала этап: " + getDescription());
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончила этап: " + getDescription());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}