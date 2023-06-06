package com.software.plugin;

import com.software.Interfaces.IPlugin;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class ExecutePlugin extends JFrame implements IPlugin {


    
    @Override
    public void executePlugin(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        System.out.println("Buscando palabra");
        setTitle("Búsqueda de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String searchText = JOptionPane.showInputDialog(ExecutePlugin.this, "Ingrese la palabra a buscar:");
        if (searchText != null && !searchText.isEmpty()) {
            searchInFile(searchText, fileJava, textPaneProcessedFile, textPaneOutMessage);
        } else {
            JOptionPane.showMessageDialog(ExecutePlugin.this, "No se ingresó ninguna palabra.");
            textPaneOutMessage.setText("No se ingreso ninguna palabra");

        }
    }

    private void searchInFile(String searchText, File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileJava))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                row++;
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
    }
    
    
    
}
