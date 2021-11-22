package com.alex.informationhandling.service;

import com.alex.informationhandling.composite.CustomComponent;

import java.util.ArrayList;
import java.util.List;

public class SentenceDeleterByWordAmount {

    public static CustomComponent deleteSentencesWithLessThanSetAmount(CustomComponent component, int wordAmount) {
        for (CustomComponent paragraph : component.getChildren()) {
            List<Integer> indexesToDelete = new ArrayList<>();
            for (int j = 0; j < paragraph.getChildren().size(); j++) {
                CustomComponent sentence = paragraph.getChild(j);
                int wordCounter = sentence.getChildren().size();
                if (wordCounter < wordAmount) {
                    indexesToDelete.add(j);
                }
            }
            int sentencesDeleted = 0;
            for (int j = 0; j < indexesToDelete.size(); j++) {
                paragraph.remove(indexesToDelete.get(j) - sentencesDeleted);
                sentencesDeleted++;
            }
        }
        return component;
    }
}
