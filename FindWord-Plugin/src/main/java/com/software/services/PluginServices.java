package com.software.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextPane;

public class PluginServices{
    public static void searchInFile(String searchText, File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage){
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileJava))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                row++;
                line = line.toLowerCase();
                searchText = searchText.toLowerCase();
                int column = line.indexOf(searchText);
                if (column != -1) {
                    result.append("Encontrado en la fila ").append(row).append(", columna ").append(column).append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
            textPaneOutMessage.setText("Fallo al buscar la palabra");
        }

        textPaneProcessedFile.setText(result.toString());
        textPaneOutMessage.setText("Plugin ejecutado correctamente");
    }
}
