package com.software.Interfaces;

import java.io.File;
import java.util.Map;
import javax.swing.JList;
import javax.swing.JTextPane;


public interface IPluginController {
    boolean addPlugin(File pluginJar, JList listComponents);
    void setPluginList(Map<String, File> pluginList);
    void executePlugin(String pluginName, File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage);
}
