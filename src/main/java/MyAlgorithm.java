import DataStorage.DataStorage;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kot on 21.11.14.
 */
public class MyAlgorithm {

    private DataStorage.DataModel model;

    private MyAlgorithm() {
    }

    public Result getSum(Date date, Date date1, ArrayList<Object> objects, int i) {

    }


    public static MyAlgorithm fromDataStorage(DataStorage storage) {

        MyAlgorithm self = new MyAlgorithm();
        self.model = storage.getDataModel();

        return self;

    }
}
