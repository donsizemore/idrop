/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.Cursor;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.TreePath;
import org.irods.jargon.core.pub.CollectionAndDataObjectListAndSearchAO;
import org.irods.jargon.core.query.CollectionAndDataObjectListingEntry;
import org.irods.jargon.idrop.desktop.systraygui.utils.TreeUtils;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.IRODSNode;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.IRODSOutlineModel;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.IRODSSearchTableModel;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.IRODSTree;
import org.irods.jargon.idrop.exceptions.IdropException;
import org.openide.util.Exceptions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lisa
 */
public class SearchResultsDialog extends javax.swing.JDialog implements ListSelectionListener {
    
    private iDrop idropGui;
    private IRODSTree irodsTree;
    private IRODSOutlineModel irodsFileSystemModel;
    private String searchText;
    public static org.slf4j.Logger log = LoggerFactory.getLogger(IRODSTree.class);

    /**
     * Creates new form SearchResultsDialog
     */
    public SearchResultsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public SearchResultsDialog(final iDrop parent, final boolean modal,
            final IRODSTree irodsTree, final String searchText) {
        super(parent, modal);
        initComponents();
        
        this.idropGui = parent;
        this.irodsTree = irodsTree;
        this.searchText = searchText;
        this.irodsFileSystemModel = (IRODSOutlineModel) irodsTree.getModel();
        
        initSearchResults();
    }
    
    private void initSearchResults() {
        final String searchTerms = searchText.trim();

        tableSearchResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);            
        ListSelectionModel listSelectionModel = tableSearchResults.getSelectionModel();
        listSelectionModel.addListSelectionListener(this);
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {
                    idropGui.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    CollectionAndDataObjectListAndSearchAO collectionAndDataObjectListAndSearchAO =
                            idropGui.getiDropCore().getIRODSAccessObjectFactory().getCollectionAndDataObjectListAndSearchAO(
                            idropGui.getiDropCore().getIrodsAccount());
                    IRODSSearchTableModel irodsSearchTableModel = new IRODSSearchTableModel(
                            collectionAndDataObjectListAndSearchAO.searchCollectionsAndDataObjectsBasedOnName(searchTerms));
                    tableSearchResults.setModel(irodsSearchTableModel);
                    //tabIrodsViews.setSelectedComponent(pnlTabSearch);
                } catch (Exception e) {
                    idropGui.showIdropException(e);
                    return;
                } finally {
                    idropGui.getiDropCore().closeAllIRODSConnections();
                    idropGui.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });
    }
    
    
    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if (lse.getValueIsAdjusting())
            return;
     
        int row = tableSearchResults.getSelectedRow();
        
        CollectionAndDataObjectListingEntry.ObjectType objType =
                (CollectionAndDataObjectListingEntry.ObjectType) tableSearchResults.getValueAt(row, 0);
        String selectedParent = (String) tableSearchResults.getValueAt(row, 1);
        String selectedName = (String) tableSearchResults.getValueAt(row, 2);
        if (selectedParent != null && selectedName != null) {

            log.info("selected returned search result: {}", selectedParent + "/" + selectedName);
        
            CollectionAndDataObjectListingEntry entry = new CollectionAndDataObjectListingEntry();
            entry.setObjectType(objType);
            entry.setParentPath(selectedParent);
            entry.setPathOrName(selectedName);
            
            TreePath path = null;
            try {
                path = TreeUtils.buildTreePathForIrodsAbsolutePath(irodsTree, selectedParent + "/" + selectedName);
            } catch (IdropException ex) {
                Exceptions.printStackTrace(ex);
            }

            if (path != null) {
                irodsTree.expandPath(path);
                java.awt.Rectangle rect = irodsTree.getPathBounds(path);
                if (rect != null) {
                    irodsTree.scrollRectToVisible(rect);
                }
            }
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
        pnlTabSearch = new javax.swing.JPanel();
        pnlTabSearchTop = new javax.swing.JPanel();
        pnlTabSearchResults = new javax.swing.JPanel();
        scrollPaneSearchResults = new javax.swing.JScrollPane();
        tableSearchResults = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnDismiss = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(SearchResultsDialog.class, "SearchResultsDialog.title")); // NOI18N

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlTabSearch.setToolTipText(org.openide.util.NbBundle.getMessage(SearchResultsDialog.class, "SearchResultsDialog.pnlTabSearch.toolTipText")); // NOI18N
        pnlTabSearch.setLayout(new java.awt.BorderLayout());
        pnlTabSearch.add(pnlTabSearchTop, java.awt.BorderLayout.NORTH);

        pnlTabSearchResults.setLayout(new java.awt.GridLayout());

        tableSearchResults.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPaneSearchResults.setViewportView(tableSearchResults);

        pnlTabSearchResults.add(scrollPaneSearchResults);

        pnlTabSearch.add(pnlTabSearchResults, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlTabSearch, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(661, 50));

        btnDismiss.setLabel(org.openide.util.NbBundle.getMessage(SearchResultsDialog.class, "SearchResultsDialog.btnDismiss.label")); // NOI18N
        btnDismiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDismissActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(528, Short.MAX_VALUE)
                .add(btnDismiss)
                .add(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(btnDismiss)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDismissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDismissActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDismissActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDismiss;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlTabSearch;
    private javax.swing.JPanel pnlTabSearchResults;
    private javax.swing.JPanel pnlTabSearchTop;
    private javax.swing.JScrollPane scrollPaneSearchResults;
    private javax.swing.JTable tableSearchResults;
    // End of variables declaration//GEN-END:variables

}
