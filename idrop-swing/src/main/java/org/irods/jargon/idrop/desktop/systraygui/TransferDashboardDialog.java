/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.irods.jargon.conveyor.core.ConveyorBusyException;
import org.irods.jargon.conveyor.core.ConveyorExecutionException;
import static org.irods.jargon.idrop.desktop.systraygui.TransferDashboardDialog.log;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.DashboardLayoutService;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.DashboardAttempt;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.TransferDashboardLayout;
import org.irods.jargon.idrop.exceptions.IdropRuntimeException;
import org.irods.jargon.transfer.dao.domain.Transfer;
import org.openide.util.Exceptions;
import org.slf4j.LoggerFactory;

/**
 * @author Mike
 */
public class TransferDashboardDialog extends javax.swing.JDialog {

    public static org.slf4j.Logger log = LoggerFactory.getLogger(TransferDashboardDialog.class);
    protected final Transfer transfer;
    private final IDROPCore idropCore;

    /**
     * Creates new form TransferDashboardDialog
     */
    public TransferDashboardDialog(javax.swing.JDialog parent, Transfer transfer, IDROPCore idropCore) {
        super(parent, true);


        if (transfer == null) {
            throw new IllegalArgumentException("null transfer");
        }

        this.idropCore = idropCore;
        try {
            this.transfer = idropCore.getConveyorService().getQueueManagerService().initializeGivenTransferByLoadingChildren(transfer);
        } catch (ConveyorExecutionException ex) {
            MessageManager.showError(this, ex.getMessage());

            throw new IdropRuntimeException(ex);
        }

        initComponents();
        initData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBarTop = new javax.swing.JToolBar();
        btnRemoveSelected = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnCancel = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnRestartSelected = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnResubmitSelected = new javax.swing.JButton();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        jSeparator3 = new javax.swing.JToolBar.Separator();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnRefresh = new javax.swing.JButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        pnlDashboard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 700));

        toolBarTop.setFloatable(false);
        toolBarTop.setRollover(true);

        btnRemoveSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_191_circle_minus.png"))); // NOI18N
        btnRemoveSelected.setMnemonic('d');
        btnRemoveSelected.setText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnRemoveSelected.text")); // NOI18N
        btnRemoveSelected.setToolTipText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnRemoveSelected.toolTipText")); // NOI18N
        btnRemoveSelected.setEnabled(false);
        btnRemoveSelected.setFocusable(false);
        btnRemoveSelected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemoveSelected.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRemoveSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSelectedActionPerformed(evt);
            }
        });
        toolBarTop.add(btnRemoveSelected);
        toolBarTop.add(filler6);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_175_stop.png"))); // NOI18N
        btnCancel.setMnemonic('l');
        btnCancel.setText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnCancel.text")); // NOI18N
        btnCancel.setToolTipText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnCancel.toolTipText")); // NOI18N
        btnCancel.setEnabled(false);
        btnCancel.setFocusable(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        toolBarTop.add(btnCancel);
        toolBarTop.add(filler7);

        btnRestartSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_085_repeat.png"))); // NOI18N
        btnRestartSelected.setMnemonic('t');
        btnRestartSelected.setText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnRestartSelected.text")); // NOI18N
        btnRestartSelected.setToolTipText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnRestartSelected.toolTipText")); // NOI18N
        btnRestartSelected.setEnabled(false);
        btnRestartSelected.setFocusable(false);
        btnRestartSelected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRestartSelected.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRestartSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRestartSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartSelectedActionPerformed(evt);
            }
        });
        toolBarTop.add(btnRestartSelected);
        toolBarTop.add(filler8);

        btnResubmitSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_434_redo.png"))); // NOI18N
        btnResubmitSelected.setMnemonic('b');
        btnResubmitSelected.setText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnResubmitSelected.text")); // NOI18N
        btnResubmitSelected.setToolTipText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnResubmitSelected.toolTipText")); // NOI18N
        btnResubmitSelected.setEnabled(false);
        btnResubmitSelected.setFocusable(false);
        btnResubmitSelected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResubmitSelected.setPreferredSize(new java.awt.Dimension(80, 80));
        btnResubmitSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnResubmitSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResubmitSelectedActionPerformed(evt);
            }
        });
        toolBarTop.add(btnResubmitSelected);
        toolBarTop.add(filler9);
        toolBarTop.add(jSeparator3);
        toolBarTop.add(filler10);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_081_refresh.png"))); // NOI18N
        btnRefresh.setMnemonic('f');
        btnRefresh.setText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnRefresh.text")); // NOI18N
        btnRefresh.setToolTipText(org.openide.util.NbBundle.getMessage(TransferDashboardDialog.class, "TransferDashboardDialog.btnRefresh.toolTipText")); // NOI18N
        btnRefresh.setFocusable(false);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        toolBarTop.add(btnRefresh);
        toolBarTop.add(filler11);
        toolBarTop.add(filler13);

        getContentPane().add(toolBarTop, java.awt.BorderLayout.NORTH);

        pnlDashboard.setPreferredSize(new java.awt.Dimension(700, 400));
        pnlDashboard.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(pnlDashboard, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSelectedActionPerformed
        if (transfer != null) {
            try {
                idropCore.getConveyorService().getQueueManagerService().deleteTransferFromQueue(transfer);
            } catch (ConveyorBusyException ex) {
                Exceptions.printStackTrace(ex);
            } catch (ConveyorExecutionException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_btnRemoveSelectedActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if (transfer != null) {
            try {
                idropCore.getConveyorService().getQueueManagerService().cancelTransfer(transfer.getId());
            } catch (ConveyorBusyException ex) {
                log.error("Error restarting transfer: {}", ex.getMessage());
                MessageManager.showError(this,
                        "Transfer Queue Manager is currently busy. Please try again later.",
                        MessageManager.TITLE_MESSAGE);
            } catch (ConveyorExecutionException ex) {
                String msg = "Error cancelling transfer. ";
                log.error(msg + " {}", ex.getMessage());
                MessageManager.showError(this, msg, MessageManager.TITLE_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRestartSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartSelectedActionPerformed
        if (transfer != null) {
            try {
                idropCore.getConveyorService().getQueueManagerService().enqueueRestartOfTransferOperation(transfer.getId());
            } catch (ConveyorBusyException ex) {
                log.error("Error restarting transfer: {}", ex.getMessage());
                MessageManager.showError(this,
                        "Transfer Queue Manager is currently busy. Please try again later.",
                        MessageManager.TITLE_MESSAGE);
            } catch (ConveyorExecutionException ex) {
                String msg = "Error restarting transfer. Transfer may have already completed.";
                log.error(msg + " {}", ex.getMessage());
                MessageManager.showError(this, msg, MessageManager.TITLE_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRestartSelectedActionPerformed

    private void btnResubmitSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResubmitSelectedActionPerformed
        if (transfer != null) {
            try {
                idropCore.getConveyorService().getQueueManagerService().enqueueResubmitOfTransferOperation(transfer.getId());
            } catch (ConveyorBusyException ex) {
                log.error("Error resubmitting transfer: {}", ex.getMessage());
                MessageManager.showError(this,
                        "Transfer Queue Manager is currently busy. Please try again later.",
                        MessageManager.TITLE_MESSAGE);
            } catch (ConveyorExecutionException ex) {
                String msg = "Error resubmitting transfer. Transfer may have already completed.";
                log.error(msg + " {}", ex.getMessage());
                MessageManager.showError(this, msg, MessageManager.TITLE_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnResubmitSelectedActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // do something to refresh this stuff
    }//GEN-LAST:event_btnRefreshActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemoveSelected;
    private javax.swing.JButton btnRestartSelected;
    private javax.swing.JButton btnResubmitSelected;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPanel pnlDashboard;
    private javax.swing.JToolBar toolBarTop;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        log.info("initData()");
        log.info("making sure transfer attemtps are expanded...");
        buildDashboardForTransfer();

    }

    private void buildDashboardForTransfer() {

        final TransferDashboardDialog dialog = this;


        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyPanel myPanel = new MyPanel(transfer);
                myPanel.setSize(800, 600);
                myPanel.setBackground(Color.WHITE);
                pnlDashboard.add(myPanel);
                dialog.repaint();
            }
        });
    }
}

class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

    private Transfer transfer;
    private List<AttemptRectangle> rectangles = new ArrayList<AttemptRectangle>();

    public MyPanel(Transfer transfer) {
        this.transfer = transfer;
        setBackground(Color.white);
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    protected void paintComponent(Graphics g) {
        log.info("getting layout info for dashboard");
        TransferDashboardLayout layout = DashboardLayoutService.layoutDashboard(transfer);
        log.info("layout:{}", layout);

        Graphics2D g2 = (Graphics2D) g;

        int nextX = 0;
        int nextY = 0;

        int width = this.getWidth();
        int height = this.getHeight();

        for (DashboardAttempt attempt : layout.getDashboardAttempts()) {
            // set fill grey for skipped
            g2.setColor(Color.BLUE);

            int widthThisBar = Math.round(width * (float) (attempt.getPercentWidth() / 100));

            int heightSkipped = 0;
            int heightTransferred = 0;
            int heightError = 0;
            nextY = height;

            if (attempt.getPercentHeightSkipped() > 0) {

                heightSkipped = Math.round(height * (float) (attempt.getPercentHeightSkipped() / 100));

                if (heightSkipped == 0) {
                    heightSkipped = 2;
                }

                Rectangle skippedRectangle = new Rectangle(nextX, nextY - heightSkipped, widthThisBar, heightSkipped);
                AttemptRectangle attemptRectangle = new AttemptRectangle();

                attemptRectangle.setShape(skippedRectangle);
                attemptRectangle.setDashboardAttempt(attempt);
                attemptRectangle.setType(AttemptRectangle.Type.SKIPPED);
                rectangles.add(attemptRectangle);

                g2.fill(skippedRectangle);


                nextY -= heightSkipped;
            }


            if (attempt.getPercentHeightTransferred() > 0) {
                g2.setColor(Color.GREEN);
                heightTransferred = Math.round(height * (float) (attempt.getPercentHeightTransferred() / 100));

                if (heightTransferred == 0) {
                    heightTransferred = 2;
                }


                Rectangle transferredRectangle = new Rectangle(nextX, nextY - heightTransferred, widthThisBar, heightTransferred);
                AttemptRectangle attemptRectangle = new AttemptRectangle();

                attemptRectangle.setShape(transferredRectangle);
                attemptRectangle.setDashboardAttempt(attempt);
                attemptRectangle.setType(AttemptRectangle.Type.TRANSFERRED);
                rectangles.add(attemptRectangle);

                g2.fill(transferredRectangle);

                nextY -= heightTransferred;

            }

            if (attempt.getPercentHeightError() > 0) {

                g2.setColor(Color.RED);
                heightError = Math.round(height * (float) (attempt.getPercentHeightError() / 100));

                if (heightError == 0) {
                    heightError = 2;
                }

                Rectangle errorRectangle = new Rectangle(nextX, nextY - heightError, widthThisBar, heightError);
                AttemptRectangle attemptRectangle = new AttemptRectangle();

                attemptRectangle.setShape(errorRectangle);
                attemptRectangle.setDashboardAttempt(attempt);
                attemptRectangle.setType(AttemptRectangle.Type.ERROR);
                rectangles.add(attemptRectangle);

                g2.fill(errorRectangle);


            }

            nextX += widthThisBar;

        }



    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
     
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
           if (this.rectangles == null) {
            return;
        }
        
        log.info("point entered:{}", me.getPoint());
        
        for (AttemptRectangle attemptRectangle : rectangles) {
            if (attemptRectangle.contains(me.getPoint())) {
                log.info("contains the rectangle for:{}", attemptRectangle);
                break;
            }
        }
    }
}

class AttemptRectangle {

    public enum Type {

        TRANSFERRED, SKIPPED, ERROR
    }
    private Rectangle2D shape;
    private DashboardAttempt dashboardAttempt;
    private Type type;

    public Rectangle2D getShape() {
        return shape;
    }

    public void setShape(Rectangle2D shape) {
        this.shape = shape;
    }

    public DashboardAttempt getDashboardAttempt() {
        return dashboardAttempt;
    }

    public void setDashboardAttempt(DashboardAttempt dashboardAttempt) {
        this.dashboardAttempt = dashboardAttempt;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
    public boolean contains(Point point) {
        
        boolean contains = false;
        if (this.shape.contains(point.x, point.y)) {
            contains = true;
        }
        
        return contains;
        
    }
}
