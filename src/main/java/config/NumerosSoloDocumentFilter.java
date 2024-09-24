package config;

import javax.swing.*;
import javax.swing.text.*;

public class NumerosSoloDocumentFilter extends DocumentFilter {
    
    private int maxCharacters;

    // Constructor para definir el límite de caracteres
    public NumerosSoloDocumentFilter(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string.matches("\\d*") && (fb.getDocument().getLength() + string.length() <= maxCharacters)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text.matches("\\d*") && (fb.getDocument().getLength() - length + text.length() <= maxCharacters)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
