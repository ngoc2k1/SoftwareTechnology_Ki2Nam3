/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BorrowCard;
import model.Clothes;
import model.ClothesRent;
import model.Deposit;

/**
 *
 * @author THAIHB.B19CN638
 */
public class BorrowCardDAO extends DAO{
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public BorrowCardDAO(){
        super();
    }
    
    public void addBorrowCard(BorrowCard bc){
        String sql = "INSERT INTO tblBorrowCard(id, dayrent, daypay, totalcost, deposit, idUser, idCustomer) values(?,?,?,?,?,?,?)";
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bc.getId());
            ps.setString(2, sdf.format(bc.getDayrent()));
            ps.setString(3, sdf.format(bc.getDaypay())); 
            ps.setFloat(4, bc.getTotalcost());    
            ps.setFloat(5, bc.getDeposit());
            ps.setInt(6, bc.getUser().getId());
            ps.setInt(7, bc.getCustomer().getId());
            
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                    bc.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    public void addClothesRent(ClothesRent clr){
        String sql = "INSERT INTO tblClothesRent(idClothes, idBorrowCard, number, total) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clr.getClothes().getId());
            ps.setInt(2, clr.getBorrowCard().getId());
            ps.setInt(3, clr.getNumber());
            ps.setFloat(4, clr.getTotal());
            
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                    clr.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }public ArrayList<ClothesRent> getClothesRentByIdBC(int key){
		ArrayList<ClothesRent> result = new ArrayList<>();
		String sql = "SELECT * FROM tblClothesRent WHERE idBorrowCard=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				ClothesRent clr = new ClothesRent();
				clr.setId(rs.getInt("id"));
                                clr.setIdClothes(rs.getInt("idClothes"));
                                Clothes clothes = new ClothesDAO().getClothesById(clr.getIdClothes());
                                clr.setClothes(clothes);
                                clr.setIdBorrowCard(rs.getInt("idBorrowCard"));
                                clr.setNumber(rs.getInt("number"));
                                clr.setTotal(rs.getFloat("total"));
                                
                                result.add(clr);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
    
    public void addDeposit(Deposit deposit){
        String sql = "INSERT INTO tblDeposit(idCustomer, idBorrowCard, deposit, note) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, deposit.getCustomer().getId());
            ps.setInt(2, deposit.getBorrowCard().getId());
            ps.setFloat(3, deposit.getDeposit());
            ps.setString(4, deposit.getNote());
            
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                    deposit.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getMaxCurrentId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM tblBorrowCard";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
//    public static void main(String[] args) {
//        BorrowCardDAO borrowCardDAO = new BorrowCardDAO();
//        int id = borrowCardDAO.getMaxCurrentId();
//        System.out.println("id: "+id);
//    }
}
