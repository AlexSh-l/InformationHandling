package com.alex.informationhandling.chain;

import com.alex.informationhandling.composite.CustomComponent;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomLeaf;

import java.util.regex.Pattern;

public class SymbolProcessor extends AbstractProcessor {

    private static final String PUNCTUATION_SYMBOL = "\\p{P}\\s";

    private static final String LETTER = "\\p{L}";

    @Override
    public void processText(String item, CustomComponent component) {
        for (int i = 0; i < item.length(); i++) {
            char symbol = item.charAt(i);
            boolean isPunctuationSymbol = Pattern.matches(PUNCTUATION_SYMBOL, String.valueOf(symbol));
            boolean isLetter = Pattern.matches(LETTER, String.valueOf(symbol));
            if (isPunctuationSymbol) {
                component.add(new CustomLeaf(symbol, CustomComponentType.PUNCTUATION));
            } else {
                if (isLetter) {
                    component.add(new CustomLeaf(symbol, CustomComponentType.LETTER));
                } else {
                    component.add(new CustomLeaf(symbol, CustomComponentType.SYMBOL));
                }
            }
        }
    }
}
