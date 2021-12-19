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


public class userController extends HttpServlet {
    private static final String USER = "/user";
    private static final String USERREG = "/userregister";
    private static final String USERLOG = "/userlogin";
    private static final String CHECKLOG = "/checklogin";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String path = request.getServletPath();

        switch (path) {
            case USERREG:
                try {
                    userBean ub = new userBean();
                    int result = ub.registerUser(request, response);
                    if(result == 0) {
                        System.out.println("Failure");
                    } else {
                        System.out.println("SUCCESS");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            break;
            case USERLOG:
                try {
                    userBean ub = new userBean();
                    ResultSet result = ub.loginUser(request, response);
                    if(result.next()) {
                        HttpSession session = request.getSession(false);
                        if(session != null) {
                            session.setAttribute("id", result.getString("id"));
                            System.out.println(session.getAttribute("id"));
                            session.setAttribute("email", result.getString("Email"));
                            String email = (String) session.getAttribute("email");
                            System.out.println(email);
                            request.setAttribute("login_message", "Login Successful");
                            RequestDispatcher rd = request.getRequestDispatcher("userprofile.jsp");
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
        }

        // try {
        // userDAO ud = new userDAO();
        // User user = ud.getAllUsers();
        // request.setAttribute("user",user); 
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
        // RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
        // rd.forward(request, response);
    }
}