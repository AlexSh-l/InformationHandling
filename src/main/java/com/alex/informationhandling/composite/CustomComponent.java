package com.alex.informationhandling.composite;

import java.util.List;

public interface CustomComponent {

    CustomComponentType getComponentType();

    void add(CustomComponent component);

    void remove(CustomComponent component);

    void remove(int index);

    CustomComponent getChild(int index);

    List<CustomComponent> getChildren();
}
