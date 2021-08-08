package com.example.FormationAngularSpring.Model.Entities;


import javax.persistence.*;

@Entity
@Table(name = "line_inventory")

public class LineInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="quantity")
    private long quantity;


    public LineInventory(long quantity, Part part, Inventory inventary) {
        this.quantity = quantity;
    }

    public LineInventory() {
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

    
}
