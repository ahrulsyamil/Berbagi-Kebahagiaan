/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class koneksi {
    public static Connection con;
    
    public static Connection getKoneksi(){
        if(con == null){
            try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_perpus", "root", "");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal!");
        } 
        }
        return con; 
  }
}