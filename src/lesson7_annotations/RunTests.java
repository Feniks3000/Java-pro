package lesson7_annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Создать класс, который может выполнять «тесты». В качестве тестов выступают классы с наборами методов с аннотациями @Test.
 * Для этого у него должен быть статический метод start(), которому в качестве параметра передается или объект типа Class,
 * или имя класса. Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется.
 * Далее запущены методы с аннотациями @Test, а по завершении всех тестов – метод с аннотацией @AfterSuite.
 * К каждому тесту необходимо добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет выбираться
 * порядок их выполнения. Если приоритет одинаковый, то порядок не имеет значения.
 * Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
 * иначе необходимо бросить RuntimeException при запуске «тестирования».
 */

public class RunTests {
    public static void start(Class aClass) throws InvocationTargetException, IllegalAccessException {
        List<Method> beforeMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeMethods.add(method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterMethods.add(method);
            }
        }
        runBeforeOrAfterMethods(beforeMethods, "@BeforeSuite");
        runTestMethodsWithSortByPriority(testMethods);
        runBeforeOrAfterMethods(afterMethods, "@AfterSuite");
    }

    private static void runTestMethodsWithSortByPriority(List<Method> testMethods) throws IllegalAccessException, InvocationTargetException {
        testMethods.sort(Comparator.comparingInt((Method method) -> method.getAnnotation(Test.class).priority()));
        for (Method method : testMethods) {
            method.invoke(null);
        }
    }

    private static void runBeforeOrAfterMethods(List<Method> methods, String annotation) throws IllegalAccessException, InvocationTargetException {
        if (methods.size() > 1) {
            throw new RuntimeException("Invalid number of methods with " + annotation + " annotation");
        } else if (methods.size() == 1){
            methods.get(0).invoke(null);
        }
    }

    public static void start(String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        start(Class.forName(className));
    }
}
