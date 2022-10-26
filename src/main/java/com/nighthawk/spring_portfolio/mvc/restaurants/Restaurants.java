package com.nighthawk.spring_portfolio.mvc.restaurants;

import javax.persistence.*;

@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String restr;

    private int five;
    private int one;

    public Restaurants(){
        this.id = (long)1;
        this.restr = "In-N-Out";
        this.five = 0;
        this.one = 0;
    }

    public Restaurants(Long id, String restr, int five, int one){
        this.id = id;
        this.restr = restr;
        this.five = five;
        this.one = one;
    }

    public Long getId(){
        return id;
    }

    public String getRestr(){
        return restr;
    }

    public int getFive(){
        return five;
    }

    public int getOne(){
        return one;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setRestr(String restr){
        this.restr = restr;
    }

    public void setFive(int five){
        this.five = five;
    }

    public void setOne(int one){
        this.one = one;
    }
}
