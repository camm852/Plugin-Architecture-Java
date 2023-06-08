package com.software.Entities;

import com.software.Interfaces.IPluginsRepository;
import com.software.Persistence.PluginsRepository;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ListPlugins {
    private Map<String, File> plugins;
    
    public ListPlugins(){
        this.plugins = new HashMap<>();
    }
    
    public ListPlugins(Map<String, File> listPlugins){
        this.plugins = listPlugins;
    }
    
    public Map<String, File> GetListPlugins(String pathPlugins){
        IPluginsRepository pluginsRepository = new PluginsRepository();
        
        this.plugins = pluginsRepository.getLoadedPlugins(pathPlugins);
        
        return this.plugins;
    }
    

}
