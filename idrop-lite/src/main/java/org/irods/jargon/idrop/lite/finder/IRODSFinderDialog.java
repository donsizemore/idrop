package org.irods.jargon.idrop.lite.finder;

import java.awt.Dimension;

import javax.swing.ListSelectionModel;
import org.irods.jargon.core.query.CollectionAndDataObjectListingEntry;
import org.irods.jargon.idrop.lite.IdropRuntimeException;
import org.irods.jargon.idrop.lite.iDropLiteCore;
import org.irods.jargon.idrop.lite.IRODSFileSystemModel;
import org.irods.jargon.idrop.lite.IRODSNode;
import org.irods.jargon.idrop.lite.IRODSRowModel;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mikeconway
 */
public class IRODSFinderDialog extends javax.swing.JDialog {
    
    private final iDropLiteCore idropCore;
    private  String selectedAbsolutePath = null;

    public String getSelectedAbsolutePath() {
        return selectedAbsolutePath;
    }

    public iDropLiteCore getIdropCore() {
        return idropCore;
    }

    public IRODSFinderTree getIrodsTree() {
        return irodsTree;
    }
     private static final org.slf4j.Logger log = LoggerFactory.getLogger(IRODSFinderDialog.class);
     private IRODSFinderTree irodsTree = null;

    /** Creates new form IRODSFinderDialog */
    public IRODSFinderDialog(boolean modal, iDropLiteCore idropCore) {
        //super(parent, modal);
    	super((java.awt.Frame)null, modal);
        
        if (idropCore == null) {
            throw new IllegalArgumentException("null idropCore");
        }
        
        this.setTitle("Import Location");
        this.idropCore = idropCore;
        initComponents();
        buildTargetTree();
    }
    
     /**
     * build the JTree that will depict the iRODS resource
     */
    public void buildTargetTree() {
        log.info("building tree to look at staging resource");
        final IRODSFinderDialog gui = this;

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

               
                CollectionAndDataObjectListingEntry root = new CollectionAndDataObjectListingEntry();

//			Change to start at root for finder dialog - requested in GForge tracker # 484
//          changing this back again to how it was before - GForge tracker #484 was apparently wrong
//                if (idropCore.getIdropConfig().isLoginPreset()) {
                    log.info("using policy preset home directory");
                    StringBuilder sb = new StringBuilder();
                    sb.append("/");
                    sb.append(idropCore.getIrodsAccount().getZone());
                    sb.append("/");
                    sb.append("home");
                    root.setParentPath(sb.toString());
                    root.setPathOrName(idropCore.getIrodsAccount().getHomeDirectory());
//                } else {
//                    log.info("using root path, no login preset");
//                    root.setPathOrName("/");
//                }

                log.info("building new iRODS tree");
                try {
                    if (irodsTree == null) {
                        irodsTree = new IRODSFinderTree(gui);
                        IRODSNode rootNode = new IRODSNode(root,
                                idropCore.getIrodsAccount(), idropCore.getIrodsFileSystem(), irodsTree);
                        irodsTree.setRefreshingTree(true);
                        // irodsTree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
                    }
                    IRODSNode rootNode = new IRODSNode(root, idropCore.getIrodsAccount(),
                            idropCore.getIrodsFileSystem(), irodsTree);

                    IRODSFileSystemModel irodsFileSystemModel = new IRODSFileSystemModel(
                            rootNode, idropCore.getIrodsAccount());
                    IRODSFinderOutlineModel mdl = new IRODSFinderOutlineModel(idropCore, irodsTree,
                            irodsFileSystemModel, new IRODSRowModel(), true,
                            "File System");
                    irodsTree.setModel(mdl);

                   
                } catch (Exception ex) {
                   log.error("exception building finder tree", ex);
                    throw new IdropRuntimeException(ex);
                } finally {
                     idropCore.getIrodsFileSystem().closeAndEatExceptions(
                        idropCore.getIrodsAccount());
                }

                scrollIrodsTree.setViewportView(irodsTree);
                scrollIrodsTree.validate();
                gui.validate();
              
                irodsTree.setRefreshingTree(false);

            }
        });
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        treePanel = new javax.swing.JPanel();
        pnlIrodsTreeToolbar = new javax.swing.JPanel();
        btnRefreshTargetTree = new javax.swing.JButton();
        pnlIrodsTreeMaster = new javax.swing.JPanel();
        scrollIrodsTree = new javax.swing.JScrollPane();
        bottomPanel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnSelectFolder = new javax.swing.JButton();
        lblInstruct = new javax.swing.JLabel();
        westPanel = new javax.swing.JPanel();
        eastPanel = new javax.swing.JPanel();
        
        bottomPanel.setMinimumSize(new Dimension(100,40));
        bottomPanel.setPreferredSize(new Dimension(100,40));
        bottomPanel.setLayout(new java.awt.BorderLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);;

        treePanel.setLayout(new java.awt.BorderLayout());

        btnRefreshTargetTree.setMnemonic('r');
        btnRefreshTargetTree.setText(org.openide.util.NbBundle.getMessage(IRODSFinderDialog.class, "IRODSFinderDialog.btnRefreshTargetTree.text")); // NOI18N
        btnRefreshTargetTree.setToolTipText(org.openide.util.NbBundle.getMessage(IRODSFinderDialog.class, "IRODSFinderDialog.btnRefreshTargetTree.toolTipText")); // NOI18N
        btnRefreshTargetTree.setFocusable(false);
        btnRefreshTargetTree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefreshTargetTree.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefreshTargetTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTargetTreeActionPerformed(evt);
            }
        });
        
        pnlIrodsTreeToolbar.setMinimumSize(new Dimension(100, 30));
        pnlIrodsTreeToolbar.setPreferredSize(new Dimension(100, 30));
        pnlIrodsTreeToolbar.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 0));
        pnlIrodsTreeToolbar.setLayout(new java.awt.BorderLayout());
        lblInstruct.setText(org.openide.util.NbBundle.getMessage(IRODSFinderDialog.class, "IRODSFinderDialog.lblInstruct.text")); // NOI18N
        pnlIrodsTreeToolbar.add(lblInstruct, java.awt.BorderLayout.WEST);
        //pnlIrodsTreeToolbar.add(btnRefreshTargetTree);

        treePanel.add(pnlIrodsTreeToolbar, java.awt.BorderLayout.NORTH);

        pnlIrodsTreeMaster.setLayout(new java.awt.BorderLayout());

        scrollIrodsTree.setMinimumSize(null);
        scrollIrodsTree.setPreferredSize(null);
        pnlIrodsTreeMaster.add(scrollIrodsTree, java.awt.BorderLayout.CENTER);

        treePanel.add(pnlIrodsTreeMaster, java.awt.BorderLayout.CENTER);

        getContentPane().add(treePanel, java.awt.BorderLayout.CENTER);

        westPanel.setPreferredSize(new Dimension(100,40));
        westPanel.add(btnRefreshTargetTree);
        
        btnCancel.setMnemonic('c');
        btnCancel.setText(org.openide.util.NbBundle.getMessage(IRODSFinderDialog.class, "IRODSFinderDialog.btnCancel.text")); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        eastPanel.setPreferredSize(new Dimension(200,40));
        eastPanel.add(btnCancel);

        btnSelectFolder.setMnemonic('s');
        btnSelectFolder.setText(org.openide.util.NbBundle.getMessage(IRODSFinderDialog.class, "IRODSFinderDialog.btnSelectFolder.text")); // NOI18N
        btnSelectFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFolderActionPerformed(evt);
            }
        });
        eastPanel.add(btnSelectFolder);
        
        bottomPanel.add(westPanel, java.awt.BorderLayout.WEST);
        bottomPanel.add(eastPanel, java.awt.BorderLayout.EAST);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshTargetTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTargetTreeActionPerformed
       buildTargetTree();
    }//GEN-LAST:event_btnRefreshTargetTreeActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.selectedAbsolutePath = null;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSelectFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFolderActionPerformed
        
        IRODSFinderOutlineModel irodsFileSystemModel = (IRODSFinderOutlineModel) irodsTree.getModel();
        

        ListSelectionModel selectionModel = irodsTree.getSelectionModel();
        int idx = selectionModel.getLeadSelectionIndex();
        
        if (idx == -1) {
            MessageManager.showWarning(this, "Please select a directory", MessageManager.TITLE_MESSAGE);
            return;

}

        // use first selection for info
        IRODSNode selectedNode = (IRODSNode) irodsFileSystemModel.getValueAt(
                idx, 0);
        log.info("selected node:{}", selectedNode);
        CollectionAndDataObjectListingEntry entry = (CollectionAndDataObjectListingEntry) selectedNode.getUserObject();
        if (entry.getObjectType() == CollectionAndDataObjectListingEntry.ObjectType.DATA_OBJECT) {
              MessageManager.showWarning(this, "Please select a directory", MessageManager.TITLE_MESSAGE);
            return;
        }
        
       this.selectedAbsolutePath = entry.getPathOrName();
       //this.selectedAbsolutePath = entry.getFormattedAbsolutePath();
       this.setVisible(false);
        
    }//GEN-LAST:event_btnSelectFolderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefreshTargetTree;
    private javax.swing.JButton btnSelectFolder;
    private javax.swing.JPanel pnlIrodsTreeMaster;
    private javax.swing.JPanel pnlIrodsTreeToolbar;
    private javax.swing.JScrollPane scrollIrodsTree;
    private javax.swing.JPanel treePanel;
    private javax.swing.JLabel lblInstruct;
    private javax.swing.JPanel westPanel;
    private javax.swing.JPanel eastPanel;
    // End of variables declaration//GEN-END:variables

}
