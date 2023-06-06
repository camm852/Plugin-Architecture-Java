package com.software.Interfaces;

import java.io.File;
import javax.swing.JList;
import javax.swing.JTextPane;


public interface IPluginController {
    void addPlugin(File pluginJar, JList listComponents);
    void executePlugin(String pluginName, File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage);
}
