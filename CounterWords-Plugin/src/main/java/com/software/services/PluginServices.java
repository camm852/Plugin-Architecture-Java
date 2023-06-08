package com.software.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class PluginServices {
    public static void counterWords(File fileJava, JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage){
        try {
            String fileContent = readFile(fileJava);
            Map<String, Integer> wordCount = countWords(fileContent);

            StyledDocument doc = textPaneProcessedFile.getStyledDocument();
            Style style = doc.addStyle("Style", null);

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                String word = entry.getKey();
                int count = entry.getValue();
                String text = word + " (" + count + ")\n";

                doc.insertString(doc.getLength(), text, style);
                textPaneOutMessage.setText("Palabras contadas correctamente");
            }
        } catch (IOException | BadLocationException e) {
            textPaneOutMessage.setText("Fallo al contar las palabras");
        }
    }
    
    private static String readFile(File fileJava) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileJava))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[\\s().\";\\d!@#\\[\\]/*:_=+\\{\\}-]+");
                for (String word : words) {
                    if(word.length() == 0) continue;
                    content.append(word).append("\n");
                }
            }
        }
        return content.toString();
    }
    
    private static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            word = word.toLowerCase();
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        return wordCount;
    }
}
