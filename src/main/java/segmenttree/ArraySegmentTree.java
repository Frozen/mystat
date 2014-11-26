package segmenttree;

/**
 * Created by kot on 25.11.14.
 */
public class ArraySegmentTree implements SegmentTree{

    private int[] t;

    private ArraySegmentTree(int[] a) {
        this.t = a;
    }

    @Override
    public int getSum(int left, int right) {
        if (left > right) {
            throw new IllegalArgumentException(left + " > " + right);
        }
        if (right > this.t.length/4 - 1) {
            throw new IndexOutOfBoundsException("right " + right + " > array max index " + (this.t.length/4 - 1));
        }
        return getSum(1, 0, this.t.length/4 - 1, left, right);
    }

    @Override
    public int[] asArray() {
        return this.t;
    }

    private int getSum(int v, int tl, int tr, int l, int r) {

        if (l > r) {
            System.out.println("l > r" + l + " " + r);
            return 0;
        }
        if (l == tl && r == tr) {
            System.out.println("l == tl && r == tr "  + l + " " + r);
            return this.t[v];
        }
        int tm = (tl + tr) / 2;
        return getSum(v*2, tl, tm, l, Math.min(r, tm)) + getSum(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }

    public static ArraySegmentTree build(int [] arr) {
        int[] t = new int[arr.length*4];

        build(t, arr, 1, 0, arr.length-1);

        return new ArraySegmentTree(t);
    }

    private static void build(int[] t, int[] a, int v, int l, int r) {
        if (l == r) {
            t[v] = a[l];
            return;
        }

        int mid = (l + r) / 2;
        build(t, a,  v*2, l, mid);
        build(t, a, v * 2 + 1, mid + 1, r);
        t[v] = t[v*2] + t[v*2+1];
    }

}
