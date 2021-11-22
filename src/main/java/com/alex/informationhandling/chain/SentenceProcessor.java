package com.alex.informationhandling.chain;

import com.alex.informationhandling.composite.CustomComponent;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomComposite;

public class SentenceProcessor extends AbstractProcessor {

    private static final String SENTENCE_SPLITTER = "(?<=[.!?])\\s* ";

    private AbstractProcessor nextProcessor = new LexemeProcessor();

    @Override
    public void processText(String item, CustomComponent component) {
        String[] sentences = item.split(SENTENCE_SPLITTER);
        for (String sentence : sentences) {
            CustomComponent customComponent = new CustomComposite(CustomComponentType.SENTENCE);
            nextProcessor.processText(sentence, customComponent);
            component.add(customComponent);
        }
    }
}
