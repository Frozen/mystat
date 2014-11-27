package datastorage;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kot on 27.11.14.
 */
public class FileDataStorageMultipleFiltersTest {

    private File dataDir;
//    private Result rs;

    @Before
    public void before() throws IOException {
        URL location = FileDataStorageBaseTest.class.getProtectionDomain().getCodeSource().getLocation();
        this.dataDir = new File(new File(location.getFile()).getParentFile().getParentFile(), "test_data");
        FileUtils.cleanDirectory(dataDir);


    }


    @Test
    public void testLoadResult1() throws Exception {

        DataStorage ds = new FileDataStorage(this.dataDir, "regions");

        DataBag dbag = ds.createDataBag(
                Arrays.asList(1),
                Arrays.asList(10, 11),
                Arrays.asList(200, 201, 202, 203, 204)
        );

        dbag.setData(1, 10, 200, 1);
        dbag.setData(1, 10, 201, 2);
        dbag.setData(1, 10, 202, 3);
        dbag.setData(1, 10, 203, 4);
        dbag.setData(1, 10, 204, 5);

        dbag.setData(1, 11, 200, 6);
        dbag.setData(1, 11, 201, 7);
        dbag.setData(1, 11, 202, 8);
        dbag.setData(1, 11, 203, 9);
        dbag.setData(1, 11, 204, 10);

        ds.write(dbag.calculate());

        Result rs = ds.loadResult();

        assertEquals(Arrays.asList(55), rs.getSum(Arrays.asList(10, 11), 200, 204));
        assertEquals(Arrays.asList(40), rs.getSum(Arrays.asList(10, 11), 200, 203));

    }


    @Test
    public void testLoadResult2() throws Exception {

        DataStorage ds = new FileDataStorage(this.dataDir, "regions");

        DataBag dbag = ds.createDataBag(
                Arrays.asList(1, 2),
                Arrays.asList(10, 11),
                Arrays.asList(200, 201, 202, 203, 204)
        );

        dbag.setData(1, 10, 200, 1);
        dbag.setData(1, 10, 201, 2);
        dbag.setData(1, 10, 202, 3);
        dbag.setData(1, 10, 203, 4);
        dbag.setData(1, 10, 204, 5);

        dbag.setData(1, 11, 200, 6);
        dbag.setData(1, 11, 201, 7);
        dbag.setData(1, 11, 202, 8);
        dbag.setData(1, 11, 203, 9);
        dbag.setData(1, 11, 204, 10);

        dbag.setData(2, 11, 200, 11);
        dbag.setData(2, 11, 201, 12);
        dbag.setData(2, 11, 202, 13);
        dbag.setData(2, 11, 203, 14);
        dbag.setData(2, 11, 204, 15);

        ds.write(dbag.calculate());

        Result rs = ds.loadResult();

        assertEquals(Arrays.asList(55, 65), rs.getSum(Arrays.asList(10, 11), 200, 204));
        assertEquals(Arrays.asList(15, 0), rs.getSum(Arrays.asList(10), 200, 204));
        assertEquals(Arrays.asList(10, 0), rs.getSum(Arrays.asList(10), 200, 203));

    }

}
