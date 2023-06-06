package com.software.api;

import com.software.Interfaces.IPlugin;
import com.software.Interfaces.IPluginController;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextPane;


/**
 * The PluginController class manages the loading and execution of plugins.
 */
public class PluginController implements IPluginController{

    /**
     * Map to store the loaded plugins. The key is the plugin's file name, and the value is the corresponding File object.
     */
    private static Map<String, File> plugins = new HashMap<>();

    
    /**
     * The path where the plugins are located.
     */
    private final String pathPlugins = "../Plugins/";

    /**
     * Default constructor for PluginController.
     */
    public PluginController() {

    }

    /**
     * Constructor for PluginController that loads plugins from the specified path and refreshes the plugin list in the given JList.
     *
     * @param pluginList The JList to be refreshed with the loaded plugin list.
     */
    public PluginController(JList pluginList) {
        File folder = new File(pathPlugins);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                    plugins.put(file.getName(), file);
                }
            }
        }
        refreshPluginList(pluginList);
    }

    /**
     * Refreshes the plugin list in the given JList with the names of the loaded plugins.
     *
     * @param pluginList The JList to be refreshed with the updated plugin list.
     */
    private void refreshPluginList(JList pluginList) {
        DefaultListModel<String> model = new DefaultListModel<>();

        for (Map.Entry<String, File> entry : plugins.entrySet()) {
            model.addElement(entry.getKey());
        }

        pluginList.setModel(model);
    }

    /**
     * Finds a plugin File object from the loaded plugins based on the plugin name.
     *
     * @param pluginName The name of the plugin to find.
     * @return The File object representing the plugin JAR file, or null if not found.
     */
    private  File findPluginFromName(String pluginName) {

        File pluginJar = null;

        for (Map.Entry<String, File> entry : plugins.entrySet()) {
            if (entry.getKey().equals(pluginName)) {
                pluginJar = entry.getValue();
            }
        }
        return pluginJar;
    }
    
    /**
     * Adds a plugin to the map of loaded plugins and refreshes the plugin list in the given JList.
     *
     * @param pluginJar       The File object representing the plugin JAR file.
     * @param pluginList The JList to be refreshed with the updated plugin list.
     */
    @Override
    public void addPlugin(File pluginJar, JList pluginList) {
        plugins.put(pluginJar.getName(), pluginJar);
        refreshPluginList(pluginList);
    }
    
    /**
     * Executes a plugin with the specified plugin name, Java file, and JTextPanes for displaying processed file and output messages.
     *
     * @param pluginName           The name of the plugin to execute.
     * @param fileJava             The Java file to be processed by the plugin.
     * @param textPaneProcessedFile The JTextPane for displaying the processed file.
     * @param textPaneOutMessage   The JTextPane for displaying the output message.
     */
    @Override
    public void executePlugin(String pluginName, File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        File jarFile = findPluginFromName(pluginName);
        try {
            URLClassLoader child = new URLClassLoader(
                    new URL[]{jarFile.toURI().toURL()},
                    this.getClass().getClassLoader()
            );
            Class classToLoad = Class.forName("com.software.plugin.ExecutePlugin", true, child);
            
            Method method = classToLoad.getDeclaredMethod("executePlugin", File.class, JTextPane.class, JTextPane.class);

            System.out.println(jarFile.toPath().toString());

            IPlugin instance = (IPlugin) classToLoad.newInstance();

            instance.executePlugin(fileJava, textPaneProcessedFile, textPaneOutMessage);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | SecurityException | MalformedURLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            textPaneOutMessage.setText("Fallo al ejecutar el plug-in");

        }
    }
    
}