package com.software.Services;

import com.software.Dto.JavaFileDto;
import com.software.Interfaces.IPluginController;
import com.software.api.PluginController;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTextPane;

public class IDEServices {
    
    private static IDEServices ideServices = null;
    private final IPluginController _pluginController;
    
    
    private IDEServices(){
        _pluginController = new PluginController();
    }
    
    private IDEServices(JList pluginList){
        _pluginController = new PluginController(pluginList);
    }
    
    
    public void writeFileToJTextPane(BufferedReader buffer, JTextPane textPaneFile, JTextPane textPaneOutMessage){
        StringBuilder contenido = new StringBuilder();
        String linea;
        try {
            while ((linea = buffer.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            textPaneFile.setText(contenido.toString());

        } catch (IOException ex) {
            Logger.getLogger(IDEServices.class.getName()).log(Level.SEVERE, null, ex);
            textPaneOutMessage.setText("Error al cargar la informacion: " + ex.getMessage());
        }
    }
    
    private boolean copyJarToClassPath(String destinationFolderPath, File pluginJar){
        Path sourcePath = pluginJar.toPath();
        Path destinationPath = Path.of(destinationFolderPath, pluginJar.getName());
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(IDEServices.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void loadPluginToIDE(File pluginJar, JTextPane textPaneOutMessage, JList pluginList){
        String destinationFolderPath = "../Plugins/"; // Ruta de la carpeta de destino
        if(!copyJarToClassPath(destinationFolderPath, pluginJar)){
            textPaneOutMessage.setText("Fallo al cargar el plugin");
            return;
        }
        
        _pluginController.addPlugin(new File(destinationFolderPath+pluginJar.getName()), pluginList);
        textPaneOutMessage.setText("Plugin Cargado correctamente");
    }
    
    public void executePlugin(String pluginName, JavaFileDto fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage){
        _pluginController.executePlugin(pluginName, fileJava.getFile(), textPaneProcessedFile, textPaneOutMessage);
    }
    
    
    
    public static IDEServices getInstance(){
        if(ideServices == null) {
            ideServices = new IDEServices();
        }
        return ideServices;
    }
    
    public static IDEServices getInstance(JList pluginList){
        if(ideServices == null) {
            ideServices = new IDEServices(pluginList);
        }
        return ideServices;
    }
        
}
    
