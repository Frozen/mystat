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
    SimpleSegmentTree[][] ret = null;
//    SimpleSegmentTree[][] ret = new SimpleSegmentTree[clip_count][100];

    public BaseDataBag(List<Integer> filters, List<Integer> items, List<Integer> values) {
        this.setFilters(filters);
        this.setItems(items);
        this.setValues(values);
    }


    @Override
    public void setFilters(List<Integer> filters) {
        for(int x: filters) this.filters.put(x, this.filters.size());
    }

    @Override
    public void setItems(List<Integer> items) {
        for(int x: items) this.items.put(x, this.items.size());
    }

    @Override
    public void setValues(List<Integer> values) {
        for(int x: values) this.values.put(x, this.values.size());
    }

    public int getSum(int item, int filter, int value_from, int value_to) {

        if (this.items.get(item) == null) {
            throw new IllegalArgumentException("no such item");
        }

    }

    public void setData(int value, int filter, List<Integer> data) {

//        int clip_count = 1000;

        SimpleSegmentTree[][] ret = new SimpleSegmentTree[this.items.size()][this.filters.size()];

        for (int x =0; x < this.filters.size(); x++) {
            System.out.println(x);

            int[] arr = new int[data.size()];

            ret[value][x] = new SimpleSegmentTree((int[]) data);

//            for (int region_id=0; region_id < 100; region_id++) {
//
//                int[] rs = new int[366];
//                for (int y=0; y<366; y++) {
//                    rs[y] = y+1;
//                }
//
//                ret[x][region_id] = new SimpleSegmentTree(rs);
//
//            }
        }

    }
}
