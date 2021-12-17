package mypack;

import java.sql.*;

public class Connector {
    public Connection createConnection() throws SQLException, ClassNotFoundException{
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertyportal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        return con;
    }   
}