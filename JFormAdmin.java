/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package UAS;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ADVAN
 */
public class JFormAdmin extends javax.swing.JFrame {

    /**
     * Creates new form JFromBeranda
     */
    private int totalKaryawan;
    
    private void load_table(){
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Membuat semua sel pada tabel tidak dapat diedit
            }
        };
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Alamat");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Nomor Telpon");
        
        try {
            String sql= "select * from karyawan";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
            }
            tblKaryawan.setModel(model);
            
        }catch (Exception e){
            
        }}
    
    public JFormAdmin() {
        initComponents();
        updateTotalKaryawan();
        load_table();
        
    }

        
    private void updateTotalKaryawan() {
        try {
            totalKaryawan = getJumlahKaryawanDariDatabase();
            txtTotalKaryawan.setText(String.valueOf(totalKaryawan));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private int getJumlahKaryawanDariDatabase() throws Exception {
        int jumlahKaryawan = 0;

        try (Connection connection = Config.configDB()) {
            String sql = "SELECT COUNT(*) FROM karyawan";
            try (java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);) {
                java.sql.ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    jumlahKaryawan = rs.getInt(1);
                }
            }
        }

        return jumlahKaryawan;
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
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btDashboard = new javax.swing.JButton();
        btTambahPegawai = new javax.swing.JButton();
        btEditPegawai = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        btLogout = new javax.swing.JButton();
        btAbout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotalKaryawan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKaryawan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 700));
        setSize(new java.awt.Dimension(1000, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(2, 112, 75));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADVAN\\Downloads\\stafftracker-high-resolution-logo1.png")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UAS/icon/user-profile (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 854, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 120));

        jPanel2.setBackground(new java.awt.Color(65, 140, 105));

        btDashboard.setBackground(new java.awt.Color(65, 140, 105));
        btDashboard.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        btDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btDashboard.setText("Dashboard");
        btDashboard.setBorderPainted(false);
        btDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDashboardMouseClicked(evt);
            }
        });

        btTambahPegawai.setBackground(new java.awt.Color(65, 140, 105));
        btTambahPegawai.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        btTambahPegawai.setForeground(new java.awt.Color(255, 255, 255));
        btTambahPegawai.setText("Tambah Pegawai");
        btTambahPegawai.setBorderPainted(false);
        btTambahPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTambahPegawaiMouseClicked(evt);
            }
        });
        btTambahPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahPegawaiActionPerformed(evt);
            }
        });

        btEditPegawai.setBackground(new java.awt.Color(65, 140, 105));
        btEditPegawai.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        btEditPegawai.setForeground(new java.awt.Color(255, 255, 255));
        btEditPegawai.setText("Edit Pegawai");
        btEditPegawai.setBorderPainted(false);
        btEditPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditPegawaiMouseClicked(evt);
            }
        });
        btEditPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditPegawaiActionPerformed(evt);
            }
        });

        btHapus.setBackground(new java.awt.Color(65, 140, 105));
        btHapus.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        btHapus.setForeground(new java.awt.Color(255, 255, 255));
        btHapus.setText("Hapus Karyawan");
        btHapus.setBorderPainted(false);
        btHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btHapusMouseClicked(evt);
            }
        });
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        btLogout.setBackground(new java.awt.Color(65, 140, 105));
        btLogout.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        btLogout.setForeground(new java.awt.Color(255, 255, 255));
        btLogout.setText("Keluar");
        btLogout.setBorderPainted(false);
        btLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLogoutMouseClicked(evt);
            }
        });
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        btAbout.setBackground(new java.awt.Color(65, 140, 105));
        btAbout.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        btAbout.setForeground(new java.awt.Color(255, 255, 255));
        btAbout.setText("About");
        btAbout.setBorderPainted(false);
        btAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAboutMouseClicked(evt);
            }
        });
        btAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAboutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btTambahPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAbout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btTambahPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btEditPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 300, 650));

        jPanel3.setBackground(new java.awt.Color(171, 190, 159));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Pegawai");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 236, -1));

        txtTotalKaryawan.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalKaryawan.setFont(new java.awt.Font("sansserif", 0, 48)); // NOI18N
        txtTotalKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtTotalKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 150, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 330, 150));

        tblKaryawan.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tblKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKaryawan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 940, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(JFormLogin.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened
    
    
    
    private void btDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDashboardMouseClicked

    }//GEN-LAST:event_btDashboardMouseClicked

    private void btTambahPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahPegawaiActionPerformed
        // TODO add your handling code here:
        JFormTambah tambahFrame = new JFormTambah();
        tambahFrame.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btTambahPegawaiActionPerformed

    private void btEditPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditPegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEditPegawaiActionPerformed

    private void btEditPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditPegawaiMouseClicked
        // TODO add your handling code here:
        JFormTambah tambahFrame = new JFormTambah();
        tambahFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btEditPegawaiMouseClicked

    private void btHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHapusMouseClicked
        // TODO add your handling code here:
        JFormHapus hapusFrame = new JFormHapus();
        hapusFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btHapusMouseClicked

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btHapusActionPerformed

    private void btLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLogoutMouseClicked
        // TODO add your handling code here:
        JFormLogin loginFrame = new JFormLogin();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btLogoutMouseClicked

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btTambahPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTambahPegawaiMouseClicked
        // TODO add your handling code here:
        JFormTambah tambahFrame = new JFormTambah();
        tambahFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btTambahPegawaiMouseClicked

    private void btAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAboutMouseClicked
        // TODO add your handling code here:
        JFormAbout aboutFrame = new JFormAbout();
        aboutFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btAboutMouseClicked

    private void btAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAboutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAboutActionPerformed

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
            java.util.logging.Logger.getLogger(JFormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFormAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbout;
    private javax.swing.JButton btDashboard;
    private javax.swing.JButton btEditPegawai;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btTambahPegawai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKaryawan;
    private javax.swing.JLabel txtTotalKaryawan;
    // End of variables declaration//GEN-END:variables
}
