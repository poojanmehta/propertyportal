package mypack;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

public class propertyController extends HttpServlet {
    private static final String USER = "/user";
    private static final String USERREG = "/userregister";
    private static final String USERLOG = "/userlogin";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String path = request.getServletPath();

        switch (path) {
            case ADDPROP:
                try {
                    propertybean pb = new propertybean();
                    int result = pb.addproperty(request, response);
                    if(result == 0) {
                        System.out.println("FAILURE");
                    } else {
                        System.out.println("SUCCESS");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            break;
            case DELPROP:
                try {
                    propertybean pb = new propertybean();
                    int result = pb.deleteproperty(request, response);
                    if(result == 0) {
                        System.out.println("FAILURE");
                    } else {
                        System.out.println("SUCCESS");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            break;
            case VIEWPROP:
                try {
                    propertybean pb = new propertybean();
                    int result = pb.addproperty(request, response);
                    if(result == 0) {
                        System.out.println("FAILURE");
                    } else {
                        System.out.println("SUCCESS");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            break;
            case LISTPROP:
                try {
                    propertybean pb = new propertybean();
                    int result = pb.addproperty(request, response);
                    if(result == 0) {
                        System.out.println("FAILURE");
                    } else {
                        System.out.println("SUCCESS");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            break;
               case UPDATEPROP:
                try {
                    propertybean pb = new propertybean();
                    int result = pb.addproperty(request, response);
                    if(result == 0) {
                        System.out.println("FAILURE");
                    } else {
                        System.out.println("SUCCESS");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            break;
        }

      
}