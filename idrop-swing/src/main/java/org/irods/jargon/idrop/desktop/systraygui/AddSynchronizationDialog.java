/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.Toolkit;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JFileChooser;
import org.irods.jargon.conveyor.core.ConveyorExecutionException;
import org.irods.jargon.core.utils.MiscIRODSUtils;
import org.irods.jargon.idrop.finder.IRODSFinderDialog;
import org.irods.jargon.transfer.dao.domain.FrequencyType;
import org.irods.jargon.transfer.dao.domain.Synchronization;
import org.irods.jargon.transfer.dao.domain.SynchronizationType;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lisa
 */
public class AddSynchronizationDialog extends javax.swing.JDialog {

    private boolean editMode = false;
    private final IDROPCore idropCore;
    private Synchronization synchronization = new Synchronization();
    private static final org.slf4j.Logger log = LoggerFactory
            .getLogger(AddSynchronizationDialog.class);

    /**
     * Creates new form AddSynchronizationDialog
     */
    public AddSynchronizationDialog(SynchronizationDialog parent, boolean modal, IDROPCore idropCore) {
        super(parent, modal);
        initComponents();
        this.idropCore = idropCore;
    }

    public AddSynchronizationDialog(SynchronizationDialog parent, boolean modal, IDROPCore idropCore, Synchronization sync) {
        super(parent, modal);
        initComponents();
        this.idropCore = idropCore;
        this.synchronization = sync;
        this.editMode = true;
        populateSyncData();
    }

    public Synchronization getSynchronization() {
        return this.synchronization;
    }

    private void populateSyncData() {
        final AddSynchronizationDialog dialog = this;

        log.info("refreshing transfer table");

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                dialog.txtIrodsPath.setText(MiscIRODSUtils.abbreviateFileName(synchronization.getIrodsSynchDirectory()));
                dialog.txtIrodsPath.setToolTipText(synchronization.getIrodsSynchDirectory());

                dialog.txtLocalPath.setText(MiscIRODSUtils.abbreviateFileName(synchronization.getLocalSynchDirectory()));
                dialog.txtLocalPath.setToolTipText(synchronization.getLocalSynchDirectory());

                dialog.txtName.setText(synchronization.getName());
                dialog.comboSynchFrequency.setSelectedItem(synchronization.getFrequencyType());
            }

        });
    }

    class FrequencyTypeModelToo extends AbstractListModel<FrequencyType> implements ComboBoxModel<FrequencyType> {

        private FrequencyType selected = null;

        FrequencyType[] frequencyTypes = FrequencyType.values();

        @Override
        public int getSize() {
            return frequencyTypes.length;
        }

        @Override
        public FrequencyType getElementAt(int index) {
            return frequencyTypes[index];
        }

        @Override
        public void setSelectedItem(Object anItem) {
            selected = (FrequencyType) anItem;
        }

        @Override
        public Object getSelectedItem() {
            return selected;
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLocalPath = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIrodsPath = new javax.swing.JTextField();
        btnLocalDirectory = new javax.swing.JButton();
        btnIrodsDirectory = new javax.swing.JButton();
        comboSynchFrequency = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        jLabel2.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.jLabel2.text")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.title")); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 360));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.lblelectLocalResource.text")); // NOI18N
        jLabel1.setName("lblelectLocalResource"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel1, gridBagConstraints);

        txtLocalPath.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.localResource.text")); // NOI18N
        txtLocalPath.setName("localResource"); // NOI18N
        txtLocalPath.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        jPanel1.add(txtLocalPath, gridBagConstraints);

        jLabel3.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.lblSelectIrodsResourcePath.text")); // NOI18N
        jLabel3.setName("lblSelectIrodsResourcePath"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel3, gridBagConstraints);

        txtIrodsPath.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.irodsResourcePath.text")); // NOI18N
        txtIrodsPath.setName("irodsResourcePath"); // NOI18N
        txtIrodsPath.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.8;
        jPanel1.add(txtIrodsPath, gridBagConstraints);

        btnLocalDirectory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_144_folder_open.png"))); // NOI18N
        btnLocalDirectory.setMnemonic('l');
        btnLocalDirectory.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.btnBrowseLocal.text")); // NOI18N
        btnLocalDirectory.setToolTipText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.btnBrowseLocal.toolTipText")); // NOI18N
        btnLocalDirectory.setMaximumSize(null);
        btnLocalDirectory.setMinimumSize(new java.awt.Dimension(140, 31));
        btnLocalDirectory.setName("btnBrowseLocal"); // NOI18N
        btnLocalDirectory.setPreferredSize(new java.awt.Dimension(140, 31));
        btnLocalDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalDirectoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(btnLocalDirectory, gridBagConstraints);

        btnIrodsDirectory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_144_folder_open.png"))); // NOI18N
        btnIrodsDirectory.setMnemonic('i');
        btnIrodsDirectory.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.btnBrowseIrodsResourcePath.text")); // NOI18N
        btnIrodsDirectory.setToolTipText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.btnBrowseIrodsResourcePath.toolTipText")); // NOI18N
        btnIrodsDirectory.setMaximumSize(null);
        btnIrodsDirectory.setMinimumSize(new java.awt.Dimension(140, 31));
        btnIrodsDirectory.setName("btnBrowseIrodsResourcePath"); // NOI18N
        btnIrodsDirectory.setPreferredSize(new java.awt.Dimension(140, 31));
        btnIrodsDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrodsDirectoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.8;
        jPanel1.add(btnIrodsDirectory, gridBagConstraints);

        comboSynchFrequency.setModel(new FrequencyTypeModel());
        comboSynchFrequency.setMinimumSize(null);
        comboSynchFrequency.setName("comboSynchronizationFrequency"); // NOI18N
        comboSynchFrequency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSynchFrequencyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.8;
        jPanel1.add(comboSynchFrequency, gridBagConstraints);

        jLabel4.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.lblChooseSynchronizationFrequency.text")); // NOI18N
        jLabel4.setName("lblChooseSynchronizationFrequency"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.8;
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.lblName.text")); // NOI18N
        jLabel5.setName("lblName"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        txtName.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.name.text")); // NOI18N
        txtName.setName("name"); // NOI18N
        txtName.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        jPanel1.add(txtName, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 4, 5));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_192_circle_remove.png"))); // NOI18N
        btnCancel.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.btnCancel.text")); // NOI18N
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 31));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_193_circle_ok.png"))); // NOI18N
        btnSave.setText(org.openide.util.NbBundle.getMessage(AddSynchronizationDialog.class, "AddSynchronizationDialog.btnSave.text")); // NOI18N
        btnSave.setMaximumSize(null);
        btnSave.setMinimumSize(null);
        btnSave.setName("btnSave"); // NOI18N
        btnSave.setPreferredSize(new java.awt.Dimension(100, 31));
        btnSave.setRolloverEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocalDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalDirectoryActionPerformed
        log.info("btnLocalDirectoryActionPerformed");

        final JFileChooser localFileChooser = new JFileChooser();
        localFileChooser.setMultiSelectionEnabled(false);
        localFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        localFileChooser.setDialogTitle("Select synchronization target");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int x = (toolkit.getScreenSize().width - localFileChooser
                .getWidth()) / 2;
        int y = (toolkit.getScreenSize().height - localFileChooser
                .getHeight()) / 2;
        localFileChooser.setLocation(x, y);
        final int returnVal = localFileChooser.showOpenDialog(this);

        final AddSynchronizationDialog dialog = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String localPath = localFileChooser.getSelectedFile()
                            .getAbsolutePath();
                    txtLocalPath.setText(MiscIRODSUtils.abbreviateFileName(localPath));
                    txtLocalPath.setToolTipText(localPath);
                    synchronization.setLocalSynchDirectory(localPath);
                }

            }
        });
    }//GEN-LAST:event_btnLocalDirectoryActionPerformed

    private void btnIrodsDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrodsDirectoryActionPerformed

        log.info("btnIrodsDirectoryActionPerformed");

        final AddSynchronizationDialog thisDialog = this;
        final IDROPCore thisIdropCore = idropCore;

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                IRODSFinderDialog irodsFinder = new IRODSFinderDialog(null, false,
                        thisIdropCore, thisIdropCore.irodsAccount());
                irodsFinder.setTitle("Select iRODS Collection Upload Target");
                irodsFinder
                        .setSelectionType(IRODSFinderDialog.SelectionType.COLLS_ONLY_SELECTION_MODE);
                irodsFinder.setLocation((int) thisDialog.getLocation().getX(), (int) thisDialog
                        .getLocation().getY());
                irodsFinder.setVisible(true);

                String selectedPath = irodsFinder.getSelectedAbsolutePath();
                if (selectedPath != null) {
                    txtIrodsPath.setText(MiscIRODSUtils.abbreviateFileName(selectedPath));
                    txtIrodsPath.setToolTipText(selectedPath);
                    synchronization.setIrodsSynchDirectory(selectedPath);
                }
            }
        });
    }//GEN-LAST:event_btnIrodsDirectoryActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        final AddSynchronizationDialog dialog = this;

        log.info("refreshing transfer table");

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                log.info("updating!");
                if (synchronization != null) {

                    synchronization.setSynchronizationMode(SynchronizationType.ONE_WAY_LOCAL_TO_IRODS);
                    synchronization.setFrequencyType((FrequencyType) comboSynchFrequency.getModel().getSelectedItem());

                    if (synchronization.getGridAccount() == null) {
                        log.info("no grid account, this is a new synch, use the present iRODS account ot set the the grid account");
                        try {
                            synchronization.setGridAccount(idropCore.getConveyorService().getGridAccountService().findGridAccountByIRODSAccount(idropCore.irodsAccount()));
                        } catch (ConveyorExecutionException ex) {
                            log.error("exception setting grid account", ex);
                            MessageManager.showError(dialog, ex.getMessage());
                        }
                    }

                    // source and target should be set, and are altered by using the lookup buttons and stored in the synchronization object, so i don't need
                    // to update them here
                    synchronization.setName(txtName.getText());
                    synchronization.setLocalSynchDirectory(txtLocalPath.getText());
                    synchronization.setIrodsSynchDirectory(txtIrodsPath.getText());
                    try {
                        idropCore.getConveyorService().getSynchronizationManagerService().addOrUpdateSynchronization(synchronization);
                        if (editMode) {
                            MessageManager.showMessage(dialog, "Synchronization updated");
                        } else {
                            MessageManager.showMessage(dialog, "Synchronization created");
                        }
                    } catch (ConveyorExecutionException ex) {
                        log.error("exception saving synchronization", ex);
                        MessageManager.showError(dialog, ex.getMessage());
                    }
                }
            }
        });
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        synchronization = null;
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void comboSynchFrequencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSynchFrequencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSynchFrequencyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnIrodsDirectory;
    private javax.swing.JButton btnLocalDirectory;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboSynchFrequency;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtIrodsPath;
    private javax.swing.JTextField txtLocalPath;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
