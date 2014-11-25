package segmenttree;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySegmentTreeTest {

    @Test
    public void testBuild() throws Exception {

        ArraySegmentTree rs = ArraySegmentTree.build(new int[]{1, 2, 3, 4, 5, 6, 7});

        assertEquals(28, rs.getSum(0, 6));
        assertEquals(21, rs.getSum(0, 5));
        assertEquals(15, rs.getSum(0, 4));
        assertEquals(14, rs.getSum(1, 4));
//        assertEquals(28, rs.getSum(0, 7));
//        assertEquals(27, rs.getSum(1, 7));

    }
}