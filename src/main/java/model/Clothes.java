/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author THAIHB.B19CN638
 */
public class Clothes implements Serializable{
    private int id;
    private String idclo, name, trademark, producer;
    private Date nsx;
    private float cost, rentcost;
    
    public Clothes() {
        super();
    }

    public Clothes(String idclo, String name, String trademark, String producer, Date nsx, float cost, float rentcost) {
        super();
        this.idclo = idclo;
        this.name = name;
        this.trademark = trademark;
        this.producer = producer;
        this.nsx = nsx;
        this.cost = cost;
        this.rentcost = rentcost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdclo() {
        return idclo;
    }

    public void setIdclo(String idclo) {
        this.idclo = idclo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getNsx() {
        return nsx;
    }

    public void setNsx(Date nsx) {
        this.nsx = nsx;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getRentcost() {
        return rentcost;
    }

    public void setRentcost(float rentcost) {
        this.rentcost = rentcost;
    }
    
}
