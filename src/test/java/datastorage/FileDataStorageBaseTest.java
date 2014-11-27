package datastorage;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.apache.commons.io.FileUtils;

public class FileDataStorageBaseTest {

    private File dataDir;

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
                Arrays.asList(10),
                Arrays.asList(200, 201, 202, 203, 204)
        );

        dbag.setData(1, 10, 200, 1);
        dbag.setData(1, 10, 201, 2);
        dbag.setData(1, 10, 202, 3);
        dbag.setData(1, 10, 203, 4);
        dbag.setData(1, 10, 204, 5);

        Result rs = dbag.calculate();

        ds.write(rs);

        assertEquals(15, rs.getSum(1, 10, 200, 204));
        assertEquals(14, rs.getSum(1, 10, 201, 204));
        assertEquals(9, rs.getSum(1, 10, 201, 203));
    }

    @Test
    public void testLoadResult2() throws Exception {
        DataStorage ds = new FileDataStorage(this.dataDir, "regions");

        DataBag dbag = ds.createDataBag(
                Arrays.asList(1),
                Arrays.asList(10),
                Arrays.asList(200, 201, 202, 203, 204)
        );

        dbag.setData(1, 10, 200, 1);
        dbag.setData(1, 10, 201, 2);
        dbag.setData(1, 10, 202, 3);
        dbag.setData(1, 10, 203, 4);
        dbag.setData(1, 10, 204, 5);

        ds.write(dbag.calculate());

        Result rs = ds.loadResult();

        assertEquals(15, rs.getSum(1, 10, 200, 204));
        assertEquals(14, rs.getSum(1, 10, 201, 204));
        assertEquals(9, rs.getSum(1, 10, 201, 203));
    }

    @Test
    public void testLoadResult3() throws Exception {
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

        assertEquals(40, rs.getSum(1, 11, 200, 204));
        assertEquals(34, rs.getSum(1, 11, 201, 204));
        assertEquals(24, rs.getSum(1, 11, 201, 203));
    }
}