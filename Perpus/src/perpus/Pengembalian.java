/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus;

import Fungsi.fungsi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Pengembalian extends javax.swing.JFrame {
    public Statement st;
    public Statement st2;
    public Statement st3;
    public ResultSet rs;
    public ResultSet rs2;
    public ResultSet rs3;
    public DefaultTableModel tabmodel;
    String sql;
    Connection con = koneksi.koneksi.getKoneksi(); 
    
    /**
     * Creates new form halaman_operator
     */
    public Pengembalian() {
        initComponents();
        judul_pinjam();
        tampildata_pinjam();
        waktu();
        ket.setVisible(false);
        kd_kembali.setEditable(false);
        kd_pinjam.setEditable(false);
        id_anggota.setEditable(false);
        kd_buku.setEditable(false);
        tgl_pinjam.setEditable(false);
        tgl_kembali.setEditable(false);
        denda_telat.setEditable(false);
        kode_kembali();
        setLocationRelativeTo(this);
    }
    
    public void reset(){
        kd_pinjam.setText(null);
        id_anggota.setText(null);
        kd_buku.setText(null);
        tgl_pinjam.setText(null);
        denda_telat.setText(null);
    }
    
    public Boolean tidak_kosong(){
        return !(kd_kembali.getText().equals("") || kd_pinjam.getText().equals("") || id_anggota.getText().equals("") || kd_buku.getText().equals("") || tgl_pinjam.getText().equals("") || tgl_kembali.getText().equals("") || denda_telat.getText().equals(""));
    }
    
    
    public void waktu(){
        //Date now = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        //String tgl = format.format(now);
        //tgl_kembali.setText(tgl);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        tgl_kembali.setText(df.format(cal.getTime()));
        cal.add(Calendar.DAY_OF_MONTH, 7);
        String hrs_kembali;
        hrs_kembali=(df.format(cal.getTime()));
    }
    
    public void kode_kembali(){
        int kd = (int)(Math.random()*999999);
        kd_kembali.setText(String.valueOf(kd));
    }
    
    public void hitung_denda(){
//        int denda  = 500;
//        String tgl1 = tgl_hrskembali.getText().toString().substring(8);
//        String tgl2 = tgl_kembali.getText().toString().substring(8);
//        int bayar = (Integer.valueOf(tgl1)-Integer.valueOf(tgl2));
//        if(bayar >0){
//            denda_telat.setText(String.valueOf(bayar*denda));
//        }else{
//            denda_telat.setText(String.valueOf(bayar*0));
//        }


        try {
            int bayar_denda = 500;
            String total;
            DateFormat tgl = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal1 = tgl_pinjam.getText();
            Date tglp = (Date)tgl.parse(tanggal1);
            String tanggal2 = tgl_kembali.getText();
            Date tglk = (Date)tgl.parse(tanggal2);
            long dnd = Math.abs(tglp.getTime()-tglk.getTime());
            long telat = (TimeUnit.MILLISECONDS.toDays(dnd));
//            denda_telat.setText(String.valueOf(telat));
            if(telat >7){
                ket.setText("Telat");
                denda_telat.setText(String.valueOf((telat-7)*bayar_denda));
            }else{
                ket.setText("Tidak telat");
                denda_telat.setText(String.valueOf(telat*0));
            }
//            if(telat <0){
//                denda_telat.setText(String.valueOf(telat*0));
//            }else{
//                denda_telat.setText(String.valueOf(telat*bayar_denda));
//            }
            
            
        } catch (ParseException ex) {
            Logger.getLogger(Pengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Boolean kosong(){
        return (kd_kembali.getText().equals("") || kd_pinjam.getText().equals("") || id_anggota.getText().equals("") || kd_buku.getText().equals("") || tgl_pinjam.getText().equals("") || tgl_kembali.getText().equals("") || denda_telat.getText().equals(""));
    }
    
    public void judul_pinjam(){
        Object[] judul = {"Kode Pinjam","ID Anggota","Nama","Kode Buku","Judul","Tanggal Pinjam","Tanggal Harus Kembali"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_pinjam.setModel(tabmodel);
    }
    
    public void tampildata_pinjam(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tb_pinjam WHERE kt != 'Sudah kembali' ORDER BY DATE(tgl_pinjam)  ASC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("kode_pinjam"),
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("kode_buku"),
                    rs.getString("judul"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_hrskembali"),
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        close = new javax.swing.JButton();
        logout1 = new javax.swing.JButton();
        cari_peminjaman = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        kd_kembali = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        kd_pinjam = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        id_anggota = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        kd_buku = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        reset = new javax.swing.JButton();
        perpanjang = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        tgl_pinjam = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        tgl_kembali = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        denda_telat = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        kembali1 = new javax.swing.JButton();
        hilang = new javax.swing.JButton();
        ket = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_pinjam = new javax.swing.JTable();

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

        cari_peminjaman.setBackground(new java.awt.Color(28, 42, 57));
        cari_peminjaman.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cari_peminjaman.setForeground(new java.awt.Color(255, 255, 255));
        cari_peminjaman.setBorder(null);
        cari_peminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari_peminjamanKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cari data peminjaman");

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(159, 159, 159)
                .addComponent(jLabel19)
                .addGap(239, 239, 239)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cari_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(920, 920, 920)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(logout)
                                    .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cari_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(28, 42, 57));
        jLabel13.setText("Kode Kembali");

        kd_kembali.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        kd_kembali.setForeground(new java.awt.Color(28, 42, 57));
        kd_kembali.setBorder(null);

        jSeparator6.setForeground(new java.awt.Color(28, 42, 57));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(28, 42, 57));
        jLabel14.setText("Kode Pinjam");

        kd_pinjam.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        kd_pinjam.setForeground(new java.awt.Color(28, 42, 57));
        kd_pinjam.setBorder(null);

        jSeparator7.setForeground(new java.awt.Color(28, 42, 57));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(28, 42, 57));
        jLabel15.setText("ID Anggota");

        id_anggota.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        id_anggota.setForeground(new java.awt.Color(28, 42, 57));
        id_anggota.setBorder(null);
        id_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_anggotaActionPerformed(evt);
            }
        });

        jSeparator8.setForeground(new java.awt.Color(28, 42, 57));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(28, 42, 57));
        jLabel17.setText("Kode Buku");

        kd_buku.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        kd_buku.setForeground(new java.awt.Color(28, 42, 57));
        kd_buku.setBorder(null);

        jSeparator10.setForeground(new java.awt.Color(28, 42, 57));

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

        perpanjang.setBackground(new java.awt.Color(28, 42, 57));
        perpanjang.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        perpanjang.setForeground(new java.awt.Color(255, 255, 255));
        perpanjang.setText("Perpanjang");
        perpanjang.setBorder(null);
        perpanjang.setContentAreaFilled(false);
        perpanjang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        perpanjang.setOpaque(true);
        perpanjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perpanjangActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(28, 42, 57));
        jLabel20.setText("Tanggal Pinjam");

        tgl_pinjam.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tgl_pinjam.setForeground(new java.awt.Color(28, 42, 57));
        tgl_pinjam.setBorder(null);

        jSeparator12.setForeground(new java.awt.Color(28, 42, 57));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(28, 42, 57));
        jLabel22.setText("Tanggal Kembali");

        tgl_kembali.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tgl_kembali.setForeground(new java.awt.Color(28, 42, 57));
        tgl_kembali.setBorder(null);

        jSeparator13.setForeground(new java.awt.Color(28, 42, 57));

        denda_telat.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        denda_telat.setForeground(new java.awt.Color(28, 42, 57));
        denda_telat.setBorder(null);

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(28, 42, 57));
        jLabel23.setText("Denda");

        jSeparator14.setForeground(new java.awt.Color(28, 42, 57));

        kembali1.setBackground(new java.awt.Color(28, 42, 57));
        kembali1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        kembali1.setForeground(new java.awt.Color(255, 255, 255));
        kembali1.setText("Kembalikan");
        kembali1.setBorder(null);
        kembali1.setContentAreaFilled(false);
        kembali1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kembali1.setOpaque(true);
        kembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali1ActionPerformed(evt);
            }
        });

        hilang.setBackground(new java.awt.Color(28, 42, 57));
        hilang.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        hilang.setForeground(new java.awt.Color(255, 255, 255));
        hilang.setText("Buku Hilang");
        hilang.setBorder(null);
        hilang.setContentAreaFilled(false);
        hilang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hilang.setOpaque(true);
        hilang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hilangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel13))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(kd_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel14))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(kd_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel15))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(id_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(kd_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel20))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(tgl_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel22))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(tgl_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel23))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(denda_telat, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(kembali1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(perpanjang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hilang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ket, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(ket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addGap(6, 6, 6)
                .addComponent(kd_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel14)
                .addGap(6, 6, 6)
                .addComponent(kd_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel15)
                .addGap(6, 6, 6)
                .addComponent(id_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(6, 6, 6)
                .addComponent(kd_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(6, 6, 6)
                .addComponent(tgl_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel22)
                .addGap(6, 6, 6)
                .addComponent(tgl_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel23)
                .addGap(8, 8, 8)
                .addComponent(denda_telat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(perpanjang, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hilang, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabel_pinjam.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pinjamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel_pinjam);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1190, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        int jawab;
        if((jawab = JOptionPane.showConfirmDialog(null,"Keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
            Login lg = new Login();
            lg.show();
            this.dispose();
        }

    }//GEN-LAST:event_logoutActionPerformed

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

    private void id_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_anggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_anggotaActionPerformed

    private void cari_peminjamanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_peminjamanKeyReleased
        // TODO add your handling code here:
        try {
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            String cr = cari_peminjaman.getText();
            rs = st.executeQuery("SELECT * FROM tb_pinjam WHERE kode_pinjam like '%"+ cr +"%' or id_anggota like '%"+ cr +"%' or nama like '%"+ cr +"%' or kode_buku like '%"+ cr +"%' or judul like '%"+ cr +"%' ORDER BY DATE(tgl_pinjam)=max(tgl_pinjam) ASC");
             while (rs.next()){
                    Object[] data ={
                     rs.getString("kode_pinjam"),
                     rs.getString("id_anggota"),
                     rs.getString("nama"),
                     rs.getString("kode_buku"),
                     rs.getString("judul"),
                     rs.getString("tgl_pinjam"),
                     rs.getString("tgl_hrskembali"),
                    };
                    tabmodel.addRow(data);
                    }
             if(cari_peminjaman.getText().length()<1){
                 tampildata_pinjam();
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cari_peminjamanKeyReleased

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void perpanjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perpanjangActionPerformed
        // TODO add your handling code here:
        if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_MONTH, 7);
                String hrs_kembali;
                hrs_kembali=(df.format(cal.getTime()));
                sql = "UPDATE tb_pinjam SET tgl_pinjam='"+ tgl_kembali.getText() +"', tgl_hrskembali='"+ hrs_kembali +"',kt='Belum kembali' WHERE kode_pinjam='"+ kd_pinjam.getText() +"' ";
                st = con.createStatement();
                st.executeUpdate(sql);
                int a = Integer.valueOf(denda_telat.getText());
                if(a > 0){
                    JOptionPane.showMessageDialog(null,"Berhasil di perpanjang dan dikenakan denda sebesar Rp."+ denda_telat.getText() +"");
                }else{
                    JOptionPane.showMessageDialog(null,"Berhasil di perpanjang");
                }
                reset();
                tampildata_pinjam();
                waktu();
                kode_kembali();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
                reset();
            }
        }
    }//GEN-LAST:event_perpanjangActionPerformed

    private void tabel_pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pinjamMouseClicked
        // TODO add your handling code here:
        int baris = tabel_pinjam.getSelectedRow();
        kd_pinjam.setText(tabel_pinjam.getModel().getValueAt(baris, 0).toString());
        id_anggota.setText(tabel_pinjam.getModel().getValueAt(baris, 1).toString());
        kd_buku.setText(tabel_pinjam.getModel().getValueAt(baris, 3).toString());
        tgl_pinjam.setText(tabel_pinjam.getModel().getValueAt(baris, 5).toString());
        hitung_denda();
        
    }//GEN-LAST:event_tabel_pinjamMouseClicked

    private void kembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali1ActionPerformed
        // TODO add your handling code here:
         if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
         }else{
             try {
                String sql1 = "INSERT INTO tb_kembali VALUES('"+ kd_kembali.getText() +"','"+ kd_pinjam.getText() +"','"+ id_anggota.getText() +"','"+ kd_buku.getText() +"','"+ tgl_kembali.getText() +"','"+ denda_telat.getText() +"','"+ ket.getText() +"','1')";
                String sql2 = "UPDATE tb_anggota set status='Tidak pinjam' WHERE id_anggota='"+ id_anggota.getText() +"'";
                String sql3 = "UPDATE tb_pinjam SET kt='Sudah kembali' WHERE kode_pinjam='"+ kd_pinjam.getText() +"'";
                st = con.prepareStatement(sql1);
                st2 = con.prepareStatement(sql2);
                st3 = con.prepareStatement(sql3);
                st.executeUpdate(sql1);
                st2.executeUpdate(sql2);
                st3.executeUpdate(sql3);
                JOptionPane.showMessageDialog(null,"Berhasil");
                reset();
                tampildata_pinjam();
                waktu();
                kode_kembali();
             } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
                reset();
             }
             
             
         }
    }//GEN-LAST:event_kembali1ActionPerformed

    private void hilangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hilangActionPerformed
         // TODO add your handling code here:
         if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else{
         int hilang = 200000;
         denda_telat.setText(String.valueOf(hilang));
         try {
            String sql1 = "INSERT INTO tb_kembali VALUES('"+ kd_kembali.getText() +"','"+ kd_pinjam.getText() +"','"+ id_anggota.getText() +"','"+ kd_buku.getText() +"','"+ tgl_kembali.getText() +"','"+ denda_telat.getText() +"','Hilang','0')";
            String sql2 = "UPDATE tb_anggota set status='Tidak pinjam' WHERE id_anggota='"+ id_anggota.getText() +"'";
            String sql3 = "UPDATE tb_pinjam SET kt='Sudah kembali' WHERE kode_pinjam='"+ kd_pinjam.getText() +"'";
            st = con.prepareStatement(sql1);
            st2 = con.prepareStatement(sql2);
            st3 = con.prepareStatement(sql3);
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
            st.executeUpdate(sql3);
            JOptionPane.showMessageDialog(null, "Buku hilang dikenakan denda sebesar Rp.'"+ hilang +"'");
            JOptionPane.showMessageDialog(null,"Berhasil di input");
            reset();
            tampildata_pinjam();
            waktu();
            kode_kembali();
        } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
             reset();
        }
       }
         
    }//GEN-LAST:event_hilangActionPerformed

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
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Pengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari_peminjaman;
    private javax.swing.JButton close;
    private javax.swing.JTextField denda_telat;
    private javax.swing.JButton hilang;
    private javax.swing.JTextField id_anggota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField kd_buku;
    private javax.swing.JTextField kd_kembali;
    private javax.swing.JTextField kd_pinjam;
    private javax.swing.JButton kembali1;
    private javax.swing.JTextField ket;
    private javax.swing.JButton logout;
    private javax.swing.JButton logout1;
    private javax.swing.JButton perpanjang;
    private javax.swing.JButton reset;
    private javax.swing.JTable tabel_pinjam;
    private javax.swing.JTextField tgl_kembali;
    private javax.swing.JTextField tgl_pinjam;
    // End of variables declaration//GEN-END:variables
}
