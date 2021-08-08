package com.example.FormationAngularSpring.Model.Entities;

import javax.persistence.*;

@Entity
@Table(name = "line_Movement")

public class LineMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="quantity")
    private long quantity;

    @Column(name="price")
    private long price;


    public LineMovement() {
    }

    public LineMovement(long quantity, long price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }



}
