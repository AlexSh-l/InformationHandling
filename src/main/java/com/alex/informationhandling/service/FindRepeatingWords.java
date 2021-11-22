package com.alex.informationhandling.service;

import com.alex.informationhandling.composite.CustomComponent;

import java.util.*;

public class FindRepeatingWords {

    public static Map<String, Integer> findWords(CustomComponent component) {
        HashMap<String, Integer> repeatingWords = new HashMap<>();
        HashMap<String, Integer> filteredWords = new HashMap<>();
        List<CustomComponent> text = component.getChildren();
        for (int i = 0; i < text.size(); i++) {
            CustomComponent paragraph = text.get(i);
            List<CustomComponent> sentences = paragraph.getChildren();
            for (CustomComponent sentence : sentences) {
                List<CustomComponent> words = sentence.getChildren();
                for (CustomComponent word : words) {
                    if (repeatingWords.containsKey(word.toString())) {
                        repeatingWords.computeIfPresent(word.toString(), (value, counter) -> counter + 1);
                    } else {
                        repeatingWords.put(word.toString(), 1);
                    }
                }
            }
        }
        repeatingWords.remove("");
        Set<Map.Entry<String, Integer>> repeatingWordsEntry = repeatingWords.entrySet();
        for (Map.Entry<String, Integer> entry : repeatingWordsEntry) {
            if (entry.getValue() > 1) {
                filteredWords.put(entry.getKey(), entry.getValue());
            }
        }
        return filteredWords;
    }
}
