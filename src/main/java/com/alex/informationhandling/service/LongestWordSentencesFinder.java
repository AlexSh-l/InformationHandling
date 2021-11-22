package com.alex.informationhandling.service;

import com.alex.informationhandling.composite.CustomComponent;
import com.alex.informationhandling.composite.CustomComponentType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestWordSentencesFinder {

    public static Set<String> findSentence(CustomComponent component) {
        int maxWordLettersCount = 0;
        boolean isSymbolCheck = false;
        int lettersCount = 0;
        int symbolsCount = 0;
        Set<String> sentencesWithLongestWord = new HashSet<>();
        List<CustomComponent> text = component.getChildren();
        for (int i = 0; i < text.stream().count(); i++) {
            CustomComponent paragraph = text.get(i);
            List<CustomComponent> sentences = paragraph.getChildren();
            for (CustomComponent sentence : sentences) {
                List<CustomComponent> words = sentence.getChildren();
                for (CustomComponent word : words) {
                    List<CustomComponent> letters = word.getChildren();
                    for (CustomComponent letter : letters) {
                        List<CustomComponent> chars = letter.getChildren();
                        for (int j = 0; j < chars.stream().count(); j++) {
                            if (chars.get(j).getComponentType() == CustomComponentType.LETTER) {
                                lettersCount++;
                            } else {
                                symbolsCount++;
                            }
                        }
                        if (symbolsCount >= 3) {
                            isSymbolCheck = true;
                        }
                        symbolsCount = 0;
                    }
                    if ((lettersCount > maxWordLettersCount) && (!isSymbolCheck)) {
                        sentencesWithLongestWord.clear();
                        maxWordLettersCount = lettersCount;
                        sentencesWithLongestWord.add(sentence.toString().trim());
                    } else if ((lettersCount == maxWordLettersCount) && (!isSymbolCheck)) {
                        sentencesWithLongestWord.add(sentence.toString().trim());
                    }
                    lettersCount = 0;
                }
            }
        }
        return sentencesWithLongestWord;
    }
}
