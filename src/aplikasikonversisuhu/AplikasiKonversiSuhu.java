/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasikonversisuhu;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author rhnfa
 */
public class AplikasiKonversiSuhu extends javax.swing.JFrame {

    /**
     * Creates new form AplikasiKonversiSuhu
     */
    public AplikasiKonversiSuhu() {
        initComponents();
        txt_suhu.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            konversiSuhu();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            konversiSuhu();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            konversiSuhu();
        }
    });
        radio_celcius.addActionListener(e -> konversiSuhu());
        radio_fahrenheit.addActionListener(e -> konversiSuhu());
        radio_reamur.addActionListener(e -> konversiSuhu());
        radio_kelvin.addActionListener(e -> konversiSuhu());
        
        // Add action listener to combo box
        combo_asal.addActionListener(e -> konversiSuhu());
    }
    
    private void konversiSuhu() {
    try {
        // Get the input temperature from the text field
        double suhu = Double.parseDouble(txt_suhu.getText().trim());

        // Check if the combo box has a selected item
        if (combo_asal.getSelectedItem() == null) {
            txt_hasil.setText("Silakan pilih satuan asal.");
            return;
        }

        // Get the selected original unit from the combo box
        String asal = combo_asal.getSelectedItem().toString();

        // Determine the target unit based on the selected radio button
        String tujuan = "";
        if (radio_celcius.isSelected()) {
            tujuan = "Celsius";
        } else if (radio_fahrenheit.isSelected()) {
            tujuan = "Fahrenheit";
        } else if (radio_kelvin.isSelected()) {
            tujuan = "Kelvin";
        } else if (radio_reamur.isSelected()) {
            tujuan = "Reaumur";
        } else {
            txt_hasil.setText("Silakan pilih satuan tujuan.");
            return;
        }

        double hasil = 0.0;

        // Perform conversion based on the original and target units
        if (asal.equals("Celcius")) {
            switch (tujuan) {
                case "Fahrenheit": hasil = (suhu * 9 / 5) + 32; break;
                case "Kelvin": hasil = suhu + 273.15; break;
                case "Reaumur": hasil = suhu * 4 / 5; break;
                case "Celsius": hasil = suhu; break;
            }
        } else if (asal.equals("Fahrenheit")) {
            switch (tujuan) {
                case "Celsius": hasil = (suhu - 32) * 5 / 9; break;
                case "Kelvin": hasil = (suhu - 32) * 5 / 9 + 273.15; break;
                case "Reaumur": hasil = (suhu - 32) * 4 / 9; break;
                case "Fahrenheit": hasil = suhu; break;
            }
        } else if (asal.equals("Kelvin")) {
            switch (tujuan) {
                case "Celsius": hasil = suhu - 273.15; break;
                case "Fahrenheit": hasil = (suhu - 273.15) * 9 / 5 + 32; break;
                case "Reaumur": hasil = (suhu - 273.15) * 4 / 5; break;
                case "Kelvin": hasil = suhu; break;
            }
        } else if (asal.equals("Reamur")) {
            switch (tujuan) {
                case "Celsius": hasil = suhu * 5 / 4; break;
                case "Fahrenheit": hasil = (suhu * 9 / 4) + 32; break;
                case "Kelvin": hasil = suhu * 5 / 4 + 273.15; break;
                case "Reaumur": hasil = suhu; break;
            }
        }

        // Display the result in the result text field
        txt_hasil.setText(String.format("%.2f", hasil));

        } catch (NumberFormatException e) {
        // Display an error message if the input is invalid
        txt_hasil.setText("Inputan tidak valid");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        label_judul = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label_suhu = new javax.swing.JLabel();
        label_asal = new javax.swing.JLabel();
        label_tujuan = new javax.swing.JLabel();
        combo_asal = new javax.swing.JComboBox<>();
        txt_suhu = new javax.swing.JTextField();
        radio_celcius = new javax.swing.JRadioButton();
        radio_fahrenheit = new javax.swing.JRadioButton();
        radio_reamur = new javax.swing.JRadioButton();
        radio_kelvin = new javax.swing.JRadioButton();
        label_hasil = new javax.swing.JLabel();
        txt_hasil = new javax.swing.JTextField();
        btn_konversi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_judul.setText("Aplikasi Konversi Suhu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(label_judul)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_judul)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        label_suhu.setText("Masukkan suhu :");

        label_asal.setText("Asal :");

        label_tujuan.setText("Tujuan :");

        combo_asal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Asal", "Celcius", "Fahrenheit", "Reamur", "Kelvin" }));

        txt_suhu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_suhuKeyTyped(evt);
            }
        });

        buttonGroup1.add(radio_celcius);
        radio_celcius.setText("Celcius");

        buttonGroup1.add(radio_fahrenheit);
        radio_fahrenheit.setText("Fahrenheit");

        buttonGroup1.add(radio_reamur);
        radio_reamur.setText("Reamur");

        buttonGroup1.add(radio_kelvin);
        radio_kelvin.setText("Kelvin");

        label_hasil.setText("Hasil :");

        txt_hasil.setEditable(false);

        btn_konversi.setText("Konversi !");
        btn_konversi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_konversiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_suhu)
                        .addGap(18, 18, 18)
                        .addComponent(txt_suhu, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_asal)
                            .addComponent(label_tujuan)
                            .addComponent(label_hasil))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_konversi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_hasil)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_asal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radio_celcius)
                                            .addComponent(radio_reamur))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radio_kelvin)
                                            .addComponent(radio_fahrenheit))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_suhu)
                    .addComponent(txt_suhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_asal)
                    .addComponent(combo_asal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tujuan)
                    .addComponent(radio_celcius)
                    .addComponent(radio_fahrenheit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_reamur)
                    .addComponent(radio_kelvin))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_hasil)
                    .addComponent(txt_hasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btn_konversi)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_konversiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_konversiActionPerformed
        // TODO add your handling code here:
        konversiSuhu();
    }//GEN-LAST:event_btn_konversiActionPerformed

    private void txt_suhuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_suhuKeyTyped
        // TODO add your handling code here:
        char input = evt.getKeyChar();
        if (!Character.isDigit(input)) {
            evt.consume();  // Mencegah input selain angka
        }
    }//GEN-LAST:event_txt_suhuKeyTyped

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
            java.util.logging.Logger.getLogger(AplikasiKonversiSuhu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiKonversiSuhu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiKonversiSuhu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiKonversiSuhu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiKonversiSuhu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_konversi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo_asal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_asal;
    private javax.swing.JLabel label_hasil;
    private javax.swing.JLabel label_judul;
    private javax.swing.JLabel label_suhu;
    private javax.swing.JLabel label_tujuan;
    private javax.swing.JRadioButton radio_celcius;
    private javax.swing.JRadioButton radio_fahrenheit;
    private javax.swing.JRadioButton radio_kelvin;
    private javax.swing.JRadioButton radio_reamur;
    private javax.swing.JTextField txt_hasil;
    private javax.swing.JTextField txt_suhu;
    // End of variables declaration//GEN-END:variables
}
