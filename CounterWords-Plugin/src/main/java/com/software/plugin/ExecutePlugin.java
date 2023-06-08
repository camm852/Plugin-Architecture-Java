package com.software.plugin;

import com.iplugin.interfaces.IPlugin;
import com.software.services.PluginServices;
import java.io.File;
import javax.swing.JTextPane;

public class ExecutePlugin implements IPlugin {
   

    @Override
    public void executePlugin(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        textPaneProcessedFile.setText("");
        PluginServices.counterWords(fileJava, textPaneProcessedFile, textPaneOutMessage);
    }
    
   
}
