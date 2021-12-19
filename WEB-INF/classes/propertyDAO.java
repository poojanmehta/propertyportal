package mypack;

import java.sql.*;

public class propertyDAO {
    Connection con;

    propertyDAO() {
        Connector connector = new Connector();
        try {
            System.out.println("connection establihed");
            this.con = connector.createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int addproperty(String query, property pr) throws SQLException {

        PreparedStatement pst = pr.con.prepareStatement(query);
        pst.setString(1, pr.id);
        pst.setString(2, pr.name);
        pst.setString(3, pr.Email);
        pst.setString(4, pr.area);
        pst.setString(5, pr.price);
        pst.setString(6, pr.floor);
        pst.setString(7, pr.bedrooms);
        pst.setString(8, pr.bathrooms);
        pst.setString(9, pr.fk_owner_id);
        pst.setString(10, pr.city);
        pst.setString(11, pr.locality);
        pst.setString(12, pr.sell_type);
        pst.setString(13, pr.available_days);
        int result = pst.executeUpdate();
        return result;
    }

    public int viewproperty(String query, int id) throws SQLException {

        PreparedStatement pst = this.con.prepareStatement(query);
        //condition
        int result = pst.executeUpdate();
        return result;
    }

    public int deleteproperty(String query, int id) throws SQLException {

        PreparedStatement pst = this.con.prepareStatement(query);
       
        int result = pst.executeUpdate();
        return result;
    }

}