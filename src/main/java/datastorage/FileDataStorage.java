package datastorage;

import segmenttree.SegmentTree;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kot on 25.11.14.
 */
public class FileDataStorage implements DataStorage {

    public final String FILE_NAME_DATA = ".dat";


    private final File directory;
    private final String filterName;

    public FileDataStorage(File directory, String filterName) {
        this.directory = directory;
        this.filterName = filterName;
    }

    @Override
    public DataBag createDataBag(List<Integer> items, List<Integer> filters, List<Integer> values) {
        return new BaseDataBag(filters, items, values);
    }

    @Override
    public Result loadResult() throws IOException {

        File items_file = new File(this.directory, this.filterName + ".items.bin");
        Map<Integer, Integer> items = this.loadData(items_file);

        File filters_file = new File(this.directory, this.filterName + ".filters.bin");
        Map<Integer, Integer> filters = this.loadData(filters_file);

        File values_file = new File(this.directory, this.filterName + ".values.bin");
        Map<Integer, Integer> values = this.loadData(values_file);

        File data = new File(this.directory, this.filterName + this.FILE_NAME_DATA);
        return new FileResult(items, filters, values, data);
    }

    private Map<Integer, Integer> loadData(File f) throws IOException {
        DataInputStream in_items = new DataInputStream(new FileInputStream(f));
        int i = 0;

        Map<Integer, Integer> items = new HashMap<Integer, Integer>((int)f.length()/4);

        try {
            while (true) {
                int readed = in_items.readInt();
                items.put(readed, i++);
            }

        } catch (EOFException ignored) {
        }
        in_items.close();

        return items;
    }

    public void write(Result rs) throws IOException {
        DataOutputStream out_items = new DataOutputStream(new FileOutputStream(new File(this.directory, this.filterName + ".items.bin")));
        DataOutputStream out_filters = new DataOutputStream(new FileOutputStream(new File(this.directory, this.filterName + ".filters.bin")));
        DataOutputStream out_values = new DataOutputStream(new FileOutputStream(new File(this.directory, this.filterName + ".values.bin")));

        this.write(rs.getItems(), out_items);
        this.write(rs.getFilters(), out_filters);
        this.write(rs.getValues(), out_values);

        this.writeData(rs);

        out_items.close();
        out_filters.close();
        out_values.close();
    }

    private void writeData(Result rs) throws IOException {

        SegmentTree[][] data = rs.getData();

        int segment_length = data[0][0].asArray().length;
        int clip_length = rs.getItems().size();
        int filter_length = rs.getFilters().size();

        DataOutputStream out_items = new DataOutputStream(new FileOutputStream(new File(this.directory, this.filterName + ".dat")));

        for (int x= 0; x< segment_length; x++ ) {
            for(int clip=0; clip<clip_length; clip++) {
                for(int filter=0; filter<filter_length; filter++) {
//                    System.out.println("bin tree " + Arrays.toString(data[clip][filter].asArray()));
                    out_items.writeInt(data[clip][filter].asArray()[x]);
                }
            }
        }

        out_items.close();

//    clip_1      clip_2
//    f1  f2  f3  f1  f2  f3
//    | | | | | | | | | | | | |
//

    }

    private void write(Map<Integer, Integer> map, DataOutputStream dos) throws IOException {
        int[] save_items = new int[map.size()];

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            save_items[entry.getValue()] = entry.getKey();
        }

        for (int x: save_items) {
            dos.writeInt(x);
        }
    }

}
