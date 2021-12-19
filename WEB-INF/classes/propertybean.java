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
        pr.sell_type=request.getParameter("sell_type");
        pr.address=request.getParameter("available_days");

        System.out.println(pr.sell_type);

        pr.fk_owner_id = Integer.parseInt((String)request.getSession(false).getAttribute("id"));

        System.out.println((String)request.getSession(false).getAttribute("id"));

        String query = "INSERT INTO property(name,area, price, floor, bedrooms,bathrooms,address,fk_owner_id,city,locality,sell_type,available_days) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

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
        boolean search_query = false;
        String query ="SELECT * FROM property";

        String searchkey = request.getParameter("searchkey");
        if(searchkey != null && searchkey.length() > 0) {
            query += " WHERE name LIKE '%" + searchkey + "%'";
            search_query = true;
        }

        float minimumprice = 0;
        float maximumprice = 0;
        String min_price_string = request.getParameter("minimumprice");
        String max_price_string = request.getParameter("maximumprice");

        if(min_price_string != null && min_price_string.length() > 0) {
            minimumprice = Float.parseFloat(min_price_string);
        }

        if(max_price_string != null && max_price_string.length() > 0) {
            maximumprice = Float.parseFloat(max_price_string);
        }

        System.out.println(min_price_string);
        System.out.println(max_price_string);
        System.out.println(minimumprice);
        System.out.println(maximumprice);

        if((minimumprice > 0) && (maximumprice > 0)) {
            if(search_query) {
                query += " AND price BETWEEN " + minimumprice + " AND " + maximumprice;
            } else {
                query += " WHERE price BETWEEN " + minimumprice + " AND " + maximumprice;
            }
            search_query = true;
        } else if(minimumprice > 0) {
            if(search_query) {
                query += " AND price >= " + minimumprice;
            } else {
                query += " WHERE price >= " + minimumprice;
            }
            search_query = true;
        } else if(maximumprice > 0) {
            if(search_query) {
                query += " AND price <= " + maximumprice;
            } else {
                query += " WHERE price <= " + maximumprice;
            }
            search_query = true;
        }
 
        ArrayList<property> result = new ArrayList<property>();
        try {
            propertyDAO pd = new propertyDAO();
            result = pd.listproperty(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addAmenities(HttpServletRequest request,HttpServletResponse response) {
        int property_id = Integer.parseInt((String)request.getAttribute("property_id"));
        String amenities[] = request.getParameterValues("amenities"); 
        String query = "";
        if (amenities != null && amenities.length != 0) {
            query = "INSERT INTO property_amenities VALUES ";
            for (int i = 0; i < amenities.length; i++) {
                query += "(" + property_id + ",'" + amenities[i] + "'),";
            }
        }
        try {
            propertyDAO pd = new propertyDAO();
            pd.addAmenities(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   