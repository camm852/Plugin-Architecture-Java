package com.software.api;


import com.iplugin.interfaces.IPlugin;
import com.software.Interfaces.IPluginController;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private String pathPlugins = "";

    /**
     * Default constructor for PluginController.
     */
    public PluginController() {

    }

    /**
     * Constructor for PluginController that loads plugins from the specified path and refreshes the plugin list in the given JList.
     *
     * @param pathPlugins The String where will load  the plugins.
     */
    public PluginController(String pathPlugins) {
        
        this.pathPlugins = pathPlugins;
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
    private File findPluginFromName(String pluginName) {

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
     * @return 
     */
    @Override
    public boolean addPlugin(File pluginJar, JList pluginList) {
        try {
            URLClassLoader child = new URLClassLoader(
                    new URL[]{pluginJar.toURI().toURL()},
                    this.getClass().getClassLoader()
            );

            // Verificar si el JAR contiene el paquete y la clase
            Class<?> classToLoad;
            try {
                classToLoad = Class.forName("com.software.plugin.ExecutePlugin", true, child);
            } catch (ClassNotFoundException e) {
                System.out.println("La clase no se encontró en el JAR.");
                return false;
            }

            // Verificar si la clase implementa la interfaz
            Class<?> interfaz = IPlugin.class;
            if (!interfaz.isAssignableFrom(classToLoad)) {
                System.out.println("La clase no implementa la interfaz.");
                return false;
            }

            // Si todo es exitoso, realizar las operaciones adicionales
            plugins.put(pluginJar.getName(), pluginJar);
            refreshPluginList(pluginList);
            return true;
        } catch (MalformedURLException e) {
            System.out.println("URL inválida al cargar el JAR.");
        } catch (SecurityException e) {
            System.out.println("Error de seguridad al cargar el JAR.");
        } catch (Exception e) {
            System.out.println("Otro error al cargar el JAR.");
        }

        return false; // Devolver false en caso de cualquier error

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

    @Override
    public void setPluginList(Map<String, File> pluginList) {
        this.plugins = pluginList;
    }
    
}