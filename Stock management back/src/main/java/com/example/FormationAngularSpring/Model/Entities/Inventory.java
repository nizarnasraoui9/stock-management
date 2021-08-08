package com.example.FormationAngularSpring.Model.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date")
    private Date date;

    @OneToMany
    private List<LineInventory> lineInventories;

    public Inventory() {
    }

    public Inventory(Date date, List<LineInventory> lineInventoryList) {
        this.date = date;
        this.lineInventories = lineInventoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<LineInventory> getLineInventories() {
        return lineInventories;
    }

    public void setLineInventories(List<LineInventory> lineInventories) {
        this.lineInventories = lineInventories;
    }
    
    
}
