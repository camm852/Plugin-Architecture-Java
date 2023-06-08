package com.software.Interfaces;

import java.io.File;
import java.util.Map;


public interface IPluginsRepository {
    Map<String, File> getLoadedPlugins(String pathPlugins);
}
