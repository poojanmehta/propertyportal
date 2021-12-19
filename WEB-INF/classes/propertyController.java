package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class propertyController extends HttpServlet {

  private static final String VIEWPROP = "/viewproperty";
  private static final String LISTPROP = "/listproperty";
  private static final String UPDATEPROP = "/updateproperty";
  private static final String ADDPROP = "/addproperty";
  private static final String DELPROP = "/delproperty";
  private static final String AMEPROP = "/addamenities";

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    String path = request.getServletPath();

    switch (path) {
      case ADDPROP:
        try {
          propertybean pb = new propertybean();
          int result = pb.addproperty(request, response);
          if (result == 0) {
            System.out.println("FAILURE");
          } else {
            RequestDispatcher rd = request.getRequestDispatcher(
              "addamenities.jsp"
            );
            rd.forward(request, response);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case DELPROP:
        try {
          propertybean pb = new propertybean();
          int result = pb.deleteproperty(request, response);
          if (result == 0) {
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
          if (result == 0) {
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
          ArrayList<property> result = pb.listproperty(request, response);
          if (result != null) {
            request.setAttribute("property_data", result);
            RequestDispatcher rd = request.getRequestDispatcher("property.jsp");
            rd.forward(request, response);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case UPDATEPROP:
        try {
          propertybean pb = new propertybean();
          int result = pb.addproperty(request, response);
          if (result == 0) {
            System.out.println("FAILURE");
          } else {
            System.out.println("SUCCESS");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case AMEPROP:
        try {
            HttpSession session = request.getSession(false);
            if(session.getAttribute("id") == null) {
                RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
                rd.forward(request, response);
            } else {
                propertybean pb = new propertybean();
                pb.addAmenities(request, response);
                RequestDispatcher rd = request.getRequestDispatcher("userprofile.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  }
}
