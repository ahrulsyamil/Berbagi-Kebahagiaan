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
import javafx.scene.control.RadioButton;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author User
 */
public class lihat_anggota extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public ResultSet rs2;
    public DefaultTableModel tabmodel;
    String sql;
    Connection con = koneksi.koneksi.getKoneksi(); 
    
    /**
     * Creates new form halaman_operator
     */
    public lihat_anggota() {
        initComponents();
        judul();
        tampildata();
        laki.setActionCommand("Laki-laki");
        perempuan.setActionCommand("Perempuan");
        id_anggota.setEditable(false);
        ubah.setEnabled(false);
        hapus.setEnabled(false);
        autokode();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    }
    
    public void reset(){
        nama.setText(null);
        pass_user.setText(null);
        pass_konfir.setText(null);
        kelamin.clearSelection();
        telp.setText(null);
        alamat.setText(null);
        tambah.setEnabled(true);
        hapus.setEnabled(false);
        ubah.setEnabled(false);
    }
    
    public Boolean kosong(){
        return (id_anggota.getText().equals("") || nama.getText().equals("") || pass_user.getText().equals("") || pass_konfir.getText().equals("") || (kelamin.getSelection()==null) || telp.getText().equals("") || alamat.getText().equals(""));
    }
    
     public Boolean tidak_sesuai(){
        String pass1 = pass_user.getText();
        String pass2 = pass_konfir.getText();
        return !(pass1.equals(pass2));
    }
    
    public void autokode(){
         try{
            String sql;
            sql = "SELECT COUNT(id_anggota) as jumlah FROM tb_anggota";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String jumlah = rs.getString("jumlah");
                int jumint = Integer.parseInt(String.valueOf(jumlah));
                if (jumint > 0) {
                    st = con.createStatement();
                        sql = "SELECT MAX(id_anggota) AS kode FROM tb_anggota";
                        rs2 = st.executeQuery(sql);
                        if(rs2.next()){
                            String id = rs2.getString("kode").substring(3);
                            String kode = String.valueOf(Integer.parseInt(id) + 1);
                            if(kode.length() == 1){
                               id_anggota.setText("USR00"+kode);
                            }else if(kode.length() == 2){
                                id_anggota.setText("USR0"+kode);
                            }else
                                id_anggota.setText("USR"+kode);
                        }
                }else{
                    id_anggota.setText("USR001");
                }
            }
        }catch(SQLException e){
            
        }
    }
    
    public void judul(){
        Object[] judul = {"ID","Nama","Password","Jenis Kelamin","Telepon","Alamat","Status"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_anggota.setModel(tabmodel);
    }
    public void judul_cari(){
        Object[] judul = {"ID","Nama","Jenis Kelamin","Telepon","Alamat","Status"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_anggota.setModel(tabmodel);
    }
    public void tampildata(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tb_anggota ORDER BY id_anggota DESC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("password"),
                    rs.getString("jk"),
                    rs.getString("telp"),
                    rs.getString("alamat"),
                    rs.getString("status"),
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
        cari = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_anggota = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        id_anggota = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        telp = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        reset = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        pass_user = new javax.swing.JPasswordField();
        pass_konfir = new javax.swing.JPasswordField();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();

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

        cari.setBackground(new java.awt.Color(28, 42, 57));
        cari.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setBorder(null);
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 537, Short.MAX_VALUE)
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
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout)
                    .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tabel_anggota.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        tabel_anggota.setForeground(new java.awt.Color(28, 42, 57));
        tabel_anggota.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_anggota.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabel_anggota.setGridColor(new java.awt.Color(28, 42, 57));
        tabel_anggota.setSelectionBackground(new java.awt.Color(28, 42, 57));
        tabel_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_anggotaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_anggota);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(28, 42, 57));
        jLabel13.setText("ID Anggota");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        id_anggota.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        id_anggota.setForeground(new java.awt.Color(28, 42, 57));
        id_anggota.setBorder(null);
        jPanel7.add(id_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 36, 370, -1));

        jSeparator6.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 390, 10));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(28, 42, 57));
        jLabel14.setText("Nama");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, -1, -1));

        nama.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        nama.setForeground(new java.awt.Color(28, 42, 57));
        nama.setBorder(null);
        jPanel7.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 370, -1));

        jSeparator7.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 394, 10));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(28, 42, 57));
        jLabel15.setText("Password");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, -1, -1));

        jSeparator8.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 184, 394, 10));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(28, 42, 57));
        jLabel16.setText("Konfirmasi Password");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jSeparator9.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 390, 10));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(28, 42, 57));
        jLabel17.setText("Jenis Kelamin");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(28, 42, 57));
        jLabel18.setText("Telepon");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        telp.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        telp.setForeground(new java.awt.Color(28, 42, 57));
        telp.setBorder(null);
        telp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telpKeyTyped(evt);
            }
        });
        jPanel7.add(telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 370, -1));

        jSeparator11.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 390, 10));

        reset.setBackground(new java.awt.Color(28, 42, 57));
        reset.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset");
        reset.setBorder(null);
        reset.setContentAreaFilled(false);
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.setOpaque(true);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel7.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 473, 92, 37));

        tambah.setBackground(new java.awt.Color(28, 42, 57));
        tambah.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tambah.setForeground(new java.awt.Color(255, 255, 255));
        tambah.setText("Tambah");
        tambah.setBorder(null);
        tambah.setContentAreaFilled(false);
        tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambah.setOpaque(true);
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        jPanel7.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 473, 92, 37));

        hapus.setBackground(new java.awt.Color(28, 42, 57));
        hapus.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("Hapus");
        hapus.setBorder(null);
        hapus.setContentAreaFilled(false);
        hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapus.setOpaque(true);
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel7.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 473, 92, 37));

        ubah.setBackground(new java.awt.Color(28, 42, 57));
        ubah.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ubah.setForeground(new java.awt.Color(255, 255, 255));
        ubah.setText("Ubah");
        ubah.setBorder(null);
        ubah.setContentAreaFilled(false);
        ubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ubah.setOpaque(true);
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        jPanel7.add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 473, 92, 37));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(28, 42, 57));
        jLabel20.setText("Alamat");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        alamat.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        alamat.setForeground(new java.awt.Color(28, 42, 57));
        alamat.setBorder(null);
        alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alamatKeyTyped(evt);
            }
        });
        jPanel7.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 370, -1));

        jSeparator12.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 390, 10));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("* Minimal 8 karakter");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 140, 30));

        pass_user.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pass_user.setForeground(new java.awt.Color(28, 42, 57));
        pass_user.setBorder(null);
        jPanel7.add(pass_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 161, 380, -1));

        pass_konfir.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pass_konfir.setForeground(new java.awt.Color(28, 42, 57));
        pass_konfir.setBorder(null);
        pass_konfir.setScrollOffset(1);
        jPanel7.add(pass_konfir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 376, -1));

        laki.setBackground(new java.awt.Color(28, 42, 57));
        kelamin.add(laki);
        laki.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        laki.setForeground(new java.awt.Color(28, 42, 57));
        laki.setText("Laki-Laki");
        laki.setBorder(null);
        laki.setContentAreaFilled(false);
        laki.setFocusPainted(false);
        jPanel7.add(laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 150, 20));

        perempuan.setBackground(new java.awt.Color(28, 42, 57));
        kelamin.add(perempuan);
        perempuan.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        perempuan.setForeground(new java.awt.Color(28, 42, 57));
        perempuan.setText("Perempuan");
        perempuan.setBorder(null);
        perempuan.setContentAreaFilled(false);
        perempuan.setFocusPainted(false);
        jPanel7.add(perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 150, 20));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("* Maksimal 13 karakter");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 140, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void tabel_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_anggotaMouseClicked
        // TODO add your handling code here:
        int baris = tabel_anggota.getSelectedRow();
        id_anggota.setEditable(false);
        tambah.setEnabled(false);
        hapus.setEnabled(true);
        ubah.setEnabled(true);
        kelamin.setSelected(null,false);
        id_anggota.setText(tabel_anggota.getModel().getValueAt(baris, 0).toString());
        nama.setText(tabel_anggota.getModel().getValueAt(baris, 1).toString());
        pass_user.setText(tabel_anggota.getModel().getValueAt(baris, 2).toString());
        pass_konfir.setText(tabel_anggota.getModel().getValueAt(baris, 2).toString());
        telp.setText(tabel_anggota.getModel().getValueAt(baris, 4).toString());
        alamat.setText(tabel_anggota.getModel().getValueAt(baris, 5).toString());
        switch(tabmodel.getValueAt(tabel_anggota.getSelectedRow(), 3).toString()){
            case "Laki-laki" :
                laki.setSelected(true);
                break;
            case "Perempuan" :
                perempuan.setSelected(true);
                break;
        }
        
    }//GEN-LAST:event_tabel_anggotaMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        
        if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(pass_user.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password minimal 8 karakter !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(tidak_sesuai()){
            JOptionPane.showMessageDialog(null, "Password tidak sesuai !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                st = con.createStatement();
                String sql = "INSERT INTO tb_anggota VALUES('"+ id_anggota.getText() +"','"+ nama.getText() +"','"+ pass_user.getText() +"','"+ kelamin.getSelection().getActionCommand().toString() +"', '"+ telp.getText() +"','"+ alamat.getText() +"','Tidak pinjam')";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Berhasil");
                reset();
                tampildata();
                autokode();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
                reset();
            }
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        autokode();
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(pass_user.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password minimal 8 karakter !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(tidak_sesuai()){
            JOptionPane.showMessageDialog(null, "Password tidak sesuai !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
            st = con.createStatement();
            String sql = "UPDATE tb_anggota SET nama='"+ nama.getText() +"', password='"+ pass_user.getText() +"',jk='"+ kelamin.getSelection().getActionCommand().toString() +"',telp='"+ telp.getText() +"',alamat='"+ alamat.getText() +"' WHERE id_anggota='"+ id_anggota.getText() +"'";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Berhasil di ubah");
            reset();
            tampildata();
            } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
            reset();
            }
        }
        
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        if(!id_anggota.getText().equals("")){
            try {
            int baris = tabel_anggota.getSelectedRow();
            String stat = "Pinjam";
            int jawab;
            if(stat.equals(tabel_anggota.getValueAt(baris, 6))){
                JOptionPane.showMessageDialog(null, "Tidak dapat menghapus selama dalam masa peminjaman");
//                reset();
            }else if((jawab = JOptionPane.showConfirmDialog(null,"Hapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
                st = con.createStatement();
                sql = "DELETE FROM tb_anggota WHERE id_anggota='"+ id_anggota.getText() +"'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Berhasil di hapus");
                reset();
                tampildata();
            }
            
            } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
            reset();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Pilih ID untuk data yang ingin di hapus!");
        }
        
        
    }//GEN-LAST:event_hapusActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        // TODO add your handling code here:
        if(cari.getText().length()>0){
            try {
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            String cr = cari.getText();
            rs = st.executeQuery("SELECT * FROM tb_anggota WHERE id_anggota like '%"+ cr +"%'or nama like '%"+ cr +"%'or jk like '%"+ cr +"%' or telp like '%"+ cr +"%' or alamat like '%"+ cr +"%' or status like '%"+ cr +"%' ORDER BY id_anggota DESC " );
             while (rs.next()){
                    judul_cari();
                    Object[] data ={
                     rs.getString("id_anggota"),
                     rs.getString("nama"),
                     rs.getString("jk"),
                     rs.getString("telp"),
                     rs.getString("alamat"),
                     rs.getString("status"),
                    };
                    tabmodel.addRow(data);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else{
            judul();
            tampildata();   
        }
        
    }//GEN-LAST:event_cariKeyReleased

    private void alamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatKeyTyped

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        int jawab;
        if((jawab = JOptionPane.showConfirmDialog(null,"Keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
            Login lg = new Login();
            lg.show();
            this.dispose();
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void telpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telpKeyTyped
        // TODO add your handling code here:
         if(!Character.isDigit(evt.getKeyChar()) || telp.getText().length()>=13){
            evt.consume();
        }
    }//GEN-LAST:event_telpKeyTyped

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

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
            java.util.logging.Logger.getLogger(lihat_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihat_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihat_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihat_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lihat_anggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField cari;
    private javax.swing.JButton close;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField id_anggota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.ButtonGroup kelamin;
    private javax.swing.JRadioButton laki;
    private javax.swing.JButton logout;
    private javax.swing.JButton logout1;
    private javax.swing.JTextField nama;
    private javax.swing.JPasswordField pass_konfir;
    private javax.swing.JPasswordField pass_user;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JButton reset;
    private javax.swing.JTable tabel_anggota;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField telp;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
