package com.software.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;


/**
 * The PluginServices class provides utility methods related to plugins.
 */
public class PluginServices {

    /**
     * Retrieves a list of unique words from a Java file.
     *
     * @param fileJava The Java file to extract the words from.
     * @return A list of unique words.
     * @throws FileNotFoundException If the specified Java file is not found.
     */
    public static List<String> listWords(File fileJava) throws FileNotFoundException {
        Scanner scanner = new Scanner(fileJava);

        Set<String> uniqueWords = new HashSet<>();

        while (scanner.hasNext()) {
            String line = scanner.next().toLowerCase();
            String[] words = line.split("[\\s().\";\\d!@#\\[\\]/*:_-]+");
            for (String word : words) {
                if (isValidWord(word)) {
                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }
                }
            }
        }
        scanner.close();
        return new ArrayList<>(uniqueWords);
    }

    /**
     * Checks if a word is valid (meets certain criteria).
     *
     * @param word The word to check.
     * @return True if the word is valid, false otherwise.
     */
    private static boolean isValidWord(String word) {
        // Add here the connectors
        String[] connectors = {"el", "la", "los", "las", "de", "en", "y", "o"};

        return word.length() > 1 && !Arrays.asList(connectors).contains(word);
    }

    /**
     * Writes the content of a list of words to a JTextPane.
     *
     * @param textPaneProcessedFile The JTextPane where the words will be displayed.
     * @param textPaneOutMessage    The JTextPane for displaying status or error messages.
     * @param palabras              The list of words to be written.
     */
    public static void writeContentToTextPane(JTextPane textPaneProcessedFile, JTextPane textPaneOutMessage, List<String> palabras) {
        StyledDocument document = textPaneProcessedFile.getStyledDocument();
        Style defaultStyle = textPaneProcessedFile.getStyle(StyleContext.DEFAULT_STYLE);

        for (String palabra : palabras) {
            try {
                document.insertString(document.getLength(), palabra + "\n", defaultStyle);
                textPaneOutMessage.setText("Se han listado las palabras correctamente");
            } catch (BadLocationException e) {
                textPaneOutMessage.setText("Fallo al listar las palabras");
            }
        }
    }
}