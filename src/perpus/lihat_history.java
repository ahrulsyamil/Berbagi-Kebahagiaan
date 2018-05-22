/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus;

import Fungsi.fungsi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.charset.CharsetDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author User
 */
public class lihat_history extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public ResultSet rs2;
    public DefaultTableModel tabmodel;
    String sql;
    Connection con = koneksi.koneksi.getKoneksi(); 
    
    /**
     * Creates new form halaman_operator
     */
    public lihat_history() {
        initComponents();
        judul();
        tampildata();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    }
    
    public void judul(){
        Object[] judul = {"ID Anggota","Nama Anggota","Kode Pinjam","Judul buku","Tanggal Pinjam","Tanggal Tenggat","Kode Kembali","Tanggal Kembali","Keterangan","Denda"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_transaksi.setModel(tabmodel);
    }
    public void tampildata_hilang(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM lihat_transaksi WHERE keterangan='Hilang' ORDER BY DATE(tgl_pinjam) ASC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("kode_pinjam"),
                    rs.getString("judul"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_hrskembali"),
                    rs.getString("kode_kembali"),
                    rs.getString("tgl_kembali"),
                    rs.getString("keterangan"),
                    rs.getString("denda")
                    
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void tampildata(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM lihat_transaksi ORDER BY DATE(tgl_pinjam) ASC, DATE(tgl_kembali) ASC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("kode_pinjam"),
                    rs.getString("judul"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_hrskembali"),
                    rs.getString("kode_kembali"),
                    rs.getString("tgl_kembali"),
                    rs.getString("keterangan"),
                    rs.getString("denda")
                    
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void tampildata_hariini(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM lihat_transaksi WHERE DATE(tgl_pinjam)=DATE(NOW()) OR DATE(tgl_kembali)=DATE(NOW()) ORDER BY DATE(tgl_pinjam) ASC, DATE(tgl_kembali) ASC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("kode_pinjam"),
                    rs.getString("judul"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_hrskembali"),
                    rs.getString("kode_kembali"),
                    rs.getString("tgl_kembali"),
                    rs.getString("keterangan"),
                    rs.getString("denda")
                    
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void tampildata_mingguini(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM lihat_transaksi WHERE WEEK(tgl_pinjam)=WEEK(NOW()) OR WEEK(tgl_kembali)=WEEK(NOW()) ORDER BY DATE(tgl_pinjam) ASC, DATE(tgl_kembali) ASC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("kode_pinjam"),
                    rs.getString("judul"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_hrskembali"),
                    rs.getString("kode_kembali"),
                    rs.getString("tgl_kembali"),
                    rs.getString("keterangan"),
                    rs.getString("denda")
                    
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void tampildata_bulanini(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM lihat_transaksi WHERE MONTH(tgl_pinjam)=MONTH(NOW()) OR MONTH(tgl_kembali)=MONTH(NOW()) ORDER BY DATE(tgl_pinjam) ASC, DATE(tgl_kembali) ASC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("kode_pinjam"),
                    rs.getString("judul"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_hrskembali"),
                    rs.getString("kode_kembali"),
                    rs.getString("tgl_kembali"),
                    rs.getString("keterangan"),
                    rs.getString("denda")
                    
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void tampildata_telat(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM lihat_transaksi WHERE keterangan='Telat' ORDER BY DATE(tgl_pinjam) ASC, DATE(tgl_kembali) ASC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("kode_pinjam"),
                    rs.getString("judul"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_hrskembali"),
                    rs.getString("kode_kembali"),
                    rs.getString("tgl_kembali"),
                    rs.getString("keterangan"),
                    rs.getString("denda")
                    
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void tampildata_tidaktelat(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM lihat_transaksi WHERE keterangan='Tidak telat' ORDER BY DATE(tgl_pinjam) ASC, DATE(tgl_kembali) ASC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("kode_pinjam"),
                    rs.getString("judul"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_hrskembali"),
                    rs.getString("kode_kembali"),
                    rs.getString("tgl_kembali"),
                    rs.getString("keterangan"),
                    rs.getString("denda")
                    
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void tampildata_belumkembali(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM lihat_transaksi WHERE kt='Belum kembali' ORDER BY DATE(tgl_pinjam) ASC, DATE(tgl_kembali) ASC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("kode_pinjam"),
                    rs.getString("judul"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_hrskembali"),
                    rs.getString("kode_kembali"),
                    rs.getString("tgl_kembali"),
                    rs.getString("keterangan"),
                    rs.getString("denda")
                    
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        close = new javax.swing.JButton();
        logout1 = new javax.swing.JButton();
        cari_transaksi = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sortir = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(28, 42, 57));

        jLabel1.setFont(new java.awt.Font("EngraversGothic BT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/books-stack-of-three (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("EngraversGothic BT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PerPus");

        logout.setBackground(new java.awt.Color(28, 42, 57));
        logout.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        logout.setText("Logout");
        logout.setToolTipText("Logout");
        logout.setBorder(null);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setFocusPainted(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        close.setBackground(new java.awt.Color(28, 42, 57));
        close.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("x");
        close.setToolTipText("Tutup");
        close.setBorder(null);
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.setFocusPainted(false);
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        logout1.setBackground(new java.awt.Color(28, 42, 57));
        logout1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        logout1.setForeground(new java.awt.Color(255, 255, 255));
        logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (2).png"))); // NOI18N
        logout1.setText("Home");
        logout1.setToolTipText("Home");
        logout1.setBorder(null);
        logout1.setBorderPainted(false);
        logout1.setContentAreaFilled(false);
        logout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout1.setFocusPainted(false);
        logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout1ActionPerformed(evt);
            }
        });

        cari_transaksi.setBackground(new java.awt.Color(28, 42, 57));
        cari_transaksi.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cari_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        cari_transaksi.setBorder(null);
        cari_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_transaksiActionPerformed(evt);
            }
        });
        cari_transaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari_transaksiKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sortir");

        sortir.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        sortir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua history", "History hari ini", "Minggu ini", "Bulan ini", "Telat", "Tidak telat", "Hilang", "Belum mengembalikan" }));
        sortir.setBorder(null);
        sortir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sortir.setOpaque(false);
        sortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sortir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 532, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cari_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sortir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logout)
                            .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(cari_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tabel_transaksi.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        tabel_transaksi.setForeground(new java.awt.Color(28, 42, 57));
        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabel_transaksi.setGridColor(new java.awt.Color(28, 42, 57));
        tabel_transaksi.setSelectionBackground(new java.awt.Color(28, 42, 57));
        jScrollPane2.setViewportView(tabel_transaksi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        fungsi.close();
    }//GEN-LAST:event_closeActionPerformed

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        // TODO add your handling code here:
        halaman_operator ho = new halaman_operator();
        ho.show();
        this.dispose();
    }//GEN-LAST:event_logout1ActionPerformed

    private void cari_transaksiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_transaksiKeyReleased
        // TODO add your handling code here:
        try {
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            String cr = cari_transaksi.getText();
            rs = st.executeQuery("SELECT * FROM lihat_transaksi WHERE id_anggota like '%"+ cr +"%'or nama like '%"+ cr +"%'or kode_pinjam like '%"+ cr +"%' or judul like '%"+ cr +"%' or tgl_pinjam like '%"+ cr +"%' or tgl_hrskembali like '%"+ cr +"%' or kode_kembali like '%"+ cr +"%' or tgl_kembali like '%"+ cr +"%' or keterangan like '%"+ cr +"%' or denda like '%"+ cr +"%' ORDER BY DATE(tgl_pinjam) ASC,DATE(tgl_kembali) ASC ") ;
             while (rs.next()){
                    Object[] data ={
                     rs.getString("id_anggota"),
                     rs.getString("nama"),
                     rs.getString("kode_pinjam"),
                     rs.getString("judul"),
                     rs.getString("tgl_pinjam"),
                     rs.getString("tgl_hrskembali"),
                     rs.getString("kode_kembali"),
                     rs.getString("tgl_kembali"),
                     rs.getString("keterangan"),
                     rs.getString("denda")
                    };
                    tabmodel.addRow(data);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cari_transaksiKeyReleased

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        int jawab;
        if((jawab = JOptionPane.showConfirmDialog(null,"Keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
            Login lg = new Login();
            lg.show();
            this.dispose();
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void cari_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cari_transaksiActionPerformed

    private void sortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortirActionPerformed
        // TODO add your handling code here:
        try {
            if(sortir.getSelectedItem().toString().equals("Semua history")){
                tampildata();
            }else if(sortir.getSelectedItem().toString().equals("History hari ini")){
                tampildata_hariini();
            }else if(sortir.getSelectedItem().toString().equals("Minggu ini")){
                tampildata_mingguini();
            }else if(sortir.getSelectedItem().toString().equals("Bulan ini")){
                tampildata_bulanini();
            }else if(sortir.getSelectedItem().toString().equals("Telat")){
                tampildata_telat();
            }else if(sortir.getSelectedItem().toString().equals("Tidak telat")){
                tampildata_tidaktelat();
            }else if(sortir.getSelectedItem().toString().equals("Hilang")){
                tampildata_hilang();
            }else if(sortir.getSelectedItem().toString().equals("Belum mengembalikan")){
                tampildata_belumkembali();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
        }
    }//GEN-LAST:event_sortirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lihat_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihat_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihat_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihat_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lihat_history().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari_transaksi;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.ButtonGroup kelamin;
    private javax.swing.JButton logout;
    private javax.swing.JButton logout1;
    private javax.swing.JComboBox<String> sortir;
    private javax.swing.JTable tabel_transaksi;
    // End of variables declaration//GEN-END:variables
}
