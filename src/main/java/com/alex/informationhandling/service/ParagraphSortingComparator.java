package com.alex.informationhandling.service;

import com.alex.informationhandling.composite.CustomComponent;

import java.util.Comparator;

public class ParagraphSortingComparator implements Comparator<CustomComponent> {

    @Override
    public int compare(CustomComponent component1, CustomComponent component2) {
        long counterFirstParagraphsChildren = component1.getChildren().stream().count();
        long counterSecondParagraphsChildren = component2.getChildren().stream().count();
        return Integer.compare((int) counterFirstParagraphsChildren, (int) counterSecondParagraphsChildren);
    }
}
