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
 * The IDEController class implements the IIDEController interface and provides the controller for the IDE (Integrated Development Environment).
 */
public class IDEController implements IIDEController {

    private final IDEServices ideServices;

    /**
     * Default constructor for IDEController.
     */
    public IDEController() {
        this.ideServices = IDEServices.getInstance();
    }

    /**
     * Constructor for IDEController that initializes it with a given plugin list.
     *
     * @param pluginList The JList representing the plugin list.
     */
    public IDEController(JList pluginList) {
        this.ideServices = IDEServices.getInstance(pluginList);
    }

    /**
     * Loads a Java file into the IDE program.
     *
     * @param fileJava           The Java file to be loaded.
     * @param textPaneFile       The JTextPane where the Java file will be displayed.
     * @param textPaneOutMessage The JTextPane for displaying status or error messages.
     */
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

    /**
     * Loads a plugin JAR file into the IDE program.
     *
     * @param pluginJar          The plugin JAR file to be loaded.
     * @param textPaneOutMessage The JTextPane for displaying status or error messages.
     * @param pluginList         The JList representing the plugin list to be refreshed.
     */
    @Override
    public void loadPlugin(File pluginJar, JTextPane textPaneOutMessage, JList pluginList) {
        this.ideServices.loadPluginToIDE(pluginJar, textPaneOutMessage, pluginList);
    }

    /**
     * Executes the functionality of a plugin.
     *
     * @param pluginJar           The name of the plugin.
     * @param fileJava            The Java file to be processed by the plugin.
     * @param textPaneProcessedFile The JTextPane for displaying the processed file.
     * @param textPaneOutMessage  The JTextPane for displaying the output message.
     */
    @Override
    public void executePlugin(String pluginJar, JavaFileDto fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        this.ideServices.executePlugin(pluginJar, fileJava, textPaneProcessedFile, textPaneOutMessage);
    }

}