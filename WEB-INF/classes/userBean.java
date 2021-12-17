package mypack;

import java.io.*;

public class User {
    User (String Firstname, String Lastname, String Email, String Mobile, String City, String Location, String State, int type) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Email = Email;
        this.Mobile = Mobile;
        this.City = City;
        this.Location = Location;
        this.State = State;
        this.type = type;
    }
    String Firstname, Lastname, Email, Mobile, City, Location, State;
    int type;
}

public class userBean {

    /* All fields used in User class */
    String Firstname, Lastname, Email, Mobile, City, Location, State;
    int type;

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
}