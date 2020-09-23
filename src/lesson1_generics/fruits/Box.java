package lesson1_generics.fruits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.fruits = Arrays.asList(fruits);
    }

    public float getWeight() {
        return (float) fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0000001;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void moveToOtherBox(Box<? super T> otherBox) {
        if (otherBox == this) {
            return;
        }
        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public int getSize() {
        return fruits.size();
    }
}
