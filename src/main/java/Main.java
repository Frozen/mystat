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

        System.out.println(System.getProperty("user.home"));

//        create_test();
        read();
    }

    private static void create_test() throws IOException {
        DataStorage ds = new FileDataStorage(new File(System.getProperty("user.home"), "datastorage"), "regions");

//        DataModel dm = ds.getDataModel();

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
//        dbag.setData(2, 10, 200, 4);

        Result rs = dbag.calculate();

//        int val = rs.getSum(9, 10, 200, 204);

//        System.out.println(val);

        ds.write(rs);
    }


    /*
    private static void create() throws ClassNotFoundException, SQLException, IOException {
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

    */

    private static void read() throws IOException {

        DataStorage ds = new FileDataStorage(new File(System.getProperty("user.home"), "datastorage"), "regions");

        Result rs = ds.loadResult();

//        System.out.print();
//        System.out.println("rs == " + rs.getSum(1, 10, 200, 204));
        // [0, 15, 6, 9, 3, 3, 4, 5, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        long startTime = System.currentTimeMillis();
        System.out.println("rs == " + rs.getSum(1, 10, 201, 204));
        System.out.println("rs == " + rs.getSum(1, 10, 202, 204));
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
//        System.out.println("rs == " + rs.getSum(1, 10, 200, 204));

    }

}


