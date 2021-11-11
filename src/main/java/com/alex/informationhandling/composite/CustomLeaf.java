package com.alex.informationhandling.composite;

import com.alex.informationhandling.exception.CompositeException;

public class CustomLeaf implements CustomComponent {
    @Override
    public void operation() {

    }

    @Override
    public void add(CustomComponent component) {
        //throw new CompositeException("Couldn't add child.");
    }

    @Override
    public void remove(CustomComponent component) {
        //throw new CompositeException("Couldn't remove child.");
    }

    @Override
    public CustomComponent getChild(int index) {
        //return null;
        //throw new CompositeException("Couldn't find child with this index.");
        throw new UnsupportedOperationException();
    }
}
