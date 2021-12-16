package mypack;

import java.sql.*;

public class propertyDAO {
    Connection con;
    public void createConnction() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?useSSL=false", "root", "root");
    }

    public void getInformation() throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT INTO students VALUES(3, 'Poojan', 10, 10, 10)");
        ResultSet rst; 
        int i = pst.executeUpdate();
    }
}