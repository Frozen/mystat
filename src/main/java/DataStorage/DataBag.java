package datastorage;

import java.util.List;

/**
 * Created by kot on 23.11.14.
 */
public interface DataBag {

    public void setFilters(List<Integer> filters);
    public void setItems(List<Integer> items);
    public void setValues(List<Integer> values);

    public int getSum(int item, int filter, int value_from, int value_to);

    public void setData(int value, int filter, List<Integer> data);

    Result calculate();
}
