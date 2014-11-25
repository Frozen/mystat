package datastorage;

import java.io.File;
import java.util.List;

/**
 * Created by kot on 25.11.14.
 */
public class FileDataStorage implements DataStorage {


    public FileDataStorage(File f, String filterName) {

    }

    @Override
    public DataBag createDataBag(List<Integer> items, List<Integer> filters, List<Integer> values) {
        return new BaseDataBag(filters, items, values);
    }
}
