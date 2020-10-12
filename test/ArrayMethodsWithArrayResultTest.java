import lesson6_junit.MyArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayMethodsWithArrayResultTest {
    private static Integer[] original;
    private static Integer[] result;

    public ArrayMethodsWithArrayResultTest(Integer[] original, Integer[] result) {
        this.original = original;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new Integer[]{1, 7}},
                        {new Integer[]{1, 2, 4, 4, 2, 3, 4, 4, 7}, new Integer[]{7}},
                        {new Integer[]{1, 2, 4, 4, 2, 3, 4, 4, 4}, new Integer[]{}}
                }
        );
    }

    @Test
    public void testGetElemetsAfterLastNumber() {
        Assert.assertArrayEquals(MyArrayUtils.getElemetsAfterLastNumber(original, 4), result);
    }
}
