package com.nighthawk.spring_portfolio.mvc.restaurants;

import javax.persistence.*;

@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String restr;

    private int delicious;
    private int inedible;

    public Restaurants(){
        this.id = (long)1;
        this.restr = "In-N-Out";
        this.delicious = 0;
        this.inedible = 0;
    }

    public Restaurants(Long id, String restr, int delicious, int inedible){
        this.id = id;
        this.restr = restr;
        this.delicious = delicious;
        this.inedible = inedible;
    }

    public Long getId(){
        return id;
    }

    public String getRestr(){
        return restr;
    }

    public int getDelicious(){
        return delicious;
    }

    public int getInedible(){
        return inedible;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setRestr(String restr){
        this.restr = restr;
    }

    public void setDelicious(int delicious){
        this.delicious = delicious;
    }

    public void setInedible(int inedible){
        this.inedible = inedible;
    }
}
