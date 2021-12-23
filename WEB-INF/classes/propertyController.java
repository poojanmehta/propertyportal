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
import java.sql.ResultSet;

public class propertyController extends HttpServlet {

  private static final String VIEWPROP = "/viewproperty";
  private static final String LISTPROP = "/listproperty";
  private static final String UPDATEPROP = "/updateproperty";
  private static final String ADDPROP = "/addproperty";
  private static final String DELPROP = "/deleteproperty";
  private static final String AMEPROP = "/addamenities";
  private static final String ADDWCH = "/addtowatchlist";
  private static final String USERPROP = "/userproperties";
  private static final String EDITPROP = "/editproperty";
  private static final String ALLPROP = "/allproperties";

  public int checkLogin(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null) {
      if ((String) session.getAttribute("id") != null) {
        int id = Integer.parseInt((String) session.getAttribute("id"));
        if (id > 0) {
          return id;
        } else {
          return 0;
        }
      }
      return 0;
    } else {
      return 0;
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = request.getServletPath();

    switch (path) {
      case ALLPROP:
        try {
          propertybean pb = new propertybean();
          ArrayList<property> result = pb.allproperties(request, response);

          request.setAttribute("property_data", result);
          RequestDispatcher rd = request.getRequestDispatcher("property.jsp");
          rd.forward(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case ADDPROP:
        try {
          propertybean pb = new propertybean();
          int result = pb.addproperty(request, response);
          if (result == 0) {
            System.out.println("FAILURE");
          } else {
            RequestDispatcher rd = request.getRequestDispatcher(
                "addamenities.jsp");
            rd.forward(request, response);
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
          request.setAttribute("property_data", result);
          RequestDispatcher rd = request.getRequestDispatcher("property.jsp");
          rd.forward(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case AMEPROP:
        try {
          propertybean pb = new propertybean();
          pb.addAmenities(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      // case ADDWCH:
      // try {
      // HttpSession session = request.getSession(false);
      // if (session != null) {
      // propertybean pb = new propertybean();
      // int user_id = Integer.parseInt((String) session.getAttribute("id"));
      // int property_id = Integer.parseInt(request.getParameter("id"));
      // int result = 0;
      // result = pb.addToWatchList(property_id, user_id);
      // if (result == 1) {
      // request.setAttribute("watchlist_message", "Added to watchlist");
      // } else {
      // request.setAttribute("watchlist_message", "Error Occured");
      // }
      // RequestDispatcher rd = request.getRequestDispatcher("property.jsp");
      // rd.forward(request, response);
      // } else {
      // RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
      // rd.forward(request, response);
      // }
      // } catch (Exception e) {
      // e.printStackTrace();
      // }
      // break;
      case USERPROP:
        try {
          int login_id = checkLogin(request);
          if (login_id > 0) {
            propertybean pb = new propertybean();
            ArrayList<property> result = pb.listuserproperty(login_id);
            if (result != null) {
              request.setAttribute("property_data", result);
              RequestDispatcher rd = request.getRequestDispatcher("property.jsp");
              rd.forward(request, response);
            }
          } else {
            RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
            rd.forward(request, response);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case EDITPROP:
        try {
          int user_id = checkLogin(request);
          if (user_id > 0) {
            propertybean pb = new propertybean();
            int result = pb.updateProperty(request, response);
            RequestDispatcher rd = request.getRequestDispatcher("property.jsp");
            rd.forward(request, response);
          } else {
            RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
            rd.forward(request, response);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
    }
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();

    switch (path) {

      case ADDWCH:
        try {
          HttpSession session = request.getSession(false);
          if (session != null) {
            propertybean pb = new propertybean();
            int user_id = Integer.parseInt((String) session.getAttribute("id"));
            int property_id = Integer.parseInt(request.getParameter("id"));
            int result = 0;
            result = pb.addToWatchList(property_id, user_id);
            if (result == 1) {
              request.setAttribute("watchlist_message", "Added to watchlist");
            } else {
              request.setAttribute("watchlist_message", "Error Occured");
            }
            RequestDispatcher rd = request.getRequestDispatcher("allproperties");
            rd.forward(request, response);
          } else {
            RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
            rd.forward(request, response);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case DELPROP:
        try {
          propertybean pb = new propertybean();
          int property_id = Integer.parseInt(request.getParameter("id"));
          int result = 0;
          result = pb.deleteproperty(property_id);
          RequestDispatcher rd = request.getRequestDispatcher("user");
          rd.forward(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case UPDATEPROP:
        try {
          propertybean pb = new propertybean();
          int property_id = Integer.parseInt(request.getParameter("id"));
          ResultSet result = null;
          result = pb.getPropertyDetails(property_id);
          request.setAttribute("property_data", result);
          RequestDispatcher rd = request.getRequestDispatcher("editproperty.jsp");
          rd.forward(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
    }
  }

}
