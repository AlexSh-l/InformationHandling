package com.alex.informationhandling.chain;

import com.alex.informationhandling.composite.CustomComponent;

public class TextProcessor extends AbstractProcessor {

    private AbstractProcessor nextProcessor = new ParagraphProcessor();

    @Override
    public void processText(String item, CustomComponent component) {
        nextProcessor.processText(item, component);
    }
}
