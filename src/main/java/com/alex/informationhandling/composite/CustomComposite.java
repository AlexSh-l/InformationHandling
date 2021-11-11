package com.alex.informationhandling.composite;

import com.alex.informationhandling.exception.CompositeException;

import java.util.ArrayList;
import java.util.List;

public class CustomComposite implements CustomComponent {

    private final List<CustomComponent> components = new ArrayList<>();

    @Override
    public void operation() {
        for (int i = 0; i < components.size(); i++) {
            components.get(i).operation();
        }
    }

    @Override
    public void add(CustomComponent component)/* throws CompositeException */ {
        //try {
        components.add(component);
        //} catch (UnsupportedOperationException e) {
        //throw new CompositeException(e.getMessage(), e);
        //}
    }

    @Override
    public void remove(CustomComponent component)/* throws CompositeException*/ {
        //try {
        components.remove(component);
        //} catch (UnsupportedOperationException e) {
        //throw new CompositeException(e.getMessage(), e);
        //}
    }

    @Override
    public CustomComponent getChild(int index)/* throws CompositeException*/ {
        //try{
        return components.get(index);
        //}catch (IndexOutOfBoundsException e){
        //throw new CompositeException(e.getMessage(), e);
        //}
    }
}
