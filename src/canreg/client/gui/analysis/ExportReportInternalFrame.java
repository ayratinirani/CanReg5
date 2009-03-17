/*
 * ExportFrame.java
 *
 * Created on 28 February 2008, 14:12
 */
package canreg.client.gui.analysis;

import cachingtableapi.DistributedTableDescription;
import cachingtableapi.DistributedTableModel;
import canreg.client.CanRegClientApp;
import canreg.client.DistributedTableDataSourceClient;
import canreg.client.LocalSettings;
import canreg.client.gui.tools.XTableColumnModel;
import canreg.common.DatabaseFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import javax.swing.table.TableColumn;
import org.jdesktop.application.Task;
import org.jdesktop.application.Action;

/**
 *
 * @author  morten
 */
public class ExportReportInternalFrame extends javax.swing.JInternalFrame implements ActionListener {

    private JDesktopPane dtp;
    private DistributedTableDescription tableDatadescription;
    private DistributedTableDataSourceClient tableDataSource;
    private DistributedTableModel tableDataModel;
    private JScrollPane resultScrollPane;
    private JTable resultTable = new JTable();
    ;
    private JFileChooser chooser;
    private String path;
    private LocalSettings localSettings;
    private LinkedList<String> variablesToShow;
    private XTableColumnModel tableColumnModel;

    /** Creates new form ExportFrame
     * @param dtp is a pointer to the current desktop pane.
     */
    public ExportReportInternalFrame(JDesktopPane dtp) {
        initComponents();
        this.dtp = dtp;
        localSettings = CanRegClientApp.getApplication().getLocalSettings();
        initOtherComponents();
        initValues();
    }

    /**
     * 
     * @param dtp
     */
    public void setDeskTopPane(JDesktopPane dtp) {
        this.dtp = dtp;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settingsPanel = new javax.swing.JPanel();
        setupPanel = new javax.swing.JPanel();
        loadSetupButton = new javax.swing.JButton();
        saveSetupButton = new javax.swing.JButton();
        optionsPanel = new javax.swing.JPanel();
        headingCheckBox = new javax.swing.JCheckBox();
        variableNamesComboBox = new javax.swing.JComboBox();
        variableNamesLabel = new javax.swing.JLabel();
        fileFormatLabel = new javax.swing.JLabel();
        fileFormatComboBox = new javax.swing.JComboBox();
        formatDateCheckBox = new javax.swing.JCheckBox();
        correctUnknownCheckBox = new javax.swing.JCheckBox();
        exportPanel = new javax.swing.JPanel();
        writeFileButton = new javax.swing.JButton();
        resultPanel = new javax.swing.JPanel();
        variableChooserPanel = new canreg.client.gui.components.VariablesChooserPanel();
        rangeFilterPanel = new canreg.client.gui.components.RangeFilterPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(ExportReportInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setDoubleBuffered(true);
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        settingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("settingsPanel.border.title"))); // NOI18N
        settingsPanel.setName("settingsPanel"); // NOI18N

        setupPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("setupPanel.border.title"))); // NOI18N
        setupPanel.setName("setupPanel"); // NOI18N

        loadSetupButton.setText(resourceMap.getString("loadSetupButton.text")); // NOI18N
        loadSetupButton.setName("loadSetupButton"); // NOI18N

        saveSetupButton.setText(resourceMap.getString("saveSetupButton.text")); // NOI18N
        saveSetupButton.setName("saveSetupButton"); // NOI18N

        javax.swing.GroupLayout setupPanelLayout = new javax.swing.GroupLayout(setupPanel);
        setupPanel.setLayout(setupPanelLayout);
        setupPanelLayout.setHorizontalGroup(
            setupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupPanelLayout.createSequentialGroup()
                .addComponent(loadSetupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveSetupButton))
        );
        setupPanelLayout.setVerticalGroup(
            setupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(loadSetupButton)
                .addComponent(saveSetupButton))
        );

        optionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("optionsPanel.border.title"))); // NOI18N
        optionsPanel.setName("optionsPanel"); // NOI18N

        headingCheckBox.setText(resourceMap.getString("headingCheckBox.text")); // NOI18N
        headingCheckBox.setName("headingCheckBox"); // NOI18N

        variableNamesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Short", "English", "User" }));
        variableNamesComboBox.setName("variableNamesComboBox"); // NOI18N

        variableNamesLabel.setText(resourceMap.getString("variableNamesLabel.text")); // NOI18N
        variableNamesLabel.setName("variableNamesLabel"); // NOI18N

        fileFormatLabel.setText(resourceMap.getString("fileFormatLabel.text")); // NOI18N
        fileFormatLabel.setName("fileFormatLabel"); // NOI18N

        fileFormatComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tab Separated Values", "Comma Separated" }));
        fileFormatComboBox.setName("fileFormatComboBox"); // NOI18N

        formatDateCheckBox.setSelected(true);
        formatDateCheckBox.setText(resourceMap.getString("formatDateCheckBox.text")); // NOI18N
        formatDateCheckBox.setName("formatDateCheckBox"); // NOI18N

        correctUnknownCheckBox.setSelected(true);
        correctUnknownCheckBox.setText(resourceMap.getString("correctUnknownCheckBox.text")); // NOI18N
        correctUnknownCheckBox.setName("correctUnknownCheckBox"); // NOI18N

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headingCheckBox)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(variableNamesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(variableNamesLabel))
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(fileFormatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fileFormatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(formatDateCheckBox)
                    .addComponent(correctUnknownCheckBox))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addComponent(headingCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(variableNamesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(variableNamesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileFormatLabel)
                    .addComponent(fileFormatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatDateCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(correctUnknownCheckBox))
        );

        exportPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("exportPanel.border.title"))); // NOI18N
        exportPanel.setName("exportPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(ExportReportInternalFrame.class, this);
        writeFileButton.setAction(actionMap.get("writeFileAction")); // NOI18N
        writeFileButton.setName("writeFileButton"); // NOI18N

        javax.swing.GroupLayout exportPanelLayout = new javax.swing.GroupLayout(exportPanel);
        exportPanel.setLayout(exportPanelLayout);
        exportPanelLayout.setHorizontalGroup(
            exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(writeFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        exportPanelLayout.setVerticalGroup(
            exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(writeFileButton)
        );

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addComponent(setupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportPanel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(setupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        resultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("resultPanel.border.title"))); // NOI18N
        resultPanel.setName("resultPanel"); // NOI18N

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 944, Short.MAX_VALUE)
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        variableChooserPanel.setName("variableChooserPanel"); // NOI18N

        rangeFilterPanel.setName("rangeFilterPanel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resultPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rangeFilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(variableChooserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rangeFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(variableChooserPanel, 0, 0, Short.MAX_VALUE)
                    .addComponent(settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rangeFilterPanel.setDeskTopPane(dtp);
        rangeFilterPanel.initValues();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox correctUnknownCheckBox;
    private javax.swing.JPanel exportPanel;
    private javax.swing.JComboBox fileFormatComboBox;
    private javax.swing.JLabel fileFormatLabel;
    private javax.swing.JCheckBox formatDateCheckBox;
    private javax.swing.JCheckBox headingCheckBox;
    private javax.swing.JButton loadSetupButton;
    private javax.swing.JPanel optionsPanel;
    private canreg.client.gui.components.RangeFilterPanel rangeFilterPanel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JButton saveSetupButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel setupPanel;
    private canreg.client.gui.components.VariablesChooserPanel variableChooserPanel;
    private javax.swing.JComboBox variableNamesComboBox;
    private javax.swing.JLabel variableNamesLabel;
    private javax.swing.JButton writeFileButton;
    // End of variables declaration//GEN-END:variables
    /**
     * 
     * @return
     */
    public JDesktopPane getDtp() {
        return dtp;
    }

    private void initValues() {
        variableChooserPanel.initPanel();
        rangeFilterPanel.setDeskTopPane(dtp);
        rangeFilterPanel.setActionListener(this);
    }

    private void initOtherComponents() {

        resultScrollPane = canreg.common.LazyViewport.createLazyScrollPaneFor(resultTable);

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
                resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(resultScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE));
        resultPanelLayout.setVerticalGroup(
                resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(resultScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE));

        resultScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        resultTable.setColumnSelectionAllowed(true);
        resultPanel.setVisible(false);

        resultTable.setName("resultTable"); // NOI18N
        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // rowClicked(evt);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // columnTableMousePressed(evt);
            }
        });

        path = localSettings.getProperty("export_data_path");

        if (path == null) {
            chooser = new JFileChooser();
        } else {
            chooser = new JFileChooser(path);
        }
    }

    /**
     * 
     * @return
     */
    @Action
    public Task refresh() {
        // navigationPanel.goToTopAction();
        resultPanel.setVisible(false);
        return new RefreshTask(org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class RefreshTask extends org.jdesktop.application.Task<Object, Void> {

        String tableName = null;
        DatabaseFilter filter = new DatabaseFilter();

        RefreshTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to RefreshTask fields, here.
            super(app);
            tableName = rangeFilterPanel.getSelectedTable();
            filter.setFilterString(rangeFilterPanel.getFilter().trim());
            variablesToShow = variableChooserPanel.getSelectedVariableNames(tableName);

            filter.setFilterString(rangeFilterPanel.getFilter().trim());
            filter.setSortByVariable(rangeFilterPanel.getSortByVariable().trim());

            tableDataSource = null;
        }

        @Override
        protected Object doInBackground() {
            try {
                setProgress(0, 0, 4);
                setMessage("Initiating query...");
                setProgress(1, 0, 4);

                tableDatadescription = canreg.client.CanRegClientApp.getApplication().getDistributedTableDescription(filter, tableName);

                tableDataSource = new DistributedTableDataSourceClient(tableDatadescription);
                tableDataModel = new DistributedTableModel(tableDataSource);
                setProgress(2, 0, 4);

                setMessage("Starting a new transaction...");
                rangeFilterPanel.setRecordsShown(tableDataModel.getRowCount());

                setProgress(3, 0, 4);

                setMessage("Fetching data...");
                resultTable.setModel(tableDataModel);
                resultTable.setColumnSelectionAllowed(false);

                tableColumnModel = new XTableColumnModel();
                resultTable.setColumnModel(tableColumnModel);
                resultTable.createDefaultColumnsFromModel();
                updateVariablesShown();

                setProgress(4, 0, 4);
                setMessage("Finished");

            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(rootPane, "Not a valid filter.", "Error", JOptionPane.ERROR_MESSAGE);
                return "Not valid";
            } catch (RemoteException ex) {
                Logger.getLogger(ExportReportInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(ExportReportInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ignore) {
            } catch (Exception ex) {
                Logger.getLogger(ExportReportInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "OK";
        }

        @Override
        protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
            boolean theResult = result.equals("OK");
            // resultTable.setAutoResizeMode (JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
            resultPanel.setVisible(theResult);

        }
    }

    private void updateVariablesShown() {
        String tableName = rangeFilterPanel.getSelectedTable();
        variablesToShow = variableChooserPanel.getSelectedVariableNames(tableName);
        // first set all invisible
        Enumeration<TableColumn> tcs = tableColumnModel.getColumns(false);
        while (tcs.hasMoreElements()) {
            TableColumn column = tcs.nextElement();
            tableColumnModel.setColumnVisible(column, variablesToShow.contains(column.getHeaderValue().toString()));
        }
    }

    public void actionPerformed(ActionEvent e) {
        if ("refresh".equalsIgnoreCase(e.getActionCommand())) {
            Task refreshTask = refresh();
            refreshTask.execute();
        }
    }

    /**
     * 
     * @return
     */
    @Action
    public Task writeFileAction() {
        // Get filename
        int returnVal = chooser.showSaveDialog(this);
        String fileName = "";
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                //set the file name
                fileName = chooser.getSelectedFile().getCanonicalPath();
                File file = new File(fileName);
                if (file.exists()) {
                    int choice = JOptionPane.showInternalConfirmDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "File exists: " + fileName + ".\n Overwrite?", "File exists.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (choice == JOptionPane.CANCEL_OPTION) {
                        return null;
                    } else if (choice == JOptionPane.NO_OPTION) {
                        // choose a new file
                        writeFileAction();
                        return null;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ExportReportInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new WriteFileActionTask(fileName, org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class WriteFileActionTask extends org.jdesktop.application.Task<Object, Void> {

        BufferedWriter bw;
        int rowCount;
        int columnCount;
        private String separatingString;

        WriteFileActionTask(String fileName, org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to WriteFileActionTask fields, here.
            super(app);
            writeFileButton.setEnabled(false);
            // refresh the table if necessary
            if (!resultPanel.isVisible()){
                Task refresher = refresh();
                refresher.execute();
                while(!refresher.isDone()){
                    // wait 
                }
            }
            
            // Lock the table
            resultPanel.setVisible(false);
            rangeFilterPanel.setRefreshButtonEnabled(false);
            
            
            if (fileFormatComboBox.getSelectedIndex() == 1) {
                separatingString = ",";
            } else {
                separatingString = "\t";
            }

            try {
                File file = new File(fileName);
                localSettings.setProperty("export_data_path", file.getParent());
                bw = new BufferedWriter(new FileWriter(file));
                rowCount = resultTable.getRowCount();
                columnCount = resultTable.getColumnCount();
            } catch (IOException ex) {
                Logger.getLogger(ExportReportInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected Object doInBackground() {
            // Your Task's code here.  This method runs
            // on a background thread, so don't reference
            // the Swing GUI from here.

            // Here we do indeed reference the jtable. However as long as the user does not move the columns it should be ok...
            // TODO: reference the data source instead of the resultTable!
            
            String line = "";

            try {
                for (int column = 0; column < columnCount; column++) {
                    line += resultTable.getColumnName(column);
                    boolean last = (column == columnCount - 1);
                    if (!last) {
                        line += separatingString;
                    }
                }
                bw.write(line + "\n");
                line = "";
                for (int row = 0; row < rowCount; row++) {
                    for (int column = 0; column < columnCount; column++) {
                        line += resultTable.getValueAt(row, column);
                        boolean last = (column == columnCount - 1);
                        if (!last) {
                            line += separatingString;
                        }
                    }
                    setProgress(100 * row / rowCount);
                    bw.write(line + "\n");
                    line = "";
                }
            } catch (IOException ex) {
                Logger.getLogger(ExportReportInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;  // return your result
        }

        @Override
        protected void succeeded(Object result) {
            try {
                // Runs on the EDT.  Update the GUI based on
                // the result computed by doInBackground().
                bw.flush();
                bw.close();
                
                rangeFilterPanel.setRefreshButtonEnabled(true);
                resultPanel.setVisible(true);
                writeFileButton.setEnabled(true);

                localSettings.writeSettings();

            } catch (IOException ex) {
                Logger.getLogger(ExportReportInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
