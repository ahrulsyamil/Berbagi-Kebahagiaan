/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fungsi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class fungsi {
           
    
    public static void close(){
        int selectedOption = JOptionPane.showConfirmDialog(null,"Konfirmasi Tutup Sistem", "Tutup Sistem", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
        System.exit(0);
        }
    }
    
}
