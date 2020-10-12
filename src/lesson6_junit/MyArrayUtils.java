package lesson6_junit;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class MyArrayUtils {

    /**
     * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
     * иначе в методе необходимо выбросить RuntimeException.
     * <p>
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     */

    public static <T> T[] getElemetsAfterLastNumber(T[] array, int number) {
        System.out.printf("Original array of %s: %s\n", array.getClass().getSimpleName(), Arrays.toString(array));
        int lastPosition = ArrayUtils.lastIndexOf(array, number);
        System.out.printf("Last position of %d: %d\n", number, lastPosition);


        if (lastPosition > -1) {
            T[] result = ArrayUtils.subarray(array, lastPosition + 1, array.length + 1);
            System.out.printf("Result array of %s: %s\n", result.getClass().getSimpleName(), Arrays.toString(result));
            return result;
        } else {
            throw new RuntimeException("Number for search not found in array");
        }
    }

    /**
     * 2. Написать метод, который проверяет состав массива из чисел 1 и 4.
     * Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     * <p>
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * [ 1 1 1 4 4 1 4 4 ] -> true
     * [ 1 1 1 1 1 1 ] -> false
     * [ 4 4 4 4 ] -> false
     * [ 1 4 4 1 1 4 3 ] -> false
     */

    public static <T> boolean noForeignElements(T[] array, T[] allowedElements) {
        System.out.printf("Original array of %s: %s\n", array.getClass().getSimpleName(), Arrays.toString(array));
        for (T element : array) {
            if (!ArrayUtils.contains(allowedElements, element)) {
                System.out.printf("%d not contains in %s", element, Arrays.toString(allowedElements));
                return false;
            }
        }
        return true;
    }


}
