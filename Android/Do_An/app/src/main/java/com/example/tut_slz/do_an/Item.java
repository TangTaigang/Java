package com.example.tut_slz.do_an;
import java.util.Date;
/**
 * Created by tut_slz on 11/4/14.
 */
public class Item {
    private int id;
    private String name;
    private String restaurant_name;
    private Date createDate;
    private Date updateDate;
    private Double price;
    private int status;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Double getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }


}
