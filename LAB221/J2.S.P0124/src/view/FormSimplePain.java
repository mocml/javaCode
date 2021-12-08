/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author vanhv
 */
public class FormSimplePain extends javax.swing.JFrame {

    /**
     * Creates new form FormSimplePain
     */
    public FormSimplePain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painPanel = new javax.swing.JPanel();
        btnRed = new javax.swing.JButton();
        btnBlack = new javax.swing.JButton();
        btnBlue = new javax.swing.JButton();
        btnGreen = new javax.swing.JButton();
        btnMagenta = new javax.swing.JButton();
        btnNeon = new javax.swing.JButton();
        btnYellow = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        painPanel.setBackground(new java.awt.Color(255, 255, 255));
        painPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        painPanel.setFocusable(false);

        javax.swing.GroupLayout painPanelLayout = new javax.swing.GroupLayout(painPanel);
        painPanel.setLayout(painPanelLayout);
        painPanelLayout.setHorizontalGroup(
            painPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
        );
        painPanelLayout.setVerticalGroup(
            painPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnRed.setBackground(new java.awt.Color(255, 0, 0));
        btnRed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        btnRed.setFocusable(false);

        btnBlack.setBackground(new java.awt.Color(0, 0, 0));
        btnBlack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        btnBlack.setFocusable(false);

        btnBlue.setBackground(new java.awt.Color(0, 51, 255));
        btnBlue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        btnBlue.setFocusable(false);

        btnGreen.setBackground(new java.awt.Color(0, 255, 51));
        btnGreen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        btnGreen.setFocusable(false);

        btnMagenta.setBackground(new java.awt.Color(255, 0, 255));
        btnMagenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        btnMagenta.setFocusable(false);

        btnNeon.setBackground(new java.awt.Color(0, 255, 255));
        btnNeon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        btnNeon.setFocusable(false);

        btnYellow.setBackground(new java.awt.Color(255, 255, 0));
        btnYellow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        btnYellow.setFocusable(false);

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnClear.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBlack, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(btnRed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGreen, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(btnBlue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNeon, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(btnMagenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnYellow, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBlack, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnRed, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnNeon, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnMagenta, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlack;
    private javax.swing.JButton btnBlue;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGreen;
    private javax.swing.JButton btnMagenta;
    private javax.swing.JButton btnNeon;
    private javax.swing.JButton btnRed;
    private javax.swing.JButton btnYellow;
    private javax.swing.JPanel painPanel;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnBlack() {
        return btnBlack;
    }

    public void setBtnBlack(JButton btnBlack) {
        this.btnBlack = btnBlack;
    }

    public JButton getBtnBlue() {
        return btnBlue;
    }

    public void setBtnBlue(JButton btnBlue) {
        this.btnBlue = btnBlue;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(JButton btnClear) {
        this.btnClear = btnClear;
    }

    public JButton getBtnGreen() {
        return btnGreen;
    }

    public void setBtnGreen(JButton btnGreen) {
        this.btnGreen = btnGreen;
    }

    public JButton getBtnMagenta() {
        return btnMagenta;
    }

    public void setBtnMagenta(JButton btnMagenta) {
        this.btnMagenta = btnMagenta;
    }

    public JButton getBtnNeon() {
        return btnNeon;
    }

    public void setBtnNeon(JButton btnNeon) {
        this.btnNeon = btnNeon;
    }

    public JButton getBtnRed() {
        return btnRed;
    }

    public void setBtnRed(JButton btnRed) {
        this.btnRed = btnRed;
    }

    public JButton getBtnYellow() {
        return btnYellow;
    }

    public void setBtnYellow(JButton btnYellow) {
        this.btnYellow = btnYellow;
    }

    public JPanel getPainPanel() {
        return painPanel;
    }

    public void setPainPanel(JPanel painPanel) {
        this.painPanel = painPanel;
    }

}
