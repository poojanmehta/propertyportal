package mypack;

import java.sql.*;

public class userDAO {
    Connection con;

    userDAO() {
        Connector connector = new Connector();
        try {
            System.out.println("connection establihed");
            this.con = connector.createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getAllUsers() throws SQLException {

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

    public int registerUser(String query, userBean ub) throws SQLException {

        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setString(1, ub.getFirstname());
        pst.setString(2, ub.getLastname());
        pst.setString(3, ub.getEmail());
        pst.setString(4, ub.getPassword());
        pst.setString(5, ub.getMobile());
        pst.setString(6, ub.getCity());
        int result = pst.executeUpdate();
        return result;
    }

    public ResultSet loginUser(String query) throws SQLException {

        Statement st = this.con.createStatement();
        ResultSet result = st.executeQuery(query);
        
        return result;
    }
}