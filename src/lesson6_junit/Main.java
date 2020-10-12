package lesson6_junit;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(MyArrayUtils.getElemetsAfterLastNumber(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, 4)));
    }
}
