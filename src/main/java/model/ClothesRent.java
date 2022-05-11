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
public class ClothesRent implements Serializable{
    private int id;
    private Clothes clothes;
    private BorrowCard borrowCard;
    private int number, idClothes, idBorrowCard;
    private float total;
    
    public ClothesRent() {
        super();
    }

    public ClothesRent( Clothes clothes,BorrowCard borrowCard, int number, float total) {
        super();
        this.clothes = clothes;
        this.borrowCard = borrowCard;
        this.number = number;
        this.total = total;
    }
    public void calcTotal(Clothes clothes, int number){
        this.total =(float) clothes.getRentcost() * number;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClothes() {
        return idClothes;
    }

    public void setIdClothes(int idClothes) {
        this.idClothes = idClothes;
    }

    public int getIdBorrowCard() {
        return idBorrowCard;
    }

    public void setIdBorrowCard(int idBorrowCard) {
        this.idBorrowCard = idBorrowCard;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public BorrowCard getBorrowCard() {
        return borrowCard;
    }

    public void setBorrowCard(BorrowCard borrowCard) {
        this.borrowCard = borrowCard;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
