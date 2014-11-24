package segmenttree;

/**
 * Created by kot on 22.11.14.
 */
public class SimpleSegmentTree implements SegmentTree {
    private final StackOverflowSegmentTree.STNode tree;

    @Override
    public int getSum(int left, int right) {
        return StackOverflowSegmentTree.getSum(this.tree, left, right);
    }

    public SimpleSegmentTree(StackOverflowSegmentTree.STNode tree) {
        this.tree = tree;
    }

    public SimpleSegmentTree(int[] arr) {
        this.tree = StackOverflowSegmentTree.constructSegmentTree(arr, 0, arr.length-1);
    }

}
