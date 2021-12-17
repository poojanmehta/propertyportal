package mypack;

import java.sql.*;

public class userDAO {
    Connection con;
    public void createConnction() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
    }

    public String getAllUsers() throws SQLException {
        PreparedStatement pst = con.prepareStatement("SELECT * FROM users");
        ResultSet rst;
        String name;

        rst = pst.executeQuery();
        rst.absolute(1);

        name = rst.getString("firstname");
        User user = new User();
        user.Firstname = rst.getString("firstname");
        user.Lastname = rst.getString("lastname");
        user.Email = rst.getString("email");
        user.Mobile = rst.getString("mobile");
        user.City = rst.getString("city");
        user.Location = rst.getString("location");
        user.State = rst.getString("state");
        user.Type = rst.getInt("type");

        name = "poojan";
        return name;
    }
}