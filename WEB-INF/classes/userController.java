package mypack;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import mypack.*;

public class userController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDAO ud = new userDAO();
        
        try {
        // User user = ud.getAllUsers();
        String user = ud.getAllUsers();
        request.setAttribute("user",user); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
        rd.forward(request, response);
    }
}