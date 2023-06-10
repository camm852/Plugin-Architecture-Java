package com.software.Persistence;

import com.software.Interfaces.IPluginsRepository;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PluginsRepository implements IPluginsRepository {

    /**
     * Find plugins already loaded in a folder
     * @param pathPlugins
     * @return Map that contain plugins prev loaded
     */
    
    
    @Override
    public Map<String, File> getLoadedPlugins(String pathPlugins) {
        
        Map<String, File> plugins = new HashMap<>();
        
        File folder = new File(pathPlugins);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                    plugins.put(file.getName(), file);
                }
            }
        }
        
        return plugins;
    }
    
}
