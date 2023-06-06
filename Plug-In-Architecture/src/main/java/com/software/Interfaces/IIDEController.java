package com.software.Interfaces;

import com.software.Dto.JavaFileDto;
import java.io.File;
import javax.swing.JList;
import javax.swing.JTextPane;


public interface IIDEController {
    void loadFile(JavaFileDto fileJava, JTextPane textPaneFile, JTextPane textPaneOutMessage);
    void loadPlugin(File fileJar ,JTextPane textPaneOutMessage, JList listComponents);
    void executePlugin(String nameJar, JavaFileDto fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage);
}
