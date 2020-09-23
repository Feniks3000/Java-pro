package lesson1_generics.fruits;

public class Main {
    public static void main(String[] args) {
        Box<Orange> orangeBox1 = new Box<>();
        for (int i = 0; i < 4; i++) {
            orangeBox1.addFruit(new Orange());
        }
        System.out.printf("OrangeBox1 contained %d oranges with total weight %f\n", orangeBox1.getSize(), orangeBox1.getWeight());

        Box<Apple> appleBox1 = new Box<>();
        for (int i = 0; i < 6; i++) {
            appleBox1.addFruit(new Apple());
        }
        System.out.printf("AppleBox1 contained %d apples with total weight %f\n", appleBox1.getSize(), appleBox1.getWeight());

        System.out.printf("OrangeBox1 compare AppleBox1 = %b\n", orangeBox1.compare(appleBox1));
        System.out.printf("AppleBox1 compare OrangeBox1 = %b\n", appleBox1.compare(orangeBox1));

        Box<Orange> orangeBox2 = new Box<>();
        System.out.printf("OrangeBox1 size %d and weight %f. OrangeBox2 size %d and weight %f.\n",
                orangeBox1.getSize(), orangeBox1.getWeight(), orangeBox2.getSize(), orangeBox2.getWeight());
        orangeBox1.moveToOtherBox(orangeBox2);
        System.out.printf("After moving -> OrangeBox1 size %d and weight %f. OrangeBox2 size %d and weight %f.\n",
                orangeBox1.getSize(), orangeBox1.getWeight(), orangeBox2.getSize(), orangeBox2.getWeight());
    }
}
