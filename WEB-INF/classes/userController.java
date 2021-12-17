package mypack;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

public class userController extends HttpServlet {
    private static final String USER = "user";
    private static final String USERREG = "userregister";
    private static final String USERLOG = "userlogin";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
        userDAO ud = new userDAO();
        User user = ud.getAllUsers();
        request.setAttribute("user",user); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
        rd.forward(request, response);
    }
}