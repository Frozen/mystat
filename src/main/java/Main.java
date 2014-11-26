import datastorage.*;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

/**
 * Created by kot on 07.11.14.
 */
public class Main {

    public Main() {

    }

    public static void main(String[] str) throws IOException {

//        create();
//        create_test();

    }

    private static void create_test() throws IOException {
        DataStorage ds = new FileDataStorage(new File("/Users/kot/datastorage"), "regions");

//        DataModel dm = ds.getDataModel();

        DataBag dbag = ds.createDataBag(
                Arrays.asList(1, 2),
//                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Arrays.asList(10, 11),
//                Arrays.asList(10, 20, 30, 40, 50),
                Arrays.asList(200, 201, 202, 203, 204)
        );

        dbag.setData(1, 10, 200, 5);
        dbag.setData(1, 10, 201, 2);
//        dbag.setData(1, 10, 200, 4);

        Result rs = dbag.calculate();

//        int val = rs.getSum(9, 10, 200, 204);

//        System.out.println(val);

        ds.write(rs);
    }

    private static void create() throws ClassNotFoundException, SQLException {
        DataStorage ds = new SimpleDataStorage();

//        DataModel dm = ds.getDataModel();

        DataBag dbag = ds.createDataBag(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Arrays.asList(10, 20, 30, 40, 50),
                Arrays.asList(200, 201, 202, 203, 204, 205)
        );

        dbag.setData(9, 10, 205, 5);

        Result rs = dbag.calculate();

        int val = rs.getSum(9, 10, 200, 204);

        System.out.println(val);


        Class.forName("com.mysql.jdbc.Driver");

        Connection connect = DriverManager
                .getConnection("jdbc:mysql://localhost/statistics?user=statistics&password=statistics");

        // statements allow to issue SQL queries to the database
        Statement statement = connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        statement.setFetchSize(Integer.MIN_VALUE);
        // resultSet gets the result of the SQL query
        ResultSet resultSet = statement
                .executeQuery("select * from table");

        while (resultSet.next()) {
            // it is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g., resultSet.getSTring(2);
            int user = resultSet.getInt("id");
            System.out.println(user);
        }
    }

    private static void read() {

        DataStorage ds = new FileDataStorage(new File("/Users/kot/datastorage"), "regions");

        Result rs = ds.loadResult();

        System.out.println(rs.getSum(1, 10, 200, 204));

    }

}


