/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.software.Views;

import com.software.Controllers.ButtonController;
import com.software.Entities.JavaFile;
import com.software.Services.ComponentsServices;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author camm0
 */
public class Main extends javax.swing.JFrame {
    private JavaFile javaFile;
    
    private String jarSelected = "";
    
    private ButtonController buttonController;
    private ComponentsServices componentsServices;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        buttonController = new ButtonController();
        componentsServices = new ComponentsServices(ListComponents);
        javaFile = new JavaFile();
        
        
        /*addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CleanPath();
            }
        });*/
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelParent = new javax.swing.JPanel();
        ButtonLoadComponent = new javax.swing.JButton();
        ButtonLoadFile = new javax.swing.JButton();
        ButtonExecuteComponent = new javax.swing.JButton();
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
        ListComponents = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelParent.setBackground(new java.awt.Color(255, 255, 255));

        ButtonLoadComponent.setText("Cargar Componente");
        ButtonLoadComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoadComponentActionPerformed(evt);
            }
        });

        ButtonLoadFile.setText("Cargar Archivo");
        ButtonLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoadFileActionPerformed(evt);
            }
        });

        ButtonExecuteComponent.setText("Ejecutar Componente");
        ButtonExecuteComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExecuteComponentActionPerformed(evt);
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

        ListComponents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListComponents.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListComponentsValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(ListComponents);

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
                            .addComponent(ButtonExecuteComponent, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(ButtonLoadComponent, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
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
                        .addComponent(ButtonLoadComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ButtonExecuteComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                // Obtén el archivo seleccionado
                javaFile.setJavaFile(fileChooser.getSelectedFile());
                buttonController.LoadFile(javaFile.getJavaFile(), TextPaneFirstFile, TextPaneOutMessage);
            }else{
                this.TextPaneOutMessage.setText("Seleccione un archivo correcto");
            }
            
        }
    }//GEN-LAST:event_ButtonLoadFileActionPerformed

    private void ButtonLoadComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoadComponentActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JAR", "jar"));

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            File pathJar = buttonController.LoadComponent(selectedFile, TextPaneOutMessage, ListComponents);
            componentsServices.addComponent(pathJar, ListComponents);
        }
    }//GEN-LAST:event_ButtonLoadComponentActionPerformed

    private void ListComponentsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListComponentsValueChanged
        if (!evt.getValueIsAdjusting()) {
            JList<String> listComponents = (JList<String>) evt.getSource();
            String selectedComponent = listComponents.getSelectedValue();
            TextPaneOutMessage.setText(selectedComponent);
            jarSelected = selectedComponent;
        }
    }//GEN-LAST:event_ListComponentsValueChanged

    private void ButtonExecuteComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExecuteComponentActionPerformed
        if(javaFile.getJavaFile() != null){
            componentsServices.executeComponent( jarSelected, javaFile.getJavaFile(), TextPaneProcessedFile, TextPaneOutMessage);
        }else{
            TextPaneOutMessage.setText("Elije el archivo inicial");
        }
    }//GEN-LAST:event_ButtonExecuteComponentActionPerformed

    
    private void CleanPath(){
        // Directorio que deseas vaciar
        String directorio = "../Plugins/";
        
        // Crea una instancia de File para el directorio
        File carpeta = new File(directorio);
        
        // Verifica si el directorio existe
        if (carpeta.exists() && carpeta.isDirectory()) {
            // Obtiene la lista de archivos en el directorio
            File[] archivos = carpeta.listFiles();
            
            // Elimina cada archivo en el directorio
            for (File archivo : archivos) {
                archivo.delete();
            }
            
            System.out.println("Archivos eliminados correctamente.");
        } else {
            System.out.println("El directorio no existe o no es válido.");
        }
    }
    
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
    private javax.swing.JButton ButtonExecuteComponent;
    private javax.swing.JButton ButtonLoadComponent;
    private javax.swing.JButton ButtonLoadFile;
    private javax.swing.JLabel LabelFirstFile;
    private javax.swing.JLabel LabelOutMessage;
    private javax.swing.JLabel LabelProcessedFile;
    private javax.swing.JList<String> ListComponents;
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
