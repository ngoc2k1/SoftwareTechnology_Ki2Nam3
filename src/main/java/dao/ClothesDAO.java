/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Clothes;

/**
 *
 * @author THAIHB.B19CN638
 */
public class ClothesDAO extends DAO{
    public ClothesDAO(){
        super();
    }
    public ArrayList<Clothes> searchClothes(String key){
        ArrayList<Clothes> result = new ArrayList<>();
        String sql = "SELECT * FROM tblClothes WHERE name LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Clothes cl = new Clothes();
                cl.setId(rs.getInt("id"));
                cl.setIdclo(rs.getString("idclo")); 
                cl.setName(rs.getString("name"));
                cl.setTrademark(rs.getString("trademark")); 
                cl.setProducer(rs.getString("producer")); 
                cl.setNsx(rs.getDate("nsx"));
                cl.setCost(rs.getFloat("cost")); 
                cl.setRentcost(rs.getFloat("rentcost")); 
                
                result.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClothesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public Clothes getClothesById(int key){
		Clothes cl = null;
		String sql = "SELECT * FROM tblClothes WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				cl = new Clothes();
				cl.setId(rs.getInt("id"));
                                cl.setIdclo(rs.getString("idclo")); 
                                cl.setName(rs.getString("name"));
                                cl.setTrademark(rs.getString("trademark")); 
                                cl.setProducer(rs.getString("producer")); 
                                cl.setNsx(rs.getDate("nsx"));
                                cl.setCost(rs.getFloat("cost")); 
                                cl.setRentcost(rs.getFloat("rentcost")); 
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return cl;
	}
}
