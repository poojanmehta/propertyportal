package mypack;

import java.io.*;

public class User {
    public String Firstname, Lastname, Email, Mobile, City, Location, State;
    public int Type;

    User() {

    }

    User (String Firstname, String Lastname, String Email, String Mobile, String City, String Location, String State, int Type) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Email = Email;
        this.Mobile = Mobile;
        this.City = City;
        this.Location = Location;
        this.State = State;
        this.Type = Type;
    }
}
