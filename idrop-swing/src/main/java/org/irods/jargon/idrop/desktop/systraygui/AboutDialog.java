/*
 * Created on Oct 8, 2010, 7:54:33 AM
 */

package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * 
 * @author mikeconway
 */
public class AboutDialog extends javax.swing.JDialog {

    /** Creates new form AboutDialog */
    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        registerKeystrokeListener();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iDROP - About");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel1.setText("iDROP - the iRODS Cloud Browser");

        jLabel2.setText("Version 0.9.0 - alpha");

        btnOK.setMnemonic('O');
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKPressed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup().add(51, 51, 51).add(jLabel1).addContainerGap(56, Short.MAX_VALUE))
                .add(org.jdesktop.layout.GroupLayout.TRAILING,
                        layout.createSequentialGroup().addContainerGap(311, Short.MAX_VALUE).add(btnOK).add(36, 36, 36))
                .add(layout
                        .createSequentialGroup()
                        .add(128, 128, 128)
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 166,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addContainerGap(128, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
                layout.createSequentialGroup().add(35, 35, 35).add(jLabel1).add(43, 43, 43).add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED).add(btnOK)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKPressed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOKPressed
        disposeOfAbout();
    }// GEN-LAST:event_btnOKPressed

    private void disposeOfAbout() {
        this.dispose();
    }

    /**
     * Register a listener for the enter event, so login can occur.
     */
    private void registerKeystrokeListener() {

        KeyStroke enter = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0);
        Action enterAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                disposeOfAbout();
            }
        };
        btnOK.registerKeyboardAction(enterAction, enter, JComponent.WHEN_IN_FOCUSED_WINDOW);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
