package com.alex.informationhandling.chain;

import com.alex.informationhandling.composite.CustomComponent;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProcessor extends AbstractProcessor {

    private static final String WORD = "\\p{L}+";

    private static final String SYMBOL = "[.'\"()-:?!=“”]";

    private AbstractProcessor nextProcessor = new SymbolProcessor();

    @Override
    public void processText(String item, CustomComponent component) {
        Pattern pattern = Pattern.compile(WORD);
        Matcher matcher = pattern.matcher(item);
        if (matcher.find()) {
            CustomComponent customComponent = new CustomComposite(CustomComponentType.WORD);
            nextProcessor.processText(item, customComponent);
            component.add(customComponent);
        }
        pattern = Pattern.compile(SYMBOL);
        matcher = pattern.matcher(item);
        if (matcher.matches()) {
            CustomComponent customComponent = new CustomComposite(CustomComponentType.SYMBOL);
            nextProcessor.processText(item, customComponent);
            component.add(customComponent);
        }
    }
}
