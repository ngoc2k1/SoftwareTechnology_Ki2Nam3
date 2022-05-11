/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author THAIHB.B19CN638
 */
public class BorrowCard implements Serializable{
    private int id;
    private Date dayrent, daypay;
    private float totalcost, deposit;
    private ArrayList<ClothesRent> listCR = new ArrayList<>();
    private Customer customer;
    private User user;

    
    public BorrowCard() {
        super();
    }
public BorrowCard(Date dayrent, Date daypay, float totalcost, float deposit, ArrayList<ClothesRent> listCR, Customer customer, User user) {
        super();
        this.dayrent = dayrent;
        this.daypay = daypay;
        this.totalcost = totalcost;
        this.deposit = deposit;
        this.listCR = listCR;
        this.customer = customer;
        this.user = user;
    }


    public void calcTotalcost(Date dayrent, Date daypay,ArrayList<ClothesRent> listCR){
        
        int daysdiff = 0;
        long diff = daypay.getTime() - dayrent.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
        daysdiff = (int) diffDays;
      
       float rentCR = 0;
       for(ClothesRent cr: listCR){
           rentCR += cr.getTotal();
       }
       this.totalcost =(float) rentCR * daysdiff;
    }
    public void calcDeposit(ArrayList<ClothesRent> listCR) {
       float costCR = 0;
       for(ClothesRent cr: listCR){
           costCR += cr.getClothes().getCost() * cr.getNumber();
       }
       this.deposit =(float) costCR;
    }
    
    public void addClothesRent(ClothesRent cr) {
        listCR.add(cr);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDayrent() {
        return dayrent;
    }

    public void setDayrent(Date dayrent) {
        this.dayrent = dayrent;
    }

    public Date getDaypay() {
        return daypay;
    }

    public void setDaypay(Date daypay) {
        this.daypay = daypay;
    }

    public float getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(float totalcost) {
        this.totalcost = totalcost;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public ArrayList<ClothesRent> getListCR() {
        return listCR;
    }

    public void setListCR(ArrayList<ClothesRent> listCR) {
        this.listCR = listCR;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
