package datastorage;

import segmenttree.SegmentTree;

import java.util.List;
import java.util.Map;

/**
 * Created by kot on 21.11.14.
 */
public interface Result {

    int getSum(int item, int filter, int from, int to);

    public Map<Integer, Integer> getItems();
    public Map<Integer, Integer> getFilters();
    public Map<Integer, Integer> getValues();

    public SegmentTree[][] getData();
}
