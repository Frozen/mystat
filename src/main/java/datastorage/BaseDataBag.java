package datastorage;

import segmenttree.SimpleSegmentTree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kot on 23.11.14.
 */
public class BaseDataBag implements DataBag {

    Map<Integer, Integer> filters = new HashMap<>(160);
    Map<Integer, Integer> items = new HashMap<>();
    Map<Integer, Integer> values = new HashMap<>();
    int[][][] ret;
//    SimpleSegmentTree[][] ret = new SimpleSegmentTree[clip_count][100];

    public BaseDataBag(List<Integer> filters, List<Integer> items, List<Integer> values) {
        this.setFilters(filters);
        this.setItems(items);
        this.setValues(values);

        this.ret = new int[this.items.size()][this.filters.size()][this.values.size()];
    }


//    @Override
    private void setFilters(List<Integer> filters) {
        for(int x: filters) this.filters.put(x, this.filters.size());
    }

//    @Override
    public void setItems(List<Integer> items) {
        for(int x: items) this.items.put(x, this.items.size());
    }

//    @Override
    private void setValues(List<Integer> values) {
        for(int x: values) this.values.put(x, this.values.size());
    }

    /*
    public void setData(int item, int filter, Map<Integer, Integer> data) {

        if (this.items.get(item) == null) {
            throw new IllegalArgumentException("illegal value " + item);
        }

        int item_id = this.values.get(item);



        SimpleSegmentTree[][] ret = new SimpleSegmentTree[this.items.size()][this.filters.size()];

        for (int x =0; x < this.filters.size(); x++) {

            int[] arr = new int[data.size()];

            for(int i=0; i<data.size(); i++) arr[i]=this.values.get(data.get(i));

            ret[item_id][x] = new SimpleSegmentTree(arr);
        }

    }*/

    public void setData(int item, int filter, int value, int data) {

        if (this.items.get(item) == null) {
            throw new IllegalArgumentException("illegal item " + item);
        }

        int item_id = this.items.get(item);


        if (this.filters.get(filter) == null) {
            throw new IllegalArgumentException("illegal filter " + filter);
        }

        int filter_id = this.filters.get(filter);

        if (this.values.get(value) == null) {
            throw new IllegalArgumentException("illegal filter " + value);
        }

        int value_id = this.values.get(value);


        this.ret[item_id][filter_id][value_id] = data;

    }

    @Override
    public Result calculate() {
        SimpleSegmentTree[][] ret = new SimpleSegmentTree[this.items.size()][this.filters.size()];

        for (int x =0; x < this.items.size(); x++) {
            for(int y=0; y<this.filters.size(); y++) {
                ret[x][y] = new SimpleSegmentTree(this.ret[x][y]);
            }
        }
        return new BaseResult(ret, this.items, this.filters, this.values);
    }
}
