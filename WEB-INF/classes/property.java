package mypack;

import java.io.*;

public class property {
    public String name,city,address,locality;
    public int id,floor,bedrooms,bathrooms,fk_owner_id,sell_type,available_days;
    public float area,price;
   
   
    property() {
    }

    property (String name, String address, String city, String locality,
            float area,float price,
            int id,int floor,int bedrooms,int bathrooms,int fk_owner_id,int sell_type,int available_days) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.locality = locality;
        this.area = area;
        this.price = price;
        this.id = id;
        this.floor = floor;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.fk_owner_id = fk_owner_id;
        this.sell_type = sell_type;
        this.available_days = available_days;

    }
}
