/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.plugin;

import com.software.Interfaces.IPlugin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author camm0
 */
public class ExecutePlugin implements IPlugin {

    @Override
    public void executePlugin(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage) {
        try {
            List<String> palabras = obtenerPalabrasArchivo(fileJava);
            mostrarPalabrasEnJTextPane(textPaneProcessedFile, palabras);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExecutePlugin.class.getName()).log(Level.SEVERE, null, ex);
            textPaneOutMessage.setText("Fallo al listar las palabras");
        }
    }
    
    private List<String> obtenerPalabrasArchivo(File fileJava) throws FileNotFoundException {
        Scanner scanner = new Scanner(fileJava);

        Set<String> palabrasUnicas = new HashSet<>();
        List<String> palabrasFiltradas = new ArrayList<>();

        while (scanner.hasNext()) {
            String palabra = scanner.next().toLowerCase();
            if (esPalabraValida(palabra)) {
                if (!palabrasUnicas.contains(palabra)) {
                    palabrasUnicas.add(palabra);
                    palabrasFiltradas.add(palabra);
                }
            }
        }

        scanner.close();
        return palabrasFiltradas;
    }

    private boolean esPalabraValida(String palabra) {
        // Agrega aquí los conectores o palabras que deseas filtrar
        String[] conectores = {"el", "la", "los", "las", "de", "en", "y", "o"};

        return palabra.length() > 1 && !Arrays.asList(conectores).contains(palabra);
    }
    
    private void mostrarPalabrasEnJTextPane(JTextPane textPane, List<String> palabras) {
        StyledDocument document = textPane.getStyledDocument();
        Style defaultStyle = textPane.getStyle(StyleContext.DEFAULT_STYLE);

        for (String palabra : palabras) {
            try {
                document.insertString(document.getLength(), palabra + "\n", defaultStyle);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
