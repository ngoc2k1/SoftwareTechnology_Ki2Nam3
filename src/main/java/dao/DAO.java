/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author THAIHB.B19CN638
 */
public class DAO {
   public static Connection con;
	
	public DAO(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3306/cnpm?autoReconnect=true&useSSL=false";
			String dbClass = "com.mysql.cj.jdbc.Driver";
                        String username = "root";
                        String password = "B19dccn638+";
			try {
				Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, username, password);
			}catch(ClassNotFoundException | SQLException e) {
			}
		}
	}
}
