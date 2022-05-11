/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author THAIHB.B19CN638
 */
public class Deposit implements Serializable{
    private int id;
    private Customer customer;
    private BorrowCard borrowCard;
    private float deposit;
    private String note;

    public Deposit(){
        super();
    }
    public Deposit(Customer customer, BorrowCard borrowCard, float deposit, String note) {
        super();
        this.customer = customer;
        this.borrowCard = borrowCard;
        this.deposit = deposit;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BorrowCard getBorrowCard() {
        return borrowCard;
    }

    public void setBorrowCard(BorrowCard borrowCard) {
        this.borrowCard = borrowCard;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
