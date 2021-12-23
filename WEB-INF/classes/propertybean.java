package mypack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.Part;

public class propertybean {
    public String name, city, address, locality;
    public int id, floor, bedrooms, bathrooms, fk_owner_id, sell_type, available_days;
    public float area, price;

    public int addproperty(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // String file_name = null;
        // String file_name2="";

        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        // boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        // if (!isMultipartContent) {
        //     System.out.println("isMultipartContent");
        //     return 0;
        // }
        // FileItemFactory factory = new DiskFileItemFactory();
        // ServletFileUpload upload = new ServletFileUpload(factory);
        // try {
        //     List < FileItem > fields = upload.parseRequest(request);
        //     Iterator < FileItem > it = fields.iterator();
        //     if (!it.hasNext()) {
        //         System.out.println("isMultipartContent");
        //         return 0;
        //     }
            
        //     while (it.hasNext()) {
        //         FileItem fileItem = it.next();
        //         boolean isFormField = fileItem.isFormField();
        //         if (isFormField) {
        //             if (file_name == null) {
        //                 if (fileItem.getFieldName().equals("file_name")) {
        //                 	file_name = fileItem.getString();
        //                 }
        //             }
        //         } else {
        //             if (fileItem.getSize() > 0) {                    	
        //             	file_name2=fileItem.getName();
        //                 fileItem.write(new File("C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 8.5\\webapps\\uploaded_files\\" + file_name2));
        //              }
        //         }
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // } finally {
        //     out.println("<script type='text/javascript'>");
        //     out.println("window.location.href='index.jsp?filename="+file_name2+"'");
        //     out.println("</script>");
        //     out.close();
        // }

        property pr = new property();
        pr.name = request.getParameter("name");
        pr.address = request.getParameter("address");
        pr.city = request.getParameter("city");
        pr.locality = request.getParameter("locality");
        pr.area = Float.parseFloat(request.getParameter("area"));
        pr.price = Float.parseFloat(request.getParameter("price"));
        pr.floor = Integer.parseInt(request.getParameter("floor"));
        pr.bedrooms = Integer.parseInt(request.getParameter("bedrooms"));
        pr.bathrooms = Integer.parseInt(request.getParameter("bathrooms"));
        pr.sell_type = request.getParameter("sell_type");
        pr.address = request.getParameter("available_days");

        System.out.println(pr.sell_type);

        pr.fk_owner_id = Integer.parseInt((String) request.getSession(false).getAttribute("id"));

        System.out.println((String) request.getSession(false).getAttribute("id"));

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

    public int updateproperty(HttpServletRequest request, HttpServletResponse response) {
        property pr = new property();
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

    public int deleteproperty(int property_id) {
        String query = "DELETE FROM property WHERE id = " + property_id;
        int result = 0;
        try {
            propertyDAO pd = new propertyDAO();
            result = pd.deleteproperty(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int viewproperty(HttpServletRequest request, HttpServletResponse response) {
        property pr = new property();
        String query = "SELECT * FROM property where id=" + request.getParameter("id");
        int result = 0;
        try {
            propertyDAO pd = new propertyDAO();
            result = pd.viewproperty(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public ArrayList<property> listproperty(HttpServletRequest request, HttpServletResponse response) {
        boolean search_query = false;
        String query = "SELECT * FROM property";

        String searchkey = request.getParameter("searchkey");
        if (searchkey != null && searchkey.length() > 0) {
            query += " WHERE name LIKE '%" + searchkey + "%'";
            search_query = true;
        }

        float minimumprice = 0;
        float maximumprice = 0;
        String min_price_string = request.getParameter("minimumprice");
        String max_price_string = request.getParameter("maximumprice");

        if (min_price_string != null && min_price_string.length() > 0) {
            minimumprice = Float.parseFloat(min_price_string);
        }

        if (max_price_string != null && max_price_string.length() > 0) {
            maximumprice = Float.parseFloat(max_price_string);
        }

        System.out.println(min_price_string);
        System.out.println(max_price_string);
        System.out.println(minimumprice);
        System.out.println(maximumprice);

        if ((minimumprice > 0) && (maximumprice > 0)) {
            if (search_query) {
                query += " AND price BETWEEN " + minimumprice + " AND " + maximumprice;
            } else {
                query += " WHERE price BETWEEN " + minimumprice + " AND " + maximumprice;
            }
            search_query = true;
        } else if (minimumprice > 0) {
            if (search_query) {
                query += " AND price >= " + minimumprice;
            } else {
                query += " WHERE price >= " + minimumprice;
            }
            search_query = true;
        } else if (maximumprice > 0) {
            if (search_query) {
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

    public ArrayList<property> listuserproperty(int login_id) {
        String query = "SELECT * FROM users WHERE fk_owner_id = " + login_id;
        ArrayList<property> result = new ArrayList<property>();
        try {
            propertyDAO pd = new propertyDAO();
            result = pd.listproperty(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addAmenities(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        System.out.println("amenities");
        String property_id_query = "SELECT * FROM property ORDER BY id DESC LIMIT 1";
        propertyDAO pdo = new propertyDAO();
        Statement st = pdo.con.createStatement();
        ResultSet property_id_result = st.executeQuery(property_id_query);
        int property_id = 0;
        if (property_id_result.next()) {
            property_id = property_id_result.getInt("id");
        }
        System.out.println(property_id);
        String amenities[] = request.getParameterValues("amenities");
        String query = "";
        if (amenities != null && amenities.length != 0) {
            query = "INSERT INTO propertyamenities (property_id, amenity_id) VALUES ";
            for (int i = 0; i < amenities.length; i++) {
                query += "(" + property_id + "," + amenities[i] + "),";
            }
        }
        query = query.substring(0, query.length() - 1);
        System.out.println(query);
        try {
            propertyDAO pd = new propertyDAO();
            pd.addAmenities(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int addToWatchList(int property_id, int user_id) throws SQLException {
        String check_query = "SELECT COUNT(id) AS total_count FROM watchlist WHERE property_id = " + property_id
                + " AND user_id = " + user_id;
        propertyDAO pd = new propertyDAO();
        ResultSet check_result_set = pd.checkWatchList(check_query);

        int check_result = 0;
        if (check_result_set.next()) {
            check_result = check_result_set.getInt("total_count");
        }
        int result = 0;
        if (check_result > 0) {
            return 0;
        } else if (check_result == 0) {
            String query = "INSERT INTO watchlist (property_id, user_id) values (" + property_id + "," + user_id + ")";
            result = pd.addToWatchList(query);
            return result;
        }
        return result;
    }
}