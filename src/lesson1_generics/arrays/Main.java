package lesson1_generics.arrays;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"1", "2", "3", "4"};
        Integer[] integers = {1, 2, 3, 4};
        Double[] doubles = {1.0, 2.0, 3.0, 4.0};

        String[] resultArray1 = MyArrayUtils.swapElements(strings, 0, 3);
        Integer[] resultArray2 = MyArrayUtils.swapElements(integers, 0, 3);
        Double[] resultArray3 = MyArrayUtils.swapElements(doubles, 0, 3);

        System.out.println();

        List<String> resultList1 = MyArrayUtils.convertToArrayList(strings);
        List<Integer> resultList2 = MyArrayUtils.convertToArrayList(integers);
        List<Double> resultList3 = MyArrayUtils.convertToArrayList(doubles);
    }
}
