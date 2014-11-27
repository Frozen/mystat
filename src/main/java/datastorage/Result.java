package datastorage;

import segmenttree.SegmentTree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by kot on 21.11.14.
 */
public interface Result {

    int getSum(int item, int filter, int from, int to) throws IOException;

    public Map<Integer, Integer> getItems();
    public Map<Integer, Integer> getFilters();
    public Map<Integer, Integer> getValues();

    public SegmentTree[][] getData();

    List<Integer> getSum(List<Integer> filters, int from, int to) throws IOException;
}
