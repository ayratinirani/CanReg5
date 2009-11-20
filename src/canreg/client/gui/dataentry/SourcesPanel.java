/*
 * SourcesPanel.java
 *
 * Created on 08-Oct-2009, 11:05:53
 */
package canreg.client.gui.dataentry;

import canreg.server.database.Dictionary;
import canreg.server.database.Source;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdesktop.application.Action;
import org.w3c.dom.Document;

/**
 *
 * @author ervikm
 */
public class SourcesPanel extends javax.swing.JPanel implements ActionListener {

    private Set<Source> sources;
    private Map<Integer, Dictionary> dictionary;
    private Document doc;
    private final ActionListener listener;

    /** Creates new form SourcesPanel */
    public SourcesPanel(ActionListener listener) {
        initComponents();
        this.listener = listener;

        // Add a listener for changing the active tab
        ChangeListener tabbedPaneChangeListener = new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                setScrollPaneSize();
            }
        };
        sourcesTabbedPane.addChangeListener(tabbedPaneChangeListener);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sourcesTabbedPane = new javax.swing.JTabbedPane();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(SourcesPanel.class);
        setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(430, 149));
        setName("Form"); // NOI18N

        sourcesTabbedPane.setName("sourcesTabbedPane"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(SourcesPanel.class, this);
        addButton.setAction(actionMap.get("addSourceAction")); // NOI18N
        addButton.setName("addButton"); // NOI18N

        removeButton.setAction(actionMap.get("removeSourceAction")); // NOI18N
        removeButton.setName("removeButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addContainerGap(191, Short.MAX_VALUE))
            .addComponent(sourcesTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sourcesTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void addSourceAction() {
        Source newSource = new Source();
        RecordEditorPanel newPanel = new RecordEditorPanel(this);
        newPanel.setDictionary(dictionary);
        newPanel.setDocument(doc);
        newPanel.setRecordAndBuildPanel(newSource);
        sources.add(newSource);
        sourcesTabbedPane.add(newPanel);
        refreshTitles();
        setScrollPaneSize();
    }

    @Action
    public void removeSourceAction() {
        RecordEditorPanel oldPanel = (RecordEditorPanel) sourcesTabbedPane.getSelectedComponent();
        Source oldSource = (Source) oldPanel.getDatabaseRecord();
        sources.remove(oldSource);
        sourcesTabbedPane.remove(oldPanel);
    }

    public void setSources(Set<Source> sources) {
        if (sources == null) {
            sources = Collections.synchronizedSet(new LinkedHashSet<Source>());
        }
        this.sources = sources;
        buildTabs();
        refreshTitles();
        setScrollPaneSize();
    }

    private void buildTabs() {
        for (Source source : sources) {
            RecordEditorPanel newPanel = new RecordEditorPanel(this);
            newPanel.setDictionary(dictionary);
            newPanel.setDocument(doc);
            newPanel.setRecordAndBuildPanel(source);
            sourcesTabbedPane.add(newPanel);
        }
    }

    private void refreshTitles() {
        int index = 0;
        for (Component comp : sourcesTabbedPane.getComponents()) {
            sourcesTabbedPane.setTitleAt(index, "Source: " + (index + 1));
            index++;
        }
    }

    public Set<Source> getSources() {
        sources = Collections.synchronizedSet(new LinkedHashSet<Source>());
        for (Component comp : sourcesTabbedPane.getComponents()) {
            RecordEditorPanel rep = (RecordEditorPanel) comp;
            Source source = (Source) rep.getDatabaseRecord();
            sources.add(source);
        }
        return sources;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JTabbedPane sourcesTabbedPane;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        // forward the event...
        listener.actionPerformed(e);
    }

    /**
     * @return the dictionary
     */
    public Map<Integer, Dictionary> getDictionary() {
        return dictionary;
    }

    /**
     * @param dictionary the dictionary to set
     */
    public void setDictionary(Map<Integer, Dictionary> dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * @return the doc
     */
    public Document getDoc() {
        return doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(Document doc) {
        this.doc = doc;
    }

    private void setScrollPaneSize() {
        if (sources != null) {
            RecordEditorPanel rep = (RecordEditorPanel) sourcesTabbedPane.getSelectedComponent();
            if (rep != null) {
                rep.maximizeSize();
            }
        }
    }
}