/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.Services;

import com.software.Interfaces.IPlugin;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextPane;

/**
 *
 * @author camm0
 */
public class ComponentsServices {
    
    private Map<String, File> components = new HashMap<>();
    private final String pathPlugins = "../Plugins/";
    
    public ComponentsServices(){
        
    }
    
    
    
    public ComponentsServices(JList listComponents){
        File folder = new File(pathPlugins);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                    components.put(file.getName(), file);
                }
            }
        }
        refreshList(listComponents);
    }
    
    
    public void refreshList(JList listComponents){
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(Map.Entry<String, File> entry : components.entrySet()){
            model.addElement(entry.getKey());
        }
        
        listComponents.setModel(model);
    }
    
    public void addComponent(File fileJar, JList listComponents){
        components.put(fileJar.getName(), fileJar);
        refreshList(listComponents);
    }
    
    private File findFileFromName(String nameJar){
        
        File jarFile = null;
        
        for(Map.Entry<String, File> entry : components.entrySet()){
           
            if(entry.getKey().equals(nameJar)){
                jarFile = entry.getValue();
            }
        }
        return jarFile;
    }
    
    public void executeComponent(String nameJar, File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        File jarFile = findFileFromName(nameJar);
        try {
            URLClassLoader child = new URLClassLoader(
                new URL[] {jarFile.toURI().toURL()},
                this.getClass().getClassLoader()
            );
            Class classToLoad = Class.forName("com.software.plugin.ExecutePlugin", true, child);

            Method method = classToLoad.getDeclaredMethod("executePlugin", File.class, JTextPane.class, JTextPane.class);

            System.out.println(jarFile.toPath().toString());
            
            IPlugin instance = (IPlugin)classToLoad.newInstance();

            //Object []parameters = {fileJava, textPaneProcessedFile, textPaneOutMessage};
            
            instance.executePlugin(fileJava, textPaneProcessedFile, textPaneOutMessage);
            
            //Object result = method.invoke(instance, parameters);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            textPaneOutMessage.setText("Fallo al ejecutar el plug-in");

        }


            
        
    }
        // Crea un URLClassLoader con la ruta del JAR
        
}
    
