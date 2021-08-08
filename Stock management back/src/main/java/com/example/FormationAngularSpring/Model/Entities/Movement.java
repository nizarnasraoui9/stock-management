package com.example.FormationAngularSpring.Model.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movement")

public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="type")
    private String type;
    
    @Column(name = "reason")
    private String reason;

    @Column(name="date")
    private Date date;

    @OneToMany
    private List<LineMovement> lineMovements;

    public Movement() {
    }

    public Movement(String type, Date date, List<LineMovement> lineMovementList) {
        this.type = type;
        this.date = date;
        this.lineMovements = lineMovementList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<LineMovement> getLineMovements() {
        return lineMovements;
    }

    public void setLineMovements(List<LineMovement> lineMovements) {
        this.lineMovements = lineMovements;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    

    
}
