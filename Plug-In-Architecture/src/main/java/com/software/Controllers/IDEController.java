/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.Controllers;

import com.software.Dto.JavaFileDto;
import com.software.Interfaces.IIDEController;
import com.software.Services.IDEServices;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTextPane;

/**
 *
 * @author camm0
 */
public class IDEController implements IIDEController{

    private final IDEServices ideServices;

    public IDEController() {
        this.ideServices = IDEServices.getInstance();
    }
    
    public IDEController(JList plugingList) {
        this.ideServices = IDEServices.getInstance(plugingList);
    }    
    
    @Override
    public void loadFile(JavaFileDto fileJava, JTextPane textPaneFile, JTextPane textPaneOutMessage) {
        
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(fileJava.getFile()));
            this.ideServices.writeFileToJTextPane(buffer, textPaneFile, textPaneOutMessage);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IDEController.class.getName()).log(Level.SEVERE, null, ex);
            textPaneOutMessage.setText("Error al cargar el archivo: " + ex.getMessage());
        }
        
    }

    @Override
    public void loadPlugin(File pluginJar, JTextPane textPaneOutMessage, JList pluginList) {
        this.ideServices.loadPluginToIDE(pluginJar, textPaneOutMessage, pluginList);
    }

    @Override
    public void executePlugin(String nameJar, JavaFileDto fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
