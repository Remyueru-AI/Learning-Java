package Day30;

import java.sql.Connection;//object for connecting to database
import java.sql.DriverManager;//driver for it to run, need jar file iirc
import java.sql.PreparedStatement;

public class DbConnect {
    //final means constant and this is the url path to db
    final String url = "jdbc:mysql://localhost:3306/learningjavadb";
    Connection conn;

    public void setConn() {
        try {
            //passing the connection object to the driver with the url, user, password
            conn = DriverManager.getConnection(url,"root","0000");
            System.out.println("Connected");
        }
        catch (Exception e) {
            //if something failed
            System.out.println("Failed\n"+e);

        }
    }

}
