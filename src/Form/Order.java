/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Connect.QLQuanCafe;
import Entity.Orders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quach
 */
public class Order extends javax.swing.JFrame {

//    public int mamon;
    public Order() {
        initComponents();
        layThongTinMon();
        String sql = "select * from BAN where TRANGTHAI =1";
        Connection ketNoi = QLQuanCafe.getConnectionToMSSQL();
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jcb_table.addItem(rs.getString("MABAN"));
            }
        } catch (Exception e) {

        }
    }

    public int count = 0;

    ArrayList<Orders> arrOrders = new ArrayList<>();

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
                vt.add(rs.getString("HINHANH"));
                vt.add(rs.getString("TENMON"));
                vt.add(rs.getString("GIA"));
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

    public boolean kiemTraMon(ArrayList arr, String tenMon) {

        Iterator it = arr.iterator();
        while (it.hasNext()) {
            Orders o = (Orders) it.next();
            if (tenMon.equals(o.getTenMon())) {

                return true;
            }
        }
        return false;
    }

    private int LayMaMonTheoTen(String tenmon) {
        int mamon = 0;
        Connection ketNoi = QLQuanCafe.getConnectionToMSSQL();
        String sql = "select MAMON from MON where TENMON = N'" + tenmon + "'";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mamon = Integer.parseInt(rs.getString("MAMON"));
            }

        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
        return mamon;
    }

    private void LayThongTinBangOrder() {
        for (int i = 0; i < jt_order.getRowCount(); i++) {
            int soluong = Integer.parseInt(jt_order.getValueAt(i, 1).toString());
            String tenmon = jt_order.getValueAt(i, 0).toString();
            System.out.println(tenmon);
            int maban = Integer.parseInt(jcb_table.getSelectedItem().toString());
            int mamon = LayMaMonTheoTen(tenmon);
            LuuThongTinDatMon(mamon, maban, soluong);
        }
    }

    private void LuuThongTinDatMon(int mamon, int maban, int soluong) {
        Connection ketNoi = QLQuanCafe.getConnectionToMSSQL();
        String sql = "insert into DATMON values (?,?,?)";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, String.valueOf(mamon));
            ps.setString(2, String.valueOf(maban));
            ps.setString(3, String.valueOf(soluong));
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
        String sql1 = "update BAN set TRANGTHAI = 0 where MABAN = ?";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql1);
            ps.setString(1, String.valueOf(maban));
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
        }
        String sql2 = "insert into HOADON values (?,?)";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql2);
            ps.setString(1, String.valueOf(maban));
            ps.setString(2, String.valueOf(0));
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, e);
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
        jtf_tenmon = new javax.swing.JTextField();
        jb_chon = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_mon = new javax.swing.JTable();
        jtf_soluong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_gia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_order = new javax.swing.JTable();
        jb_finish = new javax.swing.JButton();
        jcb_table = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jtf_tenmon.setEditable(false);
        jtf_tenmon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_tenmonActionPerformed(evt);
            }
        });

        jb_chon.setText("Chọn");
        jb_chon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_chonActionPerformed(evt);
            }
        });

        jt_mon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Image", "Name", "Price"
            }
        ));
        jt_mon.setRowHeight(40);
        jt_mon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_monMouseClicked(evt);
            }
        });
        jt_mon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_monKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jt_mon);

        jtf_soluong.setText("1");

        jLabel3.setText("Tên món");

        jLabel4.setText("Số lượng");

        jtf_gia.setEditable(false);

        jLabel5.setText("Giá");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtf_tenmon, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jtf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jb_chon)
                                            .addGap(57, 57, 57))))))
                        .addContainerGap(17, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_tenmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_chon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("List order");

        jt_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Quantity", "Price", "Total"
            }
        ));
        jt_order.setRowHeight(25);
        jt_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_orderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_order);

        jb_finish.setText("Finish");
        jb_finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_finishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jb_finish)
                        .addGap(178, 414, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(379, 390, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_table, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jcb_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jb_finish)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_tenmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_tenmonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tenmonActionPerformed

    private void jb_chonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_chonActionPerformed
        // TODO add your handling code here:
        String tenMon = jtf_tenmon.getText();
        int soLuong = Integer.parseInt(jtf_soluong.getText());
        float gia = Float.parseFloat(jtf_gia.getText());

        DefaultTableModel dtm = (DefaultTableModel) jt_order.getModel();
        dtm.setNumRows(count);
        Orders o = new Orders(tenMon, soLuong, gia);

        if (!kiemTraMon(arrOrders, tenMon)) {
            o.setTenMon(tenMon);
            o.setSoLuong(soLuong);
            o.setGia(gia);
            Vector vt = new Vector();
            vt.add(tenMon);
            vt.add(soLuong);
            vt.add(gia);
            vt.add(soLuong * gia);
            dtm.addRow(vt);
            arrOrders.add(o);
            count++;
        } else {
            Iterator it = arrOrders.iterator();
            while (it.hasNext()) {
                Orders orders = (Orders) it.next();
                if (tenMon.equals(orders.getTenMon())) {
                    orders.setSoLuong(soLuong);
                }
            }
        }

        jt_order.setModel(dtm);
    }//GEN-LAST:event_jb_chonActionPerformed

    private void jt_monKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_monKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jt_monKeyReleased

    private void jt_monMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_monMouseClicked
        // TODO add your handling code here:
        int monDuocChon = jt_mon.getSelectedRow();
        String tenMon = (String) jt_mon.getValueAt(monDuocChon, 2);
        String gia = (String) jt_mon.getValueAt(monDuocChon, 3);
        jtf_tenmon.setText(tenMon);
        jtf_gia.setText(gia);
    }//GEN-LAST:event_jt_monMouseClicked

    private void jt_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_orderMouseClicked
        // TODO add your handling code here:
        int row = jt_order.getSelectedRow();
        String tenMon = (String) jt_order.getValueAt(row, 0);

        int soLuong = (int) jt_order.getValueAt(row, 1);
        float gia = (float) jt_order.getValueAt(row, 2);
        jtf_tenmon.setText(tenMon);
        jtf_gia.setText(String.valueOf(gia));
        jtf_soluong.setText(String.valueOf(soLuong));

    }//GEN-LAST:event_jt_orderMouseClicked

    private void jb_finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_finishActionPerformed
        // TODO add your handling code here:

        try {
            System.out.println(jt_order.getRowCount());
            LayThongTinBangOrder();
            JOptionPane.showMessageDialog(this, "Thanh cong");
            new Home("thu").setVisible(true);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jb_finishActionPerformed

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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_chon;
    private javax.swing.JButton jb_finish;
    private javax.swing.JComboBox<String> jcb_table;
    private javax.swing.JTable jt_mon;
    private javax.swing.JTable jt_order;
    private javax.swing.JTextField jtf_gia;
    private javax.swing.JTextField jtf_soluong;
    private javax.swing.JTextField jtf_tenmon;
    // End of variables declaration//GEN-END:variables
}
