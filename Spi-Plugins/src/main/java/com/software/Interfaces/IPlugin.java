/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.software.Interfaces;

import java.io.File;
import javax.swing.JTextPane;

/**
 *
 * @author camm0
 */
public interface IPlugin {
    void executePlugin(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage);
}
