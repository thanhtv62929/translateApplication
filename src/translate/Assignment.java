/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Khoi Truong
 */
public class Assignment extends javax.swing.JFrame {
    int selectrow;
    int selectLanguage;
    boolean changed = false;
   String ListEngtoVi="EngtoVi.txt";
   String ListVitoEng="VitoEng.txt"; 
   TreeMap <String, LinkedList> treeEngtoVi = new TreeMap<>();
     
   TreeMap<String, LinkedList> treeVitoEng = new TreeMap<>();
     
     
     


     
     
     
     public Assignment() {
         loadData(ListEngtoVi, treeEngtoVi);
         loadData(ListVitoEng, treeVitoEng);
        initComponents();
    }
     
      void loadData(String filename , TreeMap List) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                return;
            }
            String details = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF16")); 
       
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ":");  
                String keyWorld = stk.nextToken().trim().toLowerCase();
                String Translate = stk.nextToken().trim().toLowerCase();
                LinkedList<String> Result = new LinkedList();
                StringTokenizer stk1 = new StringTokenizer(Translate, ",");
                while(stk1.hasMoreElements()){
                    Result.add(stk1.nextToken().trim());
                }
                List.put(keyWorld, Result);

            }
            
            br.close();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
          public void saveFile(TreeMap<String, LinkedList> aList, String fileName) {
        try {
            Set<String> keys = aList.keySet();
            Vector<String> allKeys = new Vector<>();
            PrintWriter pr = new PrintWriter(fileName, "UTF16");
            for (String key : keys) {
                allKeys.add(key);
            }

            for (int i = 0; i < keys.size(); i++) {
                String key = allKeys.get(i);
                String list = "";
                for (int j = 0; j < aList.get(key).size(); j++) {
                    list = list + aList.get(key).get(j) + ((j < aList.get(key).size() - 1) ? ", " : "");
                }
                String formattedData = String.format("%s:%s", key, list);
                pr.println(formattedData);
            }
            pr.close();
        } catch (Exception e) {
            System.out.println(e.toString());
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
        JPanel2 = new javax.swing.JPanel();
        txtTranslate = new javax.swing.JTextField();
        SelectLanguage = new javax.swing.JComboBox<>();
        Translate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtShow = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtVocabulary = new javax.swing.JTextField();
        txtMean = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ButtonAdd = new javax.swing.JButton();
        ComboboxAdd = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        SavetoFile = new javax.swing.JButton();
        Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 27), new java.awt.Color(0, 255, 102))); // NOI18N

        JPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Translate Program", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 30))); // NOI18N

        txtTranslate.setBackground(new java.awt.Color(204, 204, 204));
        txtTranslate.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        SelectLanguage.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        SelectLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose One", "English To Vietnamese", "Vietnamese To English" }));
        SelectLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectLanguageActionPerformed(evt);
            }
        });

        Translate.setBackground(new java.awt.Color(153, 255, 255));
        Translate.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        Translate.setText("Tranlate");
        Translate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TranslateActionPerformed(evt);
            }
        });

        txtShow.setBackground(new java.awt.Color(204, 204, 204));
        txtShow.setColumns(20);
        txtShow.setFont(new java.awt.Font("Monospaced", 0, 40)); // NOI18N
        txtShow.setRows(5);
        jScrollPane1.setViewportView(txtShow);

        javax.swing.GroupLayout JPanel2Layout = new javax.swing.GroupLayout(JPanel2);
        JPanel2.setLayout(JPanel2Layout);
        JPanel2Layout.setHorizontalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addComponent(txtTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(SelectLanguage, 0, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Translate, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        JPanel2Layout.setVerticalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Translate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Vocabulary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 30))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Vocabulary");

        txtVocabulary.setBackground(new java.awt.Color(204, 204, 204));
        txtVocabulary.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        txtMean.setBackground(new java.awt.Color(204, 204, 204));
        txtMean.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("Mean");

        ButtonAdd.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        ButtonAdd.setText("Add new vocabulary");
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        ComboboxAdd.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        ComboboxAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vietnamese - English", "English - Vietnamese" }));
        ComboboxAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboboxAddActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setText("Language");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(ComboboxAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMean)
                            .addComponent(txtVocabulary))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVocabulary, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtMean, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        SavetoFile.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        SavetoFile.setText("Save To File");
        SavetoFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavetoFileActionPerformed(evt);
            }
        });

        Exit.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        Exit.setText("Exit Program");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(SavetoFile, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(JPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(84, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(JPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SavetoFile, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents


// Select Row that you want to translate
    
    private void SelectLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectLanguageActionPerformed
       selectrow=SelectLanguage.getSelectedIndex();   
    }//GEN-LAST:event_SelectLanguageActionPerformed

    private void TranslateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TranslateActionPerformed
         boolean checkTranslate = false;
        if(selectrow==1){
          if(treeEngtoVi.containsKey(txtTranslate.getText().toLowerCase()))
          {
     txtShow.setText(treeEngtoVi.get(txtTranslate.getText().toLowerCase()).toString());
     checkTranslate=true;
          }
          else{
              JOptionPane.showMessageDialog(this, "There aren't this vocabulary in Program");
              checkTranslate=true;
          }
       }
       
       
      if(selectrow==2){
           if(treeVitoEng.containsKey(txtTranslate.getText().toLowerCase())){
     txtShow.setText(treeVitoEng.get(txtTranslate.getText().toLowerCase()).toString());
     checkTranslate=true;
   
       }   
           else{
               JOptionPane.showMessageDialog(this, "There aren't this vocabulary in Program");
               checkTranslate=true;
           }
       }
      if(checkTranslate!=true){
          JOptionPane.showMessageDialog(this, "Please choose one language to translate");
      }
       
      
    }//GEN-LAST:event_TranslateActionPerformed
// Add language [ Vietnamese to English ] [ English to Vietnamese ] 
    
    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
      //add Vietnamese to English
        if(selectLanguage==0){
            
            
            
        if(txtVocabulary.getText().equals("")&& txtMean.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter vocabulary and mean");
        }
        
    
    else{
            
            if(treeVitoEng.containsKey(txtVocabulary.getText().toLowerCase())){
                Vector<String> listVo = new Vector<>();
                StringTokenizer stkMean = new StringTokenizer(txtMean.getText().trim().toLowerCase(),",");
                
            while(stkMean.hasMoreElements()){
                listVo.add(stkMean.nextToken().trim());              
            } 
            for(int i =0;i<listVo.size();i++){
                // get key là lấy những value của key đó ra so sánh .
                if(treeVitoEng.get(txtVocabulary.getText().toLowerCase()).contains(listVo.get(i))){
                    listVo.remove(i);
                    i--;
                }
                
            }
           
            //
            LinkedList<String> listNew = new LinkedList<>();
                for (int i = 0; i < listVo.size(); i++) {
                    listNew.add(listVo.get(i));
                }
                if (listNew.isEmpty()) {
                    txtVocabulary.setText("");
                    txtMean.setText("");
                    txtVocabulary.requestFocus();
                    JOptionPane.showMessageDialog(this, "Can't add , this vocabulary valid");
                } else {
                    LinkedList<String> listOld = new LinkedList<>();
                    for (int i = 0; i < treeVitoEng.get(txtVocabulary.getText().toLowerCase()).size(); i++) {
                        listOld.add(treeVitoEng.get(txtVocabulary.getText().toLowerCase()).get(i).toString());
                    }
                    for (int i = 0; i < listOld.size(); i++) {
                        listNew.add(listOld.get(i));
                    }
                    treeVitoEng.put(txtVocabulary.getText().toLowerCase(), listNew);
                  
                    JOptionPane.showMessageDialog(this, "Added this vocabulary");
                    changed=true;
            }
            
            }
            //
            
            
            else {   
        LinkedList<String> list = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(txtMean.getText().trim().toLowerCase(),",");
        while(stk.hasMoreElements()){
            list.add(stk.nextToken());
            
        }
       treeVitoEng.put(txtVocabulary.getText().trim().toLowerCase(), list);
       JOptionPane.showMessageDialog(this, "Added this vocabulary");
       changed=true;
    }
        }
        
 
        }
    // add English to Vietnamese
        if(selectLanguage==1){
            
            
            
        if(txtVocabulary.getText().equals("")&& txtMean.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter vocabulary and mean");
        }
        
    
    else{
            
            if(treeEngtoVi.containsKey(txtVocabulary.getText().toLowerCase())){
                Vector<String> listVo = new Vector<>();
                StringTokenizer stkMean = new StringTokenizer(txtMean.getText().trim().toLowerCase(),",");
                
            while(stkMean.hasMoreElements()){
                listVo.add(stkMean.nextToken().trim());              
            } 
            for(int i =0;i<listVo.size();i++){
                if(treeEngtoVi.get(txtVocabulary.getText().toLowerCase()).contains(listVo.get(i))){
                    listVo.remove(i);
                    i--;
                }
                
            }
           
            //
            LinkedList<String> listNew = new LinkedList<>();
                for (int i = 0; i < listVo.size(); i++) {
                    listNew.add(listVo.get(i));
                }
                if (listNew.isEmpty()) {
                    txtVocabulary.setText("");
                    txtMean.setText("");
                    txtVocabulary.requestFocus();
                    JOptionPane.showMessageDialog(this, "Can't add , this vocabulary valid");
                } else {
                    LinkedList<String> listOld = new LinkedList<>();
                    for (int i = 0; i < treeEngtoVi.get(txtVocabulary.getText().toLowerCase()).size(); i++) {
                        listOld.add(treeEngtoVi.get(txtVocabulary.getText().toLowerCase()).get(i).toString());
                    }
                    for (int i = 0; i < listOld.size(); i++) {
                        listNew.add(listOld.get(i));
                    }
                    treeEngtoVi.put(txtVocabulary.getText().toLowerCase(), listNew);
                  
                    JOptionPane.showMessageDialog(this, "Added this vocabulary");
                    changed=true;
            }
            
            }
            //
            
            
            else {   
        LinkedList<String> list = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(txtMean.getText().trim().toLowerCase(),",");
        while(stk.hasMoreElements()){
            list.add(stk.nextToken());
            
        }
       treeEngtoVi.put(txtVocabulary.getText().trim().toLowerCase(), list);
       JOptionPane.showMessageDialog(this, "Added this vocabulary");
       changed=true;
    }
        }
        
        
        
        
        
        
    
    
    
    
    
    
    
    
        }
        
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void ComboboxAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboboxAddActionPerformed
       selectLanguage = ComboboxAdd.getSelectedIndex();
    }//GEN-LAST:event_ComboboxAddActionPerformed

    private void SavetoFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavetoFileActionPerformed
        saveFile(treeEngtoVi, ListEngtoVi);
        saveFile(treeVitoEng, ListVitoEng);
        JOptionPane.showMessageDialog(this, "Data was saved");
        changed=false;
    }//GEN-LAST:event_SavetoFileActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
      if (changed) {// Data changed , not save file yet 
            int r = JOptionPane.showConfirmDialog(this, " Do you want to save data to file", "Save file ? ", JOptionPane.YES_NO_CANCEL_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                SavetoFileActionPerformed(evt);
                System.exit(0);
            } else if (r == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            int r = JOptionPane.showConfirmDialog(this, " Do you want to exit application", "Exit ? ", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }//GEN-LAST:event_ExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JComboBox<String> ComboboxAdd;
    private javax.swing.JButton Exit;
    private javax.swing.JPanel JPanel2;
    private javax.swing.JButton SavetoFile;
    private javax.swing.JComboBox<String> SelectLanguage;
    private javax.swing.JButton Translate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtMean;
    private javax.swing.JTextArea txtShow;
    private javax.swing.JTextField txtTranslate;
    private javax.swing.JTextField txtVocabulary;
    // End of variables declaration//GEN-END:variables
}
