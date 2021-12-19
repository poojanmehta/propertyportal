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

        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setString(2, pr.name);
        pst.setFloat(4, pr.area);
        pst.setFloat(5, pr.price);
        pst.setInt(6, pr.floor);
        pst.setInt(7, pr.bedrooms);
        pst.setInt(8, pr.bathrooms);
        pst.setInt(9, pr.fk_owner_id);
        pst.setString(10, pr.city);
        pst.setString(11, pr.locality);
        pst.setString(12, pr.sell_type);
        pst.setInt(13, pr.available_days);
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
        
        for(property item:properties) {
            System.out.println(item.name);
        }

        return properties;
    }

    public int updateproperty(String query) {
        return 0;
    }
}