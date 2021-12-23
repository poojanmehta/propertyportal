package mypack;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        PreparedStatement pst = this.con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, pr.name);
        pst.setFloat(2, pr.area);
        pst.setFloat(3, pr.price);
        pst.setInt(4, pr.floor);
        pst.setInt(5, pr.bedrooms);
        pst.setInt(6, pr.bathrooms);
        pst.setString(7, pr.address);
        pst.setInt(8, pr.fk_owner_id);
        pst.setString(9, pr.city);
        pst.setString(10, pr.locality);
        pst.setString(11, pr.sell_type);
        pst.setInt(12, pr.available_days);
        int result = pst.executeUpdate();

        return result;

    }

    public int viewproperty(String query) throws SQLException {

        PreparedStatement pst = this.con.prepareStatement(query);
        //condition
        int result = pst.executeUpdate();
        return result;
    }

    public int deleteproperty(String query) throws SQLException {

        PreparedStatement pst = this.con.prepareStatement(query);
       
        int result = pst.executeUpdate();
        return result;
    }

    public ArrayList<property> listproperty (String query) throws SQLException{
        Statement st = this.con.createStatement();
        System.out.println(query);
        ResultSet rst = st.executeQuery(query);
        ArrayList<property> properties = new ArrayList<property>();

        while(rst.next()) {
            System.out.println(rst.getString("name"));
            property pr = new property();
            pr.name=rst.getString("name");
            pr.address=rst.getString("address");
            pr.city=rst.getString("city");
            pr.locality=rst.getString("locality");
            pr.area=rst.getFloat("area");
            pr.price=rst.getFloat("price");
            pr.id=rst.getInt("id");
            pr.floor=rst.getInt("floor");
            pr.bedrooms=rst.getInt("bedrooms");
            pr.bathrooms=rst.getInt("bathrooms");
            pr.fk_owner_id=rst.getInt("fk_owner_id");
            pr.sell_type=rst.getString("sell_type");
            pr.available_days=rst.getInt("available_days");

            properties.add(pr);
        }

        for(property p:properties){

            System.out.println(p.name);
        }

        return properties;
    }

    public int updateProperty(String query, property pr) throws SQLException {
        PreparedStatement pst = this.con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, pr.name);
        pst.setFloat(2, pr.area);
        pst.setFloat(3, pr.price);
        pst.setInt(4, pr.floor);
        pst.setInt(5, pr.bedrooms);
        pst.setInt(6, pr.bathrooms);
        pst.setString(7, pr.address);
        pst.setInt(8, pr.fk_owner_id);
        pst.setString(9, pr.city);
        pst.setString(10, pr.locality);
        pst.setString(11, pr.sell_type);
        pst.setInt(12, pr.available_days);
        pst.setInt(13, pr.id);
        int result = pst.executeUpdate();

        return result;
    }

    public void addAmenities(String query) throws SQLException {
        PreparedStatement pst = this.con.prepareStatement(query);
        int i = pst.executeUpdate();
        System.out.println(i);
    }

    public ResultSet checkWatchList(String query) throws SQLException{
        ResultSet result;
        PreparedStatement pst = this.con.prepareStatement(query);
        result = pst.executeQuery();
        return result;
    }   

    public int addToWatchList(String query) throws SQLException {
        int result = 0;
        PreparedStatement pst = this.con.prepareStatement(query);
        result = pst.executeUpdate();
        return result;
    }

    public ResultSet getPropertyDetails(String query) throws SQLException {
        ResultSet result;
        Statement st = this.con.createStatement();
        result = st.executeQuery(query);
        return result;
    }
}