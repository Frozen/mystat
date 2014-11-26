package segmenttree;

/**
 * Created by kot on 21.11.14.
 */
public interface SegmentTree {

    int getSum(int left, int right);

    int[] asArray();
}
