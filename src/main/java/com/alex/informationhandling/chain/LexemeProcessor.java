package com.alex.informationhandling.chain;

import com.alex.informationhandling.composite.CustomComponent;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomComposite;

public class LexemeProcessor extends AbstractProcessor {

    private static final String BLANK_SPACE = "\\s";

    private AbstractProcessor nextProcessor = new WordProcessor();

    @Override
    public void processText(String item, CustomComponent component) {
        String[] lexemes = item.split(BLANK_SPACE);
        for (String lexeme : lexemes) {
            CustomComponent customComponent = new CustomComposite(CustomComponentType.LEXEME);
            nextProcessor.processText(lexeme, customComponent);
            component.add(customComponent);
        }
    }
}
