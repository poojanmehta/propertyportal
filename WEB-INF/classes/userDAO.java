package mypack;

import java.sql.*;

public class userDAO {
    Connection con;

    public User getAllUsers() throws SQLException {
        Connector connector = new Connector();

        try {
            this.con = connector.createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PreparedStatement pst = con.prepareStatement("SELECT * FROM users");
        ResultSet rst;
        String name;

        rst = pst.executeQuery();
        rst.absolute(1);

        User user = new User();
        user.Firstname = rst.getString("firstname");
        user.Lastname = rst.getString("lastname");
        user.Email = rst.getString("email");
        user.Mobile = rst.getString("mobile");
        user.City = rst.getString("city");
        user.Location = rst.getString("location");
        user.State = rst.getString("state");
        user.Type = rst.getInt("type");

        return user;
    }
}