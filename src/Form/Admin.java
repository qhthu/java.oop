/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Connect.QLQuanCafe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quach
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public int mamon = 0;

    public Admin() {
        initComponents();
        layThongTinMon();
    }

    private void LuuThongTinMon(String tenmon, double gia, String hinhanh) {
        Connection ketNoi = QLQuanCafe.getConnectionToMSSQL();
        String sql = "insert into MON values (?,?,?,?)";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, tenmon);
            ps.setString(2, String.valueOf(gia));
            ps.setString(3, hinhanh);
            ps.setString(4, String.valueOf(1));
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void SuaThongTinMon(String tenmon, double gia, String hinhanh, int mamon) {
        Connection ketNoi = QLQuanCafe.getConnectionToMSSQL();
        String sql = "update MON set TENMON =?, GIA=?,HINHANH=? where MAMON=?";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, tenmon);
            ps.setString(2, String.valueOf(gia));
            ps.setString(3, hinhanh);
            ps.setString(4, String.valueOf(mamon));
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void XoaThongTinMon(int mamon) {
        Connection ketNoi = QLQuanCafe.getConnectionToMSSQL();
        String sql = "delete from MON where MAMON=?";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, String.valueOf(mamon));
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void layThongTinMon() {
        DefaultTableModel dtm = (DefaultTableModel) jt_mon.getModel();
        dtm.setNumRows(0);
        Connection ketNoi = QLQuanCafe.getConnectionToMSSQL();
        String sql = "select * from MON";
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vt = new Vector();
                vt.add(rs.getString("MAMON"));
                vt.add(rs.getString("TENMON"));
                vt.add(rs.getString("HINHANH"));
                vt.add(rs.getString("GIA"));
                vt.add(rs.getString("TRANGTHAI"));
                dtm.addRow(vt);
            }
            jt_mon.setModel(dtm);
            rs.close();
            ps.close();
            ketNoi.close();
        } catch (SQLException e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_tenmon = new javax.swing.JTextField();
        jtf_gia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jb_them = new javax.swing.JButton();
        jb_sua = new javax.swing.JButton();
        jb_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_mon = new javax.swing.JTable();
        jtf_hinhanh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setText("Tên món");

        jtf_tenmon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_tenmonActionPerformed(evt);
            }
        });

        jLabel3.setText("Giá");

        jb_them.setBackground(new java.awt.Color(51, 102, 255));
        jb_them.setForeground(new java.awt.Color(255, 255, 255));
        jb_them.setText("Thêm");
        jb_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_themActionPerformed(evt);
            }
        });

        jb_sua.setBackground(new java.awt.Color(51, 102, 255));
        jb_sua.setForeground(new java.awt.Color(255, 255, 255));
        jb_sua.setText("Sửa");
        jb_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_suaActionPerformed(evt);
            }
        });

        jb_xoa.setBackground(new java.awt.Color(51, 102, 255));
        jb_xoa.setForeground(new java.awt.Color(255, 255, 255));
        jb_xoa.setText("Xóa");
        jb_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_xoaActionPerformed(evt);
            }
        });

        jt_mon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã món", "Tên món", "Hình ảnh", "Giá", "Trạng thái"
            }
        ));
        jt_mon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_monMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_mon);

        jtf_hinhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_hinhanhActionPerformed(evt);
            }
        });

        jLabel4.setText("Hình ảnh");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jtf_tenmon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(205, 205, 205)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jtf_hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jb_them)
                .addGap(189, 189, 189)
                .addComponent(jb_sua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_xoa)
                .addGap(140, 140, 140))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_tenmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_them)
                    .addComponent(jb_sua)
                    .addComponent(jb_xoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_tenmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_tenmonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tenmonActionPerformed

    private void jt_monMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_monMouseClicked
        // TODO add your handling code here:
        int hangChon = jt_mon.getSelectedRow();
        mamon = Integer.parseInt(jt_mon.getValueAt(hangChon, 0).toString());
        String tenmon = jt_mon.getValueAt(hangChon, 1).toString();
        String hinhanh = jt_mon.getValueAt(hangChon, 2).toString();
        double gia = Double.parseDouble(jt_mon.getValueAt(hangChon, 3).toString());
        jtf_tenmon.setText(tenmon);
        jtf_hinhanh.setText(hinhanh);
        jtf_gia.setText(String.valueOf(gia));

    }//GEN-LAST:event_jt_monMouseClicked

    private void jb_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_themActionPerformed
        // TODO add your handling code here:

        String tenmon = jtf_tenmon.getText();
        String hinhanh = jtf_hinhanh.getText();
        double gia = Double.parseDouble(jtf_gia.getText());
        int check;
        int ktmamon = 0, ktgia = 0;
        if (tenmon.equals("")) {
            ktmamon = 1;
            JOptionPane.showMessageDialog(this, "Ten mon khong duoc bo trong! ");
        } else if (gia == 0) {
            ktgia = 1;
            JOptionPane.showMessageDialog(this, "Gia khong duoc bo trong! ");
        } else if (ktmamon != 1 && ktgia != 1) {
            LuuThongTinMon(tenmon, gia, hinhanh);
            JOptionPane.showMessageDialog(this, "Them mon thanh cong ! ");
            this.layThongTinMon();
        }
    }//GEN-LAST:event_jb_themActionPerformed

    private void jtf_hinhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_hinhanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_hinhanhActionPerformed

    private void jb_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_xoaActionPerformed
        // TODO add your handling code here:
        int[] nhungHangDuocChon = jt_mon.getSelectedRows();
        for (int i = 0; i < nhungHangDuocChon.length; i++) {
            try {
                int ma = Integer.parseInt(jt_mon.getValueAt(nhungHangDuocChon[i], 0).toString());
                System.out.println("ma mon" + ma);
//                JOptionPane.showConfirmDialog(rootPane, ma, title, WIDTH)

                int click = JOptionPane.showConfirmDialog(null, "Ban co muon xoa?");
                if (click == JOptionPane.YES_OPTION) {
                    XoaThongTinMon(mamon);
                    JOptionPane.showMessageDialog(this, "Xoa thanh cong! ");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xoa khong thanh cong! ");
            }
        }
        this.layThongTinMon();
    }//GEN-LAST:event_jb_xoaActionPerformed

    private void jb_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_suaActionPerformed
        // TODO add your handling code here:
        String tenmon = jtf_tenmon.getText();
        String hinhanh = jtf_hinhanh.getText();
        double gia = Double.parseDouble(jtf_gia.getText());

        int check;
        int ktmamon = 0, ktgia = 0;
        if (tenmon.equals("")) {
            ktmamon = 1;
            JOptionPane.showMessageDialog(this, "Ten mon khong duoc bo trong! ");
        } else if (gia == 0) {
            ktgia = 1;
            JOptionPane.showMessageDialog(this, "Gia khong duoc bo trong! ");
        } else if (ktmamon != 1 && ktgia != 1) {
            SuaThongTinMon(tenmon, gia, hinhanh, mamon);
            JOptionPane.showMessageDialog(this, "Chinh sua mon thanh cong ! ");
            this.layThongTinMon();
        }

    }//GEN-LAST:event_jb_suaActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_sua;
    private javax.swing.JButton jb_them;
    private javax.swing.JButton jb_xoa;
    private javax.swing.JTable jt_mon;
    private javax.swing.JTextField jtf_gia;
    private javax.swing.JTextField jtf_hinhanh;
    private javax.swing.JTextField jtf_tenmon;
    // End of variables declaration//GEN-END:variables
}
