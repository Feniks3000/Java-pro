package lesson7_annotations;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        RunTests.start(ClassWithTestAnnotations.class);
        System.out.println("---------------------------------");
        RunTests.start("lesson7_annotations.ClassWithTestAnnotations");
    }
}
