package mypack;

import java.io.*;

public class userBean {

    /* All fields used in User class */
    String Firstname, Lastname, Email, Mobile, City, Location, State;
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

}