package datastorage;

import segmenttree.SimpleSegmentTree;

import java.util.*;

/**
 * Created by kot on 21.11.14.
 */
public class SimpleDataStorage implements DataStorage {
    @Override
    public DataModel getDataModel() {

        int clip_count = 1000;

        SimpleSegmentTree[][] ret = new SimpleSegmentTree[clip_count][100];

        for (int x =0; x < clip_count; x++) {
            System.out.println(x);

            for (int region_id=0; region_id < 100; region_id++) {

                int[] rs = new int[366];
                for (int y=0; y<366; y++) {
                    rs[y] = y+1;
                }

                ret[x][region_id] = new SimpleSegmentTree(rs);

            }
        }

        return new DataModel(ret);

    }

    @Override
    public DataBag createDataBag(List<Integer> filters, List<Integer> items, List<Integer> values) {
//        Calendar calendar = Calendar.getInstance();
//        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        return new BaseDataBag(filters, items, values);
    }

//    @Override
//    public Map<String, List<Integer>> getFilters() {
//        HashMap<String, List<Integer>> x = new HashMap<>();
//        List<Integer> arraylist = new ArrayList<>(Arrays.asList(this.range(0, 100)));
//        x.put("region", arraylist);
//        return x;
//    }

    private Integer[] range(int start, int length) {
        Integer[] range = new Integer[length - start + 1];
        for (int i = start; i <= length; i++) {
            range[i - start] = i;
        }
        return range;
    }
}
