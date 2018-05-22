/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus;

import Fungsi.fungsi;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class halaman_user extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public ResultSet rs2;
    public DefaultTableModel tabmodel;
    String sql;
    Connection con = koneksi.koneksi.getKoneksi();
    public static String id;
    
    /**
     * Creates new form halaman_operator
     */
    public halaman_user() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        user_id.setText(toString().valueOf(Login.getid()));
        judul_daftar();
        tampil();
        tampil_daftar();
        daftar.setFont(new java.awt.Font("Century Gothic", 1, 16));
        id = user_id.getText();
    }
    public static String getid(){
        return id;
    }
     
    public void judul_daftar(){
        Object[] judul = {"Kode","Judul","Penerbit","Tahun Terbit","Kategori","Jumlah"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        buku.setModel(tabmodel);
    }
    public void judul_rekom(){
        Object[] judul = {"Kode Buku","Judul","Penerbit","Tahun Terbit","Kategori","Peminjam"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        buku.setModel(tabmodel);
    }
    public void tampil_daftar(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tb_buku ORDER BY jumlah DESC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("kode_buku"),
                    rs.getString("judul"),
                    rs.getString("penerbit"),
                    rs.getString("tahun_terbit"),
                    rs.getString("kategori"),
                    rs.getString("jumlah"),
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void tampil_rekom(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT *, COUNT(*) AS peminjam FROM recomendasi WHERE keterangan != 'Sudah kembali' GROUP BY kode_buku ORDER BY peminjam DESC ");
            while(rs.next()){
                Object [] data = {
                    rs.getString("kode_buku"),
                    rs.getString("judul"),
                    rs.getString("penerbit"),
                    rs.getString("tahun_terbit"),
                    rs.getString("kategori"),
                    rs.getString("peminjam"),
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setColor(JPanel panel){
        panel.setBackground(new java.awt.Color(197, 211, 226));
        
    }
    public void tampil(){
        try {
            String nama;
            sql = "SELECT * FROM tb_anggota WHERE id_anggota = '"+ user_id.getText() +"'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] data = new Object[3];
                data[0] = rs.getString(2);
                
                
                username.setText((String) data[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void kembali_daftar(){
//        daftar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        recom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        com1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        com2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
    }
    public void kembali_recom(){
        daftar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
//        recom.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        com1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        com2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
    }
    public void kembali_com1(){
        daftar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        recom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
//        com1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        com2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
    }
    public void kembali_com2(){
        daftar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        recom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        com1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
//        com2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        logout = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        user_id = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        body = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        daftar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        recom = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        com1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        com2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        buku = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(28, 42, 57));

        logout.setBackground(new java.awt.Color(28, 42, 57));
        logout.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        logout.setText("Logout");
        logout.setToolTipText("Keluar");
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

        jLabel1.setFont(new java.awt.Font("EngraversGothic BT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user-account-box.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("EngraversGothic BT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PerPus");

        jLabel3.setFont(new java.awt.Font("EngraversGothic BT", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/books-stack-of-three (1).png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Raih impianmu dengan membaca buku");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID                  :");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Username  :");

        username.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("username");

        user_id.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        user_id.setForeground(new java.awt.Color(0, 51, 51));
        user_id.setText("id_user");
        user_id.setOpaque(true);

        jButton1.setBackground(new java.awt.Color(28, 42, 57));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings (1).png"))); // NOI18N
        jButton1.setToolTipText("Pengaturan");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(28, 42, 57));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/more(1).png"))); // NOI18N
        jButton2.setToolTipText("Detail");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(493, 493, Short.MAX_VALUE))
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(headerLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logout)
                            .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7)))
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(user_id))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(username)))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 173, 173))
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 190));

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(140, 154, 169));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        daftar.setBackground(new java.awt.Color(156, 170, 185));
        daftar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        daftar.setForeground(new java.awt.Color(255, 255, 255));
        daftar.setText("Daftar Buku");
        daftar.setBorder(null);
        daftar.setContentAreaFilled(false);
        daftar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        daftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                daftarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                daftarMouseExited(evt);
            }
        });
        daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(daftar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(daftar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        body.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 150, 40));

        jPanel4.setBackground(new java.awt.Color(124, 138, 153));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        recom.setBackground(new java.awt.Color(156, 170, 185));
        recom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        recom.setForeground(new java.awt.Color(255, 255, 255));
        recom.setText("Rekomendasi");
        recom.setBorder(null);
        recom.setContentAreaFilled(false);
        recom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recomMouseExited(evt);
            }
        });
        recom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recom, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recom, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        body.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 150, 40));

        jPanel5.setBackground(new java.awt.Color(108, 122, 137));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        com1.setBackground(new java.awt.Color(156, 170, 185));
        com1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        com1.setForeground(new java.awt.Color(255, 255, 255));
        com1.setText("comming soon...");
        com1.setBorder(null);
        com1.setContentAreaFilled(false);
        com1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        com1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                com1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                com1MouseExited(evt);
            }
        });
        com1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(com1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(com1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        body.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 150, 40));

        jPanel6.setBackground(new java.awt.Color(92, 106, 121));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        com2.setBackground(new java.awt.Color(156, 170, 185));
        com2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        com2.setForeground(new java.awt.Color(255, 255, 255));
        com2.setText("comming soon...");
        com2.setBorder(null);
        com2.setContentAreaFilled(false);
        com2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        com2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                com2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                com2MouseExited(evt);
            }
        });
        com2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(com2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(com2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        body.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 150, 40));

        jScrollPane1.setBorder(null);

        buku.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        buku.setForeground(new java.awt.Color(28, 42, 57));
        buku.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(buku);

        body.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 740, 370));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(28, 42, 57));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Pilihanmu Menentukan Impianmu...");
        body.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 780, -1));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 780, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        int selectedOption = JOptionPane.showConfirmDialog(null,"Keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
        Login lg = new Login();
        lg.show();
        this.dispose();
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        fungsi.close();
    }//GEN-LAST:event_closeActionPerformed

    private void daftarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarMouseEntered
        // TODO add your handling code here:
        setColor(jPanel3);
    }//GEN-LAST:event_daftarMouseEntered

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        setColor(jPanel3);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        jPanel3.setBackground(new java.awt.Color(140,154,169));
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        setColor(jPanel4);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        jPanel4.setBackground(new java.awt.Color(124,138,153));
    }//GEN-LAST:event_jPanel4MouseExited

    private void com1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com1MouseEntered
        // TODO add your handling code here:
        setColor(jPanel5);
    }//GEN-LAST:event_com1MouseEntered

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:
        setColor(jPanel5);
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        jPanel5.setBackground(new java.awt.Color(108,122,137));
    }//GEN-LAST:event_jPanel5MouseExited

    private void com2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com2MouseEntered
        // TODO add your handling code here:
        setColor(jPanel6);
    }//GEN-LAST:event_com2MouseEntered

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
        setColor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
        jPanel6.setBackground(new java.awt.Color(92,106,121));
    }//GEN-LAST:event_jPanel6MouseExited

    private void recomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recomMouseEntered
        // TODO add your handling code here:
        setColor(jPanel4);

    }//GEN-LAST:event_recomMouseEntered

    private void daftarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarMouseExited
        // TODO add your handling code here:
        jPanel3.setBackground(new java.awt.Color(140,154,169));        
    }//GEN-LAST:event_daftarMouseExited

    private void recomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recomMouseExited
        // TODO add your handling code here:
        jPanel4.setBackground(new java.awt.Color(124,138,153));

    }//GEN-LAST:event_recomMouseExited

    private void com1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com1MouseExited
        // TODO add your handling code here:
        jPanel5.setBackground(new java.awt.Color(108,122,137));
    }//GEN-LAST:event_com1MouseExited

    private void com2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com2MouseExited
        // TODO add your handling code here:
        jPanel6.setBackground(new java.awt.Color(92,106,121));
    }//GEN-LAST:event_com2MouseExited

    private void daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarActionPerformed
        // TODO add your handling code here:
        daftar.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        kembali_daftar();
        judul_daftar();
        tampil_daftar();
    }//GEN-LAST:event_daftarActionPerformed

    private void recomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recomActionPerformed
        // TODO add your handling code here:
        recom.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        kembali_recom();
        judul_rekom();
        tampil_rekom();
    }//GEN-LAST:event_recomActionPerformed

    private void com1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com1ActionPerformed
        // TODO add your handling code here:
        com1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        kembali_com1();
    }//GEN-LAST:event_com1ActionPerformed

    private void com2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com2ActionPerformed
        // TODO add your handling code here:
        com2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        kembali_com2();
    }//GEN-LAST:event_com2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pengaturan_user pu = new pengaturan_user();
        pu.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        detail_user du = new detail_user();
        du.show();
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(halaman_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(halaman_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(halaman_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(halaman_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new halaman_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JTable buku;
    private javax.swing.JButton close;
    private javax.swing.JButton com1;
    private javax.swing.JButton com2;
    private javax.swing.JButton daftar;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton recom;
    private javax.swing.JLabel user_id;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
