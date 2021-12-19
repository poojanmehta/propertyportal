package mypack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

public class propertybean
{
    public String name,city,address,locality;
    public int id,floor,bedrooms,bathrooms,fk_owner_id,sell_type,available_days;
    public float area,price;



    public int addproperty(HttpServletRequest request,HttpServletResponse response)
    {
        property pr =new property();
        pr.name=request.getParameter("name");
        pr.address=request.getParameter("address");
        pr.city=request.getParameter("city");
        pr.locality=request.getParameter("locality");
        pr.area=Float.parseFloat(request.getParameter("area"));
        pr.price=Float.parseFloat(request.getParameter("price"));
        pr.floor=Integer.parseInt(request.getParameter("floor"));
        pr.bedrooms=Integer.parseInt(request.getParameter("bedrooms"));
        pr.bathrooms=Integer.parseInt(request.getParameter("bathrooms"));
        pr.fk_owner_id=Integer.parseInt(request.getParameter("fk_owner_id"));
        pr.sell_type=request.getParameter("sell_type");
        pr.address=request.getParameter("available_days");

        String query = "INSERT INTO property(id,name,area, price, floor, bedrooms,bathrooms,address,fk_owner_id,city,locality,sell_type,available_days) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        int result = 0;
        try {
            propertyDAO pd = new propertyDAO();
            result = pd.addproperty(query, pr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public int updateproperty(HttpServletRequest request,HttpServletResponse response)
    {
        property pr =new property();
        String query = "";
        int result = 0;
        try {
            propertyDAO pd = new propertyDAO();
            result = pd.updateproperty(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public int deleteproperty(HttpServletRequest request,HttpServletResponse response)
    {
        property pr =new property();

        String query ="DELETE * FROM property";
        int result = 0;
        try {
            propertyDAO pd = new propertyDAO();
            result = pd.deleteproperty(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int viewproperty(HttpServletRequest request,HttpServletResponse response)
    {   
        property pr =new property();
        String query ="SELECT * FROM property where id="+request.getParameter("id");
        int result = 0;
        try {
            propertyDAO pd = new propertyDAO();
            result = pd.viewproperty(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    
    }

    public ArrayList<property> listproperty(HttpServletRequest request,HttpServletResponse response)
    {   
        String query ="SELECT * FROM property";
        ArrayList<property> result = new ArrayList<property>();
        try {
            propertyDAO pd = new propertyDAO();
            result = pd.listproperty(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}   