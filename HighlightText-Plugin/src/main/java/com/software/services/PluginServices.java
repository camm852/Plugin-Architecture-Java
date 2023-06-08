package com.software.services;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class PluginServices {
    public static void highlightReservedWords(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage){
        
        writeContent(fileJava, textPaneProcessedFile, textPaneOutMessage);
        
        DefaultStyledDocument doc = (DefaultStyledDocument) textPaneProcessedFile.getDocument();
        String text;
        try {
            text = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            textPaneOutMessage.setText("Fallo al resaltar el archivo");
            return;
        }

        StyleContext styleContext = StyleContext.getDefaultStyleContext();
        AttributeSet keywordStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0x1EAEFF));

        String[] keywords = {
                "import", "public", "private", "static", "void", "class", "implements", "package",
                "int", "String", "boolean", "float", "long", "double", "while", "for", "switch", "case", "break",
                "continue", "new", "try", "catch", "return"
        };
        

        for (String keyword : keywords) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(keyword) + "\\b");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                doc.setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), keywordStyle, false);
            }
        }
        textPaneProcessedFile.setDocument(doc);
        textPaneOutMessage.setText("Archivo resaltado correctamente");
    }
    
    private static void writeContent(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileJava))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            textPaneProcessedFile.setText(contenido.toString());
        } catch (IOException e) {
            textPaneOutMessage.setText("Error al leer el archivo" + e);
        }
    }
    
    
}
