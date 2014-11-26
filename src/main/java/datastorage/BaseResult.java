package datastorage;

import segmenttree.SegmentTree;

import java.util.Map;

/**
 * Created by kot on 24.11.14.
 */
public class BaseResult implements Result {

    private final SegmentTree[][] s;
    private final Map<Integer, Integer> items;
    private final Map<Integer, Integer> filters;
    private final Map<Integer, Integer> values;

    public BaseResult(SegmentTree[][] s, Map<Integer, Integer> items, Map<Integer, Integer> filters, Map<Integer, Integer> values) {
        this.s = s;
        this.items = items;
        this.filters = filters;
        this.values = values;
    }

    @Override
    public int getSum(int item, int filter, int from, int to) {

        // TODO:
        int item_id = this.items.get(item);
        int filter_id = this.filters.get(filter);
        int from_id = this.values.get(from);
        int to_id = this.values.get(to);

        return this.s[item_id][filter_id].getSum(from_id, to_id);
    }

    @Override
    public Map<Integer, Integer> getItems() {
        return this.items;
    }

    @Override
    public Map<Integer, Integer> getFilters() {
        return this.filters;
    }

    @Override
    public Map<Integer, Integer> getValues() {
        return this.values;
    }

    @Override
    public SegmentTree[][] getData() {
        return this.s;
    }


}
