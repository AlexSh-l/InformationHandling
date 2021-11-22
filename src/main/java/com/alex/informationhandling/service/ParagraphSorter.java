package com.alex.informationhandling.service;

import com.alex.informationhandling.composite.CustomComponent;

import java.util.ArrayList;

public class ParagraphSorter {

    public static ArrayList<CustomComponent> sort(CustomComponent component) {
        ArrayList<CustomComponent> resultingText = new ArrayList<>();
        for (int i = 0; i < (int) component.getChildren().stream().count(); i++) {
            resultingText.add(component.getChild(i));
        }
        resultingText.sort(new ParagraphSortingComparator());
        return resultingText;
    }
}
