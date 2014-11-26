package datastorage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by kot on 21.11.14.
 */
public interface DataStorage {


//    public DataModel getDataModel();

//    public Map<String, List<Integer>> getFilters();

    public DataBag createDataBag(List<Integer> items, List<Integer> filters, List<Integer> values) ;

    public Result loadResult() throws IOException;

    public void write(Result rs) throws IOException;

}
