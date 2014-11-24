import datastorage.*;

import java.util.Arrays;

/**
 * Created by kot on 07.11.14.
 */
public class Main {

    public Main() {

    }

    public static void main(String[] str) throws InterruptedException {

        DataStorage ds = new SimpleDataStorage();

//        DataModel dm = ds.getDataModel();

        DataBag dbag = ds.createDataBag(
                Arrays.asList(10, 20, 30, 40, 50),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Arrays.asList(200, 201, 202, 203, 204, 205)
        );

        dbag.setData(11, 1, Arrays.asList(1,2,3,4,5));

        Result rs = dbag.calculate();

        rs.getSum(1, 2, 3, 10);

//        for (int i=0; i<50; i++) {
//            System.out.println(dm.getSum(0, 50, 5, i));
//        }




//        MyAlgorithm my = MyAlgorithm.fromDataStorage(new File("/home/kot/datastorage"));
//        MyAlgorithm my = MyAlgorithm.fromDataStorage(new SimpleDataStorage());

//        datastorage.Result rs = my.getSum(new Date(), new Date(), new ArrayList<>(), 100);






    }

}


