package ProjectJava;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class BoxCon {
    final String url = "jdbc:mysql://localhost:3306/learningjavadb",
    jPath = "src\\ProjectJava\\bag\\bag.json";
    Connection con;
    String qry, again;
    PreparedStatement preStatement;
    Statement statement;
    ResultSet resultSet;

    File bagJson = new File(jPath);
    AdventurersBox ab = new AdventurersBox();

    public void connectBox() {
        try {
            con = DriverManager.getConnection(url, "root", "0000");
        } catch (Exception e) {
            System.out.println("Connection Status: Failed" + e);
            ab.mainDisplay();
        }
    }

}
