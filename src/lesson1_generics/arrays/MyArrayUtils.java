package lesson1_generics.arrays;

import java.util.Arrays;
import java.util.List;

public class MyArrayUtils {

    /**
     * 1. Метод меняет два элемента массива местами (массив может быть любого ссылочного типа)
     */
    public static <T> T[] swapElements(T[] array, int element1, int element2) {
        System.out.printf("Original array of %s: %s\n", array.getClass().getSimpleName(), Arrays.toString(array));
        T[] resultArray = Arrays.copyOf(array, array.length);
        T temp = array[element1];
        resultArray[element1] = array[element2];
        resultArray[element2] = temp;
        System.out.printf("Result array (swap elements №%d anf №%d): %s\n", element1 + 1, element2 + 1, Arrays.toString(resultArray));
        return resultArray;
    }

    /**
     * Метод преобразует массив в ArrayList
     */
    public static <T> List<T> convertToArrayList(T[] array) {
        System.out.printf("Original array of %s: %s\n", array.getClass().getSimpleName(), Arrays.toString(array));
        List<T> resultList = Arrays.asList(array);
        System.out.printf("Result list: %s\n", resultList);
        return resultList;
    }
}
