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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextPane;

/**
 * The IDEServices class provides various services for an IDE (Integrated Development Environment).
 */
public class IDEServices {

    private static IDEServices ideServices = null;
    private final IPluginController _pluginController;
    
    /**
     * Private constructor for IDEServices.
     */
    private IDEServices() {
        _pluginController = new PluginController();
    }

    /**
     * Private constructor for IDEServices that initializes it with a given plugin list.
     *
     * @param pluginList The JList representing the plugin list.
     */
    private IDEServices(String pathPlugins) {
        _pluginController = new PluginController(pathPlugins);
    }

    /**
     * Writes the content of a BufferedReader to a JTextPane.
     *
     * @param buffer            The BufferedReader containing the file content.
     */
    public String contentFile(BufferedReader buffer) {
        StringBuilder contenido = new StringBuilder();
        String linea;
        int counterLine = 1;
        try {
            while ((linea = buffer.readLine()) != null) {
                contenido.append(counterLine).append(" ").append(linea).append("\n");
                counterLine++;
            }
            return contenido.toString();

        } catch (IOException ex) {
            Logger.getLogger(IDEServices.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Copies a plugin JAR file to the classpath.
     *
     * @param destinationFolderPath The destination folder path where the JAR file will be copied.
     * @param pluginJar             The plugin JAR file to be copied.
     * @return True if the copy operation was successful, false otherwise.
     */
    private boolean copyJarToClassPath(String destinationFolderPath, File pluginJar) {
        File folder = new File(destinationFolderPath);
        
        if(!folder.exists()) {
            folder.mkdirs();
        }
        
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

    /**
     * Loads a plugin JAR file into the IDE.
     *
     * @param destinationFolderPath The path plugins folder.
     * @param pluginJar         The plugin JAR file to be loaded.
     * @param textPaneOutMessage The JTextPane for displaying status or error messages.
     * @param pluginList        The JList representing the plugin list to be refreshed.
     */
    public void loadPluginToIDE(String destinationFolderPath,File pluginJar, JTextPane textPaneOutMessage, JList pluginList) {
        if (!copyJarToClassPath(destinationFolderPath, pluginJar)) {
            textPaneOutMessage.setText("Fallo al cargar el plugin");
            return;
        }
        if(_pluginController.addPlugin(new File(destinationFolderPath + pluginJar.getName()), pluginList)){
            textPaneOutMessage.setText("Plugin cargado correctamente");
        }else{
            textPaneOutMessage.setText("El plugin no es compatible o hubo un fallo al cargarlo");
        }
    }
    
    
    public DefaultListModel<String> loadPluginsPrevLoaded(Map<String,File> pluginList){
        DefaultListModel<String> model = new DefaultListModel<>();

        for (Map.Entry<String, File> entry : pluginList.entrySet()) {
            model.addElement(entry.getKey());
        }
        this._pluginController.setPluginList(pluginList);
        return model; 
    }
    
    

    /**
     * Executes a plugin with the specified plugin name, Java file, and JTextPanes for displaying processed file and output messages.
     *
     * @param pluginName           The name of the plugin to execute.
     * @param fileJava             The Java file to be processed by the plugin.
     * @param textPaneProcessedFile The JTextPane for displaying the processed file.
     * @param textPaneOutMessage   The JTextPane for displaying the output message.
     */
    public void executePlugin(String pluginName, JavaFileDto fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        _pluginController.executePlugin(pluginName, fileJava.getFile(), textPaneProcessedFile, textPaneOutMessage);
    }

    /**
     * Gets the instance of IDEServices (Singleton pattern).
     *
     * @return The instance of IDEServices.
     */
    public static IDEServices getInstance() {
        if (ideServices == null) {
            ideServices = new IDEServices();
        }
        return ideServices;
    }

    /**
     * Gets the instance of IDEServices (Singleton pattern) with a given plugin list.
     *
     * @param pathPlugins The pathPlugins representing the plugins folder.
     * @return The instance of IDEServices.
     */
    public static IDEServices getInstance(String pathPlugins) {
        if (ideServices == null) {
            ideServices = new IDEServices(pathPlugins);
        }
        return ideServices;
    }

}