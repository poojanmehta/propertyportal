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

        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setString(1, pr.id);
        pst.setString(2, pb.getname());
        pst.setString(3, pb.getEmail());
        pst.setString(4, pb.getarea());
        pst.setString(5, pb.getprice());
        pst.setString(6, pb.getfloor());
        pst.setString(7, pb.getbedrooms());
        pst.setString(8, pb.getbathrooms());
        pst.setString(9, pb.getfk_owner_id());
        pst.setString(10, pb.getcity());
        pst.setString(11, pb.getlocality());
        pst.setString(12, pb.getsell_type());
        pst.setString(13, pb.getavailable_days());
        int result = pst.executeUpdate();
        return result;
    }

    public int viewproperty(String query, propertybean pb) throws SQLException {

        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setString(1, pb.getid());
        pst.setString(2, pb.getname());
        pst.setString(3, pb.getEmail());
        pst.setString(4, pb.getarea());
        pst.setString(5, pb.getprice());
        pst.setString(6, pb.getfloor());
        pst.setString(7, pb.getbedrooms());
        pst.setString(8, pb.getbathrooms());
        pst.setString(9, pb.getfk_owner_id());
        pst.setString(10, pb.getcity());
        pst.setString(11, pb.getlocality());
        pst.setString(12, pb.getsell_type());
        pst.setString(13, pb.getavailable_days());
        ResultSet result = pst.executeUpdate();
        return result;
    }

    public int deleteproperty(String query, propertybean pb) throws SQLException {

        PreparedStatement pst = this.con.prepareStatement(query);
        
        int result = pst.executeUpdate();
        return result;
    }

    public ResultSet listproperty (String query) {
        Statement st = this.con.createStatement();

        ResultSet result = st.executeQuery(query);

        return result;
    }
}