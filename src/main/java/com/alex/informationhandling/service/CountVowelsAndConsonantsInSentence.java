package com.alex.informationhandling.service;

import com.alex.informationhandling.composite.CustomComponent;

import java.util.List;

public class CountVowelsAndConsonantsInSentence {

    private static final String VOWELS = "aeiouyAEIOUYаеёиоуыэюяАЕЁИОУЭЮЯ";

    private static final String CONSONANTS = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZбвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";

    public static int[] countVowelsAndConsonants(CustomComponent component) {
        int[] result = new int[2];
        int vowels = 0;
        int consonants = 0;
        List<CustomComponent> words = component.getChildren();
        for (CustomComponent word : words) {
            List<CustomComponent> letters = word.getChildren();
            for (CustomComponent letter : letters) {
                List<CustomComponent> chars = letter.getChildren();
                for (int j = 0; j < chars.size(); j++) {
                    if (VOWELS.contains(chars.get(j).toString())) {
                        vowels++;
                    } else if (CONSONANTS.contains(chars.get(j).toString())) {
                        consonants++;
                    }
                }
            }
        }
        result[0] = vowels;
        result[1] = consonants;
        return result;
    }
}
