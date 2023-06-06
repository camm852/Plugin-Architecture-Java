package com.software.plugin;

import com.software.Interfaces.IPlugin;
import com.software.services.PluginServices;
import javax.swing.*;
import java.io.File;

public class ExecutePlugin implements IPlugin{
    
    @Override
    public void executePlugin(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage){
        textPaneProcessedFile.setText("");
        PluginServices.highlightReservedWords(fileJava, textPaneProcessedFile, textPaneOutMessage);
    }
}
    
