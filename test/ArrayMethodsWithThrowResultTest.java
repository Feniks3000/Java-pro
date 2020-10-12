import lesson6_junit.MyArrayUtils;
import org.junit.Test;

public class ArrayMethodsWithThrowResultTest {

    @Test(expected = RuntimeException.class)
    public void getElemetsAfterLastNumberThrow() {
        MyArrayUtils.getElemetsAfterLastNumber(new Integer[]{1, 2, 2, 3, 1, 7}, 4);
    }

}
