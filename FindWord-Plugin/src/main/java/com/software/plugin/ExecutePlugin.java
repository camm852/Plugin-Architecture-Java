package com.software.plugin;

import com.software.Interfaces.IPlugin;
import com.software.services.PluginServices;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class ExecutePlugin extends JFrame implements IPlugin {
    
    @Override
    public void executePlugin(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        textPaneOutMessage.setText("");
        setTitle("Búsqueda de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String searchText = JOptionPane.showInputDialog(ExecutePlugin.this, "Ingrese la palabra a buscar:");
        if (searchText != null && !searchText.isEmpty()) {
            PluginServices.searchInFile(searchText, fileJava, textPaneProcessedFile, textPaneOutMessage);
        } else {
            JOptionPane.showMessageDialog(ExecutePlugin.this, "No se ingresó ninguna palabra.");
            textPaneOutMessage.setText("No se ingreso ninguna palabra");
        }
    }

    
    
    
}
