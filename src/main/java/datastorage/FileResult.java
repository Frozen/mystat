package datastorage;

import segmenttree.SegmentTree;

import java.io.*;
import java.util.*;

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

        ArrayList<Integer> _positions = new ArrayList<Integer>();
        this.searchPositions(_positions, from_id, to_id);
        Collections.sort(_positions);

//        System.out.println("positions = " + _positions);

        int row_length_bytes = 4*this.items.size()*this.filters.size();
        int row_length_ints = this.items.size()*this.filters.size();

        int[] array = new int[row_length_ints];

        int current_position = 0;

        for (int position: _positions) {
            assert position > 0;

//            System.out.println("skip " + ((position - current_position)*row_length_bytes));

            in_items.skipBytes( (position - current_position)*row_length_bytes );
            current_position = position;

            for (int i=0; i<row_length_ints; i++) {
                int readed = in_items.readInt();
//                System.out.println("readed " + readed);
                array[i] += readed;
            }
            current_position++;

        }




//            int i = this.items.size()*this.filters.size();
//            while (i>0) {
//                int readed = in_items.readInt();
//                System.out.println(readed);
//                items.put(readed, i++);
//                array

//            }

//        } catch (EOFException ignored) {
//            System.out.println("[EOF]");
//        }
        in_items.close();

        return array[item_id*filter_id];
    }

    private int searchPositions(List<Integer> rs, int v, int tl, int tr, int l, int r) {

        if (l > r) {
//            System.out.println("l > r" + l + " " + r);
            return 0;
        }
        if (l == tl && r == tr) {
//            System.out.println("l == tl && r == tr "  + l + " " + r);
            rs.add(v);
//            return this.t[v];
            return 0;
        }
        int tm = (tl + tr) / 2;
        return searchPositions(rs, v * 2, tl, tm, l, Math.min(r, tm)) + searchPositions(rs, v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }

    private int searchPositions(List<Integer> rs, int left, int right) {
        return searchPositions(rs, 1, 0, this.values.size()-1, left, right);
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
