package ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.KoneksiDatabase;

public class NIM_mhs extends javax.swing.JFrame {

    Connection cn;
    Statement st;
    ResultSet rs;
    
    public NIM_mhs() {
        initComponents();
        cn = KoneksiDatabase.BukaKoneksi();
        TampilData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuFormulirMhs = new javax.swing.JMenuItem();
        MenuTabelDataMhs = new javax.swing.JMenuItem();
        MenuKeluar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIM", "Nama Lengkap", "NIK", "Jurusan"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("File");

        MenuFormulirMhs.setText("Formulir Mahasiswa");
        MenuFormulirMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFormulirMhsActionPerformed(evt);
            }
        });
        jMenu1.add(MenuFormulirMhs);

        MenuTabelDataMhs.setText("Tabel Data Mahasiswa");
        MenuTabelDataMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTabelDataMhsActionPerformed(evt);
            }
        });
        jMenu1.add(MenuTabelDataMhs);

        MenuKeluar.setText("Keluar");
        MenuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuKeluarActionPerformed(evt);
            }
        });
        jMenu1.add(MenuKeluar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TampilData() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM jurusan_mhs");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("NIM");
            model.addColumn("Nama Lengkap");
            model.addColumn("NIK");
            model.addColumn("Jurusan");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("NIM"),
                    rs.getString("nama_lengkap"),
                    rs.getString("NIK"),
                    rs.getString("jurusan")
                });
            }

            jTable1.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data: " + e.getMessage());
        }
    }
    
    private void MenuTabelDataMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTabelDataMhsActionPerformed
        dispose();new Tabel_Data_MHS().setVisible(true);
    }//GEN-LAST:event_MenuTabelDataMhsActionPerformed

    private void MenuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_MenuKeluarActionPerformed

    private void MenuFormulirMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFormulirMhsActionPerformed
        dispose();new Formulir_MHS().setVisible(true);
    }//GEN-LAST:event_MenuFormulirMhsActionPerformed

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
            java.util.logging.Logger.getLogger(NIM_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NIM_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NIM_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NIM_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NIM_mhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuFormulirMhs;
    private javax.swing.JMenuItem MenuKeluar;
    private javax.swing.JMenuItem MenuTabelDataMhs;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
