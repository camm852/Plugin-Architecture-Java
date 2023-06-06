package com.software.Views;

import com.software.Controllers.IDEController;
import com.software.Dto.JavaFileDto;
import com.software.Entities.JavaFile;
import com.software.Interfaces.IIDEController;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Main extends javax.swing.JFrame {
    private JavaFile javaFile;
    
    private String jarSelected = "";
    
    
    private final IIDEController _ideController;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        _ideController = new IDEController(ListPlugins);
        javaFile = new JavaFile();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelParent = new javax.swing.JPanel();
        ButtonLoadPlugin = new javax.swing.JButton();
        ButtonLoadFile = new javax.swing.JButton();
        ButtonExecutePlugin = new javax.swing.JButton();
        LabelOutMessage = new javax.swing.JLabel();
        LabelFirstFile = new javax.swing.JLabel();
        LabelProcessedFile = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TextPaneFirstFile = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextPaneProcessedFile = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextPaneOutMessage = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListPlugins = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelParent.setBackground(new java.awt.Color(255, 255, 255));

        ButtonLoadPlugin.setText("Cargar Plugin");
        ButtonLoadPlugin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoadPluginActionPerformed(evt);
            }
        });

        ButtonLoadFile.setText("Cargar Archivo");
        ButtonLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoadFileActionPerformed(evt);
            }
        });

        ButtonExecutePlugin.setText("Ejecutar Plugin");
        ButtonExecutePlugin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExecutePluginActionPerformed(evt);
            }
        });

        LabelOutMessage.setText("Salida de mensajes");
        LabelOutMessage.setToolTipText("");

        LabelFirstFile.setText("Archivo Inicial");

        LabelProcessedFile.setText("Archivo Procesado");

        TextPaneFirstFile.setEditable(false);
        TextPaneFirstFile.setCaretColor(new java.awt.Color(255, 255, 255));
        TextPaneFirstFile.setFocusable(false);
        jScrollPane5.setViewportView(TextPaneFirstFile);

        TextPaneProcessedFile.setEditable(false);
        TextPaneProcessedFile.setFocusable(false);
        jScrollPane1.setViewportView(TextPaneProcessedFile);

        TextPaneOutMessage.setEditable(false);
        TextPaneOutMessage.setFocusable(false);
        jScrollPane2.setViewportView(TextPaneOutMessage);

        ListPlugins.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListPlugins.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListPluginsValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(ListPlugins);

        javax.swing.GroupLayout PanelParentLayout = new javax.swing.GroupLayout(PanelParent);
        PanelParent.setLayout(PanelParentLayout);
        PanelParentLayout.setHorizontalGroup(
            PanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelParentLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(PanelParentLayout.createSequentialGroup()
                        .addGroup(PanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelOutMessage)
                            .addComponent(ButtonExecutePlugin, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(ButtonLoadPlugin, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))
                        .addGap(36, 36, 36)
                        .addGroup(PanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PanelParentLayout.createSequentialGroup()
                                .addComponent(LabelFirstFile)
                                .addGap(320, 320, 320)
                                .addComponent(ButtonLoadFile))
                            .addComponent(LabelProcessedFile, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        PanelParentLayout.setVerticalGroup(
            PanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelParentLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelFirstFile)
                    .addComponent(ButtonLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelParentLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelProcessedFile)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelParentLayout.createSequentialGroup()
                        .addComponent(ButtonLoadPlugin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ButtonExecutePlugin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(LabelOutMessage)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoadFileActionPerformed
        if (evt.getSource() == this.ButtonLoadFile) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Java", "java");
            fileChooser.setFileFilter(filter);
            int seleccion = fileChooser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                javaFile.setJavaFile(fileChooser.getSelectedFile());
                _ideController.loadFile(new JavaFileDto(this.javaFile.getJavaFile()), TextPaneFirstFile, TextPaneOutMessage);
            }else{
                this.TextPaneOutMessage.setText("Seleccione un archivo correcto");
            }
        }
    }//GEN-LAST:event_ButtonLoadFileActionPerformed

    private void ButtonLoadPluginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoadPluginActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JAR", "jar"));

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            _ideController.loadPlugin(selectedFile, TextPaneOutMessage, ListPlugins);
        }
    }//GEN-LAST:event_ButtonLoadPluginActionPerformed

    private void ListPluginsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListPluginsValueChanged
        if (!evt.getValueIsAdjusting()) {
            JList<String> _pluginList = (JList<String>) evt.getSource();
            String selectedPlugin = _pluginList.getSelectedValue();
            TextPaneOutMessage.setText("Se ha seleccionado el plugin: "+selectedPlugin);
            jarSelected = selectedPlugin;
        }
    }//GEN-LAST:event_ListPluginsValueChanged

    private void ButtonExecutePluginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExecutePluginActionPerformed
        if(this.javaFile.getJavaFile() != null){
            _ideController.executePlugin(jarSelected, new JavaFileDto(this.javaFile.getJavaFile()), TextPaneProcessedFile, TextPaneOutMessage);
        }else{
            TextPaneOutMessage.setText("Elije el archivo inicial");
        }
    }//GEN-LAST:event_ButtonExecutePluginActionPerformed

   
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExecutePlugin;
    private javax.swing.JButton ButtonLoadFile;
    private javax.swing.JButton ButtonLoadPlugin;
    private javax.swing.JLabel LabelFirstFile;
    private javax.swing.JLabel LabelOutMessage;
    private javax.swing.JLabel LabelProcessedFile;
    private javax.swing.JList<String> ListPlugins;
    private javax.swing.JPanel PanelParent;
    private javax.swing.JTextPane TextPaneFirstFile;
    private javax.swing.JTextPane TextPaneOutMessage;
    private javax.swing.JTextPane TextPaneProcessedFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
