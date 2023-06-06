package com.software.plugin;

import com.software.Interfaces.IPlugin;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecutePlugin implements IPlugin{
    
    @Override
    public void executePlugin(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage){
       textPaneProcessedFile.setText("");
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
        
        DefaultStyledDocument doc = (DefaultStyledDocument) textPaneProcessedFile.getDocument();
        String text;
        try {
            text = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            textPaneOutMessage.setText("Fallo al resaltar el archivo");
            return;
        }

        StyleContext styleContext = StyleContext.getDefaultStyleContext();
        AttributeSet keywordStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.ORANGE);

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
}
    
