package lesson7_annotations;

public class ClassWithTestAnnotations {
    @BeforeSuite
    public static void before1() {
        System.out.println("Before1");
    }

    //@BeforeSuite
    public static void before2() {
        System.out.println("Before2");
    }

    @Test(priority = 1)
    public static void test1() {
        System.out.println("Test1 - priority 1");
    }

    @Test(priority = 10)
    public static void test2() {
        System.out.println("Test2 - priority 10");
    }

    @Test
    public static void test3() {
        System.out.println("Test3 - default pirority 5");
    }


    @AfterSuite
    public static void after1() {
        System.out.println("After1");
    }

    //@AfterSuite
    public static void after2() {
        System.out.println("After2");
    }

}
