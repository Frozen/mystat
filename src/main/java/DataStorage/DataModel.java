package datastorage;

import segmenttree.SegmentTree;

/**
 * Created by kot on 21.11.14.
 */
public class DataModel {

    private final SegmentTree[][] items;

    public DataModel(SegmentTree[][] items) {
        this.items = items;
    }

    public int getSum(int date_from, int date_to, int filter_id, int item_id) {

        return this.items[item_id][filter_id].getSum(date_from, date_to);

    }

}
