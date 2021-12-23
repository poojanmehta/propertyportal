package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;

public class userController extends HttpServlet {
    private static final String USER = "/user";
    private static final String USERREG = "/userregister";
    private static final String USERLOG = "/userlogin";

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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {
            case USERLOG:
                try {
                    userBean ub = new userBean();
                    ResultSet result = ub.loginUser(request, response);
                    if (result.next()) {
                        HttpSession session = request.getSession(false);
                        if (session != null) {
                            session.setAttribute("id", result.getString("id"));
                            session.setAttribute("email", result.getString("Email"));
                            request.setAttribute("login_message", "Login Successful");
                            RequestDispatcher rd = request.getRequestDispatcher("user");
                            rd.forward(request, response);
                        }
                    } else {
                        request.setAttribute("login_message", "Invalid Cradentials");
                        RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
                        rd.forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case USERREG:
                try {
                    userBean ub = new userBean();
                    int result = ub.registerUser(request, response);
                    if (result == 0) {
                        System.out.println("Failure");
                    } else {
                        System.out.println("SUCCESS");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

        // try {
        // userDAO ud = new userDAO();
        // User user = ud.getAllUsers();
        // request.setAttribute("user",user);
        // }
        // catch (Exception e) {
        // e.printStackTrace();
        // }
        // RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
        // rd.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case USER:
                try {
                    int user_id = checkLogin(request);
                    System.out.println(user_id);
                    if (user_id > 0) {
                        propertybean pb = new propertybean();
                        ArrayList<property> property_result = pb.listuserproperty(user_id);
                        request.setAttribute("property_data", property_result);
                        userBean ub = new userBean();
                        ResultSet result = ub.getUserDetails(user_id);
                        request.setAttribute("user_data", result);
                        RequestDispatcher rd = request.getRequestDispatcher("userprofile.jsp");
                        rd.forward(request, response);
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
                        rd.forward(request, response);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
    }
}