package DataStorage;

/**
 * Created by kot on 21.11.14.
 */
public class SimpleDataStorage implements DataStorage {
    @Override
    public DataModel getDataModel() {


        for (int x =0; x < 8000; x++) {

            for (int region_id=0; region_id< 100; region_id++) {

                int[] rs = new int[366];
                for (int y=0; y<366; y++) {
                    rs[y] = y+1;
                }

            }


        }


    }
}
