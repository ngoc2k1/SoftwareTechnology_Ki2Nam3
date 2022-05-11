/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author THAIHB.B19CN638
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Customer;

public class CustomerDAO extends DAO{
	
	/**
	 * search all customers in the tblCustomer whose name contains the @key
	 * @param key
	 * @return list of customer whose name contains the @key
	 */
	public ArrayList<Customer> searchCustomer(String key){
		ArrayList<Customer> result = new ArrayList<Customer>();
		String sql = "SELECT * FROM tblcustomer WHERE name LIKE ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setIdCard(rs.getString("idcard"));
				customer.setAddress(rs.getString("address"));
				customer.setTel(rs.getString("tel"));
				customer.setEmail(rs.getString("email"));
				customer.setNote(rs.getString("note"));
				result.add(customer);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
	
	/**
	 * get a customer whose id is @key
	 * @param key
	 * @return
	 */
	public Customer getCustomerById(int key){
		Customer customer = null;
		String sql = "SELECT * FROM tblcustomer WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setIdCard(rs.getString("idcard"));
				customer.setAddress(rs.getString("address"));
				customer.setTel(rs.getString("tel"));
				customer.setEmail(rs.getString("email"));
				customer.setNote(rs.getString("note"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return customer;
	}
	
	/**
	 * get all customer from tblCustomer
	 * @return
	 */
	public ArrayList<Customer> getAllCustomer(){
		ArrayList<Customer> result = new ArrayList<Customer>();
		String sql = "SELECT * FROM tblcustomer";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setIdCard(rs.getString("idcard"));
				customer.setAddress(rs.getString("address"));
				customer.setTel(rs.getString("tel"));
				customer.setEmail(rs.getString("email"));
				customer.setNote(rs.getString("note"));
				result.add(customer);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
	
	/**
	 * add a new @customer into the DB
	 * @param customer
     * @return 
	 */
	public boolean addCustomer(Customer customer){
		String sql = "INSERT INTO tblcustomer(name, idcard, address, tel, email, note) VALUES(?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getIdCard());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getTel());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getNote());

			ps.executeUpdate();
			
			//get id of the new inserted customer
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				customer.setId(generatedKeys.getInt(1));
			}
		}catch(Exception e){
                        e.printStackTrace();
                        return false;
		}
                return true;
	}
	
	/**
	 * update the @customer
	 * @param customer
	 */
	public void editCustomer(Customer customer){
		String sql = "UPDATE tblcustomer SET name=?, idcard =?, address=?, tel=?, email=?, note=? WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getIdCard());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getTel());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getNote());
			ps.setInt(7, customer.getId());

			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * delete the customer whose id is @id
	 * @param id
	 */
	public void deleteCustomer(int id){
		String sql = "DELETE FROM tblcustomer WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
