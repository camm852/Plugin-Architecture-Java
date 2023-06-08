package com.software.Interfaces;

import java.io.File;
import javax.swing.JList;
import javax.swing.JTextPane;


public interface IIDEController {
    void loadFile(File fileJava, JTextPane textPaneFile, JTextPane textPaneOutMessage);
    void loadPlugin(File fileJar ,JTextPane textPaneOutMessage, JList pluginsList);
    void loadPluginsPrevLoaded(JList listPlugins);
    void executePlugin(String nameJar, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage);
}
