/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.Entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "warranty")
    private String warranty;
    
    @Column(name = "material")
    private String material;
    
    @Column(name = "reference")
    private String reference;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "color_finish")
    private String colorFinish;
    
    @Column(name = "fits")
    private String fits;
    
    @Column(name = "design")
    private String design;
    
    @Column(name = "notes")
    private String notes;
    
    @Column(name = "position")
    private String position;
    
    @Column(name = "quantity")
    private long quantity;
    
    @Column(name = "buyPrice")
    private float buyPrice;
    
    @Column(name = "sellPrice")
    private float sellPrice;
    
    @Column(name = "tva")
    private float tva;

    @Column(name="isEngine")
    private Boolean isEngine;
    
    @OneToOne
    private Image image;
    
    @ManyToMany
    private List<Engine> engines;
    
    @ManyToMany
    private List<Submodel> submodels;
    
    @OneToMany
    private List<LineMovement> lineMovements;
    
    @OneToMany
    private List<LineInventory> lineInventories;

    public Part(String name, String description, String warranty, String material, String reference, String type, String colorFinish, String fits, String design, String notes, String position, long quantity, float buyPrice, float sellPrice, float tva, Boolean isEngine, Image image, List<Engine> engines, List<Submodel> submodels, List<LineMovement> lineMovements, List<LineInventory> lineInventories) {
        this.name = name;
        this.description = description;
        this.warranty = warranty;
        this.material = material;
        this.reference = reference;
        this.type = type;
        this.colorFinish = colorFinish;
        this.fits = fits;
        this.design = design;
        this.notes = notes;
        this.position = position;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.tva = tva;
        this.isEngine = isEngine;
        this.image = image;
        this.engines = engines;
        this.submodels = submodels;
        this.lineMovements = lineMovements;
        this.lineInventories = lineInventories;
    }

    public Part() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColorFinish() {
        return colorFinish;
    }

    public void setColorFinish(String colorFinish) {
        this.colorFinish = colorFinish;
    }

    public String getFits() {
        return fits;
    }

    public void setFits(String fits) {
        this.fits = fits;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

   
    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }

    public List<Submodel> getSubmodels() {
        return submodels;
    }

    public void setSubmodels(List<Submodel> submodels) {
        this.submodels = submodels;
    }

    public List<LineMovement> getLineMovements() {
        return lineMovements;
    }

    public void setLineMovements(List<LineMovement> lineMovements) {
        this.lineMovements = lineMovements;
    }

    public List<LineInventory> getLineInventories() {
        return lineInventories;
    }

    public void setLineInventories(List<LineInventory> lineInventories) {
        this.lineInventories = lineInventories;
    }


    public Boolean getisEngine() {
        return isEngine;
    }

    public void setisEngine(Boolean isengine) {
        isEngine = isengine;
    }
}
