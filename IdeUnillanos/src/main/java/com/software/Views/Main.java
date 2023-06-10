package com.software.Views;

import com.software.Controllers.IDEController;
import com.software.Interfaces.IIDEController;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Main extends javax.swing.JFrame {
    
    
    private final String pathPlugins = "../Plugins/";
    private int xMouse, yMouse; // coords screen
    private File javaFile;
    private String jarSelected = "";
    private final IIDEController _ideController;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        _ideController = new IDEController(pathPlugins);
        _ideController.loadPluginsPrevLoaded(ListPlugins);
        
        
        //quitar estilos de borde a los TextPane y JList
        EmptyBorder emptyBorder = new EmptyBorder(0, 0, 0, 0);
        this.ListPlugins.setBorder(emptyBorder);
        this.ScrollPaneList.setBorder(null);
        this.TextPaneFirstFile.setBorder(emptyBorder);
        this.ScrollPaneFirstFile.setBorder(null);
        this.TextPaneProcessedFile.setBorder(emptyBorder);
        this.ScrollPaneProcessedFile.setBorder(null);
        this.TextPaneOutMessage.setBorder(emptyBorder);
        this.ScrollPaneOutMessage.setBorder(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelParent = new javax.swing.JPanel();
        LabelOutMessage = new javax.swing.JLabel();
        LabelFirstFile = new javax.swing.JLabel();
        LabelProcessedFile = new javax.swing.JLabel();
        TopBar = new javax.swing.JPanel();
        CloseProgram = new javax.swing.JLabel();
        ScrollPaneFirstFile = new javax.swing.JScrollPane();
        TextPaneFirstFile = new javax.swing.JTextPane();
        ScrollPaneProcessedFile = new javax.swing.JScrollPane();
        TextPaneProcessedFile = new javax.swing.JTextPane();
        ScrollPaneOutMessage = new javax.swing.JScrollPane();
        TextPaneOutMessage = new javax.swing.JTextPane();
        PanelLeft = new javax.swing.JPanel();
        ScrollPaneList = new javax.swing.JScrollPane();
        ListPlugins = new javax.swing.JList<>();
        ButtonLoadPlugin = new javax.swing.JLabel();
        ButtonExecutePlugin = new javax.swing.JLabel();
        ListPluginsLabel = new javax.swing.JLabel();
        ButtonLoadFile = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(883, 650));
        setResizable(false);

        PanelParent.setBackground(new java.awt.Color(243, 242, 250));
        PanelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelOutMessage.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        LabelOutMessage.setText("Salida de mensajes");
        LabelOutMessage.setToolTipText("");
        PanelParent.add(LabelOutMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, -1, -1));

        LabelFirstFile.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        LabelFirstFile.setText("Archivo Inicial");
        PanelParent.add(LabelFirstFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        LabelProcessedFile.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        LabelProcessedFile.setText("Archivo Procesado");
        PanelParent.add(LabelProcessedFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        TopBar.setBackground(new java.awt.Color(243, 242, 250));
        TopBar.setOpaque(false);
        TopBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TopBarMouseDragged(evt);
            }
        });
        TopBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TopBarMousePressed(evt);
            }
        });

        CloseProgram.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        CloseProgram.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CloseProgram.setText("X");
        CloseProgram.setToolTipText("");
        CloseProgram.setAlignmentX(0.5F);
        CloseProgram.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CloseProgram.setDoubleBuffered(true);
        CloseProgram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseProgramMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TopBarLayout = new javax.swing.GroupLayout(TopBar);
        TopBar.setLayout(TopBarLayout);
        TopBarLayout.setHorizontalGroup(
            TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopBarLayout.createSequentialGroup()
                .addGap(0, 843, Short.MAX_VALUE)
                .addComponent(CloseProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TopBarLayout.setVerticalGroup(
            TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CloseProgram, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        PanelParent.add(TopBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        TextPaneFirstFile.setEditable(false);
        TextPaneFirstFile.setBorder(null);
        TextPaneFirstFile.setForeground(new java.awt.Color(139, 139, 139));
        TextPaneFirstFile.setCaretColor(new java.awt.Color(255, 255, 255));
        TextPaneFirstFile.setFocusable(false);
        ScrollPaneFirstFile.setViewportView(TextPaneFirstFile);

        PanelParent.add(ScrollPaneFirstFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 460, 190));

        TextPaneProcessedFile.setEditable(false);
        TextPaneProcessedFile.setBorder(null);
        TextPaneProcessedFile.setForeground(new java.awt.Color(139, 139, 139));
        TextPaneProcessedFile.setCaretColor(new java.awt.Color(255, 255, 255));
        TextPaneProcessedFile.setFocusable(false);
        ScrollPaneProcessedFile.setViewportView(TextPaneProcessedFile);

        PanelParent.add(ScrollPaneProcessedFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 460, 190));

        TextPaneOutMessage.setEditable(false);
        TextPaneOutMessage.setBorder(null);
        TextPaneOutMessage.setForeground(new java.awt.Color(139, 139, 139));
        TextPaneOutMessage.setFocusable(false);
        ScrollPaneOutMessage.setViewportView(TextPaneOutMessage);

        PanelParent.add(ScrollPaneOutMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 570, 460, 69));

        PanelLeft.setBackground(new java.awt.Color(30, 174, 255));
        PanelLeft.setToolTipText("");

        ListPlugins.setBackground(new java.awt.Color(29, 171, 250));
        ListPlugins.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        ListPlugins.setForeground(new java.awt.Color(255, 255, 255));
        ListPlugins.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListPlugins.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ListPlugins.setSelectionForeground(new java.awt.Color(29, 171, 250));
        ListPlugins.setVisibleRowCount(5);
        ListPlugins.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListPluginsValueChanged(evt);
            }
        });
        ScrollPaneList.setViewportView(ListPlugins);

        ButtonLoadPlugin.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        ButtonLoadPlugin.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLoadPlugin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonLoadPlugin.setIcon(new javax.swing.ImageIcon("C:\\Users\\camm0\\Documents\\NetBeansProjects\\Parcial2\\IdeUnillanos\\Resources\\loadFile.png")); // NOI18N
        ButtonLoadPlugin.setText("Cargar Plugin");
        ButtonLoadPlugin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonLoadPlugin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonLoadPluginMouseClicked(evt);
            }
        });

        ButtonExecutePlugin.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        ButtonExecutePlugin.setForeground(new java.awt.Color(255, 255, 255));
        ButtonExecutePlugin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonExecutePlugin.setIcon(new javax.swing.ImageIcon("C:\\Users\\camm0\\Documents\\NetBeansProjects\\Parcial2\\IdeUnillanos\\Resources\\ejecutable.png")); // NOI18N
        ButtonExecutePlugin.setText("Ejecutar Plugin");
        ButtonExecutePlugin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonExecutePlugin.setMaximumSize(new java.awt.Dimension(72, 16));
        ButtonExecutePlugin.setMinimumSize(new java.awt.Dimension(72, 16));
        ButtonExecutePlugin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonExecutePluginMouseClicked(evt);
            }
        });

        ListPluginsLabel.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        ListPluginsLabel.setForeground(new java.awt.Color(255, 255, 255));
        ListPluginsLabel.setText("Listado de plugins:");

        javax.swing.GroupLayout PanelLeftLayout = new javax.swing.GroupLayout(PanelLeft);
        PanelLeft.setLayout(PanelLeftLayout);
        PanelLeftLayout.setHorizontalGroup(
            PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLeftLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonLoadPlugin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonExecutePlugin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollPaneList, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(ListPluginsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        PanelLeftLayout.setVerticalGroup(
            PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLeftLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(ButtonLoadPlugin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(ListPluginsLabel)
                .addGap(34, 34, 34)
                .addComponent(ScrollPaneList, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(ButtonExecutePlugin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        PanelParent.add(PanelLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -24, 360, 690));

        ButtonLoadFile.setBackground(new java.awt.Color(30, 174, 255));
        ButtonLoadFile.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        ButtonLoadFile.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLoadFile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonLoadFile.setIcon(new javax.swing.ImageIcon("C:\\Users\\camm0\\Documents\\NetBeansProjects\\Parcial2\\IdeUnillanos\\Resources\\loadFile.png")); // NOI18N
        ButtonLoadFile.setText("Cargar archivo");
        ButtonLoadFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonLoadFile.setOpaque(true);
        ButtonLoadFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonLoadFileMouseClicked(evt);
            }
        });
        PanelParent.add(ButtonLoadFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 170, 30));

        getContentPane().add(PanelParent, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListPluginsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListPluginsValueChanged
        if (!evt.getValueIsAdjusting()) {
            JList<String> _pluginList = (JList<String>) evt.getSource();
            String selectedPlugin = _pluginList.getSelectedValue();
            TextPaneOutMessage.setText("Se ha seleccionado el plugin: "+selectedPlugin);
            jarSelected = selectedPlugin;
        }
    }//GEN-LAST:event_ListPluginsValueChanged

    private void CloseProgramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseProgramMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CloseProgramMouseClicked

    private void TopBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopBarMousePressed
       xMouse = evt.getX();
       yMouse = evt.getY();
    }//GEN-LAST:event_TopBarMousePressed

    private void TopBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopBarMouseDragged
        int xScreen = evt.getXOnScreen();
        int yScreen = evt.getYOnScreen();

        this.setLocation(xScreen - xMouse, yScreen - yMouse);
    }//GEN-LAST:event_TopBarMouseDragged

    private void ButtonLoadPluginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoadPluginMouseClicked
       JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JAR", "jar"));

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            _ideController.loadPlugin(selectedFile, TextPaneOutMessage, ListPlugins);
        }
    }//GEN-LAST:event_ButtonLoadPluginMouseClicked

    private void ButtonExecutePluginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExecutePluginMouseClicked
        if(this.javaFile != null){
            _ideController.executePlugin(jarSelected, TextPaneProcessedFile, TextPaneOutMessage);
        }else{
            TextPaneOutMessage.setText("Elije el archivo inicial");
        }
    }//GEN-LAST:event_ButtonExecutePluginMouseClicked

    private void ButtonLoadFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoadFileMouseClicked
        if (evt.getSource() == this.ButtonLoadFile) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Java", "java");
            fileChooser.setFileFilter(filter);
            int seleccion = fileChooser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                this.javaFile = fileChooser.getSelectedFile();
                _ideController.loadFile(javaFile, TextPaneFirstFile, TextPaneOutMessage);
            }else{
                this.TextPaneOutMessage.setText("Seleccione un archivo correcto");
            }
        }
    }//GEN-LAST:event_ButtonLoadFileMouseClicked

   
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
    private javax.swing.JLabel ButtonExecutePlugin;
    private javax.swing.JLabel ButtonLoadFile;
    private javax.swing.JLabel ButtonLoadPlugin;
    private javax.swing.JLabel CloseProgram;
    private javax.swing.JLabel LabelFirstFile;
    private javax.swing.JLabel LabelOutMessage;
    private javax.swing.JLabel LabelProcessedFile;
    private javax.swing.JList<String> ListPlugins;
    private javax.swing.JLabel ListPluginsLabel;
    private javax.swing.JPanel PanelLeft;
    private javax.swing.JPanel PanelParent;
    private javax.swing.JScrollPane ScrollPaneFirstFile;
    private javax.swing.JScrollPane ScrollPaneList;
    private javax.swing.JScrollPane ScrollPaneOutMessage;
    private javax.swing.JScrollPane ScrollPaneProcessedFile;
    private javax.swing.JTextPane TextPaneFirstFile;
    private javax.swing.JTextPane TextPaneOutMessage;
    private javax.swing.JTextPane TextPaneProcessedFile;
    private javax.swing.JPanel TopBar;
    // End of variables declaration//GEN-END:variables
}
