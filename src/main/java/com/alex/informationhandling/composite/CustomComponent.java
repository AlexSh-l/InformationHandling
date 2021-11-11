package com.alex.informationhandling.composite;

import com.alex.informationhandling.exception.CompositeException;

public interface CustomComponent {

    void operation();

    void add(CustomComponent component) /*throws CompositeException*/;

    void remove(CustomComponent component) /*throws CompositeException*/;

    CustomComponent getChild(int index) /*throws CompositeException*/;
}
