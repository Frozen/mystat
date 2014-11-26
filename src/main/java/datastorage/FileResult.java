package datastorage;

import segmenttree.SegmentTree;

import java.io.File;
import java.util.Map;

/**
 * Created by kot on 26.11.14.
 */
public class FileResult implements Result {

    private final Map<Integer, Integer> items;
    private final Map<Integer, Integer> filters;
    private final Map<Integer, Integer> values;

    public FileResult(Map<Integer, Integer> items, Map<Integer, Integer> filters, Map<Integer, Integer> values, File data) {
        this.items = items;
        this.filters = filters;
        this.values = values;
    }

    @Override
    public int getSum(int item, int filter, int from, int to) {
        return 0;
    }

    @Override
    public Map<Integer, Integer> getItems() {
        return null;
    }

    @Override
    public Map<Integer, Integer> getFilters() {
        return null;
    }

    @Override
    public Map<Integer, Integer> getValues() {
        return null;
    }

    @Override
    public SegmentTree[][] getData() {
        return new SegmentTree[0][];
    }
}
