package segmenttree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySegmentTreeTest {

    ArraySegmentTree rs;

    @Before
    public void setup() {

        rs = ArraySegmentTree.build(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void testBuild() throws Exception {
        assertEquals(28, rs.getSum(0, 6));
        assertEquals(21, rs.getSum(0, 5));
        assertEquals(15, rs.getSum(0, 4));
        assertEquals(14, rs.getSum(1, 4));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void getByInvalidId() {
        rs.getSum(0, 7);
    }
}