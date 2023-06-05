/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.Controllers;

import com.software.Services.ComponentsServices;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author camm0
 */
public class ButtonController {
    
    
    
    public ButtonController(){


    }
    
    public void LoadFile(File fileJava, JTextPane textPaneFile, JTextPane textPaneOutMessage){
        
        StyledDocument doc = textPaneOutMessage.getStyledDocument();
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileJava))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            
            StyleConstants.setForeground(attributeSet, Color.GREEN);
            StyleConstants.setBold(attributeSet, true);
            
            try {
                doc.insertString(doc.getLength(), "Archivo cargado correctamente", attributeSet);
            } catch (Exception e) {
                textPaneOutMessage.setText("Error al copiar el archivo: " + e.getMessage());
            }
            textPaneFile.setText(contenido.toString());
        } catch (IOException e) {
            textPaneOutMessage.setText("Error al leer el archivo" + e);
        }
    }
    
    public File LoadComponent(File fileJar ,JTextPane textPaneOutMessage, JList listComponents){
        String destinationFolderPath = "../plugins/"; // Ruta de la carpeta de destino
        StyledDocument doc = textPaneOutMessage.getStyledDocument();
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        
        
        try {
            // Copiar el archivo seleccionado a la carpeta de destino
            Path sourcePath = fileJar.toPath();
            Path destinationPath = Path.of(destinationFolderPath, fileJar.getName());
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

            StyleConstants.setForeground(attributeSet, Color.GREEN);
            StyleConstants.setBold(attributeSet, true);
            
            try {
                doc.insertString(doc.getLength(), "Archivo copiado exitosamente", attributeSet);
            } catch (Exception e) {
                textPaneOutMessage.setText("Error al copiar el archivo: " + e.getMessage());
            }
            
            textPaneOutMessage.setText("Archivo copiado exitosamente");
            
            System.out.println(destinationFolderPath+fileJar.getName());
            
            return new File(destinationFolderPath+fileJar.getName());
            
        } catch (IOException ex) {
            ex.printStackTrace();
            
            StyleConstants.setForeground(attributeSet, Color.RED);
            StyleConstants.setBold(attributeSet, true);
            
            try {
                doc.insertString(doc.getLength(), "Error al copiar el archivo", attributeSet);
            } catch (Exception e) {
                textPaneOutMessage.setText("Error al copiar el archivo: " + e.getMessage());
            }
            
            return null;
            
        }    
    }
}
