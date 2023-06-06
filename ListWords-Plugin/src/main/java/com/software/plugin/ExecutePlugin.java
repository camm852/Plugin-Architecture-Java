package com.software.plugin;

import com.software.Interfaces.IPlugin;
import com.software.services.PluginServices;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;



public class ExecutePlugin implements IPlugin {

    @Override
    public void executePlugin(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        textPaneProcessedFile.setText("");
        try {
            List<String> listWords = PluginServices.ListWords(fileJava);
            PluginServices.writeContentToTextPane(textPaneProcessedFile, textPaneOutMessage, listWords);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExecutePlugin.class.getName()).log(Level.SEVERE, null, ex);
            textPaneOutMessage.setText("Fallo al ejecutar el plugin");
        }
    }
    
   
    
    
}
