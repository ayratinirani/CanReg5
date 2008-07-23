/*
 * FastFilterInternalFrame.java
 *
 * Created on 29 February 2008, 14:44
 */
package canreg.client.gui;

import canreg.client.gui.components.RangeFilterPanel;
import canreg.common.DatabaseVariablesListElement;
import canreg.common.Globals;
import canreg.server.database.DictionaryEntry;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.w3c.dom.Document;

/**
 *
 * @author  morten
 */
public class FastFilterInternalFrame extends javax.swing.JInternalFrame {

    private RangeFilterPanel parentFilterPanel;
    private DatabaseVariablesListElement[] variablesInTable;
    private Document doc;
    private String tableName = "both";
    private HashMap<Integer, HashMap<String, String>> dictionary;
    private DictionaryEntry[] possibleValues;

    /** Creates new form FastFilterInternalFrame */
    public FastFilterInternalFrame(RangeFilterPanel parentFilterPanel) {
        this.parentFilterPanel = parentFilterPanel;
        initComponents();
        initValues();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        instructionLabel1 = new javax.swing.JLabel();
        instructionLabel2 = new javax.swing.JLabel();
        variableComboBox = new javax.swing.JComboBox();
        operationComboBox = new javax.swing.JComboBox();
        valueTextField = new javax.swing.JTextField();
        logicalOperatorComboBox = new javax.swing.JComboBox();
        variableLabel = new javax.swing.JLabel();
        operationLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        filterPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(FastFilterInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setName("jPanel1"); // NOI18N

        instructionLabel1.setText(resourceMap.getString("instructionLabel1.text")); // NOI18N
        instructionLabel1.setName("instructionLabel1"); // NOI18N

        instructionLabel2.setText(resourceMap.getString("instructionLabel2.text")); // NOI18N
        instructionLabel2.setName("instructionLabel2"); // NOI18N

        variableComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(FastFilterInternalFrame.class, this);
        variableComboBox.setAction(actionMap.get("varibleChosenAction")); // NOI18N
        variableComboBox.setName("variableComboBox"); // NOI18N

        operationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        operationComboBox.setName("operationComboBox"); // NOI18N

        valueTextField.setText(resourceMap.getString("valueTextField.text")); // NOI18N
        valueTextField.setAction(actionMap.get("addAction")); // NOI18N
        valueTextField.setName("valueTextField"); // NOI18N
        valueTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickHandler(evt);
            }
        });

        logicalOperatorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        logicalOperatorComboBox.setName("logicalOperatorComboBox"); // NOI18N

        variableLabel.setText(resourceMap.getString("variableLabel.text")); // NOI18N
        variableLabel.setName("variableLabel"); // NOI18N

        operationLabel.setText(resourceMap.getString("operationLabel.text")); // NOI18N
        operationLabel.setName("operationLabel"); // NOI18N

        valueLabel.setText(resourceMap.getString("valueLabel.text")); // NOI18N
        valueLabel.setName("valueLabel"); // NOI18N

        jButton3.setAction(actionMap.get("addAction")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(instructionLabel1)
            .addComponent(instructionLabel2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(variableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(variableLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(valueTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logicalOperatorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(valueLabel)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(instructionLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(variableLabel)
                    .addComponent(operationLabel)
                    .addComponent(valueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(variableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(logicalOperatorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("filterPanel.border.title"))); // NOI18N
        filterPanel.setName("filterPanel"); // NOI18N

        scrollPane.setName("scrollPane"); // NOI18N

        textPane.setName("textPane"); // NOI18N
        scrollPane.setViewportView(textPane);

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );

        cancelButton.setAction(actionMap.get("cancelAction")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N

        okButton.setAction(actionMap.get("okAction")); // NOI18N
        okButton.setName("okButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filterPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void mouseClickHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickHandler
    DatabaseVariablesListElement dbvle = (DatabaseVariablesListElement) variableComboBox.getSelectedItem();
    if (dbvle.getVariableType().equalsIgnoreCase("dict")) {
        // System.out.println("Coucou");
        if (possibleValues == null) {
            JOptionPane.showInternalMessageDialog(this, "Empty dictionary.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            DictionaryEntry selectedValue = (DictionaryEntry) JOptionPane.showInternalInputDialog(this,
                    "Choose one", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    possibleValues, possibleValues[0]);
            valueTextField.setText(selectedValue.getCode());
        }
    } else {
        // System.out.println(dbvle.getVariableType());
        // Do nothing
    }
}//GEN-LAST:event_mouseClickHandler
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JLabel instructionLabel1;
    private javax.swing.JLabel instructionLabel2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox logicalOperatorComboBox;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox operationComboBox;
    private javax.swing.JLabel operationLabel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextPane textPane;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTextField valueTextField;
    private javax.swing.JComboBox variableComboBox;
    private javax.swing.JLabel variableLabel;
    // End of variables declaration//GEN-END:variables
    private void initValues() {
        String[] operators = {">", ">=", "=", "<=", "<"};
        operationComboBox.setModel(new DefaultComboBoxModel(operators));
        operationComboBox.setSelectedIndex(2);
        // Get the system description
        doc =
                parentFilterPanel.getDatabseDescription();
        refreshVariableList();

        String[] logicalOperator = {"", "AND", "OR"};
        logicalOperatorComboBox.setModel(new DefaultComboBoxModel(logicalOperator));
        dictionary =
                canreg.client.CanRegClientApp.getApplication().getDictionary();
        updatePossibleValues();

    }

    private void refreshVariableList() {
        variablesInTable = canreg.common.Tools.getVariableListElements(doc, Globals.NAMESPACE);
        if (!tableName.equalsIgnoreCase("both")) {
            LinkedList<DatabaseVariablesListElement> tempVariablesInTable = new LinkedList<DatabaseVariablesListElement>();
            for (int i = 0; i <
                    variablesInTable.length; i++) {
                if (variablesInTable[i].getDatabaseTableName().equalsIgnoreCase(tableName)) {
                    tempVariablesInTable.add(variablesInTable[i]);
                }

            }
            variablesInTable = new DatabaseVariablesListElement[tempVariablesInTable.size()];
            for (int i = 0; i <
                    variablesInTable.length; i++) {
                variablesInTable[i] = tempVariablesInTable.get(i);
            }

        }
        variableComboBox.setModel(new DefaultComboBoxModel(variablesInTable));
    }

    public void setTextPane(String str) {
        textPane.setText(str);
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
        refreshVariableList();

    }

    @Action
    public void cancelAction() {
        this.setVisible(false);
    }

    @Action
    public void okAction() {
        parentFilterPanel.setFilter(textPane.getText().trim());
        parentFilterPanel.setFilterActive(true);
        this.setVisible(false);
    }

    @Action
    public void addAction() {
        String newFilterPart = "";
        newFilterPart +=
                variableComboBox.getSelectedItem().toString();
        newFilterPart +=
                " ";
        newFilterPart +=
                operationComboBox.getSelectedItem().toString();
        newFilterPart +=
                " ";
        DatabaseVariablesListElement dvle = (DatabaseVariablesListElement) variableComboBox.getSelectedItem();
        if (!dvle.getVariableType().equalsIgnoreCase("Number")) {
            newFilterPart += "'";
        }

        newFilterPart += valueTextField.getText();
        if (!dvle.getVariableType().equalsIgnoreCase("Number")) {
            newFilterPart += "'";
        }

        newFilterPart += " ";
        newFilterPart +=
                logicalOperatorComboBox.getSelectedItem().toString();
        newFilterPart +=
                " ";
        textPane.setText(textPane.getText() + newFilterPart);
        logicalOperatorComboBox.setSelectedIndex(0);
    }

    @Action
    public void varibleChosenAction() {
        valueTextField.setText("");
        updatePossibleValues();

    }

    @SuppressWarnings("empty-statement")
    private void updatePossibleValues() {
        DatabaseVariablesListElement dbvle = (DatabaseVariablesListElement) variableComboBox.getSelectedItem();
        int id = dbvle.getDictionaryID();
        if (id >= 0) {
            Map map = canreg.client.dataentry.DictionaryHelper.getDictionaryByID(dictionary, id);
            if (map != null) {
                Map sortedmap = new TreeMap(map);
                possibleValues =
                        canreg.client.dataentry.DictionaryHelper.buildDictionaryEntriesFromMap(sortedmap);
            } else {
                possibleValues = null;
            }

        } else {
            possibleValues = null;
        }
    }
}
