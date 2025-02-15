/* 
 * Copyright (C) 2018 Tarek Boutefara <t_boutefara@esi.dz>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package dz.univjijel.jsentiwordnet.gui;

import dz.univjijel.jsentiwordnet.core.JSentiWordNet;
import dz.univjijel.jsentiwordnet.dict.Synset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class MainGui extends javax.swing.JFrame {
    
    MyListModel myListModel;

    /**
     * Creates new form MainGui
     */
    public MainGui() {
        myListModel = new MyListModel();
        initComponents();
        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                updateSynsetDetails();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        synsetDetails = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList<>();
        modeSearch = new javax.swing.JComboBox<>();
        mnBar = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        quit = new javax.swing.JMenuItem();
        mnHelp = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JSentiWordnet (v 0.0.1)");
        setResizable(false);

        btnSearch.setText("Serach");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        synsetDetails.setColumns(20);
        synsetDetails.setRows(5);
        jScrollPane2.setViewportView(synsetDetails);

        resultList.setModel(myListModel);
        jScrollPane1.setViewportView(resultList);

        modeSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By Id", "By Term", "By Native format", "In Gloss" }));

        mnFile.setText("File");

        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        mnFile.add(quit);

        mnBar.add(mnFile);

        mnHelp.setText("Help");

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        mnHelp.add(about);

        mnBar.add(mnHelp);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modeSearch, 0, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch)
                            .addComponent(modeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JOptionPane.showMessageDialog(this, "JSentiWordnet (v 0.0.1)");
    }//GEN-LAST:event_aboutActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       
        String command = (String)modeSearch.getSelectedItem();
        String value = txtSearch.getText().toLowerCase();
        
        switch(command){
                case "By Id" :
                   
                    setListContent(Arrays.asList(JSentiWordNet.findById(value)));
                    break;
                    
                case "By Term" :
                    
                    setListContent(JSentiWordNet.findTerm(value));
                    break;
                    
                case "By Native format" :
                    
                    setListContent(JSentiWordNet.findNativeTerm(value));
                    break;
                    
                case "In Gloss" :
                    
                    setListContent(JSentiWordNet.findInGloss(value));
                    break;
                    
            }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void setListContent(List<Synset> synsets){
        myListModel.setSynsets(synsets);
        resultList.updateUI();
    }
    
    public void updateSynsetDetails() {
        int position = resultList.getSelectedIndex();
        Synset synset = myListModel.getSynsetAt(position);
        synsetDetails.setText(synset.toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenu mnHelp;
    private javax.swing.JComboBox<String> modeSearch;
    private javax.swing.JMenuItem quit;
    private javax.swing.JList<String> resultList;
    private javax.swing.JTextArea synsetDetails;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

class MyListModel extends AbstractListModel<String> {
    
    List<Synset> synsets = new ArrayList<>();

    public List<Synset> getSynsets() {
        return synsets;
    }

    public void setSynsets(List<Synset> synsets) {
        this.synsets = synsets;
    }

    @Override
    public int getSize() {
        return synsets.size();
    }

    @Override
    public String getElementAt(int i) {
        return synsets.get(i).getId();
    }
    
    public Synset getSynsetAt(int i){
        return synsets.get(i);
    }
    
}
