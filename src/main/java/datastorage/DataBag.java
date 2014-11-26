package datastorage;

import java.util.List;

/**
 * Created by kot on 23.11.14.
 */
public interface DataBag {

    public void setData(int item, int filter, int value, int data);

    Result calculate();
}
