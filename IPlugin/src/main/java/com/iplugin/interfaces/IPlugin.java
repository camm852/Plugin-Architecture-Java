package com.iplugin.interfaces;

import java.io.File;
import javax.swing.JTextPane;


public interface IPlugin {
    void executePlugin(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage);
}
