package mypack;

import java.io.*;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

public class userBean {

    /* All fields used in User class */
    String Firstname, Lastname, Email, Mobile, City, Location, State, Password;
    int Type;

    /* Setter method for Name */
    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    /* Getter method for Name */
    public String getFirstname() {
        return this.Firstname;
    }
    
     /* Setter method for Name */
     public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    /* Getter method for Name */
    public String getLastname() {
        return this.Lastname;
    }

    /* Setter method for Email */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /* Getter method for  */
    public String getEmail() {
        return this.Email;
    }
    
    /* Setter method for  Mobile */
    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    /* Getter method for Mobile */
    public String getMobile() {
        return this.Mobile;
    }
    /* Setter method for City */
    public void setCity(String City) {
        this.City = City;
    }

    /* Getter method for City */
    public String getCity() {
        return this.City;
    }
    /* Setter method for Location */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    /* Getter method for Location */
    public String getLocation() {
        return this.Location;
    }

    /* Setter method for State */
    public void setState(String State) {
        this.State = State;
    }

    /* Getter method for State */
    public String getState() {
        return this.State;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public int getType() {
        return this.Type;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return this.Password;
    }
    
    public int registerUser(HttpServletRequest request, HttpServletResponse response) {
        setFirstname(request.getParameter("Firstname"));
        setLastname(request.getParameter("Lastname"));
        setEmail(request.getParameter("Email"));
        setPassword(request.getParameter("Password"));
        setMobile(request.getParameter("Mobile"));
        setCity(request.getParameter("City"));

        String query = "INSERT INTO users(firstname, lastname, email, password, mobile, city) VALUES (?,?,?,?,?,?)";

        int result = 0;
        try {
            userDAO ud = new userDAO();
            result = ud.registerUser(query, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet loginUser(HttpServletRequest request, HttpServletResponse response) {
        setEmail(request.getParameter("Email"));
        setPassword(request.getParameter("Password"));

        String query = "SELECT * FROM users where email = '" + request.getParameter("Email") + "' AND password = " + request.getParameter("Password");

        ResultSet result = null;
        try {
            userDAO ud = new userDAO();
            result = ud.loginUser(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getUserDetails(int user_id) {
        String query = "SELECT * FROM users WHERE id = " + user_id;
        
        ResultSet result = null;
        try {
            userDAO ud = new userDAO();
            result = ud.getUserDetails(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}