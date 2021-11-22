package com.alex.informationhandling.chain;

import com.alex.informationhandling.composite.CustomComponent;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomComposite;

public class ParagraphProcessor extends AbstractProcessor {

    private static final String PARAGRAPH = "\\s{2}";

    private AbstractProcessor nextProcessor = new SentenceProcessor();

    @Override
    public void processText(String item, CustomComponent component) {
        String[] paragraphs = item.split(PARAGRAPH);
        for (String paragraph : paragraphs) {
            CustomComponent customComponent = new CustomComposite(CustomComponentType.PARAGRAPH);
            nextProcessor.processText(paragraph, customComponent);
            component.add(customComponent);
        }
    }
}
