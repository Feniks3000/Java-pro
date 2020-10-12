import lesson6_junit.MyArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayMethodsWithTrueResultTest {
    private static Integer[] original;
    private static Integer[] allowedElements;

    public ArrayMethodsWithTrueResultTest(Integer[] original, Integer[] allowedElements) {
        this.original = original;
        this.allowedElements = allowedElements;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new Integer[]{1, 4, 1, 4, 1, 4}, new Integer[]{1, 4}},
                        {new Integer[]{1}, new Integer[]{1, 4}},
                        {new Integer[]{}, new Integer[]{1, 4}}
                }
        );
    }

    @Test
    public void testNoForeignElements() {
        Assert.assertTrue(MyArrayUtils.noForeignElements(original, allowedElements));
    }
}
