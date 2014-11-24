package datastorage;

import java.util.List;
import java.util.Map;

/**
 * Created by kot on 21.11.14.
 */
public interface DataStorage {


    public DataModel getDataModel();

//    public Map<String, List<Integer>> getFilters();

    public DataBag createDataBag(List<Integer> items, List<Integer> filters, List<Integer> values) ;


}
