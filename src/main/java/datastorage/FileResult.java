package datastorage;

import segmenttree.SegmentTree;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kot on 26.11.14.
 */
public class FileResult implements Result {

    private final Map<Integer, Integer> items;
    private final Map<Integer, Integer> filters;
    private final Map<Integer, Integer> values;
    private final File dataFile;

    public FileResult(Map<Integer, Integer> items, Map<Integer, Integer> filters, Map<Integer, Integer> values, File dataFile) {
        this.items = items;
        this.filters = filters;
        this.values = values;
        this.dataFile = dataFile;
    }

    @Override
    public int getSum(int item, int filter, int from, int to) throws IOException {
        DataInputStream in_items = new DataInputStream(new FileInputStream(this.dataFile));

        int item_id = this.items.get(item);
        int filter_id = this.filters.get(filter);
        int from_id = this.values.get(from);
        int to_id = this.values.get(to);

        Map<Integer, Integer> items = new HashMap<Integer, Integer>((int)this.dataFile.length()/4);

        in_items.skipBytes(4*this.items.size()*this.filters.size());
//        in_items.skipBytes(4*this.items.size()*this.filters.size());

        int[] array = new int[this.items.size()*this.filters.size()];

        try {

            for (int i=0; i<this.items.size()*this.filters.size(); i++) {
                int readed = in_items.readInt();
                System.out.println(readed);
                array[i] = readed;
            }

//            int i = this.items.size()*this.filters.size();
//            while (i>0) {
//                int readed = in_items.readInt();
//                System.out.println(readed);
//                items.put(readed, i++);
//                array

//            }

        } catch (EOFException ignored) {
            System.out.println("[EOF]");
        }
        in_items.close();

        return array[item_id*filter_id];
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
